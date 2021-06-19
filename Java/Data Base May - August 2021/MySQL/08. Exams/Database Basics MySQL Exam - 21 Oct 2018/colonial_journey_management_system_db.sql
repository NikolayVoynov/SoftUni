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


/* Problem 11 - Extract all educational mission */

SELECT pl.`name`, spt.`name`
FROM planets AS pl
JOIN spaceports AS spt ON pl.id = spt.planet_id
JOIN journeys AS j ON spt.id = j.destination_spaceport_id
WHERE j.purpose LIKE 'Educational'
ORDER BY spt.`name` DESC;

/* Problem 12 - Extract all planets and their journey count */

SELECT pl.`name`, count(j.id) AS journeys_count
FROM planets AS pl
JOIN spaceports AS spt ON pl.id = spt.planet_id
JOIN journeys AS j ON spt.id = j.destination_spaceport_id
GROUP BY pl.id
ORDER BY journeys_count DESC, pl.`name`;

/* Problem 13 - Extract the shortest journey */

SELECT j.id, pl.`name` AS planet_name, spt.`name` AS spaceport_name, j.purpose AS journey_purpose
FROM journeys AS j
JOIN spaceports AS spt ON spt.id = j.destination_spaceport_id
JOIN planets AS pl ON pl.id = spt.planet_id
ORDER BY datediff(j.journey_end, j.journey_start) ASC
LIMIT 1;

/* Problem 14 - Extract the less popular job */

SELECT tc.job_during_journey
FROM travel_cards AS tc
WHERE tc.journey_id = 
(
SELECT j.id FROM journeys AS j
ORDER BY datediff(j.journey_end, j.journey_start) DESC
LIMIT 1
)
GROUP BY tc.job_during_journey
ORDER BY count(tc.job_during_journey)
LIMIT 1;

/* Problem 15 - Get colonists count */

DELIMITER $$
CREATE FUNCTION `udf_count_colonists_by_destination_planet`(planet_name VARCHAR (30)) RETURNS int
    DETERMINISTIC
BEGIN
DECLARE colonists_number INT;
SET colonists_number := (SELECT count(c.id)
FROM colonists AS c
JOIN travel_cards tc ON tc.colonist_id = c.id 
JOIN journeys AS j ON j.id = tc.journey_id
JOIN spaceports AS spt ON spt.id = j.destination_spaceport_id
JOIN planets AS pl ON pl.id = spt.planet_id
WHERE pl.`name` LIKE planet_name);

RETURN colonists_number;
END$$

SELECT udf_count_colonists_by_destination_planet('Otroyphus');

/* Problem 16 - Modify spaceship */

DELIMITER $$
CREATE PROCEDURE `udp_modify_spaceship_light_speed_rate`(spaceship_name VARCHAR(50), light_speed_rate_increse INT(11))
BEGIN

IF spaceship_name IN (SELECT `name` FROM spaceships) 
THEN
	UPDATE spaceships ssh
    SET ssh.light_speed_rate = ssh.light_speed_rate + light_speed_rate_increse
    WHERE ssh.`name` = spaceship_name;
ELSE
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
    ROLLBACK;
END IF;
END$$


CALL udp_modify_spaceship_light_speed_rate('Na Pesho koraba', 1914);
CALL udp_modify_spaceship_light_speed_rate('USS Templar', 5);









