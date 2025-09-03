/* 1.	Obtener los nombres y salarios de los empleados con m�s de 1000 euros 
de salario por orden alfab�tico. */

SELECT nombre, salario
FROM empleado
WHERE salario > 1000
ORDER BY nombre;

/*2.	Obtener el nombre de los empleados cuya comisi�n es superior al 20% de 
su salario.*/

SELECT nombre, salario, comision
FROM empleado 
WHERE comision >= salario*0.2;

/*3.	Obtener el c�digo de empleado, c�digo de departamento, nombre y sueldo 
total en pesetas, de aquellos empleados cuyo sueldo total (salario m�s comisi�n)
supera los 1800 euros. Presentarlos ordenados por c�digo de departamento y, 
dentro de �stos, por orden alfab�tico.*/

SELECT codemple, coddpto, nombre, salario*166.38 AS salario_ptas
FROM empleado
WHERE salario > 1800
ORDER BY coddpto, nombre;

/*4.	Obtener, por orden alfab�tico, los nombres de empleados cuyo salario 
igualen o superen en m�s de un 5% al salario de la empleada �MARIA JAZMIN�.*/

SELECT nombre, salario
FROM empleado
WHERE salario >= ((SELECT salario FROM empleado WHERE nombre = 'MARIA') * 1.05)
ORDER BY nombre;

/*5.	Obtener una listado ordenado por a�os en la empresa con los nombres, y 
apellidos de los empleados, y los a�os de antig�edad en la empresa.*/

SELECT nombre, TRUNC (MONTHS_BETWEEN(sysdate, fechaingreso)/12) AS antiguedad
FROM empleado
ORDER BY antiguedad;

/*6.	Obtener el nombre de los empleados que trabajan en un departamento con 
presupuesto superior a 50.000 euros. Hay que usar predicado cuantificado.*/

SELECT nombre, dpto.presupuesto, empleado.coddpto
FROM empleado, dpto
WHERE dpto.coddpto = empleado.coddpto AND dpto.presupuesto > 50000
ORDER BY nombre;

/*7.	Obtener los nombres y apellidos de empleados que m�s cobran en la 
empresa. Considerar el salario m�s la comisi�n.*/

SELECT nombre, ape1 || ' ' || ape2 apellidos, (salario + NVL(comision, 0)) as Total_Salario
FROM empleado
WHERE salario + NVL(comision, 0) = 
    (SELECT max(salario + NVL(comision, 0)) 
      FROM empleado)
;

/*8.	Obtener en orden alfab�tico los nombres de empleado cuyo salario es 
inferior al m�nimo de los empleados del departamento 1.*/

SELECT nombre, salario
FROM empleado
WHERE salario < 
    (SELECT MIN(salario) 
     FROM empleado WHERE coddpto = 1);

/*9.	Obtener los nombres de empleados que trabajan en el departamento del 
cu�l es jefe el empleado con c�digo 1.*/

SELECT nombre, dpto.coddpto, dpto.dptodepende
FROM empleado, dpto
WHERE empleado.coddpto = dpto.coddpto AND dpto.codemplejefe = 1;

/*10.	Obtener los nombres de los empleados cuyo primer apellido empiece 
por las letras p, q, r, s.*/

SELECT nombre, ape1
FROM empleado
WHERE ape1 LIKE 'P%' OR ape1 LIKE 'Q%' OR ape1 LIKE 'R%' OR ape1 LIKE 'S%'
;

/*11.	Obtener los empleados cuyo nombre de pila contenga el nombre JUAN.*/

SELECT nombre
FROM empleado
WHERE nombre LIKE '%JUAN%';

/*12.	Obtener los nombres de los empleados que viven en ciudades en las que 
hay alg�n centro de trabajo.*/

SELECT nombre, empleado.localidad
FROM empleado
WHERE LOWER(localidad) = 
ANY (SELECT LOWER(localidad) from centro);

/*13.	Obtener el nombre del jefe de departamento que tiene mayor salario de 
entre los jefes de departamento.*/

SELECT nombre
FROM empleado
WHERE salario = 
    (SELECT max(salario) 
     FROM empleado
     WHERE codemple IN 
        (SELECT codemplejefe 
         FROM dpto));

/*14.	Obtener en orden alfab�tico los salarios y nombres de los empleados
cuyo salario sea superior al 60% del m�ximo salario de la empresa.*/

SELECT nombre, salario
FROM empleado
WHERE salario > (SELECT max(salario) * 0.6 FROM empleado)
ORDER BY nombre;

/*15.	Obtener en cu�ntas ciudades distintas viven los empleados.*/

SELECT COUNT (DISTINCT localidad) AS localidades_distintas
FROM empleado;

/*16.	El nombre y apellidos del empleado que m�s salario cobra.*/

SELECT nombre, ape1 || ' ' || ape2 apellidos, salario
FROM empleado
WHERE salario =
    (SELECT MAX(salario) FROM empleado);

/*17.	Obtener las localidades y n�mero de empleados de aquellas en las que 
viven m�s de 3 empleados.*/

SELECT localidad, COUNT(*) AS numempleados
FROM empleado
GROUP BY localidad
HAVING COUNT(*) > 3;

/*18.	Obtener, para cada departamento, cu�ntos empleados trabajan, la suma de 
sus salarios y la suma de sus comisiones, para aquellos departamentos en los 
que hay alg�n empleado cuyo salario es superior a 1700 euros.*/

SELECT coddpto, COUNT(*) AS numempleados, SUM(salario) AS total_salarios, SUM(NVL(comision, 0)) AS total_comisiones
FROM empleado
WHERE coddpto = ANY (SELECT coddpto FROM empleado WHERE salario > 1700)
GROUP BY coddpto;

