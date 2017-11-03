alter proc dbo.VK1 @ngay date
AS
	SELECT P.BSX,TENKH,NGAYSUACHUA, NGAYNHAN, DT, DC
	FROM PHIEUSUACHUA P, KHACHHANG K
	WHERE P.BSX=K.BSX and ([NGAYSUACHUA]) = @Ngay



alter proc dbo.VK2 (@MASC varchar(12), @Tien int output)
as
begin	
	set @Tien = (SELECT SUM(SOLUONG*DONGIA) as N'Thành tiền'
	FROM  HOADON HD, PHIEUSUACHUA PK, CHITIETSUACHUA CT, PHUTUNG PT
	WHERE  PT.MAPT =CT.MAPT and CT.MASC=PK.MASC and
		PK.MASC=HD.MASC and CT.MASC = @MASC
	group by CT.MASC)
end	



CREATE TRIGGER AutoIncrement04
ON HOADON
for Insert
AS
BEGIN
DECLARE @MAXValue VARCHAR(10),@NEWValue VARCHAR(10),@NEW_ID VARCHAR(10), @OLD_ID VARCHAR(10);
SELECT @MAXValue = ISNULL(MAX(MAHD), '0') FROM HOADON
select @OLD_ID = MAHD from INSERTED
SET @NEWValue= REPLACE(@MaxValue,'HD','')+1
SET @NEW_ID = 'HD'+
    CASE
       WHEN LEN(@NEWValue)<3
          THEN REPLICATE('0',3-LEN(@newValue))
          ELSE ''
       END +
       @NEWValue
UPDATE HOADON SET MAHD = @NEW_ID WHERE MAHD = @OLD_ID
END



create procedure dbo.BCDS
	@Thang int, @Nam int
as
 select count(*) as 'Số Xe Sửa', sum(TONGTIEN) as 'Tổng Doanh Thu'
 from KHACHHANG KH join PHIEUSUACHUA PS on KH.BSX = PS.BSX join HOADON HD on HD.MASC = PS.MASC
 where month(NGAYLAPHD) = @Thang and year(NGAYLAPHD) = @Nam
 --group by [Ngày Khám]




alter procedure dbo.BCT
	@Thang int, @Nam int
as
select  ct.MAPT,t.TENPT , sum([SOLUONGPT]) as 'Tổng Số Lượng', count(*) as 'Số Lần Dùng'
from PHUTUNG t join CHITIETSUACHUA ct on t.MAPT = ct.MAPT join PHIEUSUACHUA pk 
		on ct.MASC = pk.MASC join HOADON hd on hd.MASC = pk.MASC
where month([NGAYSUACHUA]) = @Thang and year([NGAYSUACHUA]) = @Nam and DONGIA != 0
group by ct.MAPT, TENPT
