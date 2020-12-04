create table users(

user_id INT NOT NULL auto_increment,
user_name VARCHAR(100),
user_password varchar(40),
user_cnic varchar(15),
user_mobile_no varchar(15),
user_address varchar(100),
is_active boolean,
last_successful_login date,
primary key(user_id)

);

create table suppliers(

sup_id int NOT NULL auto_increment,
sup_name varchar(100),
sup_contact_number int,
sup_email_address varchar(100),
sup_address varchar(150),
primary key(sup_id)

);

create table products(

product_id int NOT NULL auto_increment,
product_name varchar(100),
price numeric,
quantity_at_hand numeric,
reccomendid_supplier_id NUMERIC, 
primary key (product_id)
);

create table customers(
customer_id int not null AUTO_INCREMENT, 
customer_name varchar(100),
customer_mobile_no varchar(15),
customer_cnic varchar(15),
customer_address varchar(150), 
 primary key(customer_id)
 );
 
 create table sales(sale_id int not null auto_increment,
customer_id int not null ,
transaction_date date, 
amount_paid int ,
paid_status boolean,user_id int,
primary key(sale_id),
constraint sale_customer_fk foreign key(customer_id) references customers(customer_id) ,
constraint sale_user_fk foreign key(user_id) references users(user_id)
);
 


------------------added by abid ali -----------------------------------------------

create table sale_detail(sale_detail_id int not null auto_increment,
	sale_id int not null ,
	product_id int not null, 
	product_price int,
    quantity int ,
    sub_total int,
	primary key(sale_detail_id),
	constraint sale_id_fk foreign key(sale_id) references sales(sale_id) ,
	constraint product_id_fk foreign key(product_id) references products(product_id)
);
 
ALTER TABLE products
ADD COLUMN supplier_id  int;

ALTER TABLE products ADD CONSTRAINT supplier_id_fk FOREIGN KEY (supplier_id) REFERENCES suppliers(`sup_id`);
 
 alter TABLE suppliers
MODIFY COLUMN sup_contact_number varchar(13)

ALTER TABLE customers ADD COLUMN total_amount Long;

ALTER TABLE sales ADD COLUMN arrear_amount_to_be_paid int;

alter table products add column purchase_price decimal;

ALTER TABLE products ADD COLUMN barcode  varchar(48);
ALTER TABLE products ADD CONSTRAINT barcode_unique_contraint UNIQUE (barcode);