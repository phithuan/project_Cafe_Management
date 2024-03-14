CREATE DATABASE QLQuancoffee

Use QLQuancoffee

CREATE TABLE Nhanvien (
    Manv varchar(6) PRIMARY KEY,
    Hoten varchar(30),
    SDT int,
    Gioitinh varchar(5),
    Chucvu varchar(20),
    Phanquyen int,
    Ngayvaolam datetime
);
GO

CREATE TABLE Khachhang (
    Makh varchar(6) PRIMARY KEY,
    Tenkh varchar(30),
    SDT int,
    DiemTL int
);
GO

CREATE TABLE Account (
    Username varchar(20) PRIMARY KEY,
    Matkhau varchar(20),
    Manv varchar(6),
    FOREIGN KEY (Manv) REFERENCES Nhanvien(Manv)
);
GO

CREATE TABLE Thucdon (
    Mathucdon varchar(6) PRIMARY KEY,
    Tenthucdon varchar(30),
    Gia int
);
GO

CREATE TABLE Ban (
    Maban varchar(6) PRIMARY KEY,
    Trangthai varchar(255)
);
GO

CREATE TABLE Donhang (
    Madon varchar(6) PRIMARY KEY,
    Ngaymua datetime,
    Maban varchar(6),
    Makh varchar(6),
    Mavn varchar(6),
    FOREIGN KEY (Maban) REFERENCES Ban(Maban),
    FOREIGN KEY (Makh) REFERENCES Khachhang(Makh),
    FOREIGN KEY (Mavn) REFERENCES Nhanvien(Manv)
);
GO

CREATE TABLE Chitietdonhang (
    Machitiet int  PRIMARY KEY,
    Mathucdon varchar(6),
    Madon varchar(6),
    DiemTL int,
    Soluong int,
    Tongtien int,
    FOREIGN KEY (Mathucdon) REFERENCES Thucdon(Mathucdon),
    FOREIGN KEY (Madon) REFERENCES Donhang(Madon)
);
GO

-- Thêm nhân viên
INSERT INTO Nhanvien (Manv, Hoten, SDT, Gioitinh, Chucvu, Phanquyen, Ngayvaolam)
VALUES
    ('NV001', 'Nguyen Van A', 123456789, 'Nam', 'Quan ly', 1, '2024-03-15 08:00:00'),
    -- Thêm các nhân viên khác ở đây...

-- Thêm khách hàng
INSERT INTO Khachhang (Makh, Tenkh, SDT, DiemTL)
VALUES
    ('KH001', 'Le Thi B', 987654321, 100),
    -- Thêm các khách hàng khác ở đây...

-- Thêm tài khoản
INSERT INTO Account (Username, Matkhau, Manv)
VALUES
    ('user001', 'password123', 'NV001'),
    -- Thêm các tài khoản khác ở đây...

-- Thêm thực đơn
INSERT INTO Thucdon (Mathucdon, Tenthucdon, Gia)
VALUES
    ('TD001', 'Cafe sua da', 25000),
    -- Thêm các món ăn khác ở đây...

-- Thêm bàn
INSERT INTO Ban (Maban, Trangthai)
VALUES
    ('B001', 'Trong'),
    -- Thêm các bàn khác ở đây...

-- Thêm đơn hàng
INSERT INTO Donhang (Madon, Ngaymua, Maban, Makh, Mavn)
VALUES
    ('DH001', '2024-03-15 10:30:00', 'B001', 'KH001', 'NV001'),
    -- Thêm các đơn hàng khác ở đây...

-- Thêm chi tiết đơn hàng
INSERT INTO Chitietdonhang (Machitiet, Mathucdon, Madon, DiemTL, Soluong, Tongtien)
VALUES
    (1, 'TD001', 'DH001', 5, 2, 50000);
    -- Thêm các chi tiết đơn hàng khác ở đây...

