CREATE TABLE IF NOT EXISTS product (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(30),
    `description` VARCHAR(100),
    `price` DECIMAL,
    `weight` DOUBLE,
    `category_id` int,
    `supplier_id` int,
    `image_url` VARCHAR(100),
    FOREIGN KEY (category_id) REFERENCES `category`(id),
    FOREIGN KEY (supplier_id) REFERENCES supplier(id)
)