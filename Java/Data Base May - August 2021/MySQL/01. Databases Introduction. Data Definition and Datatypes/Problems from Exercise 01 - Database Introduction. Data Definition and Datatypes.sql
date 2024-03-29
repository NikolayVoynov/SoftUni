#Problem 00

CREATE DATABASE `minions`;

#Problem 01

USE `minions`;
CREATE TABLE `minions`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`age` INT 
);

CREATE TABLE `towns`(
`town_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

#Problem 02

ALTER TABLE `minions`
ADD `town_id` INT NOT NULL;

ALTER TABLE `minions`
ADD CONSTRAINT `fk_minions_towns`
FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`);

#Problem 03

INSERT INTO `towns`
VALUES
(1,'Sofia'),
(2,'Plovdiv'),
(3,'Varna');

INSERT INTO `minions`
VALUES
(1,'Kevin',22,1),
(2,'Bob',15,3),
(3,'Steward',NULL,2);

#Problem 04

TRUNCATE `minions`;

#Problem 05

DROP TABLE `minions`;
DROP TABLE `towns`;

#Problem 06

USE `minions`;
CREATE TABLE `people`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DOUBLE(5,2),
 `weght` DOUBLE(5,2),
 `gender` CHAR(1) NOT NULL,
 `birthdate` DATE NOT NULL,
 `biography` TEXT
);

INSERT INTO `people`
VALUES
(1, 'Nikolay Voynov', NULL, 174.50, 80.00, 'm', '91-04-16', NULL),
(2, 'Monika Voynova', NULL, 174.00, 50.00, 'f', '99-08-17', NULL),
(3, 'Aneliya Milusheva', NULL, 174.50, 45.00, 'f', '80-04-19', NULL),
(4, 'Dimitar Milushev', NULL, 176.00, 90.00, 'm', '80-11-08', NULL),
(5, 'Voyn Grigorov', NULL, 178.00, 100.00, 'm', '91-08-15', NULL);

#Problem 07

CREATE TABLE `users` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` TIME,
`is_deleted` BOOLEAN
);

INSERT INTO `users`
VALUES
(1, 'levski1', 'cbilsbcbs', NULL, '2021-05-23 12:40:00', 1),
(2, 'levski2', 'jcbdslhsb', NULL, '2021-05-23 12:40:01', 1),
(3, 'levski3', 'cdmdivodfbv', NULL, '2021-05-23 12:40:02', 0),
(4, 'levski4', 'ywbddididj', NULL, '2021-05-23 12:40:03', 1),
(5, 'levski5', 'cvnfjvj', NULL, '2021-05-23 12:40:04', 0);

#Problem 08

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY (`id`, `username`);

#Problem 09

ALTER TABLE `users`
CHANGE COLUMN `last_login_time` `last_login_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP;

#Problem 10

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY (`id`);

ALTER TABLE `users`
MODIFY COLUMN `username` VARCHAR(30) NOT NULL UNIQUE;

#Problem 11

CREATE DATABASE `Movies`;
USE `Movies`;

CREATE TABLE `directors`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(75) NOT NULL,
`notes` VARCHAR(500)
);

CREATE TABLE `genres`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(75) NOT NULL,
`notes` VARCHAR(500)
);

CREATE TABLE `categories`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(75) NOT NULL,
`notes` VARCHAR(500)
);

CREATE TABLE `movies` (
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(75) NOT NULL,
`director_id` INT NOT NULL,
`copyright_year` INT NOT NULL,
`length` INT NOT NULL,
`genre_id` INT NOT NULL,
`category_id` INT NOT NULL,
`rating` DECIMAL(2,1) NOT NULL,
`notes` VARCHAR(500)
);

ALTER TABLE `movies`
ADD CONSTRAINT `fk_movies_directors`
FOREIGN KEY (`director_id`) REFERENCES `directors`(`id`);

ALTER TABLE `movies`
ADD CONSTRAINT `fk_movies_genres`
FOREIGN KEY (`genre_id`) REFERENCES `genres`(`id`);

