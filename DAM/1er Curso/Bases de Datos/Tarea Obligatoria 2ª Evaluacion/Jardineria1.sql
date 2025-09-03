--1.	Sacar el código de oficina y la ciudad donde hay oficinas.
SELECT codigooficina, ciudad
FROM oficinas;
--2.	Cuantos empleados hay en la compañía.
SELECT count(*) as numero_empleados
FROM empleados;
--3.	Cuantos clientes tiene cada país.
SELECT count(*), pais
FROM clientes
GROUP BY pais;
--4.	Pago medio en 2005. 
SELECT sum(cantidad) / count(*) as pago_medio
FROM pagos
WHERE fechapago BETWEEN '01/01/05' AND '31/12/05';
--5.	Cuantos pedidos están en cada estado ordenado descendente por el número de pedidos.
SELECT count(*) as numero_pedidos, estado
FROM pedidos
GROUP BY estado
ORDER BY count(*);
--6.	Obtener el precio del producto más caro y del más barato.
SELECT max(precioventa) as preciomaximo, min(precioventa) as preciominimo
FROM productos;
--7.	Obtener el nombre del cliente con mayor límite de crédito
SELECT nombrecliente, limitecredito
FROM clientes
WHERE limitecredito = (SELECT max(limitecredito) FROM clientes);
--8.	Obtener el nombre, apellido1 y cargo de los empleados que no representen a ningún cliente.
SELECT nombre, apellido1, puesto, codigoempleado
FROM empleados e
WHERE e.codigoempleado NOT IN (SELECT codigoempleadorepventas FROM clientes)
ORDER BY codigoempleado;
--9.	Obtener el nombre del producto más caro.
SELECT nombre
FROM productos
WHERE precioventa = (SELECT max(precioventa) FROM productos);
--10.	Obtener el nombre del producto del que más unidades se han vendido en un mismo pedido.
SELECT nombre, p.codigoproducto
FROM productos p, detallepedidos d
WHERE p.codigoproducto = d.codigoproducto AND cantidad = (SELECT max(cantidad) FROM detallepedidos);
--11.	Obtener los clientes cuya línea de crédito sea mayor que los pagos que haya realizado.
SELECT nombrecliente, limitecredito, cantidad
FROM clientes c, pagos p
WHERE c.codigocliente = p.codigocliente AND c.limitecredito > p.cantidad;
--12.	Sacar el producto que más unidades tiene en stock y el que menos unidades tiene en stock.
SELECT nombre, cantidadenstock
FROM productos
WHERE cantidadenstock = (SELECT max(cantidadenstock)FROM productos) OR cantidadenstock = (SELECT min(cantidadenstock)FROM productos);  
--13.	Numero de productos que se piden en cada pedido.
SELECT codigopedido, sum(cantidad) as cantidad
FROM detallepedidos
GROUP BY codigopedido;
--14.	Listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.
SELECT nombrecliente, nombre, apellido1
FROM clientes c, empleados e
WHERE c.codigoempleadorepventas = e.codigoempleado;
--15.	Nombre de los clientes que no han realizado pagos junto con el nombre de representante.
SELECT nombrecliente, nombre
FROM clientes c, empleados e
WHERE codigoempleadorepventas = codigoempleado AND c.codigocliente NOT IN (SELECT codigocliente FROM pagos);
--16.	Nombre, unidades vendidas, total facturado y total con impuestos de los productos que hayan facturado más de 3000 euros. 
SELECT p.nombre, sum(d.cantidad) as cantidad, sum(cantidad * precioventa) as total_facturado, sum(cantidad * precioventa * 0.79) as total_con_impuestos
FROM productos p, detallepedidos d
WHERE p.codigoproducto = d.codigoproducto AND (cantidad * precioventa) > 3000
GROUP BY nombre;
--17.	Dirección de las oficinas que tengan clientes de Fuenlabrada.
SELECT DISTINCT o.lineadireccion1, o.codigooficina
FROM oficinas o, empleados e, clientes c
WHERE o.codigooficina = e.codigooficina AND e.codigoempleado = c.codigoempleadorepventas AND c.ciudad = 'Fuenlabrada';
--18.	Listado con el precio total de cada pedido.
SELECT sum(cantidad * preciounidad) as precio_total, codigopedido
FROM detallepedidos
GROUP BY codigopedido;
--19.	Cliente que hizo el pago con mayor cuantía y el que hizo el pago con menor cuantía.
SELECT c.nombrecliente AS cliente_max_pago, SUM(p.cantidad) AS max_pago_total 
FROM pagos p
JOIN clientes c ON p.codigocliente = c.codigocliente
GROUP BY c.nombrecliente
HAVING SUM(p.cantidad) = (SELECT MAX(total) FROM (SELECT SUM(cantidad) AS total FROM pagos GROUP BY codigocliente));

