CREATE TABLE IF NOT EXISTS order_detail (
    `order_id` int NOT NULL,
    `product_id` int NOT NULL,
    `location_id` int NOT NULL,
    `quantity` int,
    FOREIGN KEY (order_id) REFERENCES `orders`(id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (location_id) REFERENCES location(id),
    PRIMARY KEY (order_id, product_id)
)