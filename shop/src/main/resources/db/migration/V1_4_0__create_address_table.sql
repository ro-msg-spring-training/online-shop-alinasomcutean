CREATE TABLE IF NOT EXISTS address (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `country` VARCHAR(30),
    `city` VARCHAR(30),
    `county` VARCHAR(30),
    `streetAddress` VARCHAR(50)
)