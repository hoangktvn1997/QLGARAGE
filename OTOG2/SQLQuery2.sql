ALTER proc dbo.VK2 (@MASC varchar(12), @Tien int output)
as
begin	
	set @Tien = (SELECT SUM(CT.SOLUONG*PT.DONGIA) as N'Thành tiền'
	FROM  HOADON HD, CHITIETSUACHUA CT, PHUTUNG PT, PHIEUSUACHUA PS
	WHERE  CT.MASC = HD.MASC and PT.MAPT = CT.MAPT--and CT.MASC = @MASC
	group by CT.MASC)
end

alter proc Vk4 (@MASC varchar(10), @Tien int output)
as
begin
set @Tien = 
(SELECT SUM(CT.SOLUONG*PT.DONGIA + TC.TC) as N'Thành tiền'
FROM CHITIETSUACHUA CT, PHUTUNG PT, TIENCONG TC
WHERE PT.MAPT = CT.MAPT and TC.MATC =  PT.MATC and CT.MASC = @MASC
group by CT.MASC)
end