SELECT c.nombrecliente AS cliente_min_pago, SUM(p.cantidad) AS min_pago_total 
FROM pagos p
JOIN clientes c ON p.codigocliente = c.codigocliente
GROUP BY c.nombrecliente
HAVING SUM(p.cantidad) = (SELECT MIN(total) FROM (SELECT SUM(cantidad) AS total FROM pagos GROUP BY codigocliente));
--20.	Clientes que hayan hecho pedidos en el 2008 por una cuantía superior a 2000 euros.   
SELECT c.nombrecliente, SUM(d.cantidad * d.preciounidad) AS total_compras
FROM clientes c
JOIN pedidos p ON c.codigocliente = p.codigocliente
JOIN detallepedidos d ON p.codigopedido = d.codigopedido
WHERE p.fechaentrega BETWEEN '01/01/08' AND '31/12/08' 
GROUP BY c.nombrecliente
HAVING SUM(d.cantidad * d.preciounidad) > 2000;
--21.	¿Pedido más caro del empleado que más clientes tiene?
--Cantidad total maxima de entre todos los pedidos
SELECT max(t.cantidad_total)
FROM (SELECT p.codigopedido as cod_pedido, sum(cantidad * preciounidad) as cantidad_total
FROM detallepedidos d, pedidos p
WHERE p.codigopedido = d.codigopedido
GROUP BY p.codigopedido) t JOIN clientes c ON c.codigoclientes = pedidos.codigocliente;
--Clientes de cada empleado
select t.codigoempleadorepventas, t.numclientes
from
(select codigoempleadorepventas, numclientes
from(select count(distinct codigocliente) as numclientes, codigoempleadorepventas
from clientes c, empleados e
where e.codigoempleado = c.codigoempleadorepventas 
group by codigoempleadorepventas
order by numclientes DESC)) t;
--22.	Ciudad y teléfono de las oficinas de EEUU.
SELECT ciudad, telefono
FROM oficinas
WHERE pais = 'EEUU';
--23.	Nombre, apellidos y email de los empleados a cargo de Alberto Soria.
SELECT nombre, apellido1, apellido2 
FROM empleados
WHERE codigojefe = (SELECT codigoempleado FROM empleados WHERE nombre = 'Alberto' AND apellido1 = 'Soria');
--24.	Nombre, apellidos y cargo de aquellos que no sean representantes de ventas.
SELECT nombre, apellido1, puesto
FROM empleados
WHERE puesto NOT IN 'Representante Ventas';
--25.	Nombre de los clientes españoles
SELECT nombrecliente
FROM clientes
WHERE pais = 'EspaÃ±a';
--26.	Número de clientes de las ciudades que empiezan por M.
SELECT count(*) as total_clientes
FROM clientes 
WHERE ciudad like 'M%';
--27.	Código de empleado y el número de clientes al que atiende cada representante de ventas.
SELECT codigoempleadorepventas, count(*) as total_empleados
FROM clientes, empleados
WHERE clientes.codigoempleadorepventas = empleados.codigoempleado
GROUP BY codigoempleadorepventas;
--28.	Número de clientes que no tiene asignado representante de ventas.
SELECT count(*) as numero_clientes
FROM clientes
WHERE codigoempleadorepventas IS NULL;
--29.	Código de cliente de aquellos clientes que hicieron pagos en 2008.
SELECT codigocliente
FROM pagos
WHERE fechapago between '01/02/08' and '31/12/08'
GROUP BY codigocliente;
--30.	Distintos estados por los que puede pasar un pedido.
SELECT distinct estado
from pedidos;
--31.	Numero de pedido, código de cliente, fecha requerida y fecha de entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha requerida.
SELECT codigopedido, codigocliente, fechaesperada, fechaentrega
FROM pedidos
WHERE fechaentrega <= fechaesperada -2;
--32.	Facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el IVA y el total facturado. Nota: La base imponible se calcula sumando el coste del producto por el número de unidades vendidas. El IVA es el 21% de la base imponible.
--Por pagos
SELECT sum(cantidad) as base_imponible, 0.21 as IVA, sum(cantidad) * 0.79 as total_facturado 
FROM pagos;
--Por detalles pedidos 
SELECT sum(cantidad*preciounidad) as base_imponible, 0.21 as IVA, sum(cantidad*preciounidad) * 0.79 as total_facturado
FROM detallepedidos;
--33.	Listado con el nombre de los empleados junto con el nombre de sus jefes.
SELECT e.nombre as nombre_empleado, e2.nombre as nombre_jefe
FROM empleados e
INNER JOIN empleados e2 ON e.codigojefe = e2.codigoempleado;
--34.	Listado de clientes indicando el nombre del cliente y cuantos pedidos ha realizado.
SELECT c.nombrecliente, count(p.codigopedido) as cantidad_pedidos
FROM clientes c LEFT JOIN pedidos p ON c.codigocliente = p.codigocliente
GROUP BY c.nombrecliente;
--35.	Listado con los nombres de los clientes y el total pagado por cada uno de ellos.
SELECT nombrecliente, sum(cantidad)
FROM clientes c LEFT JOIN pagos p ON p.codigocliente = c.codigocliente
GROUP BY nombrecliente;
--36.	Cuantos empleados tiene cada oficina, mostrando el nombre de la ciudad donde está la oficina.
SELECT ciudad, sum(codigoempleado) as numero_empleados
FROM empleados e LEFT JOIN oficinas o ON e.codigooficina = o.codigooficina
GROUP BY ciudad;
--37.	Nombre, apellido, oficina (ciudad) y cargo del empleado que no represente a ningún cliente.
SELECT o.ciudad, e.nombre, e.apellido1, e.puesto 
FROM empleados e LEFT JOIN oficinas o ON o.codigooficina = e.codigooficina 
WHERE e.codigoempleado NOT IN (SELECT codigoempleadorepventas FROM clientes);
--38.	Media de unidades de stock de los productos agrupados por gama.
SELECT gama, AVG(cantidadenstock) as media_stock 
FROM productos
GROUP BY gama;
--39.	Clientes que residan en la misma ciudad donde hay una oficina, indicando dónde está la oficina.
SELECT c.nombrecliente, o.ciudad
FROM clientes c JOIN oficinas o ON o.ciudad = c.ciudad;
--40.	Clientes que residan en ciudades donde no hay oficinas ordenado por la ciudad donde residen.
SELECT c.nombrecliente, c.ciudad
FROM clientes c 
WHERE c.ciudad NOT IN (SELECT ciudad FROM oficinas)
ORDER BY c.ciudad;

