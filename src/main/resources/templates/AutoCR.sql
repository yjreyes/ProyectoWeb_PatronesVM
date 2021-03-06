CREATE SCHEMA `AutoCR`;

use AutoCR;

CREATE TABLE `AutoCR`.`usuario`(
idusuario int not null auto_increment,
nombre varchar(20) not null,
apellidos varchar(30) not null,
correo varchar(25) null,
cedula varchar(10) null,
telefono varchar(15) null,
contraseña varchar(15) not null,
primary key(idusuario))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

create user 'admin'@'%' identified by 'admin123';
grant all privileges on AutoCR.* to 'admin'@'%';
flush privileges;


-- drop table usuario;

CREATE TABLE `AutoCR`.`vehiculo`(
id_vehiculo int not null auto_increment,
modelo varchar(15) not null,
marca varchar(15) not null,
anno int not null,
kilometraje int null,
precio double not null,
primary key(id_vehiculo))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

select * from usuario;

select * from vehiculo;
-- drop table vehiculo;