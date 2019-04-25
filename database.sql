use master

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
	type varchar(10)
)

create table customers
(
	id char(5) not null primary key,
	name nvarchar(50),
	address nvarchar(100),
	phone nvarchar(12),
	point int
)

create table vouchers
(
	id char(5) not null primary key,
	code varchar(20),
	discount_percent int,
	status bit
)

create table bills
(
	id int  not null IDENTITY(1,1) primary key,
	staff_id int foreign key references staffs(id) on update cascade,
	customer_id char(5) foreign key references customers(id) on update cascade,
	voucher_id  char(5) foreign key references vouchers(id) on update cascade,
	total_prices money,
	discount_prices money,
	total_people int,
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



insert into categories(name)  values (N'Đồ uống')
insert into categories(name)  values (N'Đồ ngọt')
insert into categories(name)  values (N'Thức ăn nhanh')

insert into products(id, name, price, quantity, category_id) values ('A01', N'Trà sữa trân châu', 30000, 50, 1)
insert into products(id, name, price, quantity, category_id) values ('A02', N'Trà sữa không đường', 25000, 50, 1)
insert into products(id, name, price, quantity, category_id) values ('B01', N'Bánh sữa', 20000, 50, 2)
insert into products(id, name, price, quantity, category_id) values ('B02', N'Bánh đường', 20000, 50, 2)
insert into products(id, name, price, quantity, category_id) values ('B03', N'Bánh canh', 20000, 50, 2)
insert into products(id, name, price, quantity, category_id) values ('B04', N'Bánh cay', 20000, 50, 2)
insert into products(id, name, price, quantity, category_id) values ('B05', N'Bánh cay hơn cái bánh trên', 20000, 50, 2)

insert into staffs(name, username, password, type) values (N'Bùi Ngọc Minh', 'minhnora98', '123456', 'staff')
insert into staffs(name, username, password, type) values (N'Trần Thị Ánh Ngọc', 'anngo98', '123456', 'staff')
insert into staffs(name, username, password, type) values (N'Admin', 'admin', '123456', 'admin')

select * from categories;
select * from products;
select * from staffs;

SELECT products.*, categories.id as catID, categories.name as catName, categories.status as catStatus FROM products INNER JOIN categories ON products.category_id = categories.id WHERE categories.name = N'Đồ uống'
