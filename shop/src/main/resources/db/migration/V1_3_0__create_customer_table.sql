CREATE TABLE IF NOT EXISTS customer (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(30),
    `last_name` VARCHAR(30),
    `username` VARCHAR(30),
    `password` VARCHAR(30),
    `email` VARCHAR(30)
)