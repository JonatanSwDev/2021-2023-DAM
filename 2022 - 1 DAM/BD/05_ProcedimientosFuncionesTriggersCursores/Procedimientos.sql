-- 1.- Crear un procedimiento sobre la DB facturacion que informe 
-- si un cliente es mayor de 65 años devolviendo 's' o 'n' 
-- si es mayor de 65 o no lo es respectivamente.
-- El procedimiento recibirá como parámetro el campo primary key de la tabla cliente.
use comercial;
-- No OUT
drop procedure if exists mayor_65;

delimiter //
create procedure mayor_65 (IN v_dni varchar(9))
begin
declare edad double(5,2);
select datediff(now(), fecha_nac)/365
from cliente
where dni=v_dni into edad;
if edad >=65 then
	select 'S';
else 
	select 'N';
end if;
end
// delimiter ;

call mayor_65('11111111A');
-- OUT
drop procedure if exists mayor_65_OUT;
delimiter //
create procedure mayor_65_OUT (IN v_dni varchar(9), OUT mayor_65 char)
begin
declare edad double(5,2);
select datediff(now(), fecha_nac)/365
from cliente
where dni=v_dni into edad;
if edad >=65 then
	set mayor_65 = 'S';
else 
	set mayor_65 = 'N';
end if;
end
// delimiter ;

call mayor_65_OUT ('11111111A',@mayor_65);
select @mayor_65;

-- 2.- Que reciba el DNI de un comercial y devuelva la provincia a la que pertenece basándose en su CP. 
-- Para simplificar se considerarán solamente las provincias de Murcia y sus limítrofes en este ejercicio.
use comercial;

-- NOT OUT
drop procedure if exists cod_postal_com;
delimiter //
create procedure cod_postal_com(v_dni varchar(9))
begin
select if (substr(cod_postal, 1, 2) = '30', 'Region de murcia', "Ortro lugar" )
from comercial
where dni=v_dni; 
end
// delimiter ;

call cod_postal_com('55555555E');

-- OUT
drop procedure if exists cod_postal_com_OUT;
delimiter //
create procedure cod_postal_com_OUT(IN v_dni varchar(9), OUT cod_postal_OUT varchar(50))
begin
select if (substr(cod_postal, 1, 2) = '30', 'Region de murcia', "Ortro lugar" )
from comercial
where dni=v_dni into cod_postal_OUT; 
end
// delimiter ;

call cod_postal_com_OUT('55555555E', @cod_postal_OUT);
select @cod_postal_OUT;

-- 3.- Crea un procedimiento al que se le pase como parámetro el dni de empleado
-- y devuelva en el mismo parámetro el nombre completo en el fomato "apellidos, nombre" del mismo.
use comercial;
-- NOT OUT
drop procedure if exists get_apellidos_nombre;
delimiter //
create procedure get_apellidos_nombre (IN v_dni varchar(152))
begin
declare v_salida varchar(152);
select concat(apellidos, ", ", nombre) 
from comercial where dni=v_dni into v_salida;
select v_salida;
end
// delimiter ;

call get_apellidos_nombre('66666666F');

-- OUT
drop procedure if exists get_apellidos_nombre_OUT;
delimiter //
create procedure get_apellidos_nombre_OUT (INOUT v_dni varchar(152))
begin
select concat(apellidos, ", ", nombre) 
from comercial where dni=v_dni into v_dni;
end
// delimiter ;

set @v_dni_INOUT = '66666666F';
call get_apellidos_nombre_OUT (@v_dni_INOUT);
SELECT @v_dni_INOUT;


-- 4.- Agrega un campo 'sueldo' a la tabla Comercial si no existiese ya.
-- Inserta sueldos entre 1000 y 2000 euros para cada empleado si no existen ya. 
-- Crea un procedimiento al que se le envíe como parámetros el dni de un empleado
-- y una cantidad que representa el dinero que se le va a aumentar al empleado. 
-- El procedimiento debe devolver en el mismo parámetro el nuevo sueldo del empleado.

alter table comercial
add sueldo double(7,2) not null;
-- function
drop function if exists sueldo_com;

delimiter //
create function sueldo_com(s_base double(7,2), multiplicador double(3,2))
returns double(7,2)
begin
declare valor double(7,2);
set valor = s_base*multiplicador;
return valor;
end
// delimiter ;

drop procedure if exists set_sueldo_INOUT;
-- Procedurae INOUT
delimiter //
create procedure set_sueldo_INOUT(IN v_dni varchar(9), INOUT v_sueldo double(7,2))
begin
update comercial
set sueldo = v_sueldo
where dni = v_dni;
end
// delimiter ;

set @v_sueldo = 1000;
call set_sueldo_INOUT('55555555E', @v_sueldo);
set @v_sueldo = sueldo_com(@v_sueldo, 1.05);
call set_sueldo_INOUT('66666666F', @v_sueldo);
set @v_sueldo = sueldo_com(@v_sueldo, 1.10);
call set_sueldo_INOUT('77777777G', @v_sueldo);
set @v_sueldo = sueldo_com(@v_sueldo, 1.20);
call set_sueldo_INOUT('88888888H', @v_sueldo);

select * from comercial;

-- 5.- Se desea realizar un procedimiento al cual se le pase como parámetro una cantidad
-- y un número de cuenta y devuelva si la cuenta tiene un saldo superior o inferior
-- a la cantidad pasada como parámetro. Realizar el procedimiento para la BD banco.
use comercial;
-- NOT OUT
drop procedure if exists esinferior;

delimiter //
create procedure esinferior(IN cantidad double(7,2), IN v_dni varchar(9))
begin
declare cant_dni double(7,2);
select sueldo from comercial
where dni=v_dni into cant_dni;
if cant_dni > cantidad then
	select 'superior';
	else if cant_dni < cantidad then
		select 'inferior';
	else
		select 'igual';
	end if;
end if;
end
// delimiter ;

call esinferior(1000, '55555555E');
call esinferior(2000, '66666666F');
call esinferior(1050, '77777777G');

-- OUT
drop procedure if exists esinferior_OUT;

delimiter //
create procedure esinferior_OUT(IN cantidad double(7,2), IN v_dni varchar(9), OUT resultado varchar(10))
begin
declare cant_dni double(7,2);
select sueldo from comercial
where dni=v_dni into cant_dni;
if cant_dni > cantidad then
	set resultado = 'superior';
	else if cant_dni < cantidad then
		set resultado = 'inferior';
	else
		set resultado = 'igual';
	end if;
end if;
end
// delimiter ;

call esinferior_OUT(1000, '55555555E', @es);
select @es;
call esinferior_OUT(2000, '66666666F', @es);
select @es;
call esinferior_OUT(1050, '77777777G', @es);
select @es;