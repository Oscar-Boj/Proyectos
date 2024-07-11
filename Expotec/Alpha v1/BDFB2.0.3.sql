create database Banco2;
use Banco2;

Create Table usuario(
dpi bigint primary key not null,
nombre varchar(50),
apellido varchar(50),
correo varchar(50),
telefono int,
pass varchar(50),
pin int
);
insert into usuario values(1,'Edwin','Cruz','ESCP@gmail.com',12345678,'xd',123);
insert into usuario values(3,'Steve','Cruz','ESCP@gmail.com',12345678,'xd',123);
-- insert into usuario values(1,123,123);
-- INSERT INTO usuario (dpi, nombre, apellido, correo, telefono, pass, pin) VALUES (?, ?, ?, ?, ?, ?, ?);
-- select * from usuario;

create table rol(
id_rol int primary key auto_increment not null,
nombre varchar(50)
);
-- insert into rol (nombre) values('gerente');
-- select * from rol;

create table usuario_rol(
dpi bigint primary key not null,
id_rol int,
foreign key (dpi) references usuario(dpi) on delete cascade on update cascade,
foreign key (id_rol) references rol(id_rol) on delete cascade on update cascade
);
-- INSERT INTO usuario_rol values (3, 3);
-- select * from usuario_rol;

create table tipo_cuenta(
id_tipo_cuenta int primary key auto_increment not null,
nombre varchar(50) not null
);
-- insert into tipo_cuenta (nombre) values('Inversion');
-- select * from tipo_cuenta;

create table cuenta(
numero_cuenta int primary key not null,
dpi bigint,
id_tipo_cuenta int,
foreign key (dpi) references usuario(dpi) on delete cascade on update cascade,
foreign key (id_tipo_cuenta) references tipo_cuenta(id_tipo_cuenta) on delete cascade on update cascade
);
-- insert into cuenta values(1,'00001','1');

create table transaccion(
id_transaccion int primary key auto_increment not null,
numero_cuenta int,
monto float not null,
tipo_transaccion varchar(50) not null,
fecha_transaccion date,
cuenta_destino int null,
foreign key (numero_cuenta) references cuenta(numero_cuenta) on delete cascade on update cascade
);
-- insert into transaccion values(1,'00001','1200.00','D',NOW(),200);
-- select * from transaccion;