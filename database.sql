﻿use master

if DB_ID('QLQAN') is not null
	drop database QLQAN
go

create database QLQAN

go

use QLQAN

create table categories
(
	id int not null primary key identity(1,1),
	name nvarchar(50),
	status bit default 1
)

create table products
(
	id char(5) not null primary key,
	name nvarchar(50),
	image nvarchar(500),
	price money,
	quantity int,
	status bit default 1,
	category_id int foreign key references categories(id) on update cascade
)

create table staffs
(
	id int not null IDENTITY(1,1) primary key,
	name nvarchar(30),
	username nvarchar(30),
	password nvarchar(10),
	type varchar(10),
	status bit default 1
)

create table customers
(
	id int not null IDENTITY(1,1) primary key,
	name nvarchar(50),
	address nvarchar(100),
	phone nvarchar(12),
	status bit default 1
)

create table vouchers
(
	id int not null IDENTITY(1,1) primary key,
	code varchar(20),
	discount_percent int,
	status bit default 1
)

create table bills
(
	id int  not null IDENTITY(1,1) primary key,
	staff_id int foreign key references staffs(id) on update cascade,
	customer_id int foreign key references customers(id) on update cascade,
	voucher_id  int foreign key references vouchers(id) on update cascade,
	total_prices money,
	discount_prices money,
	created_at datetime
)

create table product_bills
(
	product_id char(5) foreign key references products(id) on update cascade,
	bill_id int foreign key references bills(id) on update cascade,
	product_quantity int,
	price money,
	primary key(product_id, bill_id)
)



insert into categories(name)  values ('Chicken')
insert into categories(name)  values ('Beef')
insert into categories(name)  values ('Vegetable')
insert into categories(name)  values ('Drinks')

insert into products(id, name, image, price, quantity, category_id) values ('C01', 'Slow Cooker Chicken Tortilla Soup', 'slow-cooker-chicken-tortilla-soup.jpg', 40000, 50, 1)
insert into products(id, name, image, price, quantity, category_id) values ('C02', 'Thai Chicken and Vegetable Soup', 'thai-chiken-and-vegetable-soup.jpg', 50000, 50, 1)
insert into products(id, name, image, price, quantity, category_id) values ('C03', 'Mexican Tortilla Soup', 'mexican-tortilla-soup.jpg', 60000, 50, 1)
insert into products(id, name, image, price, quantity, category_id) values ('C04', 'Tasty 2 Step Chicken Bake', 'tasty-2-step-chicken-bake.jpg', 70000, 50, 1)
insert into products(id, name, image, price, quantity, category_id) values ('C05', 'Easy Chicken Pot Pie', 'easy-chicken-pot-pie.jpg', 80000, 50, 1)
insert into products(id, name, image, price, quantity, category_id) values ('C06', 'Cheesy Chicken Enchiladas Verde', 'cheesy-chicken-enchiladas-verde.jpg', 20000, 50, 1)
insert into products(id, name, image, price, quantity, category_id) values ('C07', 'Easy Chicken Paprika', 'easy-chicken-paprika.jpg', 10000, 50, 1)
insert into products(id, name, image, price, quantity, category_id) values ('C08', 'Orange Picante Chicken', 'orange-picante-chicken.jpg', 50000, 50, 1)
insert into products(id, name, image, price, quantity, category_id) values ('C09', 'Chicken Pasta Primavera', 'chicken-pasta-primavera.jpg', 20000, 50, 1)

insert into products(id, name, image, price, quantity, category_id) values ('B01', 'Classic Lasagna', 'classic-lasagna.jpg', 10000, 50, 2)
insert into products(id, name, image, price, quantity, category_id) values ('B02', 'Meatloaf With Roasted Garlic Potatoes', 'meatloaf-with-roasted-garlic-potatoes.jpg', 60000, 50, 2)
insert into products(id, name, image, price, quantity, category_id) values ('B03', 'Savory Vegetable Beef Soup', 'savory-vegetable-beef-soup.jpg', 50000, 50, 2)
insert into products(id, name, image, price, quantity, category_id) values ('B04', 'Easy Meatball Parm Hero', 'easy-meatball-parm-hero.jpg', 20000, 50, 2)
insert into products(id, name, image, price, quantity, category_id) values ('B05', 'Italian Stuffed Meatloaf', 'italian-stuffed-meatloaf.jpg', 60000, 50, 2)
insert into products(id, name, image, price, quantity, category_id) values ('B06', 'Beef Enchiladas', 'beef-enchiladas.jpg', 70000, 50, 2)

insert into products(id, name, image, price, quantity, category_id) values ('V01', 'Broccoli Rice Casserole', 'broccoli-rice-casserole.jpg', 2000, 50, 3)
insert into products(id, name, image, price, quantity, category_id) values ('V02', 'Swiss Vegetable Bake For A Crowd', 'swiss-vegetable-bake-for-a-crowd.jpg', 40000, 50, 3)
insert into products(id, name, image, price, quantity, category_id) values ('V03', 'Cheesy Chile Corn Casserole', 'cheesy-chile-corn-casserole.jpg', 20000, 50, 3)
insert into products(id, name, image, price, quantity, category_id) values ('V04', 'Crowd Pleasing Vegetable Casserole', 'crowd-pleasing-vegetable-casserole.jpg', 60000, 50, 3)
insert into products(id, name, image, price, quantity, category_id) values ('V05', 'Classic Green Bean Casserole', 'classic-green-bean-casserole.jpg', 50000, 50, 3)