--DML
--2)	Crea y ejecuta un script ‘actualiza.sql’ que realice las siguientes acciones.
--1.	Inserta una oficina con sede en Fuenlabrada
INSERT INTO OFICINAS (codigooficina, ciudad, pais, region, codigopostal, telefono, lineadireccion1, lineadireccion2) 
VALUES ('FLB-ES','Fuenlabrada','EspaÃ±a','Madrid','28940','+34 666666666','Avenida de Europa, 12','2B');
--2.	Inserta un empleado para la oficina de Fuenlabrada que sea representante de ventas
INSERT INTO EMPLEADOS (codigoempleado, nombre, apellido1, apellido2, extension, email, codigooficina, puesto) 
VALUES (32, 'Maria', 'Hernandez', 'Muñoz', '4224', 'mhernandez@gardening.es', 'FLB-ES' ,'Representante Ventas');
--3.	Inserta un cliente del representante de ventas en el punto 2.
INSERT INTO CLIENTES (codigocliente, nombrecliente, telefono, fax, lineadireccion1, ciudad, codigoempleadorepventas)
VALUES (39, 'Jardineria Alfredo', '+34 611111111', '978453215', 'Calle Miguel de Cervantes', 'Albacete', '32');
--4.	Inserta un pedido del cliente anterior (con su detalle) de al menos 2 productos.
INSERT INTO PEDIDOS (codigopedido, fechapedido, fechaesperada, fechaentrega, estado, comentarios, codigocliente)
VALUES (129, '01/04/23', '10/04/23', '10/04/23', 'Entregado', 'El pedido ha llegado correctamente', 39);

