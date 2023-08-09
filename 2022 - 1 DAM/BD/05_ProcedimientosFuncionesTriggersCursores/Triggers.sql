-- 1.- Sobre la DB facturacion, crear un trigger que al insertar un artículo en el campo stock 
-- guarde el valor del stock que se pasa como valor en la inserción si dicho valor es positivo 
-- y guarde un cero si el valor que se pasase en la inserción fuese negativo.

 use comercial;

drop trigger if exists actualiza_stock_bef_ins;

-- before

delimiter //
create trigger actualiza_stock_bef_ins before insert on articulo
for each row
begin
if new.stock < 0 then
set new.stock = 0;
end if;
end // delimiter ;
 
insert into articulo
values ('ART-301','Articulo nuevo',250,-3);
insert into articulo
values ('ART-302','Articulo nuevo2',250,3);

-- 2.- Sobre la DB CatalogoFarmacia crear un trigger que se ejecute al insertar un registro nuevo sobre la tabla empleados para que no se permita que un empleado sea jefe de más de 10 empleados

use jardineria;

drop trigger if exists insert_empleado_bef;

-- before

delimiter //
create trigger insert_empleado_bef before insert on empleado
for each row
begin
declare num_empleados int(5);
select count(*) from empleado where codigo_jefe=new.codigo_jefe into num_empleados;
if num_empleados = 10 then
	SET new.codigo_jefe = null;
end if;
end//
delimiter ;

select * from empleado;

use jardineria; 
insert into empleado
values(33, 'Prueba', 'Apellidos','', '33333', 'pelos@pelos.net', 'TOK-JP', 5, 'Representante Ventas');
 
 -- 3.- Crear un trigger para impedir que se aumente el precio de un fármaco en más de un 20% 
 -- en una operación de actualización sobre la tabla fármaco (UPDATE).
 
 use comercial;
 
 -- before
 
 drop trigger if exists max_update_price_ins;
 
 delimiter //
 create trigger max_update_price_ins before update on articulo
 for each row
 begin
 if new.precio > old.precio*1.20 then
 set new.precio = old.precio;
 end if;
 end // delimiter ;
 
 update articulo set precio=precio*1.21 where cod_art = 'ART-10';
 
 select * from articulo;
 
 -- 4.- Crear una tabla de logs y un trigger que genere un log con información de las modificaciones
 -- de precio de los artículos almacenando la fecha de modificación, el precio antiguo y el nuevo.
 
 use comercial;
 
 -- Tabla de auditoria
 
 create table audit_log_articulo(
 numlog int auto_increment primary key,
 cod_art varchar(8),
 fecha datetime,
 precio_antiguo double(8,2),
 precio_nuevo double (8,2),
 foreign key (cod_art) references articulo(cod_art)
 );
 
 -- Auditoria
 
 drop trigger if exists update_price_articulo;
 delimiter //
 create trigger update_price_articulo after update on articulo
 for each row
 begin
 if old.precio != new.pecio then
 insert into audit_log_articulo
 values(0, new.cod_art,now(),old.precio,new.precio);
 end if;
 end
 // delimiter ;
 
 update articulo set precio=precio*1.10 where cod_art = 'ART-10';
 update articulo set precio=precio/1.10 where cod_art = 'ART-10';
 
 select * from audit_log_articulo;