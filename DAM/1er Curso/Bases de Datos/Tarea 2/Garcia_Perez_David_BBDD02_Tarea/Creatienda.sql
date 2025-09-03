CREATE TABLE FAMILIA( --CREAMOS LA TABLA FAMILIA--
Codfamilia NUMBER(3,0) PRIMARY KEY, --A�ado la columna Codfamilia de tipo num�rico de 3 d�gitos enteros y 0 decimales, y como clave primaria--
Denofamilia VARCHAR(50) UNIQUE NOT NULL);--A�ado la columna Denofamilia de tipo alfanum�rico de 50 caracteres, no puede haber dos familias con la misma denominaci�n y debe tener contenido--

CREATE TABLE PRODUCTO( --CREAMOS LA TABLA PRODUCTO--
Codproducto NUMBER(5,0) PRIMARY KEY, --A�ado la columna Codproducto de tipo num�rico con 5 d�gitos enteros y 0 decimales y como clave primaria--
Denoproducto VARCHAR(20) NOT NULL, --A�ado la columna Denoproducto de tipo alfanum�rico con 20 caracteres, debe de tener contenido.--
Descripcion VARCHAR(100),--A�ado la columna Descripci�n de tipo alfanum�rico con 100 caracteres.
PrecioBase NUMBER(6,2) NOT NULL,--A�ado la columna PrecioBase de tipo num�rico con 6 d�gitos enteros y 2 decimales, debe de tener contenido--
PorcReposicion NUMBER(3,0),--A�ado la columna PorcReposicion de tipo numerico con 3 d�gitos enteros y 0 decimales--
UnidadesMinimas NUMBER(4,0) NOT NULL,--A�ado la columna UnidadesMinimas de tipo numerico con 3 digitos enteros y 0 decimales, debe de tener contenido.--
Codfamilia NUMBER(3,0) NOT NULL, --A�ado la columna Codfamilia de tipo num�rico con 3 digitos enteros y 0 decimales, debe de tener contenido--
CONSTRAINT PRECIO_BASE_CHK CHECK (PrecioBase > 0),--Creo restricci�n con nombre PRECIO_BASE_CHK, debe de contener valores mayores que 0.--
CONSTRAINT PORC_REPOSICION_CHK CHECK (PorcReposicion > 0), --Creo restricci�n con nombre PORC_REPOSICION_CHK, debe de contener valores mayores que 0.--
CONSTRAINT UNIDADES_MINIMAS_CHK CHECK(UnidadesMinimas > 0),--Creo restricci�n con nombre UNIDADES_MINIMAS_CHK, debe de contener valores mayores que 0.--
CONSTRAINT FAMILIA_FK FOREIGN KEY (Codfamilia) REFERENCES FAMILIA(Codfamilia));--Creo restricci�n con nombre FAMILIA_FK, clave for�nea Codfamilia perteneciente a la tabla FAMILIA.--

CREATE TABLE TIENDA(--CREO LA TABLA TIENDA--
Codtienda NUMBER(3,0) PRIMARY KEY,--Creo columna Codtienda de tipo num�rico con 3 d�gitos enteros y 0 decimales como clave primaria.--
Denotienda VARCHAR(20) NOT NULL,--Creo columna Denotienda de tipo alfanum�rico con 20 d�gitos, debe de tener contenido.--
Telefono VARCHAR(11),--Creo la columna Tel�fono de tipo alfanum�rico con 11 car�cteres.--
CodigoPostal VARCHAR(5) NOT NULL,--Creo la columna CodigoPostal de tipo alfanum�rico con 5 car�cteres, debe tener contenido.--
Provincia VARCHAR(5) NOT NULL);--Creo la columna Provincia de tipo alfanum�rico con 5 car�cteres, debe tener contenido.--

CREATE TABLE STOCK(--CREO LA TABLA STOCK--
Codtienda NUMBER(3,0),--Creo la columna Codtienda de tipo num�rico con 3 d�gitos enteros y 0 decimales.--
Codproducto NUMBER(5,0),--Creo la columna Codproducto de tipo num�rico con 5 d�gitos enteros y 0 decimales.--
Unidades NUMBER(6,0) NOT NULL,--Creo la columna Unidades de tipo num�rico con 6 d�gitos enteros y 0 decimales.--
PRIMARY KEY (Codtienda, Codproducto), -- Establezco como claves primarias las columnas Codtienda y Codproducto.--
CONSTRAINT CODTIENDA_FK FOREIGN KEY (Codtienda) REFERENCES TIENDA(Codtienda), --Creo restricci�n con nombre CODTIENDA_FK, clave for�nea Codtienda perteneciente a la tabla TIENDA.--
CONSTRAINT CODPRODUCTO_FK FOREIGN KEY (Codproducto) REFERENCES PRODUCTO(Codproducto),--Creo restricci�n con nombre CODPRODUCTO_FK, clave for�nea CodProducto perteneciente a la tabla PRODUCTO.
CONSTRAINT UNIDADES_CHK CHECK (Unidades >= 0));--Creo restricci�n con nombre UNIDADES_CHK, el valor para Unidades debe de ser mayor que 0.--

