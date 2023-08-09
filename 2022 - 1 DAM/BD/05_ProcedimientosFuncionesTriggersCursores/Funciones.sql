-- Jonatan Gomez Garcia

-- 1.- Crear una función sobre la DB facturacion que calcule la retención de los comerciales. 
-- Dicha retención será el 20% de su sueldo.

use facturacion;

drop function if exists retencion_comercial;

delimiter //
create function retencion_comercial ()
returns double (6,2)
begin
declare retencion double(6,2);
select sueldo*0.20 from nomina into retencion;
return retencion;
end  
// delimiter ;

-- 2.- Calcular los años de diferencia entre el cliente más joven y el de más edad.

use comercial;

drop function if exists yeardiff_cliente;

delimiter //
create function yeardiff_cliente ()
returns double
begin
declare year1 double;
declare year2 double;
declare years_cliente double;
select max(datediff(now(), fecha_nac)/365) from cliente into year1;
select min(datediff(now(), fecha_nac)/365) from cliente into year2;
set years_cliente = year1-year2;
return years_cliente;
end
// delimiter ;

select yeardiff();

-- 3.- Calcular el número de visitas de un comercial en un año determinado 
-- (parámetros: dni del comercial y año).
use comercial;

drop function if exists yeardiff_cliente;

delimiter //
create function n_visitas (v_dni_comercial varchar(9), v_anyo char(4))
returns int
begin
declare visitas_anyo double;
select count(*) from visita 
where dni_comercial=v_dni_comercial 
and year(fecha_visita)=v_anyo into visitas_anyo;
return visitas_anyo;
end
// delimiter ;

-- 4.- Calcular el importe total de facturación en un CP que se pase como parámetro.
use comercial;

drop function if exists importe_CP;

delimiter //
create function importe_CP (v_cod_postal int(5))
returns double
begin
declare v_importe double;
select sum(importe) from factura join cliente using(dni) where cod_postal=v_cod_postal into v_importe;
return v_importe;
end
// delimiter ;

-- 5.- Crear una función que informe sobre el número de artículos 
-- cuyo stock está por debajo de un valor dado que se pase como parámetro.
use comercial;

drop function if exists count_art_stock;

delimiter //
create function count_art_stock(v_stock int(4))
returns int (4)
begin
declare contador int(4);
select count(*) from articulo where stock < v_stock into contador;
return contador;
end
// delimiter ;

-- 6.- Sobre la DB facturación crear una función que calcule el precio más IVA 
-- siendo el IVA aplicable de un 8% si el cod_art es menor que 100 
-- y un 21% si el cod_art es mayor o igual a 100. NOTA: el cod_art comienza siempre por 
-- 'ART-'. Es el valor que aparece a continuación el que hay que evaluar para saber 
-- si es menor o mayor que 100. 
use comercial;

drop function if exists iva_art;
delimiter //
create function iva_art(v_cod_art varchar(8))
returns double(8,2)
begin
declare v_substr integer;
declare resultado double(8,2);
select substr(v_cod_art, 5) into v_substr;
if v_substr < 100 then
select precio*1.08 from articulo where cod_art=v_cod_art into resultado;
else
select precio*1.21 from articulo where cod_art=v_cod_art into resultado;
end if;
return resultado;
end
// delimiter ;
