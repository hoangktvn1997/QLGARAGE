USE [OTOG1]
GO
/****** Object:  StoredProcedure [dbo].[BCDoanhThu]    Script Date: 30-Oct-17 9:18:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE procedure [dbo].[BCDS] 
	@Thang int, @Nam int
as
 select NGAYSUACHUA, count(*) as 'SoBN', sum(TONGTIEN) as 'Doanhso'
 from KHACHHANG K join PHIEUSUACHUA P on K.BSX = P.BSX join HOADON H on H.MASC = P.MASC
 where month(NGAYSUACHUA) = @Thang and year(NGAYSUACHUA) = @Nam
 group by NGAYSUACHUA