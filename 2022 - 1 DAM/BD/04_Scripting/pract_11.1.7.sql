-- Jonatan Gomez Garcia Practica 11

-- Seguramente exista la manera de hacerlo con los datos ya introducidos, pero calentandome la cabeza no logro sacar la respuesta
-- Voy a hacer los pasos como si fuera crear la base de datos de 0 con las sentencias DDL corresponientes:

-- Lo primero de todo son las definiciones tanto de la tabla factura como de la tabla albaran, ya que la tabla albaran contiene una foreign key hacia 
-- la tabla factura:

create table factura (
cod_fac int (6) auto_increment comment 'Codigo de identificacion',
dni varchar(9) not null comment 'DNI del cliente (FK)',
fecha_fac date not null comment 'Fecha de realización de la factura',
importe double(8,2) not null comment 'Importe a pagar',
primary key(cod_fac, dni, fecha_fac) comment 'Primary key que identifica univoca la factura',
foreign key (dni) references cliente(dni) on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


create table albaran (
cod_alb varchar(6) not null comment 'Codigo de identificacion',
cod_fact int(6) not null comment 'Codigo de factura (FK)',
fecha_alb date not null comment 'Fecha de creacion del albaran',
cod_art varchar(8) not null comment 'Codigo del articulo (FK)',
cantidad int (7) not null,
primary key (cod_alb,cod_fact,fecha_alb,cod_art) comment 'Primary key que identifica univoca el albaran',
foreign key (cod_fact) references factura(cod_fac) on update cascade,
foreign key (cod_art) references articulo(cod_art) on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- En la insercion de datos sobre la factura se anula el campo cod_fac, ya que es auto incremental

insert into factura (dni, fecha_fac, importe)
values ('11111111A','2012-02-01',2800);
insert into factura (dni, fecha_fac, importe)
values ('11111111A','2012-03-02',1500);
insert into factura (dni, fecha_fac, importe)
values ('11111111A','2012-08-15',800);
insert into factura (dni, fecha_fac, importe)
values ('22222222B','2013-09-20',3000);
insert into factura (dni, fecha_fac, importe)
values ('22222222B','2013-10-02',900);
insert into factura (dni, fecha_fac, importe)
values ('33333333C','2013-11-15',2500);
insert into factura (dni, fecha_fac, importe)
values ('44444444D','2014-02-02',520);
insert into factura (dni, fecha_fac, importe)
values ('44444444D','2015-02-04',2500);

-- Para las inserciones de la tabla albaan hay que cambiar cada cod_art hacia la nueva clave

insert into albaran
values ('A-0001',000001,'2012-01-10','ART-250',10);
insert into albaran
values ('A-0002',000001,'2012-01-20','ART-120',30);
insert into albaran
values ('A-0003',000002,'2012-02-15','ART-100',3);
insert into albaran
values ('A-0004',000003,'2012-04-03','ART-80',25);
insert into albaran
values ('A-0005',000003,'2012-06-15','ART-120',10);
insert into albaran
values ('A-0006',000003,'2012-07-25','ART-77',4);
insert into albaran
values ('A-0007',000004,'2013-09-15','ART-10',50);
insert into albaran
values ('A-0008',000005,'2013-10-02','ART-10',15);
insert into albaran
values ('A-0009',000006,'2013-11-15','ART-100',5);
insert into albaran
values ('A-0010',000007,'2014-02-01','ART-101',1);
insert into albaran
values ('A-0011',000007,'2014-02-02','ART-100',1);
insert into albaran
values ('A-0012',000008,'2015-02-04','ART-100',5);