/****
 * Creación del esquema lógico específico MySQL para base de datos de academia de refuerzo
 * 1. Este orden de creación de las tablas permite la creación correcta de las Foreign Keys (FK)
 * 2. Recordad que las claves alternativas como dni en docente deben ser not null y unique
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
 * 		- Para el nre o nss pasa lo mismo, lo definiremos como int pero más adelantete veremos que es mejor varchar
 *****/

/* Borramos la base de datos si existe */
drop database if exists academia;

/* Creamos la base de datos con la codificación de caracter correcta */
create database academia character set utf8 collate utf8_general_ci;

/* Utilizamos la base de datos creada */
use academia;

/* Creamos las tablas con SQL DDL específico de MySQL */

create table nivel (
	cod_nivel varchar(4) primary key,
	descripcion varchar(50) not null
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table curso (
	cod_curso varchar(4) primary key,
	descripcion varchar(50) not null
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table area (
	cod_area varchar(4) primary key,
	descripcion varchar(50) not null
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table aula (
	cod_aula varchar(4) primary key,
	descripcion varchar(50) not null,
	capacidad int(3),
    	CHECK (capacidad > 0) /* La capacidad debe de ser un entero positivo */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table asignatura (
	cod_asignatura varchar(4) primary key,
	descripcion varchar(50) not null,
	cod_nivel varchar(4) not null,
	cod_curso varchar(4) not null,
    /* Coloco tanto nivel como curso en update cascade porque esto es España y cambian las cosas cada
    2 por 3. No permito que se elimine ni nivel ni curso, ya que no se suele dar el caso y podria generar
    Inconsistencia, sobre todo para la matricula */
	CONSTRAINT nivel_asign foreign key (cod_nivel) references nivel(cod_nivel) ON UPDATE CASCADE ON DELETE RESTRICT,
	CONSTRAINT curso_asign foreign key (cod_curso) references curso(cod_curso) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table alumno (
	nre int(7) primary key,
	nombre varchar(50) not null,
	apellidos varchar(50) not null,
	fecha_nac date not null,
	via varchar(50) not null,
	nombre_via varchar(50) not null,
	num int(3) not null,
	piso varchar(3),
	esc varchar(3),
	letra varchar(3),
	localidad varchar (50) not null,
	telf1 int(13),
	telf2 int(13),
	CHECK (nre > 0), /* El NRE debe de ser positivo */
    CHECK (num > 0), /* La capacidad debe de ser un entero positivo */
    CHECK (letra regexp '[A-Z]'), /* La letra debe de ser un caracter alfabetico */
	CHECK ( telf1 > 0), /* Los telefonos no pueden ser negativos */
    CHECK ( telf2 > 0),
    CHECK (nre > 0 && nre regexp '[0-9]{7}') /* El NRE debe de ser positivo */
    /* Adicionalmente el NRE debe estar formado por 7 digitos en total, de ahí el regexp */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table docente(
	nss int(15) primary key,
	dni varchar(9) not null unique,
	nombre varchar(50) not null,
	apellidos varchar(50) not null,
	iban varchar(30) not null,
	email varchar(50) not null,
	via varchar(50) not null,
	nombre_via varchar(50) not null,
	num int(3) not null,
	piso varchar(3),
	esc varchar(3),
	letra varchar(3),
	localidad varchar (50) not null,
	telf1 int(13) not null,
	telf2 int(13),
	telf3 int(13),
    CHECK (num > 0), /* La capacidad debe de ser un entero positivo */
    CHECK (letra regexp '[A-Z]'), /* La letra debe de ser un caracter alfabetico */
    CHECK ( telf1 > 0), /* Los telefonos no pueden ser negativos */
    CHECK ( telf2 > 0),
    CHECK ( telf3 > 0),
    CHECK (nss > 0 && nss regexp '[0-9]{15}') /* El NSS debe de ser positivo */
    /* Adicionalmente el NSS debe ser representado por 15 digitos consecutivos, de ahi el regexp */
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table habilitado (
	cod_area varchar(4),
	nss int(15),
	primary key(cod_area,nss),
    /* El area puede que no cambie, pero quizá la descripción varía de un año para otro, no se puede eliminar el area del docente */
	CONSTRAINT area_habili foreign key (cod_area) references area(cod_area) ON UPDATE CASCADE ON DELETE RESTRICT,
    /* El docente de dicho area puede cambiar de multiples valores en distintos atributos, si se elmina el docente no hace falta que se encuentre
    en la tabla habilitado, aunque si se elmina generaría inconsistencia en el historial de imparte, pero no va a ocurrir a no ser
    que se elimine del histórico imparte*/
	CONSTRAINT docent_habili foreign key (nss) references docente(nss) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */

create table imparte(
	nss int(15),
	cod_asignatura varchar(4),
	cod_aula varchar(4),
	anyo_lectivo varchar(9),
	primary key(nss,cod_asignatura,cod_aula,anyo_lectivo),
    /* Los docentes ya hemos comentado que pueden variar sus datos, una clase debe de tener docente y hay que preservar el histórico */
	CONSTRAINT docent_impart foreign key (nss) references docente(nss) ON UPDATE CASCADE ON DELETE RESTRICT,
    /* La asignatura podría cambiar como hemos comentado antes*/
    /* Aquí hay un dilema con la eliminación, porque se podría dejar de impartir una clase, pero si se coloca en cascade */
    /* Se podría perder el histórico, por lo que voy a dejarlo en RESTRICT */
	CONSTRAINT asign_impart foreign key (cod_asignatura) references asignatura(cod_asignatura) ON UPDATE CASCADE ON DELETE RESTRICT,
    /* El aula puede que no varíe, pero se podría modificar la descripción en un futuro, quien sabe*/
    /* El aula no se puede borrar, si o si se necesita de un aula para impartir la clase*/
	CONSTRAINT aula_impart foreign key (cod_aula) references aula(cod_aula) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */


create table matricula(
	nre int(7),
	cod_asignatura varchar(4),
	anyo_lectivo varchar(9),
	primary key(nre,cod_asignatura,anyo_lectivo),
    /* Una matricula solo puede pertenecer a un alumno en concreto, aqui tendriamos un problema con el histórico si se eliminan alumnos
    por lo que hay que colocar ON DELETE RESTRICT*/
	CONSTRAINT alumn_matric foreign key (nre) references alumno(nre) ON UPDATE RESTRICT ON DELETE RESTRICT,
    /* La asignatura hemos dicho que podía cambiar según legislación, para conservar el histórico coloco ON DELETE RESTRICT*/
	CONSTRAINT asign_matric foreign key (cod_asignatura) references asignatura(cod_asignatura) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = INNODB; /* InnoDB para aplicar restricciones de Integridad referencial */