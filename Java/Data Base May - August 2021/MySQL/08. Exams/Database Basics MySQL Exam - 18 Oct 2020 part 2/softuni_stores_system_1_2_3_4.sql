CREATE DATABASE softuni_stores_system_1_2_3_4;
USE softuni_stores_system_1_2_3_4;

CREATE TABLE towns (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE addresses (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL UNIQUE,
town_id INT NOT NULL,
CONSTRAINT `fk_addresses_towns`
FOREIGN KEY (town_id)
REFERENCES towns(id)
);

CREATE TABLE stores (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL UNIQUE,
rating FLOAT NOT NULL,
has_parking TINYINT(1) DEFAULT 0,
address_id INT NOT NULL,
CONSTRAINT `fk_stores_addresses`
FOREIGN KEY (address_id)
REFERENCES addresses(id)
);

CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(15) NOT NULL,
middle_name CHAR(1),
last_name VARCHAR(20) NOT NULL,
salary DECIMAL(19,2) DEFAULT 0,
hire_date DATE NOT NULL,
manager_id INT,
CONSTRAINT `fk_managers_employees`
FOREIGN KEY (manager_id)
REFERENCES employees(id),
store_id INT NOT NULL,
CONSTRAINT `fk_employees_stores`
FOREIGN KEY (store_id)
REFERENCES stores(id)
);

CREATE TABLE pictures(
id INT PRIMARY KEY AUTO_INCREMENT,
url VARCHAR(100) NOT NULL,
added_on DATETIME NOT NULL
);

CREATE TABLE categories(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE products(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE,
best_before DATE,
price DECIMAL(10,2) NOT NULL,
`description` TEXT,
category_id INT NOT NULL,
CONSTRAINT `fk_products_categories`
FOREIGN KEY (category_id)
REFERENCES categories(id),
picture_id INT NOT NULL,
CONSTRAINT `fk_products_pictures`
FOREIGN KEY (picture_id)
REFERENCES pictures(id)
);

CREATE TABLE products_stores (
product_id INT NOT NULL,
store_id INT NOT NULL,
CONSTRAINT `pk_products_stores`
PRIMARY KEY (product_id, store_id),
CONSTRAINT `fk_products_stores_products`
FOREIGN KEY (product_id)
REFERENCES products(id),
CONSTRAINT `fk_products_stores_stores`
FOREIGN KEY (store_id)
REFERENCES stores(id)
);

/* Problem 02 - Insert */

INSERT INTO products_stores (product_id, store_id)
(SELECT p.id, 1 FROM products AS p where p.id not in 
(SELECT product_id FROM products_stores as ps));

/* Problem 03 - Update */

UPDATE employees e
SET e.manager_id = 3, e.salary = e.salary - 500
WHERE year(e.hire_date) > 2003
AND e.store_id IN (SELECT id FROM stores WHERE `name` NOT IN ('Cardguard', 'Veribet'));

/* Problem 04 - Delete */

DELETE FROM employees
WHERE manager_id IS NOT NULL AND salary >= 6000;

