CREATE DATABASE `one_to_many`;
USE `one_to_many`;

CREATE TABLE `manufacturers` (
`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20),
`establiched_on` DATE
);

CREATE TABLE `models` (
`model_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40),
`manufacturer_id` INT
);

ALTER TABLE `models` AUTO_INCREMENT = 101;

ALTER TABLE `models`
ADD CONSTRAINT `fk_models_manufacturers`
FOREIGN KEY (`manufacturer_id`)
REFERENCES `manufacturers`(`manufacturer_id`);

INSERT INTO `manufacturers`
VALUES
(1,'BMW','1916-03-01'),
(2,'Tesla','2003-01-01'),
(3,'Lada','1966-05-01');

INSERT INTO `models` (`name`, `manufacturer_id`)
VALUES
('X1',	1),
('i6',	1),
('Model S',	2),
('Model X',	2),
('Model 3',	2),
('Nova', 3);


