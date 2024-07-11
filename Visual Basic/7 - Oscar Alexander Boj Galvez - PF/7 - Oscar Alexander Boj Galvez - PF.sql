CREATE DATABASE ProyectoF;
USE ProyectoF;

CREATE TABLE Administrador(
Id_Usuario int not null PRIMARY KEY,
Usuario varchar(100),
Contraseña varchar(100)
);

CREATE TABLE Estudiante(
Id_Estudiante int not null PRIMARY KEY,
Usuario varchar(100),
Contraseña varchar(100)
);

CREATE TABLE Libros(
ID_Libro int not null PRIMARY KEY,
Titulo varchar(100),
Categoria varchar(50),
Autor varchar(100),
Fecha_Publicacion date,
Cantidad int
);

CREATE TABLE CuentaEstudiante(
Id_Estudiante int FOREIGN KEY REFERENCES Estudiante(Id_Estudiante),
Id_Libro int FOREIGN KEY REFERENCES Libros(Id_Libro),
Id_Prestamo int FOREIGN KEY REFERENCES Prestamo(Id_Prestamo)
);

CREATE TABLE Prestamo(
Id_Prestamo int not null PRIMARY KEY,
Titulo varchar(100),
Categoria varchar(50),
Autor varchar(100),
Fecha_Prestamo date,
Cantidad int
);

CREATE TABLE Devolucion(
Id_Devolucion int not null PRIMARY KEY,
Id_Prestamo int FOREIGN KEY REFERENCES Prestamo(Id_Prestamo),
Titulo varchar(100),
Categoria varchar(50),
Autor varchar(100),
Fecha_Devol date,
Cantidad int
);