create database IES_PF1;
use IES_PF1;

create table Login(
Nombre varchar(20),
Apellido varchar(20),
Usuario varchar(25),
Contraseña varchar(30),
rol varchar(20)
);
select * from Login;
drop table Login;

insert into Login values('Oscar','Boj','Admin','IES2023','Administrador');
insert into Login values('Josue','Lopez','JosLop','Josue123','Empleado');
insert into Login values('Alexander','Galvez','AlexGal','Alex123','Empleado');
insert into Login values('Marco','Boror','MarBor','Marco123','Cliente');
insert into Login values('Andrea','Gonzales','AndreGon','Andrea123','Cliente');

create table Cliente(
id_cliente int primary key,
Nombre varchar(20) not null,
Apellido varchar(20) not null,
edad int not null
);
drop table Cliente;

create table Empleado(
id_empleado int primary key,
Nombre varchar(20) not null,
Apellido varchar(20) not null,
Edad int not null,
Fecha_ingreso date not null,
Salario_mensual float not null
);
drop table Empleado;

create table Producto(
id_producto int primary key,
Nombre varchar(20) not null,
costo float not null,
cantidad int not null
);
drop table Producto;

create table Factura(
id_factura int primary key,
id_cliente int not null,
Nombre varchar(20) not null,
Monto float not null,
IVA float,
foreign key (id_cliente) references Cliente(id_cliente) on delete cascade on update cascade
);
drop table Factura;