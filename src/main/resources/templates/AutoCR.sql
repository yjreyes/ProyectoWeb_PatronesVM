CREATE SCHEMA `AutoCR`;

CREATE TABLE `AutoCR`.`usuario`(
idusuario varchar(10) not null,
nombre varchar(20) not null,
apellidos varchar(30) not null,
correo varchar(25) null,
telefono varchar(15) null,
primary key(`idusuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

create user 'admin'@'%' identified by 'admin123';
grant all privileges on AutoCR.* to 'admin'@'%';
flush privileges;

