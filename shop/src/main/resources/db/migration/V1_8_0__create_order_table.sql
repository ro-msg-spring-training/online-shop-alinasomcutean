CREATE TABLE IF NOT EXISTS `Order` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `shippedFrom` int,
    `customer_id` int,
    `createdAt` DATETIME,
    `address_id` int,
    FOREIGN KEY (shippedFrom) REFERENCES Location(id),
    FOREIGN KEY (customer_id) REFERENCES Customer(id),
    FOREIGN KEY (address_id) REFERENCES Address(id)
)