insert into category(name,description) values ('cat1', 'cat1');
insert into category(name,description) values ('cat2', 'cat2');
insert into category(name,description) values ('cat3', 'cat3');

insert into supplier(name) values('supplier1');
insert into supplier(name) values('supplier2');
insert into supplier(name) values('supplier3');

insert into product(name, description, price, weight, category_id, supplier_id, image_url) values ('prod1', 'prod1', 10, 10, 1, 1, 'prod1');
insert into product(name, description, price, weight, category_id, supplier_id, image_url) values ('prod2', 'prod2', 20, 20, 2, 2, 'prod2');
insert into product(name, description, price, weight, category_id, supplier_id, image_url) values ('prod3', 'prod3', 30, 30, 3, 3, 'prod3');

insert into customer(first_name, last_name, username, password, email) values ('Alina', 'Somcutean', 'alina', 'alina', 'alina@yahoo.com');

insert into address(country, city, county, street_address) values ('Romania', 'Cluj-Napoca', 'Cluj', 'stree2');

insert into location(name, address_id) values ('Location1', 1);

insert into stock(product_id, location_id, quantity) values (1, 1, 4);
insert into stock(product_id, location_id, quantity) values (2, 1, 1);
