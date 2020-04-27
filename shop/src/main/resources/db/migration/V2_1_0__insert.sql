insert into category(name,description) values ('Sweet', 'Sweet');
insert into category(name,description) values ('Drink', 'Drink');
insert into category(name,description) values ('Fruits', 'Fruits');
insert into category(name,description) values ('Vegetables', 'Vegetables');
insert into category(name,description) values ('Dairy products', 'Dairy products');

insert into supplier(name) values('Lidl');
insert into supplier(name) values('Kaufland');
insert into supplier(name) values('Auchan');

insert into product(name, description, price, weight, category_id, supplier_id, image_url) values ('Chocolate', 'Chocolate', 3, 100, 1, 1, 'x');
insert into product(name, description, price, weight, category_id, supplier_id, image_url) values ('Milk', 'Milk', 5, 1000, 5, 2, 'x');
insert into product(name, description, price, weight, category_id, supplier_id, image_url) values ('Water', 'Water', 3, 2000, 2, 3, 'x');
insert into product(name, description, price, weight, category_id, supplier_id, image_url) values ('Yougurt', 'Yougurt', 6, 400, 5, 1, 'x');
insert into product(name, description, price, weight, category_id, supplier_id, image_url) values ('Salad', 'Salad', 5, 200, 4, 2, 'x');
insert into product(name, description, price, weight, category_id, supplier_id, image_url) values ('Apples', 'Apples', 6, 1000, 3, 3, 'x');

insert into customer(first_name, last_name, username, password, email) values ('Alina', 'Somcutean', 'alina', 'alina', 'alina@yahoo.com');
insert into customer(first_name, last_name, username, password, email) values ('Carmen', 'Pop', 'carmen', 'carmen', 'carmen@yahoo.com');
insert into customer(first_name, last_name, username, password, email) values ('Rares', 'Pop', 'rares', 'rares', 'rares@yahoo.com');

insert into address(country, city, county, street_address) values ('Romania', 'Cluj-Napoca', 'Cluj', 'Aleea Herculane');
insert into address(country, city, county, street_address) values ('Romania', 'Baia Mare', 'Maramures', 'Bd. Traian');
insert into address(country, city, county, street_address) values ('Romania', 'Ileanda', 'Salaj', 'Str. Simion Barnutiu');

insert into location(name, address_id) values ('Cluj', 1);
insert into location(name, address_id) values ('Baia Mare', 2);
insert into location(name, address_id) values ('Ileanda', 3);

insert into stock(product_id, location_id, quantity) values (2, 1, 10);
insert into stock(product_id, location_id, quantity) values (3, 1, 100);
insert into stock(product_id, location_id, quantity) values (4, 1, 30);
insert into stock(product_id, location_id, quantity) values (5, 1, 10);
insert into stock(product_id, location_id, quantity) values (6, 1, 50);
insert into stock(product_id, location_id, quantity) values (1, 2, 40);
insert into stock(product_id, location_id, quantity) values (2, 2, 10);
insert into stock(product_id, location_id, quantity) values (3, 2, 100);
insert into stock(product_id, location_id, quantity) values (4, 2, 30);
insert into stock(product_id, location_id, quantity) values (5, 2, 10);
insert into stock(product_id, location_id, quantity) values (6, 2, 50);
