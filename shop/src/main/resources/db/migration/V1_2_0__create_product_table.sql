CREATE TABLE IF NOT EXISTS Product (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(30),
    `description` VARCHAR(100),
    `price` DECIMAL,
    `weight` DOUBLE,
    `category_id` int,
    `supplier_id` int,
    `imageURL` VARCHAR(100),
    FOREIGN KEY (category_id) REFERENCES `Category`(id),
    FOREIGN KEY (supplier_id) REFERENCES Supplier(id)
)