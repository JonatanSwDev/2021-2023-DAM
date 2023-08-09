-- 1.- Crear un procedimiento que incremente de forma condicionada el stock de todos los artículos
--  en una cantidad dada de forma que:
-- Se pase como parámetro la cantidad a sumar
-- si el stock actual es <= 10 sumarle la cantidad pasada
-- si el stock actual es > 10 y <= 100 no sumarle nada
-- si el stock actual es > 100 sumarle el doble de la cantidad pasada como parámetro
use comercial;

drop procedure if exists incremento_condicionado_stock;

delimiter //
create procedure incremento_condicionado_stock(IN v_cantidad int(5))
begin
	declare var_cod_art varchar(8);
    declare var_stock int(5);
    declare var_final integer default 0;
    
    declare cursor1 cursor for select cod_art, stock from articulo;
    declare continue handler for not found set var_final = 1;

	open cursor1;
    bucle: LOOP
		fetch cursor1 INTO var_cod_art, var_stock;
        
        if var_final = 1 THEN
			leave bucle;
        end if;
        
        if var_stock <= 10 then
			update articulo
            set stock = stock + v_cantidad
            where cod_art = var_cod_art;
		elseif var_stock >= 100 then
			update articulo
            set stock = stock + (v_cantidad *2)
            where cod_art = var_cod_art;
		end if;
        
        end loop bucle;
        close cursor1;
end
// delimiter ;

call  incremento_condicionado_stock(10);
select * from articulo;


