CREATE DATABASE `self_referencing`;
USE `self_referencing`;

CREATE TABLE `teachers` (
`teacher_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30),
`manager_id` INT,
CONSTRAINT `fk_manager_teacher`
FOREIGN KEY (`manager_id`)
REFERENCES `teachers`(`teacher_id`)
);

INSERT INTO `teachers`
VALUES
(101,'John',NULL),	
(102,'Maya',106),
(103,'Silvia',106),
(104,'Ted',105),
(105,'Mark',101),
(106,'Greta',101);