ALTER TABLE `movies`
ADD CONSTRAINT `fk_movies_categories`
FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`);

INSERT INTO `directors`
VALUES
(1, 'Petar Petrov', 'The best director1'),
(2, 'Ivan Ivanov', 'The best director2'),
(3, 'George Georiev', 'The best director3'),
(4, 'George Ivanov', 'The best director4'),
(5, 'Ivan Georiev', 'The best director5');

INSERT INTO `genres`
VALUES
(1, 'comedy', 'smth1'),
(2, 'horror', 'smth2'),
(3, 'action', 'smth3'),
(4, 'sci-fi', 'smth4'),
(5, 'thriller', 'smth5');

INSERT INTO `categories`
VALUES
(1, 'first', 'smth1'),
(2, 'second', 'smth2'),
(3, 'third', 'smth3'),
(4, 'forth', 'smth4'),
(5, 'fifth', 'smth5');

INSERT INTO `movies`
VALUES
(1, 'title1', 1, 1988, 220, 2, 3, 8.5, 'a lot'),
(2, 'title2', 3, 1934, 180, 1, 2, 7.5, 'nothing2'),
(3, 'title3', 2, 1952, 181, 3, 4, 9.3, 'nothing3'),
(4, 'title4', 4, 1939, 300, 4, 5, 5.5, 'nothing4'),
(5, 'title5', 5, 2020, 170, 5, 1, 7.3, 'some text');

SELECT * FROM `directors`;
SELECT * FROM `genres`;
SELECT * FROM `categories`;
SELECT * FROM `movies`;

#Problem 12

CREATE DATABASE `car_rental`;
USE `car_rental`;

CREATE TABLE `categories`(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(20) NOT NULL,
`daily_rate` INT,
`weekly_rate` INT,
`monthly_rate` INT,
`weekend_rate` INT
);

CREATE TABLE `cars` (
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`plate_number` VARCHAR(8) NOT NULL UNIQUE,
`make` VARCHAR(10),
`model` VARCHAR(30),
`car_year` DATE,
`category_id` INT NOT NULL,
`doors` INT,
`picture` BLOB,
`car_condition` VARCHAR(10),
`available` BOOLEAN NOT NULL
);

ALTER TABLE `cars`
ADD CONSTRAINT `fk_cars_categories`
FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`);

CREATE TABLE `employees` (
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(15),
`last_name` VARCHAR(15),
`title` VARCHAR(15),
`notes` TEXT
);

CREATE TABLE `customers` (
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`drivers_licence_number` INT,
`full_name` VARCHAR(40),
`adress` TEXT,
`city` VARCHAR(10),
`zip_code` INT,
`notes` TEXT
);

CREATE TABLE `rental_orders` (
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT NOT NULL, 
`customer_id`INT NOT NULL, 
`car_id`INT NOT NULL, 
`car_condition` VARCHAR(10), 
`tank_level` DOUBLE(4,2), 
`kilometrage_start` INT NOT NULL, 
`kilometrage_end` INT NOT NULL, 
`total_kilometrage` INT NOT NULL, 
`start_date` DATE, 
`end_date` DATE, 
`total_days` INT NOT NULL, 
`rate_applied` VARCHAR(20), 
`tax_rate` INT NOT NULL, 
`order_status` VARCHAR(20) NOT NULL, 
`notes` TEXT
);

INSERT INTO `categories`
VALUE
(1, 'sedan', 50, 35, 120, 60),
(2, 'combi', 45, 30, 110, 55),
(3, 'hatchback', 40, 25, 100, 50);

INSERT INTO `cars`
VALUE
(1, 'CB2615MP', 'Germany', 'Audi A3', '2010-09-11', 3, 4, NULL, 'good', 1),
(2, 'CB2013HA', 'Germany', 'BMW M3', '2015-04-16', 1, 4, NULL, 'perfect', 0),
(3, 'CB1321MH', 'Germany', 'Mercedes C200', '2011-10-18', 2, 4, NULL, 'perfect', 1);

