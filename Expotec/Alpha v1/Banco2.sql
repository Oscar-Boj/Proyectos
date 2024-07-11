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
-- insert into usuario values(1,123,123);
INSERT INTO usuario (dpi, nombre, apellido, correo, telefono, pass, pin) VALUES (?, ?, ?, ?, ?, ?, ?);
select * from usuario;

create table rol(
id_rol int primary key auto_increment not null,
nombre varchar(50)
);
insert into rol (nombre) values('cliente');
select * from rol;
update rol set nombre = 'gerente' where id_rol = 3;

create table usuario_rol(
dpi bigint primary key not null,
id_rol int,
foreign key (dpi) references usuario(dpi) on delete cascade on update cascade,
foreign key (id_rol) references rol(id_rol) on delete cascade on update cascade
);
INSERT INTO usuario_rol (dpi, id_rol) VALUES (300267750101, 1);
select * from usuario_rol;

create table tipo_cuenta(
id_tipo_cuenta int primary key auto_increment not null,
nombre varchar(50) not null
);
insert into tipo_cuenta (nombre) values('Inversion');
select * from tipo_cuenta;

create table cuenta(
numero_cuenta int primary key not null,
dpi bigint,
id_tipo_cuenta int,
foreign key (dpi) references usuario(dpi) on delete cascade on update cascade,
foreign key (id_tipo_cuenta) references tipo_cuenta(id_tipo_cuenta) on delete cascade on update cascade
);
insert into cuenta values(66286, 300267750101,1);
select * from cuenta;
select numero_cuenta from cuenta where dpi = ?;

create table transaccion(
id_transaccion int primary key auto_increment not null,
numero_cuenta int,
monto float not null,
tipo_transaccion varchar(50) not null,
fecha_transaccion date,
cuenta_destino int null,
foreign key (numero_cuenta) references cuenta(numero_cuenta) on delete cascade on update cascade
);
insert into transaccion (numero_cuenta, monto, tipo_transaccion, fecha_transaccion, cuenta_destino) 
values(1260973702,-100.00,'D',sysdate(),null);
select * from transaccion;
update transaccion set tipo_transaccion = 'C' where id_transaccion = 1;
select ROUND(sum(monto),2) from transaccion where numero_cuenta = 21911;

select us.dpi, us.pass, us.pin from usuario us
inner join cuenta ct on ct.dpi = us.dpi
where ct.numero_cuenta = 66286;

select us.dpi, us.pin, us.pass, usr.id_rol from usuario us
inner join usuario_rol usr on usr.dpi = us.dpi
where usr.id_rol = 1;

select us.dpi, us.pin, us.pass, usr.id_rol from usuario us
inner join usuario_rol usr on usr.dpi = us.dpi
where usr.id_rol = 2;

select us.dpi, us.pin, us.pass, usr.id_rol from usuario us
inner join usuario_rol usr on usr.dpi = us.dpi
where usr.id_rol = 3;

select * from transaccion where numero_cuenta = 1260973702; 

select 
id_transaccion, 
fecha_transaccion,
case tipo_transaccion 
when 'D' 
then 'DEBITO'
when 'C'
then 'CREDITO' 
else tipo_transaccion
end tipo_transaccion, monto from transaccion where numero_cuenta = 1260973702;

select ct.numero_cuenta, tc.nombre, sum(ts.monto) 
from usuario us 
inner join cuenta ct on ct.dpi = us.dpi
inner join tipo_cuenta tc on tc.id_tipo_cuenta = ct.id_tipo_cuenta
inner join transaccion ts on ts.numero_cuenta = ct.numero_cuenta
where us.dpi = 325468520101;

select ROUND(COALESCE(sum(monto),0),2) from transaccion where numero_cuenta = (select numero_cuenta from cuenta where dpi = 2 limit 1);

select tc.nombre tipo_cuenta, 
ct.numero_cuenta,
(select ROUND(COALESCE(sum(monto),0),2) from transaccion where numero_cuenta = (select numero_cuenta from cuenta where dpi = 2 and numero_cuenta = 1603035 limit 1)) saldo
from cuenta ct
inner join tipo_cuenta tc on tc.id_tipo_cuenta = ct.id_tipo_cuenta 
where ct.dpi = 2 and ct.numero_cuenta = 1603035;

select dpi, nombre, apellido, correo, telefono from usuario where dpi = 2;

select numero_cuenta from cuenta where dpi = 2;