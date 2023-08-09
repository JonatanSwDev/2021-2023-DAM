-- Jonatan Gomez Garcia Practica 11

use comercial;

-- Asegurar unas buenas búsquedas por DNI en la tabla cliente. (Indica
-- razonadamente si se ha de tomar alguna medida y si es así cual y de qué tipo con
-- el código correspondiente)
--		No hace falta tomar ninguna medida para asegurar unas buenas búsquedas por el campo DNI
--		ya que por defecto, MySQL ya crea un índice para las primary key, y DNI ya es primary key

-- Asegurar unas buenas búsquedas por DNI en la tabla factura. ( Indica
-- razonadamente si se ha de tomar alguna medida y si es así cual y de qué tipo con
-- el código correspondiente)
--		En este caso tampoco hace falta tomar alguna medida porque DNI es una FOREIGN key dentro
--		de la tabla factura, por lo que MySQL ya crea el indice correspondiente de forma automática
--		sobre este campo.

-- Asegurar una buenas búsquedas por Apellidos en la tabla cliente. ( Indica
-- razonadamente si se ha de tomar alguna medida y si es así cual y de qué tipo con
-- el código correspondiente)
--		En este caso se crearía un index, ya que los valores de apellidos pueden contener repetidos
--		y MySQL no los crea de forma automática.
--		Podría especificarse en la creación de la tabla o a posteriori con un alter table
alter table cliente add index (apellidos);

-- Se desearía utilizar como clave alternativa en la tabla artículo el campo
-- descripción del artículo. ( Indica razonadamente si se ha de tomar alguna medida y
-- si es así cual y de qué tipo, con el código correspondiente. Si has de realizar
-- operaciones DML para ajustar los datos actuales a lo que se demanda indica
-- también cuáles serían)
--		Lo primero de todo, para convertir la descripción de articulo a clave alternativa no pueden existir duplicados.
--		Por lo que había que solucionar el tema de los duplicados de alguna forma, como por marca o versión de los artículos duplicados
--		Lo segundo sería convertir el campo descripción en un campo único mediante un alter table..
--		Por último no hace falta crear la indexación porque autimáticamente quedaría indexado por MySQL, ya que al establecer que es
--		un campo único lo crearía automáticamente.
--	Por ejemplo para modificar los campos:
update articulo
set descripcion = 'Condesador RJW 101'
where cod_art = 'ART-101';
update articulo
set descripcion = 'Condesador RJW 250'
where cod_art = 'ART-250';
--	Sentencia para establecer campo unico
alter table articulo add unique index (descripcion);