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
 standard_cost NUMBER(10) NOT NULL,
 Productsimage varchar2(255),
 status varchar2(1) DEFAULT 'y');

 --------------------------------------------------------------------------------------------------------------------------------
  SELECT * FROM cart where order_id=101;
  
  SELECT quantity FROM cart where order_id=101;
 SELECT * FROM product;
select*from customer;
 SELECT * FROM order_details;
 SELECT * FROM customer;
 SELECT TO_CHAR(SYSDATE, 'DD-MM-YYYY') FROM DUAL;
 update order_details set status ='conform', order_date=TO_CHAR(SYSDATE, 'DD-MM-YYYY') where order_id=46;
 
 
  SELECT order_id,status,order_date,customer_id from cu
  SELECT customer_id FROM order_details where  status in 'place order'  'conform';
 SELECT TO_CHAR(SYSDATE, 'DD-MM-YYYY') FROM DUAL;

 ----------------one day sale
 create view today_product_sale as
 select  
 p.products_name
 ,c.price
 ,sum(c.quantity) as quantity
 ,(c.price*sum(c.quantity)) as cost
 ,p.Productsimage
 from order_details d
 join cart c on d.order_id=c.order_id
 join product p on p.products_id=c.product_id
 group by(p.products_name,c.price,trunc(d.order_date),d.status,p.Productsimage)
 having trunc(d.order_date)=trunc(sysdate) and  d.status='conform';

 --------------------------------------------- total one day
 create view today_product_amount_sale as
   select  
 sum(c.price*sum(c.quantity)) as cost
 from order_details d
 join cart c on d.order_id=c.order_id
 join product p on p.products_id=c.product_id
 group by(p.products_name,c.price,trunc(d.order_date),d.status)
 having trunc(d.order_date)=trunc(sysdate) and d.status='conform';
 ------------------------------------------- last 7 days 
 create view week_product_sale as
 select  
 p.products_name
 ,c.price
 ,sum(c.quantity) as quantity
 ,(c.price*sum(c.quantity))
 as cost,p.productsimage
 from order_details d
 join cart c on d.order_id=c.order_id
 join product p on p.products_id=c.product_id
 where trunc(d.order_date) between trunc(sysdate-7) and trunc(sysdate )
 group by(p.products_name,c.price,d.status,p.productsimage)
 having  d.status='conform' ;

----------------------------------------------------------last 7 days amount
create view week_product_amount_sale as
 select  
 sum(c.price*sum(c.quantity)) as cost
 from order_details d
 join cart c on d.order_id=c.order_id
 join product p on p.products_id=c.product_id
 group by(p.products_name,c.price,trunc(d.order_date),d.status)
 having trunc(d.order_date) between trunc(sysdate-7) and trunc(sysdate ) and d.status='conform'  ;
 -------------------------------
 SELECT * FROM   week_product_amount_sale;
 select* from  week_product_sale;
 select * from  today_product_amount_sale;
 SELECT * FROM  today_product_sale;
 --------------------------------------customer order
  SELECT order_id,status,order_date FROM order_details where customer_id=2 and status= 'place order' or status='conform';
  
 -------------------------------------------- order view 
  select p.products_name,c.quantity,c.price,(c.quantity*c.price) as cost from order_details o
  join cart c on o.order_id =c.order_id
  join product p on p.products_id=c.product_id where o.order_id=1;
  -------------------------------------------------------------order cost
  select sum(c.quantity*c.price) as cost from order_details o
  join cart c on o.order_id =c.order_id
  join product p on p.products_id=c.product_id where o.order_id=3;
  ---------------------------------------------------
------------------------------
  insert into customer (user_name ,password,first_name,last_name,address,phone, email) values('ladha','ladha','ladha','ladha','ladha',9597785471,'ladha@gmail.com');
  -------------------------------------------------
  today orders
   SELECT order_id,status,order_date FROM order_details where order_date=trunc(sysdate );
   ---------------------------------------------------------------------------------
   --check in cart 
    SELECT order_id FROM order_details; where customer_id=2 and status='in cart'
    ---------------------------------------------
    --check product already in cart
     SELECT * FROM order_details where order_id =;
      SELECT quantity FROM cart where order_id=43 and product_id =1;
      -----------------------------------------------------
      --increase quantity
      --------------in cart details-------------------
        select p.products_name,c.quantity,p.standard_cost,(c.quantity*p.standard_cost),p.products_id as cost 
        from order_details o 
        join cart c on o.order_id =c.order_id 
        join product p on p.products_id=c.product_id 
        where o.order_id=46;
  ----------------in cart cost-------------------
   select sum(c.quantity*p.standard_cost) as cost from order_details o join cart c on o.order_id =c.order_id join product p on p.products_id=c.product_id where o.order_id=46;
  ------delete product in cart-----
   delete FROM cart where product_id=1 and order_id=46  ;
 -----------------------------------------------getting current price------------

 SELECT
     standard_cost
 FROM product where products_id=1;
 --------------------------upate rate-------------
  update cart SET price = 456  where order_id=46 and product_id=1;
 
 -----------getting produvt id in list------------
 SELECT product_id FROM cart where order_id=46;
 ----------------------------------------
  --place order
  ------------------------------------sort
   SELECT products_name,standard_cost FROM product where status ='y' or status ='Y' and  products_name LIKE '%chili 1kg%';
   SELECT  products_name,standard_cost,products_id,Productsimage FROM product where status in('y' ,'Y') and  products_name LIKE 'chili 1kg';
   