INSERT INTO `employees`
VALUE
(1, 'Nikolay', 'Voynov', 'Engineer', 'smth1'),
(2, 'Dimitar', 'Milushev', 'Engineer', 'smth2'),
(3, 'Monika', 'Voynova', 'Accounting', 'smth3');

INSERT INTO `customers`
VALUE
(1, 12345678, 'Boris Vasilev', 'somewhere1', 'Sofia', 1632, 'notes1'),
(2, 910111213, 'Ivan Georgiev', 'somewhere2', 'Burgas', 2178, 'notes2'),
(3, 141516171, 'Petar Ivanov', 'somewhere3', 'Plovdiv', 9874, 'notes3');

INSERT INTO `rental_orders`
VALUE
(1, 1, 1, 1, 'good', 80.50, 20000, 20300, 300, '2021-05-21', '2021-05-24', 4, 'monthly', 15, 'finished', 'notes1'),
(2, 1, 2, 2, 'perfect', 84.70, 20200, 20300, 100, '2021-05-21', '2021-05-24', 4, 'monthly', 20, 'finished', 'notes2'),
(3, 3, 1, 3, 'good', 78.50, 20100, 20300, 200, '2021-05-21', '2021-05-24', 4, 'monthly', 15, 'finished', 'notes3');

#Problem 13

CREATE DATABASE `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) UNIQUE
);

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address_text` TEXT NOT NULL,
`town_id` INT NOT NULL
);

ALTER TABLE `addresses`
ADD CONSTRAINT `fk_addresses_towns`
FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`);

CREATE TABLE `departments`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) UNIQUE
);

CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20) NOT NULL,
`middle_name` VARCHAR(20) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`job_title` VARCHAR(20) NOT NULL,
`department_id` INT NOT NULL,
`hire_date` DATE,
`salary` DOUBLE,
`address_id` INT NOT NULL
);

ALTER TABLE `employees`
ADD CONSTRAINT `fk_employees_departments`
FOREIGN KEY (`department_id`) REFERENCES `departments`(`id`);

ALTER TABLE `employees`
ADD CONSTRAINT `fk_employees_addresses`
FOREIGN KEY (`address_id`) REFERENCES `addresses`(`id`);

INSERT INTO `towns`
VALUE 
(1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna'),
(4, 'Burgas');

INSERT INTO `addresses`
VALUES 
(1, 'address1', 1),
(2, 'address2', 2),
(3, 'address3', 3),
(4, 'addres4', 4);

INSERT INTO `departments`
VALUE 
(1, 'Engineering'),
(2, 'Sales'),
(3, 'Marketing'),
(4, 'Software Development'),
(5, 'Quality Assurance');

INSERT INTO `employees` (`id`, `first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`, `address_id`)
VALUE
(1, 'Ivan','Ivanov','Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00, 1),
(2, 'Petar','Petrov','Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00, 2),
(3, 'Maria','Petrova','Ivanova', 'Intern', 5, '2016-08-28', 525.25, 3),
(4, 'Georgi','Terziev','Ivanov', 'CEO', 2, '2007-12-09', 3000.00, 4),
(5, 'Peter','Pan','Pan', 'Intern', 3, '2016-08-28', 599.88, 1);

#Problem 14

SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;

#Problem 15

SELECT * FROM `towns` ORDER BY `name` ASC;
SELECT * FROM `departments` ORDER BY `name` ASC;
SELECT * FROM `employees` ORDER BY `salary` DESC;

#Problem 16

SELECT `name` FROM `towns` ORDER BY `name` ASC;
SELECT `name` FROM `departments` ORDER BY `name` ASC;
SELECT `first_name`, `last_name`,`job_title`,`salary` FROM `employees` ORDER BY `salary` DESC;

#Problem 17

UPDATE `employees`
SET `salary` = `salary` * 1.1;

SELECT `salary` FROM `employees`;

#Problem 18

/* TRUNCATE `employees` */


