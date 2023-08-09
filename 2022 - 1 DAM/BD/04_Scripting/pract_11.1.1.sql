-- Jonatan Gomez Garcia Practica 11

DROP DATABASE IF EXISTS comercial;

CREATE DATABASE comercial character set utf8mb4; 

USE comercial;

drop table if exists cliente; 

create table cliente (
dni varchar(9) not null comment 'DNI del cliente',
nombre varchar(50) not null comment 'Nombre del cliente',
apellidos varchar(100) not null comment 'Apellidos del cliente',
fecha_nac date comment 'Fecha de nacimiento del cliente',
direccion varchar(200) not null comment 'Direccion completa del cliente',
cod_postal varchar(5) comment 'Codigo postal de residencia',
primary key(dni) comment 'primary key'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

drop table if exists articulo;

create table articulo (
cod_art varchar(8) not null comment 'Codigo de identificacion',
descripcion varchar(200) not null comment 'Descripcion del articulo',
precio double(8,2) not null comment 'Precio del articulo',
stock int(7) default 100 not null comment 'Stock de existencias',
primary key (cod_art) comment 'Primary key'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

drop table if exists factura;

create table factura (
cod_fac varchar(6) comment 'Codigo de identificacion',
dni varchar(9) not null comment 'DNI del cliente (FK)',
fecha_fac date not null comment 'Fecha de realización de la factura',
importe double(8,2) not null comment 'Importe a pagar',
primary key(cod_fac, dni, fecha_fac) comment 'Primary key que identifica univoca la factura',
foreign key (dni) references cliente(dni) on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

drop table if exists albaran;

create table albaran (
cod_alb varchar(6) not null comment 'Codigo de identificacion',
cod_fact varchar(6) not null comment 'Codigo de factura (FK)',
fecha_alb date not null comment 'Fecha de creacion del albaran',
cod_art varchar(8) not null comment 'Codigo del articulo (FK)',
cantidad int (7) not null,
primary key (cod_alb,cod_fact,fecha_alb,cod_art) comment 'Primary key que identifica univoca el albaran',
foreign key (cod_fact) references factura(cod_fac) on update cascade,
foreign key (cod_art) references articulo(cod_art) on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

drop table if exists comercial;

create table comercial (
dni varchar(9) not null comment 'DNI del comercial',
nombre varchar(50) not null comment 'Nombre del comercial',
apellidos varchar (100) not null comment 'Apellidos del comercial',
fecha_nac date not null comment 'Fecha de nacimiento del comercial',
direccion varchar(200) not null comment 'Direccion completa del comercial',
cod_postal varchar(5) not null comment 'Codigo postal asociado a la direccion',
primary key(dni) comment 'Primary Key '
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

drop table if exists visita;

create table visita (
dni_cli varchar(9) not null comment 'DNI del cliente (FK)',
dni_comercial varchar(9) not null comment 'DNI del comercial (FK)',
fecha_visita date not null comment 'Fecha en la que ocurre la visita',
primary key(dni_cli,dni_comercial,fecha_visita) comment 'Primary key que identifica univoca la visita',
foreign key (dni_cli) references cliente(dni) on update cascade,
foreign key (dni_comercial) references comercial(dni) on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;