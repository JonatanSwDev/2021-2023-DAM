/****
 * Creación del esquema lógico específico MySQL para base de datos de biblioteca
 * 1. Este orden de creación de las tablas permite la creación correcta de las Foreign Keys (FK)
 * 2. En esta ISA se ha utilizado el Método1 para paso a grafo relacional ya que era completa, había pocos atributos y los subtipos no tenían interrelaciones
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
 *  	- En este caso como en el ER no se ponía límite de telfs por socio en el grafo se ha creado una tabla de telfs
 * 		- Los campos telfs se crean en el dominio int() ya que van a recibir datos con dígitos numéricos
 * 		- Pero mas adelante veremos que, realmente, si no vamos a hacer cálculos con un campo, no debería crearse int o decimal
 * 		- Estos campos se podrían crear de tipo varchar asignándole a posteriori una máscara de entrada para verificar los dígitos
 ******/

/* Borramos la base de datos si existe */
drop database if exists biblioteca;

/* Creamos la base de datos con la codificación de caracter correcta */
create database biblioteca character set utf8 collate utf8_general_ci;

/* Utilizamos la base de datos creada */
use biblioteca;

/* Creamos las tablas con SQL DDL específico de MySQL */


create table socio (
	cod_soc int(5) primary key,
	dni varchar(9) not null unique,
	nombre varchar(50) not null,
	apellidos varchar(50) not null,
	direccion varchar(50) not null,
    CHECK (dni regexp '[0-9]{8}[A-Z]{1}') /* El DNI esta formado por 8 digitos numericos y uno alfabetico */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */


/*Se crea la tabla de telfs como el grafo indica ya que no sabemos cuantos tiene como max un socio*/
/* Cuidado la PK es cod_soc y telf, cod_soc no puede ser el solo PK*/

create table telfs (
	cod_soc int(5),
	telf int(9),
	primary key(cod_soc,telf),
    /* Se debe permitir los cambios en el socio, si se elimina el socio se eliminan los telefonos */
	CONSTRAINT soc_telf foreign key (cod_soc) references socio(cod_soc) ON UPDATE CASCADE ON DELETE CASCADE,
    CHECK (telf > 0 && telf regexp '[0-9]{9}') /* El telefono no puede ser negativo ni estar incompleto */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table autor (
	cod_autor int(5) primary key,
	nombre varchar(50) not null,
	pais varchar(50) not null
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */


/*Cuidado en obra el anyo no es date sino varchar pq no es una fecha exacta*/
/* n_pages, n_canciones, duracion deben poder ser nulos */
create table obra (
	cod_obra int(6) primary key,
	nombre  varchar(50) not null,
	anyo varchar(5) not null, /*No añado un regexp a enteros porque puede contener AC o DC */
	tipo varchar(5) not null,
	n_pages int(5),
	n_canciones int(5),
	duracion int(5),
    CHECK (n_pages >= 0), /* En caso de que contenga paginas, canciones o duracion debe de ser positivo */
    CHECK (n_canciones >= 0), /* Aunque ya puede ser el valor null contemplo el 0 como valor */
    CHECK (duracion >= 0)
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */


/*Articulo depende en existencia no en identidad*/
/*Por eso su codigo le identifica como PK*/
/*Cod_obra solo es una FK y no forma parte de la PK*/
/*Deteriorado es un booleano*/
create table articulo (
	cod_art int(7) primary key,
	cod_obra int(6) not null,
	tipo varchar(15) not null,
	deteriorado boolean not null,
	comentario text not null,
    /* Se debe permitir la modificacion de la obra, a demás como artículo es una entidad
    debil en existencia, si se elimina obra también debe hacerlo artículo, aunque claro está
    no se podrá hacer hasta que se elimine de prestar */
    CONSTRAINT obra_art foreign key (cod_obra) references obra (cod_obra) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */


/*Tabla presta*/
/*Cuidado aqui la PK como viene de una N:M se compone de los dos códigos*/
/*Pero además tienen que incluir la fecha de prestamo*/
/*Debido a la dimensión temporal*/
/*Ya que un un socio puede coger prestado el mismo articulo varias veces en distintas fechas*/

create table presta (
	cod_art int(7),
	cod_soc int(5),
	fech_prest date,
	fech_tope date not null,
	fech_dev date,
	primary key(cod_art,cod_soc,fech_prest),
    /* Hay que preservar el histórico, por lo que no se permite la eliminación ni de Socio ni de Artículo
    a no ser que se realice a mano primero en el prestamo, pero tanto los datos de socio como el deterioro y el comentario
    del artículo pueden ser modificados */
	CONSTRAINT art_prest foreign key (cod_art) references articulo(cod_art)ON UPDATE CASCADE ON DELETE RESTRICT,
	CONSTRAINT soc_prest foreign key (cod_soc) references socio(cod_soc) ON UPDATE CASCADE ON DELETE RESTRICT,
    CHECK (fech_tope >= fech_prest) /* La fecha tope de devolucion debe de ser igual o superior a la de prestamo */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

/* Te falto la tabla publica cayetano */

create table publica (
	cod_autor int (5),
    cod_obra int (6),
    rol varchar (50),
    primary key (cod_autor, cod_obra),
    /* Puedo permitir el cambio de pais del autor, imagina que se cambia de nacionalidad */
    /* Aqui lo importante no es el historico de publicaciones, sino el autor que publica
    por lo que si desaparece obra se elimina un registro que ya no nos hace falta, pero sin embargo
    el autor no se puede eliminar.
    Hay que tener en cuenta que ya existe el control sobre la eliminacion de obra a partir de 
    el artículo prestado, y eso es lo que nos va a generar todo el control*/
	foreign key (cod_autor) references autor (cod_autor)ON UPDATE CASCADE ON DELETE RESTRICT,
    /* Permito las modificaciones sobre obra, claro está */
    foreign key (cod_obra) references obra (cod_obra) ON UPDATE CASCADE ON DELETE CASCADE
    
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */


