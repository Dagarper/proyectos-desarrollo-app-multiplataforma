CREATE TABLE FAMILIA( --CREAMOS LA TABLA FAMILIA--
Codfamilia NUMBER(3,0) PRIMARY KEY, --Añado la columna Codfamilia de tipo numérico de 3 dígitos enteros y 0 decimales, y como clave primaria--
Denofamilia VARCHAR(50) UNIQUE NOT NULL);--Añado la columna Denofamilia de tipo alfanumérico de 50 caracteres, no puede haber dos familias con la misma denominación y debe tener contenido--

CREATE TABLE PRODUCTO( --CREAMOS LA TABLA PRODUCTO--
Codproducto NUMBER(5,0) PRIMARY KEY, --Añado la columna Codproducto de tipo numérico con 5 dígitos enteros y 0 decimales y como clave primaria--
Denoproducto VARCHAR(20) NOT NULL, --Añado la columna Denoproducto de tipo alfanumérico con 20 caracteres, debe de tener contenido.--
Descripcion VARCHAR(100),--Añado la columna Descripción de tipo alfanumérico con 100 caracteres.
PrecioBase NUMBER(6,2) NOT NULL,--Añado la columna PrecioBase de tipo numérico con 6 dígitos enteros y 2 decimales, debe de tener contenido--
PorcReposicion NUMBER(3,0),--Añado la columna PorcReposicion de tipo numerico con 3 dígitos enteros y 0 decimales--
UnidadesMinimas NUMBER(4,0) NOT NULL,--Añado la columna UnidadesMinimas de tipo numerico con 3 digitos enteros y 0 decimales, debe de tener contenido.--
Codfamilia NUMBER(3,0) NOT NULL, --Añado la columna Codfamilia de tipo numérico con 3 digitos enteros y 0 decimales, debe de tener contenido--
CONSTRAINT PRECIO_BASE_CHK CHECK (PrecioBase > 0),--Creo restricción con nombre PRECIO_BASE_CHK, debe de contener valores mayores que 0.--
CONSTRAINT PORC_REPOSICION_CHK CHECK (PorcReposicion > 0), --Creo restricción con nombre PORC_REPOSICION_CHK, debe de contener valores mayores que 0.--
CONSTRAINT UNIDADES_MINIMAS_CHK CHECK(UnidadesMinimas > 0),--Creo restricción con nombre UNIDADES_MINIMAS_CHK, debe de contener valores mayores que 0.--
CONSTRAINT FAMILIA_FK FOREIGN KEY (Codfamilia) REFERENCES FAMILIA(Codfamilia));--Creo restricción con nombre FAMILIA_FK, clave foránea Codfamilia perteneciente a la tabla FAMILIA.--

CREATE TABLE TIENDA(--CREO LA TABLA TIENDA--
Codtienda NUMBER(3,0) PRIMARY KEY,--Creo columna Codtienda de tipo numérico con 3 dígitos enteros y 0 decimales como clave primaria.--
Denotienda VARCHAR(20) NOT NULL,--Creo columna Denotienda de tipo alfanumérico con 20 dígitos, debe de tener contenido.--
Telefono VARCHAR(11),--Creo la columna Teléfono de tipo alfanumérico con 11 carácteres.--
CodigoPostal VARCHAR(5) NOT NULL,--Creo la columna CodigoPostal de tipo alfanumérico con 5 carácteres, debe tener contenido.--
Provincia VARCHAR(5) NOT NULL);--Creo la columna Provincia de tipo alfanumérico con 5 carácteres, debe tener contenido.--

CREATE TABLE STOCK(--CREO LA TABLA STOCK--
Codtienda NUMBER(3,0),--Creo la columna Codtienda de tipo numérico con 3 dígitos enteros y 0 decimales.--
Codproducto NUMBER(5,0),--Creo la columna Codproducto de tipo numérico con 5 dígitos enteros y 0 decimales.--
Unidades NUMBER(6,0) NOT NULL,--Creo la columna Unidades de tipo numérico con 6 dígitos enteros y 0 decimales.--
PRIMARY KEY (Codtienda, Codproducto), -- Establezco como claves primarias las columnas Codtienda y Codproducto.--
CONSTRAINT CODTIENDA_FK FOREIGN KEY (Codtienda) REFERENCES TIENDA(Codtienda), --Creo restricción con nombre CODTIENDA_FK, clave foránea Codtienda perteneciente a la tabla TIENDA.--
CONSTRAINT CODPRODUCTO_FK FOREIGN KEY (Codproducto) REFERENCES PRODUCTO(Codproducto),--Creo restricción con nombre CODPRODUCTO_FK, clave foránea CodProducto perteneciente a la tabla PRODUCTO.
CONSTRAINT UNIDADES_CHK CHECK (Unidades >= 0));--Creo restricción con nombre UNIDADES_CHK, el valor para Unidades debe de ser mayor que 0.--

