CREATE DATABASE cafe;
GO

USE cafe;
GO

CREATE TABLE [ad] (
    [id] int NOT NULL,
    [username] varchar(200) DEFAULT NULL,
    [password] varchar(100) DEFAULT NULL,
    [s_ques] varchar(500) DEFAULT NULL,
    [ans] varchar(200) DEFAULT NULL,
    PRIMARY KEY ([id])
);
GO

CREATE TABLE [product] (
    [id] int NOT NULL IDENTITY,
    [name] varchar(200) DEFAULT NULL,
    [price] float DEFAULT NULL,
    [image] varbinary(max),
    PRIMARY KEY ([id])
);
GO

CREATE TABLE [cart] (
    [cid] int DEFAULT NULL,
    [pid] int DEFAULT NULL,
    [pName] varchar(45) DEFAULT NULL,
    [qty] int DEFAULT NULL,
    [price] float DEFAULT NULL,
    [total] float DEFAULT NULL
);
GO

CREATE TABLE [payment] (
    [pid] int NOT NULL IDENTITY,
    [cName] varchar(200) DEFAULT NULL,
    [proid] varchar(100) DEFAULT NULL,
    [pName] varchar(200) DEFAULT NULL,
    [total] float DEFAULT NULL,
    [pdate] date DEFAULT NULL,
    PRIMARY KEY ([pid])
);
GO

-- Insert data into the 'ad' table
INSERT INTO [ad] (id, username, password, s_ques, ans)
VALUES
    (1, 'admin', 'admin123', 'What is your favorite color?', 'Blue'),
    -- Add more rows for 'ad' table here...

-- Insert data into the 'product' table
INSERT INTO [product] (name, price, image)
VALUES
    ('Coffee', 3.5, NULL),
    -- Add more rows for 'product' table here...

-- Insert data into the 'cart' table
INSERT INTO [cart] (cid, pid, pName, qty, price, total)
VALUES
    (1, 1, 'Coffee', 2, 3.5, 7),
    -- Add more rows for 'cart' table here...

-- Insert data into the 'payment' table
INSERT INTO [payment] (cName, proid, pName, total, pdate)
VALUES
    ('John Doe', 'P001', 'Coffee', 7, '2024-03-15'),
    -- Add more rows for 'payment' table here...

