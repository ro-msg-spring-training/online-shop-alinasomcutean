CREATE TABLE IF NOT EXISTS stock (
    `product_id` int NOT NULL,
    `location_id` int NOT NULL,
    `quantity` int,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (location_id) REFERENCES location(id),
    PRIMARY KEY (product_id, location_id)
)