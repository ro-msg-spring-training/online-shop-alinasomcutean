CREATE TABLE IF NOT EXISTS `order` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `shippedFrom` int,
    `customer_id` int,
    `createdAt` DATETIME,
    `address_id` int,
    FOREIGN KEY (shippedFrom) REFERENCES location(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (address_id) REFERENCES address(id)
)