CREATE DATABASE k10;
USE k10;

CREATE TABLE members(
	`id` VARCHAR(20) PRIMARY KEY,
	`name` VARCHAR (50) NOT NULL,
	`username` VARCHAR (250) NOT NULL UNIQUE,
	`password` VARCHAR (250) NOT NULL,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE members

INSERT INTO members (`id`, `name`, `username`, `password`)
VALUES ("0000", "admin", "admin", "admin");
INSERT INTO members (`id`, `name`, `username`, `password`) VALUES ("0001", "angel", "angelruth", "angel"); 
INSERT INTO members (`id`, `name`, `username`, `password`) VALUES ("0002", "syalom", "syalomadvensia", "syalom"); 
INSERT INTO members (`id`, `name`, `username`, `password`) VALUES ("0003", "riskia", "riskianaomi", "riskia"); 

SELECT * FROM members;

CREATE TABLE students(
	`nim` VARCHAR(20) PRIMARY KEY,
	`nama` VARCHAR(50) NOT NULL,
	`gender` VARCHAR(20) NOT NULL,
	`angkatan` VARCHAR(10) NOT NULL
);

SELECT * FROM students;

CREATE TABLE `logs` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`nim` VARCHAR(20),
	`date_in` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`date_out` DATETIME NULL
);

SELECT * FROM LOGS

