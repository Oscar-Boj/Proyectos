CREATE DATABASE TemarioF2;
USE TemarioF2;

CREATE TABLE usuarios(
id_usuario int primary key auto_increment not null,
usuario varchar(50) not null,
correo varchar(100) not null,
telefono int not null,
contraseña varchar(50) not null,
rol_usuario varchar(25) not null
);
SELECT * FROM usuarios;

INSERT INTO usuarios(usuario, correo, telefono, contraseña, rol_usuario) VALUES('Oscar', 'oscar.boj2000@gmail.com', '35755728', '123', 'administrador');
INSERT INTO usuarios(usuario, correo, telefono, contraseña, rol_usuario) VALUES('Daniel', 'daniel2000@gmail.com', '12346749', '123', 'responsable');
INSERT INTO usuarios(usuario, correo, telefono, contraseña, rol_usuario) VALUES('Sergio', 'sergio2000@gmail.com', '35497825', '123', 'tecnico');

CREATE TABLE clientes(
id_cliente int primary key auto_increment not null,
nombre varchar(50) not null,
telefono int not null,
correo varchar(100) not null
);
SELECT * FROM clientes;

INSERT INTO clientes(nombre, telefono, correo) VALUES('Manuel', '49875612', 'manuel@gmail.com');

CREATE TABLE incidencias(
id_incidencia int primary key auto_increment not null,
descripcion varchar(255) not null,
fecha_inicio date,
fecha_finalizada date,
estado varchar(25) not null,
id_tecnico int not null,
id_cliente int not null,
foreign key (id_tecnico) references usuarios(id_usuario) on delete cascade on update cascade,
foreign key (id_cliente) references clientes(id_cliente) on delete cascade on update cascade
);
SELECT * FROM incidencias;

CREATE TABLE tareas(
id_tarea int primary key auto_increment not null,
descripcion varchar(255) not null,
fecha_asignacion date,
estado varchar(25) not null,
id_tecnico int,
id_responsable int,
foreign key (id_tecnico) references usuarios(id_usuario) on delete cascade on update cascade,
foreign key (id_responsable) references usuarios(id_usuario) on delete cascade on update cascade
);
SELECT * FROM tareas;

CREATE TABLE visitas(
id_visita int primary key auto_increment not null,
fecha date,
id_tecnico int not null,
id_cliente int not null,
foreign key (id_tecnico) references usuarios(id_usuario) on delete cascade on update cascade,
foreign key (id_cliente) references clientes(id_cliente) on delete cascade on update cascade
);
SELECT * FROM visitas;

CREATE TABLE equipos(
id_equipo int primary key auto_increment not null,
id_cliente int not null,
descripcion varchar(255) not null,
foreign key (id_cliente) references clientes(id_cliente) on delete cascade on update cascade
);
SELECT * FROM equipos;

CREATE TABLE asistencias(
id_asistencia int primary key auto_increment not null,
id_tecnico int not null,
id_cliente int not null,
fecha date,
foreign key (id_tecnico) references usuarios(id_usuario) on delete cascade on update cascade,
foreign key (id_cliente) references clientes(id_cliente) on delete cascade on update cascade
);
SELECT * FROM asistencias;