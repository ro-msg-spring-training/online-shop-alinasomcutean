CREATE TABLE IF NOT EXISTS Revenue (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `location_id` int,
    `date` DATE,
    `sum` DECIMAL,
    FOREIGN KEY (location_id) REFERENCES Location(id)
)