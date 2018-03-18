DROP TABLE IF EXISTS basket;
DROP TABLE IF EXISTS order;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS user;


CREATE TABLE IF NOT EXISTS user (
  id         IDENTITY PRIMARY KEY,
  telephone  VARCHAR(20) NOT NULL,
  password   VARCHAR(30) NOT NULL,
  first_name VARCHAR(20) NOT NULL,
  last_name  VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS category (
  id   IDENTITY PRIMARY KEY,
  name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS product (
  id          IDENTITY PRIMARY KEY,
  name        VARCHAR(20) NOT NULL,
  id_category IDENTITY    NOT NULL,
  price       DOUBLE      NOT NULL,
  FOREIGN KEY (id_category) REFERENCES category (id)
);

CREATE TABLE IF NOT EXISTS order (
  id          IDENTITY PRIMARY KEY,
  id_user     IDENTITY    NOT NULL,
  datetime    TIMESTAMP   NOT NULL,
  destination VARCHAR(40) NOT NULL,
  FOREIGN KEY (id_user) REFERENCES user (id)
);

CREATE TABLE IF NOT EXISTS basket (
  id         IDENTITY PRIMARY KEY,
  id_product IDENTITY NOT NULL,
  id_order   IDENTITY NOT NULL,
  FOREIGN KEY (id_product) REFERENCES product (id),
);