insert into products(id, name, image, price, quantity, category_id) values ('D01', 'Strawberry Mojito', 'strawberry-mojito.jpg', 10000, 50, 4)
insert into products(id, name, image, price, quantity, category_id) values ('D02', 'Fruit Flavored Water', 'fruit-flavored-water.jpg', 80000, 50, 4)
insert into products(id, name, image, price, quantity, category_id) values ('D03', 'Rhubarb Margarita', 'rhubarb-margarita.jpg', 20000, 50, 4)
insert into products(id, name, image, price, quantity, category_id) values ('D04', 'Mexican Strawberry Water', 'mexican-strawberry-water-agua-de-fresa.jpg', 40000, 50, 4)
insert into products(id, name, image, price, quantity, category_id) values ('D05', 'Peanut Butter Banana Smoothie', 'peanut-butter-banana-smoothie.jpg', 10000, 50, 4)


insert into staffs(name, username, password, type) values ('Bui Ngoc Minh', 'minhnora98', '123456', 'staff')
insert into staffs(name, username, password, type) values ('Tran Thi Anh Ngoc', 'ngoc98', '123456', 'staff')
insert into staffs(name, username, password, type) values ('Admin', 'admin', 'admin', 'admin')

insert into customers(name, phone, address) values ('Minh', '123456', 'Ha Noi')
insert into customers(name, phone, address) values ('Ngoc', '654321', 'Ha Noi')
insert into customers(name, phone, address) values ('Bui', '1654321', 'Ha Noi')


insert into vouchers values('HANOI2019', 20, 1)
insert into vouchers values('FIGHTING', 50, 1)
insert into vouchers values('FREE', 30, 1)

select * from categories;
select * from products;
select * from staffs;


go
create trigger trg_update_quantity_products on products
for update
as
	begin
		declare @before int 
		declare @after int 
		select @before = quantity from deleted 
		select @after = quantity from inserted 
		if (@before <> @after)
			begin
				if (@after < 0)
					begin
						RAISERROR ('The quantity must be higher than 0.' ,16,1)
						ROLLBACK TRANSACTION
					end
			end
		update products set quantity = quantity
	end
go

--update products set quantity = quantity - 50 where id = 'B01'

--SELECT TOP 1 * FROM bills ORDER BY id DESC

select * from bills
select * from product_bills
select * from vouchers
select * from categories
select * from customers


insert into bills(staff_id, customer_id, total_prices, discount_prices, created_at) values(1, 1, 50000, 10, '2019-04-26')
insert into bills(staff_id, customer_id, total_prices, discount_prices, created_at) values(2, 2, 60000, 10, '2019-04-25')
insert into bills(staff_id, customer_id, total_prices, discount_prices, created_at) values(1, 1, 70000, 10, '2019-04-24')
insert into bills(staff_id, customer_id, total_prices, discount_prices, created_at) values(2, 2, 80000, 10, '2019-04-23')
insert into bills(staff_id, customer_id, total_prices, discount_prices, created_at) values(1, 3, 90000, 10, '2019-04-27')


insert into bills(staff_id, customer_id, total_prices, discount_prices, created_at) values(2, 2, 80000, 10, '2019-03-23')
insert into bills(staff_id, customer_id, total_prices, discount_prices, created_at) values(2, 2, 80000, 10, '2019-03-23')
insert into bills(staff_id, customer_id, total_prices, discount_prices, created_at) values(2, 2, 80000, 10, '2019-03-22')
insert into bills(staff_id, customer_id, total_prices, discount_prices, created_at) values(2, 2, 80000, 10, '2019-03-21')

insert into product_bills(product_id, bill_id, product_quantity, price) values('C01', 1, 10, 50000)
insert into product_bills(product_id, bill_id, product_quantity, price) values('C02', 2, 20, 60000)
insert into product_bills(product_id, bill_id, product_quantity, price) values('B01', 3, 30, 70000)
insert into product_bills(product_id, bill_id, product_quantity, price) values('B02', 4, 40, 80000)
insert into product_bills(product_id, bill_id, product_quantity, price) values('B02', 5, 40, 80000)


/*
SET DATEFIRST 1 SELECT products.name, bills.total_prices, bills.discount_prices, bills.created_at, product_bills.product_quantity, product_bills.price FROM products INNER JOIN product_bills ON products.id = product_bills.product_id INNER JOIN bills on bills.id = product_bills.bill_id AND bills.created_at >= dateadd(day, 1-datepart(dw, getdate()), CONVERT(date,getdate())) AND bills.created_at <  dateadd(day, 8-datepart(dw, getdate()), CONVERT(date,getdate()))

SET DATEFIRST 1 SELECT products.name, bills.total_prices, bills.discount_prices, bills.created_at, product_bills.product_quantity, product_bills.price FROM products INNER JOIN product_bills ON products.id = product_bills.product_id INNER JOIN bills on bills.id = product_bills.bill_id WHERE bills.created_at >= dateadd(m, datediff(m, 0, GetDate()), 0)
  AND bills.created_at < dateadd(m, datediff(m, -1, GetDate()), 0)

SET DATEFIRST 1 SELECT products.name, bills.total_prices, bills.discount_prices, bills.created_at, product_bills.product_quantity, product_bills.price FROM products INNER JOIN product_bills ON products.id = product_bills.product_id INNER JOIN bills on bills.id = product_bills.bill_id WHERE bills.created_at >= DATEADD(DAY, 0, DATEDIFF(DAY, 0, CURRENT_TIMESTAMP)) AND bills.created_at <  DATEADD(DAY, 1, DATEDIFF(DAY, 0, CURRENT_TIMESTAMP));
*/