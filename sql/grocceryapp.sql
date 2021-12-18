CREATE TABLE customer
(
customer_id  NUMBER(10) GENERATED BY DEFAULT AS IDENTITY (START WITH 1) NOT NULL PRIMARY KEY,
user_name  VARCHAR2(30) NOT NULL,
password VARCHAR2(30) NOT NULL,
 first_name VARCHAR(30) NOT NULL,
 last_name VARCHAR2(30) NOT NULL,
address VARCHAR2(250) NOT NULL,
 phone NUMBER(10) NOT NULL UNIQUE,
  email VARCHAR2(30) NOT NULL UNIQUE); 
 CREATE TABLE order_details
 (
 order_id NUMBER(4) GENERATED BY DEFAULT AS IDENTITY (START WITH 1) NOT NULL PRIMARY KEY,
 customer_id NUMBER(10) NOT NULL,
 status VARCHAR2(20) DEFAULT 'processing',
 order_date DATE DEFAULT sysdate,
 FOREIGN KEY (customer_id)REFERENCES customer(customer_id));
 CREATE TABLE cart
 (
 order_id NUMBER(4) NOT NULL,
 product_id NUMBER(4)NOT NULL,
 quantity NUMBER(3) NOT NULL,
 price NUMBER(10) NOT NULL,
 FOREIGN KEY (product_id)REFERENCES product(products_id),
 FOREIGN KEY (order_id)REFERENCES order_details(order_id)
 );
--DROP TABLE order_items cascade constraints;
  --DROP TABLE orders cascade constraints;
 CREATE TABLE product
 (
 products_name VARCHAR(20) NOT NULL,
 products_id NUMBER(4) GENERATED BY DEFAULT AS IDENTITY (START WITH 1) NOT NULL PRIMARY KEY,
 standard_cost NUMBER(10) NOT NULL);
 --------------------------------------------------------------------------------------------------------------------------------
 SELECT * FROM cart;
 SELECT * FROM product;
 SELECT * FROM order_details;
 SELECT * FROM customer;

 
 
 