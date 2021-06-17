CREATE DATABASE softuni_stores_system_5_6_7_8_9_10_11;
USE softuni_stores_system_5_6_7_8_9_10_11;

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

/* Problem 05 - Employees */

SELECT first_name, middle_name, last_name, salary, hire_date
FROM employees
ORDER BY hire_date DESC;

/* Problem 06 - Products with old pictures */

SELECT prd.`name`, 
prd.price, 
prd.best_before, 
concat_ws('', substring(`description`, 1, 10), '...') short_description, 
pic.url
FROM products AS prd
JOIN pictures AS pic
ON prd.picture_id = pic.id
WHERE char_length(prd.`description`) > 100 AND year(pic.added_on) < 2019 AND prd.price >20
ORDER BY prd.price DESC;

/* Problem 07 - Counts of products in stores and their average */

SELECT str.`name`, count(prd.`name`) AS product_count, round(avg(prd.price), 2) AS `avg`
FROM stores AS str
LEFT JOIN products_stores AS prst
ON str.id = prst.store_id
LEFT JOIN products AS prd
ON prst.product_id = prd.id
GROUP BY str.`name`
ORDER BY product_count DESC,  `avg` DESC, str.id;

/* Problem 08 - Specific employee */

SELECT concat_ws(' ', e.first_name, e.last_name) AS full_name,
str.`name`, a.`name`, e.salary
FROM employees AS e
JOIN stores AS str
ON e.store_id = str.id
JOIN addresses AS a
ON str.address_id = a.id
WHERE e.salary < 4000 AND a.`name` LIKE '%5%' AND 
char_length(str.`name`) > 8 AND e.last_name LIKE '%n';

/* Problem 09 - Find all information of stores */

SELECT reverse(str.`name`) AS reversed_name,
concat_ws('-', upper(tw.`name`), a.`name`) AS full_address,
count(e.first_name) AS employees_count
FROM stores AS str
JOIN addresses AS a
ON str.address_id = a.id
JOIN towns AS tw
ON a.town_id = tw.id
JOIN employees AS e
ON str.id = e.store_id
GROUP BY str.`name`
HAVING employees_count >= 1
ORDER BY full_address ASC;