/*19.	Obtener el departamento que m�s empleados tiene.*/

/* OPCION 1: */
SELECT t.coddpto, t.numempleados
FROM (SELECT d.coddpto, COUNT(*) AS numempleados
      FROM empleado e, dpto d
      WHERE e.coddpto = d.coddpto
      GROUP BY d.coddpto) T
WHERE t.numempleados = (SELECT MAX(t2.numempleados) 
                        FROM(SELECT d.coddpto, COUNT(*) AS numempleados
                             FROM empleado e, dpto d
                             WHERE e.coddpto = d.coddpto
                             GROUP BY d.coddpto) T2);

/* OPCION 2: */                             
SELECT coddpto, COUNT(*) AS num_empleados
FROM empleado
GROUP BY coddpto
HAVING COUNT(*) = (SELECT MAX(empleados_numero) 
                   FROM (SELECT COUNT(*) AS empleados_numero 
                   FROM empleado 
                   GROUP BY coddpto));
                   
/*20.	Obtener los nombres de todos los centros y los departamentos que se 
ubican en cada uno, as� como aquellos centros que no tienen departamentos.*/

SELECT c.codcentro, COUNT(*) AS num_departamentos
FROM centro c LEFT JOIN dpto d ON c.codcentro = d.codcentro
GROUP BY c.codcentro;

/*21.	Obtener el nombre del departamento de m�s alto nivel, es decir, aquel 
que no depende de ning�n otro.*/

SELECT coddpto, denominacion
FROM dpto
WHERE coddptodepende IS NULL;

/*22.	Obtener todos los departamentos existentes en la empresa y los empleados
(si los tiene) que pertenecen a �l.*/

/* OPCION 1: */
SELECT e.nombre, d.denominacion
FROM empleado e LEFT JOIN dpto d ON e.coddpto = d.coddpto
ORDER BY denominacion;

/* OPCION 2: */
SELECT d.denominacion, COUNT(*) as num_empleados
FROM empleado e LEFT JOIN dpto d ON e.coddpto = d.coddpto
GROUP BY d.denominacion;

/*23.	Obtener un listado en el que aparezcan todos los departamentos 
existentes y el departamento del cual depende, si depende de alguno.*/

/* OPCION 1: */
SELECT coddpto, denominacion, coddptodepende
FROM dpto
WHERE coddptodepende IS NOT NULL;

/* OPCION 2: */
SELECT d1.coddpto, d1.denominacion, d2.denominacion AS dpto_depende
FROM dpto d1, dpto d2
WHERE d1.coddptodepende = d2.coddpto;

/*24.	Obtener un listado, ordenado alfab�ticamente, donde aparezcan los 
nombres de los empleados y a continuaci�n el literal "tiene comisi�n" si la 
tiene, y "no tiene comisi�n" si no la tiene.*/

/* OPCION 1: */
SELECT nombre, DECODE(comision, NULL, 'No tiene comision', 'Tiene comision') AS estado_comision1
FROM empleado
ORDER BY nombre;

/* OPCION 2: */
SELECT nombre,
CASE WHEN comision IS NULL THEN 'No tiene comision' ELSE 'Tiene comision' END AS estado_comision2
FROM empleado
ORDER BY NOMBRE;

/*25.   Obtener un listado de las localidades en las que hay centros y no vive ning�n 
empleado, ordenado alfab�ticamente.*/

SELECT c.localidad, count(*)AS num_empleados
FROM centro c LEFT JOIN empleado e ON LOWER(c.localidad) = LOWER(e.localidad) 
GROUP BY c.localidad
HAVING COUNT(*) = 0;

/*26.	Obtener un listado de las localidades en las que hay centros y adem�s 
vive al menos un empleado, ordenado alfab�ticamente.*/

SELECT c.localidad, count(*)AS num_empleados
FROM centro c LEFT JOIN empleado e ON UPPER(c.localidad) = UPPER(e.localidad) 
GROUP BY c.localidad
HAVING COUNT(*) >= 1;

/*27.	Esta cuesti�n punt�a  doble. Se desea dar una gratificaci�n por 
navidades en funci�n de la antig�edad en la empresa siguiendo estas pautas:
o	Si lleva entre 1 y 5 a�os, se le dar� 100 euros
o	Si lleva entre 6 y 10 a�os, se le dar� 50 euros por a�o
o	Si lleva entre 11 y 20 a�os, se le dar� 70 euros por a�o
o	Si lleva m�s de 21 a�os, se le dar� 100 euros por a�o
28.	Obtener un listado de los empleados, ordenado alfab�ticamente, 
indicando cu�nto le corresponde de gratificaci�n.*/

SELECT nombre, t.antiguedad,
CASE WHEN t.antiguedad >= 1 and t.antiguedad <=5 THEN 100
WHEN t.antiguedad >= 6 and t.antiguedad <=10 THEN 50
WHEN t.antiguedad >= 11 and t.antiguedad <=20 THEN 70
WHEN t.antiguedad > 20 THEN 100
ELSE 0
END AS gratificacion
FROM (SELECT nombre, FLOOR(MONTHS_BETWEEN(sysdate, fechaingreso)/12) AS antiguedad 
FROM empleado)T
ORDER BY nombre;

/*29.	Obtener los nombres y apellidos de los empleados que no son jefes 
de departamento.*/

SELECT nombre, ape1 || ' ' || ape2 apellidos, codemple
FROM empleado
WHERE codemple NOT IN (SELECT codemplejefe FROM dpto)
ORDER BY nombre;


