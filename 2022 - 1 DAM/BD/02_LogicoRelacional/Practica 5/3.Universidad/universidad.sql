/****
 * Creación del esquema lógico específico MySQL para base de datos de universidad
 * 1. Este orden de creación de las tablas permite la creación correcta de las Foreign Keys (FK)
 * 2. Recordad que en una IS-A no completa se deben crear tantas tablas como entidades de la IS-A con la PK del padre en todos los hijos
 * 3. Recordad que las FK deben definirse exactamente en el mismo dominio que los campos referenciados
 * 4. Recordad que las FK no tienen por que ser not null obligatoriamente y las PK compuestas se definen como sigue en el ejemplo
 * 5. Los tipos de datos en MySQL:
 * 		5.1 varchar(n): cadena de longitud n
 * 		5.2 int(n): número entero de longitud n
 * 		5.3 decimal(n,m): numero decimal de longitud n de los cuales m son decimales
 * 		5.4 date: campo fecha
 * 		5.5 time: campo hora
 * 6. Otras consideraciones:
 *  	- Los campos telfs se crean en el dominio int() ya que van a recibir datos con dígitos numéricos
 * 		- Pero mas adelante veremos que, realmente, si no vamos a hacer cálculos con un campo, no debería crearse int o decimal
 * 		- Estos campos se podrían crear de tipo varchar asignándole a posteriori una máscara de entrada para verificar los dígitos
 * 		- Para el nss pasa lo mismo, lo definiremos como int pero más adelante veremos que es mejor varchar
 *****/

/* Borramos la base de datos si existe */
drop database if exists universidad;

/* Creamos la base de datos con la codificación de caracter correcta */
create database universidad character set utf8 collate utf8_general_ci;

/* Utilizamos la base de datos creada */
use universidad;

/* Creamos las tablas con SQL DDL específico de MySQL */


create table persona (
	dni varchar(9) primary key,
	nombre varchar(50) not null,
	apellidos varchar(50) not null,
	email varchar(50) not null,
	telf int(13) not null,
	movil int(13),
    CHECK (telf > 0), /* El telefono no puede ser negativo */
    CHECK (movil > 0), /* El telefono no puede ser negativo */
    CHECK (dni regexp '[0-9]{8}[A-Z]{1}') /* El DNI esta formado por 8 digitos numericos y uno alfabetico */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table alumno (
	dni varchar(9) primary key,
	n_exp int(9) not null unique,
	fecha_nac date not null,
    /* Un alumno depende de persona, y podría variar en los campos Telf y Movil, por lo que permito los cambios*/
    /* Si se elimina la persona se elimina el alumno */
	CONSTRAINT alumno_dni foreign key (dni) references persona(dni) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table docente (
	dni varchar(9) primary key,
	nss int(15) not null unique,
	tipo  varchar(10) not null,
	fecha_alta date not null,
    /* Un docente depende de persona, y podría variar en los campos Telf y Movil, por lo que permito los cambios */
    /* Si se elimina a la persona en si también debe de hacerlo el DOCENTE */
	CONSTRAINT docente_dni foreign key (dni) references persona(dni) ON UPDATE CASCADE ON DELETE CASCADE,
	CHECK (dni regexp '[0-9]{8}[A-Z]{1}'), /* El DNI esta formado por 8 digitos numericos y uno alfabetico */
	CHECK (nss > 0 && nss regexp '[0-9]{15}') /* El NSS debe de tener 15 digitos enteros positivos */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table administrativo (
	dni varchar(9) primary key,
	nivel  varchar(10) not null,
	competencia_digital varchar(15),
    /* Un administrativo depende de persona, y podría variar en los campos Telf y Movil, por lo que permito los cambios*/
    /* Si se elimina la persona en concreto se elimina su rol */
	CONSTRAINT adminis_dni foreign key (dni) references persona(dni) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */


create table asignatura (
	cod_asign varchar(4) primary key,
	descripcion varchar(50) not null,
	tipo varchar(15) not null
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */


create table titulacion (
	cod_titulacion varchar(4) primary key,
	descripcion varchar(50) not null
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table imparte(
	dni varchar(9),
	cod_asign varchar(4),
	curso_lectivo varchar(9),
	primary key(dni,cod_asign,curso_lectivo),
    /* Los valores de tipo o fecha_alta podríancambiar, aun así fecha alta si cambia generaría conflictos del tipo
    que la fecha alta sea superior al curso lectivo histórico si se despide y se vuelve a contrata, de todas formas
    se mantiene en CASCADE, a demás, Docente hereda los atributos de persona que de por si ya pueden ser modificados*/
    /* A demás se debe conservar el historial, por lo que no permito eliminar un dicente en CASCADE*/
	CONSTRAINT docent_impart foreign key (dni) references docente(dni) ON UPDATE CASCADE ON DELETE RESTRICT,
    /* Considero que al ser una universidad hay que ser más restrictivos que en la academia y no dejar
    cambiar la asignatura de la clase, solamente se podrá cambiar el docente, así como tampooc se podrá eliminar */
	CONSTRAINT asgin_impart foreign key (cod_asign) references asignatura(cod_asign) ON UPDATE RESTRICT ON DELETE RESTRICT
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table matricula(
	dni varchar(9),
	cod_asign varchar(4),
	curso_lectivo varchar(9),
	primary key(dni,cod_asign,curso_lectivo),
    /* Como Alumno hereda los atributos de persona y estos pueden ser modificados, por lo que se debe permitir tambien
    los cambios en esta herencia */
	CONSTRAINT alumno_matric foreign key (dni) references alumno(dni) ON UPDATE CASCADE ON DELETE RESTRICT,
    /* Como hemos dicho la asignatura pertenece inmutable */
	CONSTRAINT asign_matric foreign key (cod_asign) references asignatura(cod_asign) ON UPDATE RESTRICT ON DELETE RESTRICT
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table compuesta(
	cod_titulacion varchar(4),
	cod_asign varchar(4),
	primary key(cod_titulacion,cod_asign),
    /* La titulación debe de estar grabada a fuego con la asignatura, tampoco permito modificaciones porque aunque pueda cambiar 
    de un año a otro, hay que preservar el histórico de las matriculas y clases (imparte) con los datos de cada titulo
    de cada año lectivo, obligar a crear un titulo nuevo en caso de que cambie la legislatura */
	CONSTRAINT titulo_comp foreign key (cod_titulacion) references titulacion(cod_titulacion) ON UPDATE RESTRICT ON DELETE RESTRICT,
	/* La titulación debe de estar grabada a fuego con la asignatura */
	CONSTRAINT asign_comp foreign key (cod_asign) references asignatura(cod_asign) ON UPDATE RESTRICT ON DELETE RESTRICT
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */