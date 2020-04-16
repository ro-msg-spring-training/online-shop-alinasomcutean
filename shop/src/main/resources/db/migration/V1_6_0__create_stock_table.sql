CREATE TABLE IF NOT EXISTS Stock (
    `product_id` int NOT NULL,
    `location_id` int NOT NULL,
    `quantity` int,
    FOREIGN KEY (product_id) REFERENCES Product(id),
    FOREIGN KEY (location_id) REFERENCES Location(id),
    PRIMARY KEY (product_id, location_id)
)