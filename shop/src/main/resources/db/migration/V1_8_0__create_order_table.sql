CREATE TABLE IF NOT EXISTS `orders` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `shipped_from_id` int,
    `customer_id` int,
    `created_at` DATETIME,
    `address_id` int,
    FOREIGN KEY (shipped_from_id) REFERENCES location(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (address_id) REFERENCES address(id)
)