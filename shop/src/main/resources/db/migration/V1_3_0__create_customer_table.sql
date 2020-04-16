CREATE TABLE IF NOT EXISTS Customer (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(30),
    `lastName` VARCHAR(30),
    `username` VARCHAR(30),
    `password` VARCHAR(30),
    `email` VARCHAR(30)
)