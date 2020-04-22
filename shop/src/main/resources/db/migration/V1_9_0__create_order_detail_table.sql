CREATE TABLE IF NOT EXISTS order_detail (
    `order_id` int NOT NULL,
    `product_id` int NOT NULL,
    `quantity` int,
    FOREIGN KEY (order_id) REFERENCES `order`(id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    PRIMARY KEY (order_id, product_id)
)