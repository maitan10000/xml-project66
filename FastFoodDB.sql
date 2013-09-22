IF(OBJECT_ID('OrderDetail')) IS NOT NULL
DROP TABLE [OrderDetail]
GO

IF(OBJECT_ID('Order')) IS NOT NULL
DROP TABLE [Order]
GO

IF(OBJECT_ID('Product')) IS NOT NULL
DROP TABLE Product
GO

IF(OBJECT_ID('Category')) IS NOT NULL
DROP TABLE Category
GO

IF(OBJECT_ID('User')) IS NOT NULL
DROP TABLE [User]
GO

-- User table
CREATE TABLE [User]
(
	UserName varchar(30) PRIMARY KEY,
	Password varchar(30) not null,
	FirstName nvarchar(50),
	LastName nvarchar(50),
	Email nvarchar(50),
	Address nvarchar(256),
	Phone nvarchar(30),
	[Role] nvarchar(20) not null,
	CreateDate DateTime,
	IsActive bit
)
-- Ex:
INSERT INTO [User](UserName, Password, FirstName, LastName,Email, Address,Phone, [Role], CreateDate, IsActive) 
VALUES ('test1', 'test1', 'A', 'Nguyen Van', 'test1@gmail.com', 'HCM', '09356254568', 'Customer', '09/20/2013', 'true')
INSERT INTO [User](UserName, Password, FirstName, LastName,Email, Address,Phone, [Role], CreateDate, IsActive) 
VALUES ('test2', 'test2', 'B', 'Nguyen Thi', 'test2@gmail.com', 'HCM', '09356254458', 'Customer', '09/20/2013', 'true')
INSERT INTO [User](UserName, Password, FirstName, LastName,Email, Address,Phone, [Role], CreateDate, IsActive) 
VALUES ('test3', 'test3', 'C', 'Nguyen Van', 'test3@gmail.com', 'HCM', '09435345454', 'Customer', '09/20/2013', 'true')

INSERT INTO [User](UserName, Password, FirstName, LastName,Email, Address,Phone, [Role], CreateDate, IsActive) 
VALUES ('admin1', 'admin1', 'D', 'Nguyen Thi', 'admin1@gmail.com', 'HCM', '09354224568', 'Admin', '09/20/2013', 'true')
INSERT INTO [User](UserName, Password, FirstName, LastName,Email, Address,Phone, [Role], CreateDate, IsActive) 
VALUES ('admin2', 'admin2', 'E', 'Nguyen Van', 'admin2@gmail.com', 'HCM', '09542254568', 'Admin', '09/20/2013', 'true')


--Category table
CREATE TABLE Category
(
	ID int IDENTITY PRIMARY KEY,
	[Name] nvarchar(256),
	IsActive bit	
)
--Ex:
INSERT INTO Category([Name], IsActive) VALUES('Cakes', 'true')
INSERT INTO Category([Name], IsActive) VALUES('Drink', 'true')
INSERT INTO Category([Name], IsActive) VALUES('Fruit', 'true')
INSERT INTO Category([Name], IsActive) VALUES('Hamburger', 'true')
INSERT INTO Category([Name], IsActive) VALUES('Rice', 'true')

--Product table
CREATE TABLE Product
(
	ID bigint IDENTITY PRIMARY KEY,
	[Name] nvarchar(256) not null,
	Price int not null,
	[Image] nvarchar(256),
	Description text,
	CateID int FOREIGN KEY REFERENCES Category(ID),
	BuyCount int,
	CreateDate Datetime,
	LastUpdate Datetime,
	IsActive bit
)
--Ex:
--Drink 2
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Coca', 10000, '', '', 2, 0, '09/20/2013', '09/20/2013', 'true')
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Pepsi', 10000, '', '', 2, 0, '09/20/2013', '09/20/2013', 'true')
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('C2', 8000, '', '', 2, 0, '09/20/2013', '09/20/2013', 'true')
--Cakes 1
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Speical cake 1', 20000, '', '', 1, 0, '09/20/2013', '09/20/2013', 'true')
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Speical cake 2', 30000, '', '', 1, 0, '09/20/2013', '09/20/2013', 'true')
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Speical cake 3', 50000, '', '', 1, 0, '09/20/2013', '09/20/2013', 'true')
--Fruit 3
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Apple', 15000, '', '', 3, 0, '09/20/2013', '09/20/2013', 'true')
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Watermelon', 10000, '', '', 3, 0, '09/20/2013', '09/20/2013', 'true')
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Mango', 15000, '', '', 3, 0, '09/20/2013', '09/20/2013', 'true')
--Humburger 4
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Pork Humburger', 45000, '', '', 4, 0, '09/20/2013', '09/20/2013', 'true')
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Beef Humburger', 50000, '', '', 4, 0, '09/20/2013', '09/20/2013', 'true')
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Vegetable Humburger', 25000, '', '', 4, 0, '09/20/2013', '09/20/2013', 'true')
--Rice 5
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Chicken Rice', 45000, '', '', 5, 0, '09/20/2013', '09/20/2013', 'true')
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Egg Rice', 30000, '', '', 5, 0, '09/20/2013', '09/20/2013', 'true')
INSERT INTO Product([Name], Price, [Image], Description, CateID, BuyCount, CreateDate, LastUpdate, IsActive)
VALUES('Broken Rice', 35000, '', '', 5, 0, '09/20/2013', '09/20/2013', 'true')

--Order table
CREATE TABLE [Order]
(
	ID bigint IDENTITY PRIMARY KEY,
	BuyerName varchar(30) FOREIGN KEY REFERENCES [User](UserName),
	Creator varchar(30) FOREIGN KEY REFERENCES [User](UserName),
	Status nvarchar(10) not null,
	Notes text,
	ReceiveAddress nvarchar(256),
	CreateDate Datetime,	
	IsActive bit
)

--Order detail table
CREATE TABLE [OrderDetail]
(
	OrderID bigint FOREIGN KEY REFERENCES[Order](ID),
	ProductID bigint FOREIGN KEY REFERENCES Product(ID),
	Price int,
	Quantity int,
	IsActive bit,
	PRIMARY KEY(OrderID, ProductID)
)