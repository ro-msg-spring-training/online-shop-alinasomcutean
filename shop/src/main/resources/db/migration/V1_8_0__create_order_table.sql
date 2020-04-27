CREATE TABLE IF NOT EXISTS `orders` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `customer_id` int,
    `created_at` DATETIME,
    `address_id` int,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (address_id) REFERENCES address(id)
)