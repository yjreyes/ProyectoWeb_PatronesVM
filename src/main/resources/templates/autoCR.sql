create database AutoCR;

use AutoCr;

create table usuario(
id_usuario int not null auto_increment primary key,
nombre varchar(20) not null,
apellidos varchar(30) not null,
correo varchar(25) null,
cedula varchar(10) null,
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
foreign key(id_tipo) references Tipo(id_tipo))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

insert into tipo(descripcion)
values('Alquiler'),('Venta');

create trigger rolAutomatico after insert on usuario
for each row
insert into roles(nombre,id_usuario)
values('ROLE_USUARIO',new.id_usuario);



#########################################
#Despues de crear el usuario, para los permisos de admin
insert into roles(nombre,id_usuario)
values('ROLE_ADMIN',1);
############################################

-- select * from roles;
-- select * from usuario;
-- select * from roles_usuarios;
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





