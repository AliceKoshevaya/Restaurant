INSERT INTO user (telephone, password, first_name, last_name) VALUES ('380502602778', 'qwerty2', 'Alex', 'Kotow');
INSERT INTO user (telephone, password, first_name, last_name) VALUES ('380502606789', '77erty4', 'Alice', 'Smith');
INSERT INTO user (telephone, password, first_name, last_name) VALUES ('380507890778', 'qweyuy5', 'Max', 'Timmson');
INSERT INTO user (telephone, password, first_name, last_name) VALUES ('380502789078', 'jkerty8', 'Olha', 'Grey');
INSERT INTO user (telephone, password, first_name, last_name) VALUES ('380502874778', 'qujkrty0', 'Daren', 'Shelby');

INSERT INTO category (name) VALUES ('sushi');
INSERT INTO category (name) VALUES ('wok');
INSERT INTO category (name) VALUES ('pizza');
INSERT INTO category (name) VALUES ('salad');
INSERT INTO category (name) VALUES ('soup');

INSERT INTO product (name, id_category, price) VALUES ('Greek salad', 4, 200);
INSERT INTO product (name, id_category, price) VALUES ('California', 1, 200);
INSERT INTO product (name, id_category, price) VALUES ('Rome', 5, 200);
INSERT INTO product (name, id_category, price) VALUES ('Spain', 3, 200);
INSERT INTO product (name, id_category, price) VALUES ('Pleasure', 2, 200);


INSERT INTO "order" (id_user, datetime, destination) VALUES (1, '2017-06-05 12:15:06', 'Komarova Street 25.3');
INSERT INTO "order" (id_user, datetime, destination) VALUES (2, '2017-06-06 13:04:09', 'Bern Street 6.7');
INSERT INTO "order" (id_user, datetime, destination) VALUES (3, '2017-06-07 17:09:09', 'Omash Street 480.36');
INSERT INTO "order" (id_user, datetime, destination) VALUES (4, '2017-06-08 18:13:09', 'Wolk Street 56.40');
INSERT INTO "order" (id_user, datetime, destination) VALUES (5, '2017-06-06 16:50:20', 'Kiew Street 256.1');

INSERT INTO product_order (id_product, id_order) VALUES (5, 4);
INSERT INTO product_order (id_product, id_order) VALUES (4, 2);
INSERT INTO product_order (id_product, id_order) VALUES (3, 1);
INSERT INTO product_order (id_product, id_order) VALUES (2, 5);
INSERT INTO product_order (id_product, id_order) VALUES (1, 3);

