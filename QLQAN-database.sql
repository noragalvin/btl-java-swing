use master

if DB_ID('QLQAN') is not null
	drop database QLQAN
go

create database QLQAN

go

use QLQAN

create table shops
(
	id int not null IDENTITY(1,1) primary key,
	name nvarchar(50),
	address nvarchar(100)
)

create table foods
(
	id char(5) not null primary key,
	name nvarchar(50),
	price money,
	quantity int
)

create table staffs
(
	id int not null IDENTITY(1,1) primary key,
	shop_id int foreign key references shops(id) on update cascade on delete cascade,
	working_time nvarchar(10)
)

create table bills
(
	id int  not null IDENTITY(1,1) primary key,
	staff_id int foreign key references staffs(id) on update cascade on delete cascade,
	total_prices money,
	total_people int,
	created_at datetime
)

create table food_bills
(
	food_id char(5) foreign key references foods(id) on update cascade on delete cascade,
	bill_id int foreign key references bills(id) on update cascade on delete cascade,
	food_quantity int
)


create table vouchers
(
	id char(5) not null primary key,
	code varchar(20)
)

create table customers
(
	id int not null IDENTITY(1,1) primary key,
	voucher_id char(5) foreign key references vouchers(id) on update cascade on delete cascade,
	name nvarchar(50),
	address nvarchar(100),
	visit_time datetime
)

create table checkin_checkout
(
	id int not null IDENTITY(1,1) primary key,
	staff_id int foreign key references staffs(id) on update cascade on delete cascade,
	checkin int,
	checkout int,
	checkin_time datetime,
	checkout_time datetime
)