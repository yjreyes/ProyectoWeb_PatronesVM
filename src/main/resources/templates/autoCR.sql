create database AutoCR;

use AutoCr;

create table usuario(
id_usuario int not null auto_increment primary key,
nombre varchar(20) not null,
apellidos varchar(30) not null,
correo varchar(25) null,
telefono varchar(15) null,
contraseña varchar(200) not null)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

create table roles(
id_rol int not null auto_increment primary key,
nombre varchar(20) not null,
id_usuario int,
foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

create table tipo(
id_tipo int not null auto_increment primary key,
descripcion varchar(30) not null)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

create table vehiculo(
id_vehiculo int not null auto_increment primary key,
id_tipo int not null,
modelo varchar(15) not null,
marca varchar(15) not null,
anno int not null,
kilometraje int null,
precio double not null,
ruta_imagen varchar(200),
foreign key(id_tipo) references Tipo(id_tipo))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

insert into tipo(descripcion)
values('Alquiler'),('Venta');

insert into vehiculo(id_tipo,modelo,marca,anno,kilometraje,precio,ruta_imagen)
values(1,'Yaris','Toyota',2008,150000,30000,'https://firebasestorage.googleapis.com/v0/b/vehiculos-4f017.appspot.com/o/imagenes%2FYaris%202008.jpg?alt=media&token=99189d74-1e36-416e-9b88-36e5005508d0'),
(1,'Picanto','KIA',2008,100000,27000,'https://firebasestorage.googleapis.com/v0/b/vehiculos-4f017.appspot.com/o/imagenes%2FPicanto%202008.jpg?alt=media&token=d276ab4c-4453-4dea-8865-952c24e81e36'),
(1,'Accent','Hyundai',2009,200000,25000,'https://firebasestorage.googleapis.com/v0/b/vehiculos-4f017.appspot.com/o/imagenes%2FAccent%202009.jpg?alt=media&token=478960b5-0b0c-4c2b-9ed7-a792bfe113d2'),
(1,'Yaris','Toyota',2008,160000,30000,'https://firebasestorage.googleapis.com/v0/b/vehiculos-4f017.appspot.com/o/imagenes%2FYaris%202008_2.jpg?alt=media&token=f0810a75-66a5-4d50-a5b7-b71fe1155efb'),
(1,'Corolla','Toyota',2010,170000,35000,'https://firebasestorage.googleapis.com/v0/b/vehiculos-4f017.appspot.com/o/imagenes%2FCorolla%202010.jpg?alt=media&token=456e0ab9-a065-4091-ab12-fff6e6c179d8'),
(2,'Sentra','Nissan',2013,50000,7000000,'https://firebasestorage.googleapis.com/v0/b/vehiculos-4f017.appspot.com/o/imagenes%2FSentra%202013.jpg?alt=media&token=6605497d-cdf9-4443-9ec4-1343f26b7b78'),
(2,'Montero','Mitsubichi',2014,45000,10000000,'https://firebasestorage.googleapis.com/v0/b/vehiculos-4f017.appspot.com/o/imagenes%2FMontero%202014.jpg?alt=media&token=139d97c9-cb2a-4575-979f-8ea59ffba4d0'),
(2,'Fiesta','Ford',2005,70000,2800000,'https://firebasestorage.googleapis.com/v0/b/vehiculos-4f017.appspot.com/o/imagenes%2FFiesta%202005.jpg?alt=media&token=5a16668e-4fb1-4805-a609-53d135fd8503'),
(2,'Civic','Honda',2005,90000,3000000,'https://firebasestorage.googleapis.com/v0/b/vehiculos-4f017.appspot.com/o/imagenes%2FCivic%202005.jpg?alt=media&token=c94e2336-c508-44e3-b3ba-83417aa5a17b'),
(2,'M3','BMW',2007,20000,11000000,'https://firebasestorage.googleapis.com/v0/b/vehiculos-4f017.appspot.com/o/imagenes%2FM3%202007.jpg?alt=media&token=edd54840-da40-4c6d-b12c-2c6241134686');

create trigger rolAutomatico after insert on usuario
for each row
insert into roles(nombre,id_usuario)
values('ROLE_USUARIO',new.id_usuario);


#########################################
#Despues de crear el usuario para los permisos de admin
insert into roles(nombre,id_usuario)
values('ROLE_ADMIN',1);
############################################

-- select * from roles;
-- select * from usuario;
-- select * from vehiculo;
-- select * from tipo;
-- drop table roles;
-- drop table usuario;
-- drop table vehiculo;
-- drop table tipo;
-- drop table rol_usuario;
create user 'admin'@'%' identified by 'admin123';
grant all privileges on AutoCR.* to 'admin'@'%';
flush privileges;





