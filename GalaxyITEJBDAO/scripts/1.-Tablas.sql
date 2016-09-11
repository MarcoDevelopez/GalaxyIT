CREATE TABLE EMPLEADO
(
	ID				NUMERIC				NOT NULL			PRIMARY KEY,
	NOMBRES		VARCHAR2(50)	NOT NULL,
	APELLIDOS	VARCHAR2(50)	NULL,
	DIRECCION	VARCHAR2(500)	NULL,
	PAIS			VARCHAR2(50)	NULL,
	ESTADO		CHAR(1)				NULL,
	SITUACION	CHAR(2)				NULL
);

SELECT * FROM EMPLEADO;