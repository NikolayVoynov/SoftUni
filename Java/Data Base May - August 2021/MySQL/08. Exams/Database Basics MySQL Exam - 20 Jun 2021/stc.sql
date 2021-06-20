CREATE DATABASE stc;
USE stc;

CREATE TABLE addresses(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL
);

CREATE TABLE clients(
id INT PRIMARY KEY AUTO_INCREMENT,
full_name VARCHAR(50) NOT NULL,
phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE drivers(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
age INT NOT NULL,
rating FLOAT DEFAULT 5.5
);

CREATE TABLE categories(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10) NOT NULL
);

CREATE TABLE cars(
id INT PRIMARY KEY AUTO_INCREMENT,
make VARCHAR(20) NOT NULL,
model VARCHAR(20),
`year` INT NOT NULL DEFAULT 0,
mileage INT DEFAULT 0,
`condition` CHAR(1),
category_id INT NOT NULL,
CONSTRAINT `fk_cars_categories`
FOREIGN KEY (category_id)
REFERENCES categories(id)
);

CREATE TABLE courses(
id INT PRIMARY KEY AUTO_INCREMENT,
from_address_id INT NOT NULL,
`start` DATETIME NOT NULL,
car_id INT NOT NULL,
client_id INT NOT NULL,
bill DECIMAL(10,2) DEFAULT 10,
CONSTRAINT `fk_courses_addresses`
FOREIGN KEY (from_address_id)
REFERENCES addresses(id),
CONSTRAINT `fk_courses_clients`
FOREIGN KEY (client_id)
REFERENCES clients(id),
CONSTRAINT `fk_courses_cars`
FOREIGN KEY (car_id)
REFERENCES cars(id)
);

CREATE TABLE cars_drivers (
car_id INT NOT NULL,
driver_id INT NOT NULL,
CONSTRAINT `cpk_cars_drivers`
PRIMARY KEY (car_id, driver_id),
CONSTRAINT `fk_cars_drivers_cars`
FOREIGN KEY (car_id)
REFERENCES cars(id),
CONSTRAINT `fk_cars_drivers_drivers`
FOREIGN KEY (driver_id)
REFERENCES drivers(id)
);

/* Problem 02 - Insert */

-- INSERT INTO clients (full_name, phone_number)
-- SELECT concat_ws(' ', first_name, last_name), concat('(088) 9999','',id * 2)
-- FROM drivers
-- WHERE id BETWEEN 10 AND 20;

/* Problem 03 - Update */

-- UPDATE cars
-- SET `condition` = 'C'
-- WHERE mileage IS NULL OR mileage >= 800000 
-- AND `year` <= 2010
-- AND make NOT LIKE 'Mercedes-Benz'
-- AND `condition` NOT LIKE 'C';

/* Problem 04 - Delete */

-- DELETE FROM clients AS cl
-- WHERE char_length(cl.full_name) > 3
-- AND cl.id NOT IN (SELECT client_id FROM courses);

/* Problem 05 - Cars */

SELECT make, model, `condition`
FROM cars
ORDER BY id;

/* Problem 06 - Drivers and Cars */

SELECT d.first_name, d.last_name, c.make, c.model, c.mileage
FROM drivers AS d
JOIN cars_drivers AS cd ON d.id = cd.driver_id
JOIN cars AS c ON cd.car_id = c.id
WHERE c.mileage IS NOT NULL
ORDER BY c.mileage DESC, d.first_name;

/* Problem 07 - Number of courses */

SELECT c.id AS car_id, c.make, c.mileage, count(crs.id) AS count_of_courses, round(avg(crs.bill),2) AS avg_bill
FROM cars AS c
LEFT JOIN courses AS crs
ON c.id = crs.car_id
GROUP BY c.id
HAVING count(crs.id) != 2
ORDER BY count_of_courses DESC, c.id;

/* Problem 08 - Regular clients */

SELECT cl.full_name, count(c.id) AS count_of_cars, sum(crs.bill) AS total_sum
FROM clients AS cl
JOIN courses AS crs ON crs.client_id = cl.id
JOIN cars AS c ON crs.car_id = c.id
GROUP BY cl.full_name
HAVING cl.full_name LIKE '_a%' AND count(c.id) > 1
ORDER BY cl.full_name;

/* Problem 09 - Full info for courses */

SELECT a.`name`, 
CASE
WHEN hour(crs.`start`) BETWEEN 6 AND 20 THEN 'Day'
WHEN hour(crs.`start`) BETWEEN 21 AND 24 THEN 'Night'
WHEN hour(crs.`start`) BETWEEN 0 AND 5 THEN 'Night'
END
AS day_time, 
crs.bill, 
cl.full_name, 
c.make, 
c.model, 
cat.`name`
FROM courses AS crs
JOIN addresses AS a ON crs.from_address_id = a.id
JOIN clients AS cl ON crs.client_id = cl.id
JOIN cars AS c ON crs.car_id = c.id
JOIN categories AS cat ON c.category_id = cat.id
ORDER BY crs.id;

/* Problem 10 - Find all courses by client’s phone number */

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `udf_courses_by_client`(phone_num VARCHAR (20)) RETURNS int
    DETERMINISTIC
BEGIN

DECLARE `count_courses` INT;
SET `count_courses` :=(
SELECT count(crs.id)
FROM clients AS cl
JOIN courses AS crs
ON cl.id = crs.client_id
WHERE cl.phone_number LIKE phone_num
);

RETURN `count_courses`;
END$$

SELECT udf_courses_by_client('(704) 2502909');

/* Problem 11 - Full info for address */

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `udp_courses_by_address`(address_name VARCHAR (100))
BEGIN

SELECT a.`name`, 
cl.full_name,
CASE
	WHEN crs.bill <= 20 THEN 'Low'
	WHEN crs.bill <= 30 THEN 'Medium'
	ELSE 'High'
END AS level_of_bill,
c.make,
c.`condition`,
cat.`name`
FROM courses AS crs
JOIN addresses AS a ON crs.from_address_id = a.id
JOIN clients AS cl ON crs.client_id = cl.id
JOIN cars AS c ON crs.car_id = c.id
JOIN categories AS cat ON c.category_id = cat.id
WHERE a.`name` LIKE address_name
ORDER BY c.make, cl.full_name;

END$$



