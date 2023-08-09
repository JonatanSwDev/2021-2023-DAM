/****
 * Creación del esquema lógico específico MySQL para base de datos de venta de entradas para eventos
 * 1. Este orden de creación de las tablas permite la creación correcta de las Foreign Keys (FK)
 * 2. Recordad que las claves alternativas como dni en cliente deben ser not null y unique
 * 3. Recordad que las FK deben definirse exactamente en el mismo dominio que los campos referenciados
 * 4. Recordad que las FK no tienen por que ser not null obligatoriamente
 * 		4.1 cif en evento sí es not null porque en el grafo así se especifíca
 * 		4.2 cod_festival en evento no es not null pq en el grafo asi se especifíca
 * 5. Los tipos de datos en MySQL:
 * 		5.1 varchar(n): cadena de longitud n
 * 		5.2 int(n): número entero de longitud n
 * 		5.3 decimal(n,m): numero decimal de longitud n de los cuales m son decimales
 * 		5.4 date: campo fecha
 * 		5.5 time: campo hora
 * 6. Otras consideraciones:
 *  		- Los campos cod_postal o telfs se crean en el dominio int() ya que van a recibir datos con dígitos numéricos
 * 		- Pero mas adelante veremos que, realmente, si no vamos a hacer cálculos con un campo, no debería crearse int o decimal
 * 		- Estos campos se podrían crear de tipo varchar asignándole a posteriori una máscara de entrada para verificar los dígitos
 *****/

/* Borramos la base de datos si existe */
drop database if exists entradas;

/* Creamos la base de datos con la codificación de caracter correcta */
create database entradas character set utf8 collate utf8_general_ci;

/* Utilizamos la base de datos creada */
use entradas;

/* Creamos las tablas con SQL DDL específico de MySQL */

create table lugar (
	cod_lugar varchar(4) primary key,
	descripcion varchar(50) not null,
	aforo int(5) not null,
	via varchar(15) not null,
	num int(3) not null,
	cod_postal int(5) not null,
	localidad varchar(50) not null,
	CHECK (aforo > 0), /* El aforo debe de ser positivo */
	CHECK (num >= 0), /* El numero de via no puede ser negativo, contemplo el 0 como Sin Numero, tipico de empresas*/
	CHECK (cod_postal >= 0 AND cod_postal regexp '[0-9]{5}') /* El codigo postal no puede ser negativo, existe el codigo postal 00000 */
    /*Adicionalmente el codigo postal si o si esta formado por 5 digitos, por ello el regexp */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table promotor (
	cif varchar(9) primary key,
	razon_social varchar(50) not null,
	tipo varchar(15) not null,
	email varchar(50) not null,
	telf1 int(13) not null,
	telf2 int(13),
	CHECK (cif regexp '[0-9]{8}[A-Z]{1}'), /* El CIF esta formado por 8 digitos numericos y uno alfabetico */
	CHECK (telf1 > 0), /* El telefono no puede ser negativo */
	CHECK (telf2 > 0) /* El telefono no puede ser negativo */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table festival (
	cod_festival varchar(5) primary key,
	nombre varchar(50) not null,
	fecha_ini date not null,
	fecha_fin date not null,
	CHECK (fecha_ini <= fecha_fin) /* La fecha de inicio debe de ser menor o igual que la fecha de fin */
    /* Sería interesante tener control tambien sobre las fechas de los festivales en relacion con los eventos */
    /* Comprobaré si hay forma de hacerlo, si no, te lo preguntaré en clase */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table cliente (
	email varchar(50) primary key,
	dni varchar(9) not null unique,
	nombre varchar(50) not null,
	apellidos varchar(50) not null,
	telf1 int(13) not null,
	telf2 int(13),
	CHECK (dni regexp '[0-9]{8}[A-Z]{1}'), /* El DNI esta formado por 8 digitos numericos y uno alfabetico */
	CHECK (telf1 > 0), /* El telefono no puede ser negativo */
	CHECK (telf2 > 0) /* El telefono no puede ser negativo */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table evento (
	cod_evento varchar(5) primary key,
	nombre varchar(50) not null,
	fecha date not null,
	hora time not null,
	cod_festival varchar(5),
	cif varchar(9) not null,
	cod_lugar varchar(4) not null,
    /* Considero que los datos de un festival podrían cambiar, asi que permito los cambios en cascada, dejo abierta la opcion de set null por posible cambio de planes */
	CONSTRAINT fest_event foreign key (cod_festival) references festival(cod_festival) ON UPDATE CASCADE ON DELETE SET NULL,
    /* Considero que tanto tipo como telf pueden variar de un promotor, permito los cambios, pero siempre hay un promotor */
	CONSTRAINT cif_event foreign key (cif) references promotor(cif) ON UPDATE CASCADE ON DELETE RESTRICT,
    /* Considero que puede cambiar el aforo del lugar, y mas en tiempos de COVID, pero un evento necesita un lugar */
	CONSTRAINT lugar_event foreign key (cod_lugar) references lugar(cod_lugar) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table tarifa (
	cod_tarifa varchar(9) primary key,
	precio decimal(5,2) not null,
	zona varchar(25) not null,
	cod_evento varchar(5) not null,
    /* Cualquier dato del evento podría ser modificado, si se elmina el evento no nos sirve la tarifa */
	CONSTRAINT event_tar foreign key (cod_evento) references evento(cod_evento) ON UPDATE CASCADE ON DELETE CASCADE,
	CHECK (precio > 000.00 AND precio <=200) /* El precio debe de tener un valor positivo */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table entrada (
	cod_entrada varchar(9) primary key,
	localidad varchar(9) not null,
	zona varchar(5) not null,
	cod_evento varchar(5) not null,
	email varchar(50) not null,
	medio_pago varchar(50) not null,
	fecha_compra date not null, /* Sería interesante comprobar que la fecha de compra fuera inferior o igual a la fecha de evento */
	precio decimal(5,2),
    /* Como ya hemos dicho el evento puede ser modificado en cualquier momento */
    /* Lo ideal en realidad sería marcarlo como NOT NULL en caso de eliminar el Evento para poder hacer devoluciones de dinero
    /* O situaciones poco comunes poder manejar la situación, así que lo coloco en RESTRICT dado que el valor no puede ser nulo
    /* Teniendo que solucionar primero todas las situaciones poco comunes para poder eleiminar el evento */
	CONSTRAINT event_entr foreign key (cod_evento) references evento(cod_evento) ON UPDATE CASCADE ON DELETE RESTRICT,
    /* El telefono del usuario podria cambiar en cualquier momento, debo permitir dicho cambio */
    /* Si permitimos la eliminacion se eliminaría una entrada vendida generando inconsistencia */
	CONSTRAINT mail_entr foreign key (email) references cliente(email) ON UPDATE CASCADE ON DELETE RESTRICT,
	CHECK (precio >= 000.00 AND precio <= 200.00) /* El precio debe de tener un valor positivo, en este caso, contemplo la opcion de entradas regalo
	por posibles eventos promocionales a diferencia de la tabla tarifa no puede superar los 200€*/
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */