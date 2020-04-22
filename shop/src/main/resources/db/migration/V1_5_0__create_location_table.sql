CREATE TABLE IF NOT EXISTS location (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(30),
    `address_id` int,
    FOREIGN KEY (address_id) REFERENCES address(id)
)