create database QuanLyDiemHocSinh
go
use QuanLyDiemHocSinh
go
create table HocSinh
(
    id          int primary key identity,
    hoten       nvarchar(50),
    ngaysinh    nvarchar(100),
    diachi      nvarchar(100),
    sodienthoai char(10),
    lop         varchar(10)
)
go
create table MonHoc
(
    id        int primary key identity,
    tenmonhoc nvarchar(50),
    sotc      int
)
go
create table Diem
(
    id        int primary key identity,
    idhocsinh int,
    kyhoc     int
)
go
create table CTDiem
(
    id       int primary key identity,
    iddiem   int not null,
    idmonhoc int,
    diem     float
)
go
create proc addHocSinh @hoten nvarchar(50), @ngaysinh nvarchar(100), @diachi nvarchar(100), @sodienthoai char(10),
                       @lop varchar(10)
as
begin
    insert into HocSinh(hoten, ngaysinh, diachi, sodienthoai, lop)
    values (@hoten, @ngaysinh, @diachi, @sodienthoai, @lop)
end
go
create proc updateHocSinh @id int, @hoten nvarchar(50), @ngaysinh nvarchar(100), @diachi nvarchar(100),
                          @sodienthoai char(10), @lop varchar(10)
as
begin
    update HocSinh
    set hoten= @hoten,
        ngaysinh= @ngaysinh,
        diachi= @diachi,
        sodienthoai= @sodienthoai,
        lop= @lop
    where id = @id
end
go
create proc deleteHocSinh @id int
as
begin
    delete from HocSinh where id = @id
end
go
create proc getHocSinh
as
begin
    select * from HocSinh
end
go
create proc addMonHoc @tenmonhoc nvarchar(50), @sotc int
as
begin
    insert into MonHoc(tenmonhoc, sotc) values (@tenmonhoc, @sotc)
end
go
create proc updateMonHoc @id int, @tenmonhoc nvarchar(50), @sotc int
as
begin
    update MonHoc set tenmonhoc= @tenmonhoc, sotc= @sotc where id = @id
end
go
create proc deleteMonHoc @id int
as
begin
    delete from MonHoc where id = @id
end
go
create proc getMonHoc
as
begin
    select * from MonHoc
end
go
create proc addDiem @idhocsinh int, @kihoc int
as
begin
    insert into Diem(idhocsinh, kyhoc) values (@idhocsinh, @kihoc)
end
go
create proc updateDiem @id int, @idhocsinh int, @kyhoc int
as
begin
    update Diem set idhocsinh= @idhocsinh, kyhoc= @kyhoc where id = @id
end
go
create proc deleteDiem @id int
as
begin
    delete from Diem where id = @id
end
go
create proc getDiem @idhocsinh int
as
begin
    select Diem.id, HocSinh.id, HocSinh.hoten, kyhoc
    from Diem,
         HocSinh
    where Diem.idhocsinh = HocSinh.id and HocSinh.id= @idhocsinh
end
go
create proc addCTDiem @iddiem int, @idmonhoc int, @diem float
as
begin
    insert into CTDiem(iddiem, idmonhoc, diem) values (@iddiem, @idmonhoc, @diem)
end
go
create proc updateCTDiem @id int, @iddiem int, @idmonhoc int, @diem float
as
begin
    update CTDiem
    set iddiem= @iddiem,
        idmonhoc = @idmonhoc,
        diem= @diem
    where id = @id
end
go
create proc deleteCTDiem @id int
as
begin
    delete from Diem where id = @id
end
go
create proc getCTDiem @idDiem int
as
    begin 
        select CTDiem.id,CTDiem.iddiem,CTDiem.idmonhoc,MonHoc.tenmonhoc,MonHoc.sotc,CTDiem.diem from CTDiem,MonHoc where CTDiem.idmonhoc= MonHoc.id and CTDiem.iddiem= @idDiem
    end
