CREATE TABLE `clients` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`client_name` VARCHAR(100)
);

CREATE TABLE `projects` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`client_id` INT,
`project_lead_id` INT,
CONSTRAINT `fk_projects_clients`
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30),
`last_name` VARCHAR(30),
`project_id` INT,
CONSTRAINT `fk_employees_projects`
FOREIGN KEY (`project_id`)
REFERENCES `projects`(`id`)
);

ALTER TABLE `projects`
ADD CONSTRAINT `fk_projects_employees`
FOREIGN KEY (`project_lead_id`)
REFERENCES `employees`(`id`);