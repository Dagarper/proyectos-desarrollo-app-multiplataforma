ALTER TABLE STOCK ADD FechaUltimaEntrada DATE DEFAULT SYSDATE;--Incluyo columna FechaUltimaEntrada en la tabla STOCK que toma el valor de la fecha actual.-- 
ALTER TABLE STOCK ADD Beneficio NUMBER (1,0);--Incluyo columna Beneficio de tipo num�rico con 1 d�gito entero y 0 decimales a la tabla STOCK--
ALTER TABLE STOCK ADD CONSTRAINT BENEFICIO_CHK CHECK (Beneficio >= 1 AND Beneficio <= 5);--Modifico valores de la columna Beneficio (nombre de la modificaci�n BENEFICIO_CHK) de la tabla STOCK, los valores deben de estar entre 1 y 5.

ALTER TABLE PRODUCTO DROP COLUMN Descripcion; --Borro la columna Descripcion de la tabla PRODUCTO.--

ALTER TABLE PRODUCTO ADD perecedero VARCHAR (1); --Incluyo la columna perecedero de tipo alfanum�rico con 1 caracter en la tabla PRODUCTO.--
ALTER TABLE PRODUCTO ADD CONSTRAINT PERECEDERO_CHK CHECK (perecedero IN ('S','N'));--A�ado restricci�n con nombre RECEDERO_CHK a la columna perecedero, los valores de perecedero deben de ser S o N.--

ALTER TABLE PRODUCTO MODIFY Denoproducto VARCHAR (50);--Modifico columna Denoproducto de la tabla PRODUCTO, n�mero de caracteres 50.--

ALTER TABLE FAMILIA ADD IVA NUMBER (2,0);--A�ado columna IVA a la tabla FAMILIA, de tipo num�rico con 2 valores enteros y 0 decimales.--
ALTER TABLE FAMILIA ADD CONSTRAINT IVA_CHK CHECK (IVA IN ('21','10','4'));--A�ado restricci�n con nombre IVA_CHK a la columna IVA, los valores deben ser 21, 10 o 4.

ALTER TABLE TIENDA ADD CONSTRAINT TIENDASRESTRING_CHK UNIQUE (CodigoPostal);--Modifico la tabla TIENDA, con nombre de la restricci�n TIENDASRESTRING_CHK para que no pueda haber m�s de 1 tienda con el mismo CodigoPostal--

RENAME STOCK TO PRODXTIENDAS;--Renombro tabla STOCK por nombre PRODXTIENDAS--

DELETE FROM FAMILIA;--Borrar de la tabla FAMILIA--
ALTER TABLE PRODUCTO DROP CONSTRAINT FAMILIA_FK;--Modifico la tabla PRODUCTO, eliminando la restricci�n FAMILIA_FK, quitando la clave primaria a la columna CodFamilia(clave for�nea que pertenece a la tabla FAMILIA) para poder borrar la tabla--
DROP TABLE FAMILIA;--Borro tabla familia--
--Procedo a conectar el usuario administrado para crear el usuario C##INVITADO.--
GRANT ALL ON PRODUCTO TO C##INVITADO;--Doy todos los privilegios sobre la tabla PRODUCTO al usuario C##INVITADO.--

REVOKE ALTER, DELETE ON PRODUCTO FROM C##INVITADO;--Retiro todos los privilegios al usuario C##INVITADO sobre la tabla PRODUCTO.-- 
