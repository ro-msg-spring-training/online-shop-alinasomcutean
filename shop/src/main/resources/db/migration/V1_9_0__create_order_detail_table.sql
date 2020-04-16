CREATE TABLE IF NOT EXISTS OrderDetail (
    `order_id` int NOT NULL,
    `product_id` int NOT NULL,
    `quantity` int,
    FOREIGN KEY (order_id) REFERENCES `Order`(id),
    FOREIGN KEY (product_id) REFERENCES Product(id),
    PRIMARY KEY (order_id, product_id)
)