INSERT INTO DETALLEPEDIDOS(codigopedido, codigoproducto, cantidad, preciounidad, numerolinea)
VALUES (129, 'AR-009', 12, 1, 8);
INSERT INTO DETALLEPEDIDOS(codigopedido, codigoproducto, cantidad, preciounidad, numerolinea)
VALUES (129, 'FR-67', 5, 4, 8);
--5.	Actualiza el código del cliente insertado y averigua si hubo cambios en las tablas relacionadas.
UPDATE clientes set codigocliente = 34 where nombrecliente = 'Jardineria Alfredo';
--6.	Borra el cliente y verifica si hubo cambios.
DELETE FROM DetallePedidos WHERE CodigoPedido IN 
(SELECT CodigoPedido FROM Pedidos WHERE CodigoCliente = 39);

DELETE FROM Pedidos WHERE CodigoCliente = 39;

DELETE FROM Clientes WHERE CodigoCliente = 39;

--3)	Usando subconsultas en los filtros, realiza las siguientes actualizaciones:
--1.Borra los clientes que no tengan pedidos
DELETE FROM Clientes WHERE CodigoCliente NOT IN (SELECT DISTINCT CodigoCliente FROM Pedidos);
--2.Incrementa en un 20% el precio de los productos
UPDATE productos SET precioventa = precioventa * 1.2;
--3.Borra los pagos del cliente con menor límite de crédito.
DELETE FROM pagos WHERE codigocliente = (
SELECT codigocliente FROM clientes
WHERE limitecredito = (SELECT MIN(limitecredito) FROM Clientes));
--4.Establece a 0 el límite de crédito del cliente que menos unidades pedidas tenga del producto ‘OR-179’
UPDATE clientes SET limitecredito = 0 WHERE codigocliente = (
  SELECT C.codigocliente
  FROM pedidos P
  JOIN detallepedidos D ON P.codigopedido = D.codigopedido
  JOIN productos PR ON D.codigoproducto = PR.codigoproducto
  JOIN clientes C ON P.codigocliente = c.codigocliente
  WHERE PR.codigoproducto = 'OR-179'
  GROUP BY C.codigocliente
  HAVING SUM(D.cantidad) = (
    SELECT MIN(totalcantidad)
    FROM (
      SELECT SUM(D2.cantidad) AS totalcantidad
      FROM pedidos P2
      JOIN detallepedidos D2 ON P2.codigopedido = D2.codigopedido
      JOIN productos PR2 ON D2.codigoproducto = PR2.codigoproducto
      WHERE PR2.codigoproducto = 'OR-179'
      GROUP BY P2.codigocliente
    )
  )
);

--PL/SQL
--4)	Triggers 
--Cree un disparador para que cuando se borre un cliente de la base de datos, 
--se almacene en una tabla que ya existirá previamente, que se llame “clientes_borrados” 
--con la siguiente información: Nombre_cliente,Fecha_borrado,Importe_facturación. 

