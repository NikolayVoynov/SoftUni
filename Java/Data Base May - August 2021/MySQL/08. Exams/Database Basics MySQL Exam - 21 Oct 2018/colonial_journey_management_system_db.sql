CREATE DATABASE colonial_journey_management_system_db;
USE colonial_journey_management_system_db;

CREATE TABLE planets(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL
);

CREATE TABLE spaceships(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
manufacturer VARCHAR(30) NOT NULL,
light_speed_rate INT DEFAULT 0
);

CREATE TABLE colonists(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
ucn CHAR(10) NOT NULL UNIQUE,
birth_date DATE NOT NULL
);

CREATE TABLE spaceports(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
planet_id INT,
CONSTRAINT `fk_spaceport_planet`
FOREIGN KEY (planet_id)
REFERENCES planets(id)
);

CREATE TABLE journeys(
id INT PRIMARY KEY AUTO_INCREMENT,
journey_start DATETIME NOT NULL,
journey_end DATETIME NOT NULL,
purpose ENUM('Medical', 'Technical', 'Educational', 'Military') NOT NULL,
destination_spaceport_id INT,
spaceship_id INT,
CONSTRAINT `fk_journey_spaceport`
FOREIGN KEY (destination_spaceport_id)
REFERENCES spaceports(id),
CONSTRAINT `fk_journey_spaceship`
FOREIGN KEY (spaceship_id)
REFERENCES spaceships(id)
);

CREATE TABLE travel_cards(
id INT PRIMARY KEY AUTO_INCREMENT,
card_number CHAR(10) NOT NULL UNIQUE,
job_during_journey ENUM('Pilot', 'Engineer', 'Trooper', 'Cleaner', 'Cook'),
colonist_id INT,
journey_id INT,
CONSTRAINT `fk_travel_card_colonist`
FOREIGN KEY (colonist_id)
REFERENCES colonists(id),
CONSTRAINT `fk_travel_card_journey`
FOREIGN KEY (journey_id)
REFERENCES journeys(id)
);


-- /* Problem 01 - Insert */

-- INSERT INTO travel_cards (card_number, job_during_journey, colonist_id, journey_id)
-- SELECT (
-- CASE
-- 	WHEN c.birth_date > '1980-01-01' THEN concat(year(c.birth_date), day(birth_date), left(c.ucn,4))
--     ELSE concat(year(c.birth_date), month(birth_date), right(c.ucn,4))
--     END)
-- 	AS card_number,
--  (CASE
-- 	WHEN c.id % 2 = 0 THEN 'Pilot'
--     WHEN c.id % 3 = 0 THEN 'Cook'
--     ELSE 'Engineer'
--     END)
--     AS job_during_journey,
-- c.id AS colonist_id,
-- left(c.ucn,1) AS journey_id
-- FROM colonists AS c
-- WHERE id BETWEEN 96 AND 100;

-- /* Problem 02 - Update */

-- UPDATE journeys
-- SET purpose = (
-- CASE
-- 	WHEN id % 2 = 0 THEN 'Medical'
-- 	WHEN id % 3 = 0 THEN 'Technical'
-- 	WHEN id % 5 = 0 THEN 'Educational'
-- 	WHEN id % 7 = 0 THEN 'Military'
--     ELSE purpose
-- END);

-- /* Problem 03 - Delete */

-- DELETE FROM colonists AS c
-- WHERE c.id NOT IN (
-- SELECT colonist_id
-- FROM travel_cards AS jc
-- WHERE jc.journey_id IS NOT NULL);

/* Problem 04 - Extract all travel cards */

SELECT card_number,	job_during_journey
FROM travel_cards
ORDER BY card_number;

/* Problem 05 - Extract all colonists */

SELECT id, concat_ws(' ', first_name, last_name) AS full_name, ucn
FROM colonists
ORDER BY first_name, last_name, id;

/* Problem 06 - Extract all military journeys */

SELECT id, journey_start, journey_end
FROM journeys
WHERE purpose LIKE 'Military'
ORDER BY journey_start;

/* Problem 07 - Extract all pilots */

SELECT c.id, concat_ws(' ', first_name, last_name) AS full_name
FROM colonists AS c
JOIN travel_cards AS tc
ON c.id = tc.colonist_id
WHERE job_during_journey LIKE 'Pilot'
ORDER BY id;

/* Problem 08 - Count all colonists */

SELECT count(c.id)
FROM colonists AS c
JOIN travel_cards AS tc
ON c.id = tc.colonist_id
JOIN journeys AS j
ON tc.journey_id = j.id
WHERE purpose LIKE 'Technical';

/* Problem 09 - Extract the fastest spaceship */

SELECT ssh.`name`, spt.`name`
FROM spaceships AS ssh
JOIN journeys AS j ON ssh.id = j.spaceship_id
JOIN spaceports AS spt ON j.destination_spaceport_id = spt.id
ORDER BY ssh.light_speed_rate DESC
LIMIT 1;


/* Problem 10 - Extract - pilots younger than 30 years */

SELECT ssh.`name`, ssh.manufacturer
FROM spaceships ssh
JOIN journeys j ON ssh.id = j.spaceship_id
JOIN travel_cards tc ON j.id = tc.journey_id
JOIN colonists AS c ON tc.colonist_id = c.id
WHERE '2019' - year(c.birth_date) < 30 AND tc.job_during_journey LIKE 'Pilot'
ORDER BY ssh.`name`;








