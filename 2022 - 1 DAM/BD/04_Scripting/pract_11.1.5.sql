-- Jonatan Gomez Garcia Practica 11

use comercial;

-- Indica como definirías (y en qué nivel de aislamiento óptimo lo harías -concurrencia vs
-- serialización-), un conjunto de sentencias como transacción para realizar una venta de
-- artículo (realizar el albaran correspondiente y actualizar stock).

--	No utilizaría el nivel de aislamiento serializable, ya que puede presentar tiempos de trabajo elevados
--	a la hora de gestionar las transacciones, a demás de que también se bloquearía la parte de consultas y
--	podría generar problemas a la hora de actualizar el sock o la información en el nivel de vistas dentro
--	de una página web por ejemplo.

--	Usando el nivel de repeatables read podría ser interesante, no permite la lectura ni escritura, pero únicamente
--	de los campos afectados por la transacción en curso. El tiempo de espera para que se produzca transacciones derivadas
--	sobre los mismos campos repetidas veces seguiría siendo elevado, pero la consulta a los campos que no se están modificando
--	seguirían disponibles. Adicionalmente las consultas de rango (SELECT ... WHERE...) podrían dar lugar a lecturas fantasma

--	Usando el nivel de read commited el bloqueo se produce sobre la escritura, pero la lectura se desbloquea en cuanto la operacion
--	select acaba, dando lugar a que dos transacciones comiencen leyendo los mismos datos antes de que la transacción A inserte los 
--	datos, causando el problema de que cuando la transacción B inserte datos anule los datos de la transacción A.

--	Usando el nivel de read uncommited se permite la lectura de todos los datos en cualquier momento, haya escrito o no la anterior
--	transacción, lo que genera lecturas sucias con sus correspondientes problemas a la hora de la consistencia de los datos

-- Escojo el nivel de concurrencia repetible read por mantener una integridad razonable y una consistencia aceptable
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;

begin;
update articulo
set stock=stock -7
where cod_art = 'ART-100';
insert into albaran values ('A-0014', null, '2022-05-04', 'ART-100', 7);
commit;

begin;
update articulo
set stock=stock -1
where cod_art = 'ART-250';
insert into albaran values ('A-0015', null, '2022-05-03', 'ART-250', 1);
commit;