CREATE TABLE clientes_borrados(
Nombre_cliente VARCHAR2(50) NOT NULL,
Fecha_borrado DATE NOT NULL,
Importe_facturacion NUMBER (15,2)
);

CREATE OR REPLACE TRIGGER borrado_cliente
BEFORE DELETE ON clientes
FOR EACH ROW
DECLARE
v_importe_facturacion NUMBER (15,2);
v_fecha_borrado DATE;
BEGIN
  
  SELECT SUM(cantidad * preciounidad)
  INTO v_importe_facturacion
  FROM detallepedidos d JOIN pedidos p ON d.codigopedido = p.codigopedido 
  WHERE p.codigocliente = :OLD.codigocliente;
  
  v_fecha_borrado:= sysdate;
  
  INSERT INTO clientes_borrados (nombre_cliente, fecha_borrado, importe_facturacion)
  VALUES (:OLD.nombrecliente, v_fecha_borrado, v_importe_facturacion);
END;

--------------------------------------------------------------------------------
--5)	Procedimientos 
--Deseamos tener un procedimiento que pasemos el código de un cliente y nos liste 
--los datos de ese cliente: Código, Nombre, Ciudad y País, así como los pagos que 
--ha realizado, ordenados cronológicamente. Para finalizar que muestre la cantidad 
--total pagada. Fíjate bien en la imagen capturada para ver todos los detalles que 
--debe mostrar el procedimiento. Implementa también el tratamiento de excepciones.
CREATE OR REPLACE PROCEDURE pagos_cliente(p_codigocliente IN NUMBER)
IS
  v_nombre_cliente clientes.nombrecliente%TYPE;
  v_ciudad_cliente clientes.ciudad%TYPE;
  v_pais_cliente clientes.pais%TYPE;
  v_total_pagos pagos.cantidad%TYPE := 0;
  v_cantidad pagos.cantidad%TYPE;
BEGIN
  -- Obtener datos del cliente
  SELECT nombrecliente, ciudad, pais
  INTO v_nombre_cliente, v_ciudad_cliente, v_pais_cliente
  FROM clientes
  WHERE codigocliente = p_codigocliente;
  
  -- Obtener el total de pagos del cliente
  SELECT SUM(cantidad)
  INTO v_total_pagos
  FROM pagos
  WHERE codigocliente = p_codigocliente;

  -- Mostrar información del cliente
  DBMS_OUTPUT.PUT_LINE('CODIGO CLIENTE: ' || p_codigocliente);
  DBMS_OUTPUT.PUT_LINE('NOMBRE CLIENTE: ' || v_nombre_cliente);
  DBMS_OUTPUT.PUT_LINE('CIUDAD CLIENTE: ' || v_ciudad_cliente);
  DBMS_OUTPUT.PUT_LINE('PAIS CLIENTE: ' || v_pais_cliente);
  DBMS_OUTPUT.PUT_LINE('==========================================================');
  DBMS_OUTPUT.PUT_LINE('ID-TRANSACCION      FECHA          FORMA       CANTIDAD');
  DBMS_OUTPUT.PUT_LINE('==========================================================');

  -- Obtener pagos del cliente y mostrar información
  FOR pagos IN (SELECT idtransaccion, fechapago, formapago, cantidad
               FROM pagos
               WHERE codigocliente = p_codigocliente
               ORDER BY fechapago)
  LOOP
    DBMS_OUTPUT.PUT_LINE(pagos.idtransaccion || '       ' || pagos.fechapago || '       ' || pagos.formapago || '      ' || pagos.cantidad);
  END LOOP;

  DBMS_OUTPUT.PUT_LINE('=======================================================================');
  DBMS_OUTPUT.PUT_LINE('TOTAL PAGOS EFECTUADOS: ' || v_total_pagos);

EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('El cliente con código ' || p_codigocliente || ' no existe.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Ha ocurrido un error: ' || SQLERRM);
END;

SET SERVEROUTPUT ON;

EXEC pagos_cliente(1);

