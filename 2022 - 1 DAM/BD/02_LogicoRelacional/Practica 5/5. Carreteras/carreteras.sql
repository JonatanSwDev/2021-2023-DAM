/****
 * Creación del esquema lógico específico MySQL para base de datos de carreteras
 * 1. Este orden de creación de las tablas permite la creación correcta de las Foreign Keys (FK)
 * 2. Cuidado ue en el E/R la entidad debil es en Identidad y en el grafo se decide optar por campoPK compuesto
 * 3. Recordad que las FK deben definirse exactamente en el mismo dominio que los campos referenciados
 * 4. Recordad que las FK no tienen por que ser not null obligatoriamente y las PK compuestas se definen como sigue en el ejemplo
 * 5. Los tipos de datos en MySQL:
 * 		5.1 varchar(n): cadena de longitud n
 * 		5.2 int(n): número entero de longitud n
 * 		5.3 decimal(n,m): numero decimal de longitud n de los cuales m son decimales
 * 		5.4 date: campo fecha
 * 		5.5 time: campo hora
 * 		5.6 boolean: capo que puede ser solo true o false
 * 		5.7 text: campo de texto de hasta 65535 caracteres
 * 6. Otras consideraciones:
 * 		- Código de carretera y código de comuna se han decidido que sea varchar ejemplo: A-P7 o Albacete respectivamente
 *  	- Se ha decidido en el paso de E/R a grafor relacional que la interrelación Confluye sea una reflexiva
 * 		- Al ser el ID de Tramo, un ID compuesto. la reflexiva se complica un poco
 * 		- Además la reflexiva es una N:M con atributo
 * 		- Algunas especificaciones del enunciado como en qué comuna o carretera confluye, se ha decidido que se puede obtener calculando sobre Confluye y Tramo
 ******/

/* Borramos la base de datos si existe */
drop database if exists carreteras;

/* Creamos la base de datos con la codificación de caracter correcta */
create database carreteras character set utf8 collate utf8_general_ci;

/* Utilizamos la base de datos creada */
use carreteras;

/* Creamos las tablas con SQL DDL específico de MySQL */


create table carretera (
	cod_carretera varchar(6) primary key,
	categoria varchar(50) not null 
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table comuna (
	cod_comuna varchar(6) primary key,
	nombre varchar(50) not null 
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

/*Se crea la tabla de tramo como débil en identidad
/* Cuidado la PK es cod_carretera y n_tramo juntos*/

create table tramo (
	cod_carretera varchar(6),
	n_tramo int(5),
	km_inicio_c decimal(5,2) not null,
	km_fin_c decimal(5,2) not null,
	es_inicio boolean not null,
	es_fin boolean not null,
	primary key(cod_carretera,n_tramo),
    /* Si se modifica algun dato de carretera hay que permitir esa modificación, pero no se puede eliminar la carretera
    porque no tendría sentido para este modelo que se eliminase la carretera, generaría una inconsistencia grabe,
    ya que siempre van a haber carreteras, a no ser que ocurra una catástrofe natural */
	CONSTRAINT carr_tramo foreign key (cod_carretera) references carretera(cod_carretera) ON UPDATE CASCADE ON DELETE RESTRICT,
    CHECK (n_tramo >= 0), /* El n_tramo no puede ser negativo */
    CHECK (km_inicio_c >= 0), /* El km de inicio y fin deben de ser numeros positivos */
    CHECK (km_fin_c >= 0)
    /*En este caso el km de inicio si puede ser mayor que el km de fin */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

/*Tabla confluye, la más complicada */
/* Porque es una reflexiva sobre una tabla con PK compuesto*/

create table confluye (
	cod_carretera varchar(6),
	n_tramo int(5),
	cod_carretera_conf varchar(6),
	n_tramo_conf int(5),
	km_conf decimal(5,2) not null,
	primary key(cod_carretera,n_tramo,cod_carretera_conf,n_tramo_conf),
    /* Esta tabla es una tabla reflexiva de la talba tramo, por lo que los datos pueden ser modificados en cascada como es obvio
    a demás tampoco haría falta dichos datos si no existe el tramo */
	CONSTRAINT conf1 foreign key (cod_carretera,n_tramo) references tramo(cod_carretera,n_tramo) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT conf2 foreign key (cod_carretera_conf,n_tramo_conf) references tramo(cod_carretera,n_tramo)ON UPDATE CASCADE ON DELETE CASCADE,
    CHECK (km_conf >= 000.00) /* El km_conf debe de ser positivo */
    /* A demas podria darse el caso de que confluya al inicio o fin de una carretera, por lo que */
    /* km_conf tambien puede ser 0 */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */


/*Tabla pasa, N:M con una de las tablas PK con campo compuesto */
/* La PK aquí es la conjunción de las PK's de las dos tablas referenciadas*/

create table pasa (
	cod_carretera varchar(6),
	n_tramo int(5),
	cod_comuna varchar(6),
	primary key(cod_carretera,n_tramo,cod_comuna),
    /* Como se puede observar, estoy haciendo la base de datos con la integridad marcada sobre la tabla
    tramo, teniendo que elmiminar el tramo para que todo lo demás pueda ser eliminado, creo que es lo más lógico, la única entidad
    que podría tener cambios tan significativos como lo es desaparecer.
    Es más dificil que desaparezca una carretera concreta o una comuna.
    Como he visto que es la más susceptible a recibir cambios debo permitir dichos cambios. */
	CONSTRAINT carr_tram_pasa foreign key (cod_carretera,n_tramo) references tramo(cod_carretera,n_tramo)ON UPDATE CASCADE ON DELETE CASCADE,
    /* Las comunas no van a desaparecer, por otro lado si podría cambiar de datos */
	CONSTRAINT com_pasa foreign key (cod_comuna) references comuna(cod_comuna) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

