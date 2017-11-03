--
select MAPT from PHUTUNG

select TENTC
from TIENCONG T, PHUTUNG P
where T.MATC = P.MATC

select TENKH, DT
from KHACHHANG

--đinh dạng tiền
declare @mon money
set @mon = 50000
select PARSENAME(convert(varchar,convert(money,@mon),1),2 )


-- Tạo mã sinh ID cho Mã Tiền Công
CREATE  TRIGGER AutoIncrement01
ON TIENCONG
for Insert
AS
BEGIN
DECLARE @MAXValue VARCHAR(10),@NEWValue VARCHAR(10),@NEW_ID VARCHAR(10), @OLD_ID VARCHAR(10);
--Lấy giá trị lớn nhất của UserID trong bảng Manager
SELECT @MAXValue = ISNULL(MAX(MATC), '0') FROM TIENCONG
--Lấy giá trị ID được chèn vào từ bên ngoài (bất kì, không quan trọng)
select @OLD_ID = MATC from INSERTED
--Lấy phần chuỗi số đằng sau MNG rồi tăng lên 1 đơn vị
SET @NEWValue= REPLACE(@MaxValue,'TC','')+1
-- Kiểm tra NEWValue nếu < 100
-- Nếu <100, thêm vào số 0 sao cho NEWValue có độ dài = 3
SET @NEW_ID = 'TC'+
    CASE
       WHEN LEN(@NEWValue)<3
          THEN REPLICATE('0',3-LEN(@newValue))
          ELSE ''
       END +
       @NEWValue
--Thay thế giá trị Id từ bên ngoài bằng Id vừa được tạo
UPDATE TIENCONG SET MATC = @NEW_ID WHERE MATC = @OLD_ID
END

-- Tạo mã sinh ID cho Mã Phụ Tùng

CREATE TRIGGER AutoIncrement02
ON PHUTUNG
for Insert
AS
BEGIN
DECLARE @MAXValue VARCHAR(10),@NEWValue VARCHAR(10),@NEW_ID VARCHAR(10), @OLD_ID VARCHAR(10);
SELECT @MAXValue = ISNULL(MAX(MAPT), '0') FROM PHUTUNG
select @OLD_ID = MAPT from INSERTED
SET @NEWValue= REPLACE(@MaxValue,'PT','')+1
SET @NEW_ID = 'PT'+
    CASE
       WHEN LEN(@NEWValue)<3
          THEN REPLICATE('0',3-LEN(@newValue))
          ELSE ''
       END +
       @NEWValue
--Thay thế giá trị Id từ bên ngoài bằng Id vừa được tạo
UPDATE PHUTUNG SET MAPT = @NEW_ID WHERE MAPT = @OLD_ID
END

--ID PSC

CREATE TRIGGER AutoIncrement03
ON PHIEUSUACHUA
for Insert
AS
BEGIN
DECLARE @MAXValue VARCHAR(10),@NEWValue VARCHAR(10),@NEW_ID VARCHAR(10), @OLD_ID VARCHAR(10);
SELECT @MAXValue = ISNULL(MAX(MASC), '0') FROM PHIEUSUACHUA
select @OLD_ID = MASC from INSERTED
SET @NEWValue= REPLACE(@MaxValue,'SC','')+1
SET @NEW_ID = 'SC'+
    CASE
       WHEN LEN(@NEWValue)<3
          THEN REPLICATE('0',3-LEN(@newValue))
          ELSE ''
       END +
       @NEWValue
--Thay thế giá trị Id từ bên ngoài bằng Id vừa được tạo
UPDATE PHIEUSUACHUA SET MASC = @NEW_ID WHERE MASC = @OLD_ID
END