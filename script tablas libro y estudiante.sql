CREATE TABLE Estudiante(
	id VARCHAR(15) NOT NULL PRIMARY KEY,
    nombre VARCHAR(45),
    ciudad VARCHAR(45),
    telefono VARCHAR(13),
    correo VARCHAR(25),
    universidad VARCHAR(45)
);

CREATE TABLE Libro(
	codigo VARCHAR(15) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50),
    autor VARCHAR(45),
    editor VARCHAR(45),
    pais VARCHAR(30),
    lenguaje VARCHAR(25),
    detalles VARCHAR(100),
    propietario VARCHAR(15),
    
    CONSTRAINT c_Libro_Estudiante_id
    FOREIGN KEY fk_Libro_Estudiante_id (propietario)
    REFERENCES Estudiante (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);