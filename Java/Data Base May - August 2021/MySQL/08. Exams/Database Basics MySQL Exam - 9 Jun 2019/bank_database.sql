CREATE DATABASE bank_database;
USE bank_database;

CREATE TABLE clients(
id INT PRIMARY KEY AUTO_INCREMENT,
full_name VARCHAR(50) NOT NULL,
age INT NOT NULL
);

CREATE TABLE bank_accounts(
id INT PRIMARY KEY AUTO_INCREMENT,
account_number VARCHAR(10) NOT NULL,
balance DECIMAL(10,2) NOT NULL,
client_id INT NOT NULL UNIQUE,
CONSTRAINT `fk_bank_accounts_clients`
FOREIGN KEY (client_id)
REFERENCES clients(id)
);

CREATE TABLE cards(
id INT PRIMARY KEY AUTO_INCREMENT,
card_number VARCHAR(19) NOT NULL,
card_status VARCHAR(7) NOT NULL,
bank_account_id INT NOT NULL,
CONSTRAINT `fk_cards_bank_accounts`
FOREIGN KEY (bank_account_id)
REFERENCES bank_accounts(id)
);

CREATE TABLE branches(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE employees(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
salary DECIMAL(10,2) NOT NULL,
started_on DATE NOT NULL,
branch_id INT NOT NULL,
CONSTRAINT `fk_employees_branches`
FOREIGN KEY (branch_id)
REFERENCES branches(id)
);

CREATE TABLE employees_clients(
employee_id INT,
client_id INT,
CONSTRAINT `fk_employees_clients_employees`
FOREIGN KEY (employee_id)
REFERENCES employees(id),
CONSTRAINT `fk_employees_clients_clients`
FOREIGN KEY (client_id)
REFERENCES clients(id)
);

/* Problem 02 - Insert */

INSERT INTO cards (card_number, card_status, bank_account_id)
SELECT reverse(full_name), 'Active', id
FROM clients
WHERE id BETWEEN 191 AND 200;

/* Problem 03 - Update */

UPDATE employees_clients ec
JOIN (
SELECT ec2.employee_id FROM employees_clients ec2
GROUP BY ec2.employee_id
ORDER BY count(ec2.client_id), ec2.employee_id
LIMIT 1) AS result
SET ec.employee_id = result.employee_id
WHERE ec.employee_id = ec.client_id;

/* Problem 04 - Delete */

DELETE FROM employees
WHERE id NOT IN (SELECT employee_id FROM employees_clients);


/* Problem 05 - Clients */

SELECT id, full_name
FROM clients
ORDER BY id;

/* Problem 06 - Newbies */

SELECT id, concat(first_name, ' ', last_name) AS full_name, concat('$','',salary), started_on
FROM employees
WHERE salary >= 100000 AND started_on >= '2018-01-01'
ORDER BY salary DESC, id;

/* Problem - 07 Cards against Humanity */

SELECT crd.id, concat(crd.card_number, ' : ', cl.full_name) AS card_token
FROM cards AS crd
JOIN bank_accounts AS ba
ON crd.bank_account_id = ba.id
JOIN clients AS cl
ON ba.client_id = cl.id
ORDER BY id DESC;

/* Problem 08 - Top 5 Employees */

SELECT concat(e.first_name, ' ' , e.last_name) AS `name`, e.started_on, count(ec.client_id) AS count_of_clients
FROM employees AS e
JOIN employees_clients AS ec
ON e.id = ec.employee_id
GROUP BY e.id
ORDER BY count_of_clients DESC, e.id
LIMIT 5;

/* Problem 09 - Branch cards */

SELECT br.`name` AS branch_name, count(crd.id) AS count_of_cards
FROM branches AS br
LEFT JOIN employees AS e ON br.id = e.branch_id
LEFT JOIN employees_clients AS ec ON ec.employee_id = e.id
LEFT JOIN clients AS cl ON ec.client_id = cl.id
LEFT JOIN bank_accounts AS ba ON ba.client_id = cl.id
LEFT JOIN cards AS crd ON ba.id = crd.bank_account_id
GROUP BY branch_name
ORDER BY count_of_cards DESC, branch_name;


/* Problem 10 - Extract client cards count */

DELIMITER $$
CREATE FUNCTION `udf_client_cards_count`(name VARCHAR(30)) RETURNS int
    DETERMINISTIC
BEGIN

DECLARE cards_number INT;
SET cards_number := (
SELECT count(crd.id)
FROM cards AS crd
JOIN bank_accounts AS ba ON crd.bank_account_id = ba.id
JOIN clients AS cl ON ba.client_id = cl.id
WHERE cl.full_name = name
);

RETURN cards_number;
END$$

SELECT udf_client_cards_count('Baxy David');

/* Problem 11 - Extract Client Info */

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `udp_clientinfo`(fullname VARCHAR(50))
BEGIN

SELECT cl.full_name, cl.age, ba.account_number, concat('$','',ba.balance) AS balance
FROM clients AS cl
JOIN bank_accounts AS ba
ON cl.id = ba.client_id
WHERE cl.full_name LIKE fullname;

END$$

CALL udp_clientinfo('Hunter Wesgate');








