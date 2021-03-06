create database SalesManagement
use SalesManagement

/* Create tables*/
CREATE TABLE USERS(
	ID char(10) not null primary key,
	Pass varchar(20),
	Name nvarchar(40),
	dBirth smalldatetime,
	cID char(9),
	phoneNo char(11),
	Adrs nvarchar(50),
	joinDate smalldatetime,
	Stt nvarchar(50),
	Revenue money,
	outDate smalldatetime,
	Img image,
	Roles varchar(7)
)

CREATE TABLE PRODUCER (
	ID char(10) not null primary key,
	Name nvarchar(40),
	Adrs nvarchar(50),
	phoneNo char(11)
)

CREATE TABLE PRODUCT (
	ID char(10) not null primary key,
	Name nvarchar(40),
	pdcID char(10),
	Unit nvarchar(20),
	Price money
)

CREATE TABLE ORDERS (
	ID char(10) not null primary key,
	oDate smalldatetime,
	userID char(10),
	Total money
)

CREATE TABLE DETAILORDER (
	oID char(10) not null,
	pID char(10) not null,
	Quantum int,
	Value money,
	Primary Key (oID, pID)
)

/* Alter tables */
Alter Table ORDERS Add Constraint FK_Order_USERS Foreign Key (userID) References USERS(ID);
Alter Table PRODUCT Add Constraint FK_Product_Producer Foreign Key (pdcID) References PRODUCER(ID);
Alter table USERS add constraint checkTuoiNV CHECK (Year(getdate()) - year(dBirth) >= 18);
Alter table USERS add constraint check_NGS_NGVL CHECK (joinDate > dBirth);
Alter table USERS add constraint check_NGVL_NGNV CHECK (outDate > joinDate);
/*Alter Table USERS Add Img Image*/
Alter table PRODUCER Add Descript nvarchar(50)
Alter table PRODUCT Add Quantum int

/* TRIGGERS */
/* Ngày xuất hóa đơn của 1 NV phải > ngày vào làm của nhân viên đó */
CREATE TRIGGER ORDERS_NGHD_NGVL
ON ORDERS
FOR INSERT, UPDATE
AS
	Declare @NG_HD smalldatetime, @NG_VL smalldatetime
	Select @NG_HD = oDate,
		   @NG_VL = joinDate
	From Inserted, USERS
	Where Inserted.userID = USERS.ID
IF (@NG_HD < @NG_VL)
Begin
	Print('Ngày xuất hóa đơn phải > ngày vào làm')
	ROLLBACK TRAN
End

CREATE TRIGGER USERS_NGHD_NGVL
ON USERS
FOR UPDATE
AS
	Declare @NG_HD smalldatetime, @NG_VL smalldatetime
	Select @NG_HD = oDate,
		   @NG_VL = joinDate
	From Inserted, ORDERS
	Where Inserted.ID = ORDERS.userID
IF (@NG_HD < @NG_VL)
Begin
	Print('Ngày xuất hóa đơn phải > ngày vào làm')
	ROLLBACK TRAN
End

/* Ngày xuất hóa đơn của 1 NV phải <= Ngày nghỉ việc của NV đó */
CREATE TRIGGER ORDERS_NGHD_NGNV
ON ORDERS
FOR INSERT, UPDATE
AS
	Declare @NG_HD smalldatetime, @NG_NV smalldatetime
	Select @NG_HD = oDate,
		   @NG_NV = outDate
	From Inserted, USERS
	Where Inserted.userID = USERS.ID
IF (@NG_HD > @NG_NV)
Begin
	Print('Ngày xuất hóa đơn phải <= ngày nghỉ việc')
	ROLLBACK TRAN
End

CREATE TRIGGER USERS_NGHD_NGNV
ON USERS
FOR UPDATE
AS
	Declare @NG_HD smalldatetime, @NG_NV smalldatetime
	Select @NG_HD = oDate,
		   @NG_NV = outDate
	From Inserted inner join ORDERS On Inserted.ID = ORDERS.userID
IF (@NG_NV < @NG_HD)
Begin
	Print('Ngày nghỉ việc phải >= ngày xuất hóa đơn')
	ROLLBACK TRAN
End

/* userID trong ORDERS phải tồn tại trong USERS */
CREATE TRIGGER ORDERS_userID
ON ORDERS
FOR INSERT, UPDATE
AS
	Declare @uID char(10)
	Select @uID = userID
	From Inserted
IF NOT EXISTS(Select 1 from USERS where ID = @uID)
Begin
	Print('Mã nhân viên không tồn tại')
	ROLLBACK TRAN
End

/* pdcID trong PRODUCT phải tồn tại trong PRODUCER */
CREATE TRIGGER PRODUCT_pdcID
ON PRODUCT
FOR INSERT, UPDATE
AS
	Declare @pdc_ID char(10)
	Select @pdc_ID = pdcID
	From Inserted
IF NOT EXISTS (Select 1 from PRODUCER where ID = @pdc_ID)
Begin
	Print ('Mã nhà sản xuất không tồn tại')
	ROLLBACK TRAN
End

/* Xóa ORDER thì các detail order có oID trùng với ID của order vừa xóa cũng phải đc xóa */
CREATE TRIGGER ORDERS_Del_Order
ON ORDERS
INSTEAD OF DELETE
AS
	Declare @oldID char(10)
	Select @oldID = ID
	from Deleted
Begin
	Delete from DETAILORDER where oID = @oldID
	Delete from ORDERS where ID = @oldID
	Print ('Delete completed')
End

DROP table DETAILORDER
CREATE TABLE DETAILORDER (
	oID char(10) NOT NULL,
	pID char(10) NOT NULL,
	Quantum int NOT NULL,
	Value money
	Primary key (oID, pID)
)
Alter Table DETAILORDER Add Constraint FK_DetailOrder_Order_oID Foreign Key (oID) References ORDERS(ID);
Alter Table DETAILORDER Add Constraint FK_DetailOrder_Order_pID Foreign Key (pID) References PRODUCT(ID);

/* Số lượng SP trong CTHĐ không đc < 1 */
CREATE TRIGGER Quantum_DetailOrder
ON DETAILORDER
FOR INSERT, UPDATE
AS
	Declare @qtm int
	Select @qtm = Quantum
	From Inserted
IF @qtm<1
Begin
	Rollback TRAN
	Print('')
End
/* Value của DETAILORDER = Quantum * giá của sản phẩm */
CREATE TRIGGER DETAILORDER_VALUE
ON DETAILORDER
FOR INSERT, UPDATE
AS
	Declare @pID char(10), @oID char(10),
			@qtm int,
			@prc money,
			@vlue money
		
	Select @pID = Inserted.pID, @oID = Inserted.oID, @qtm = Inserted.Quantum, @prc = Price,
		   @vlue = @qtm * @prc
	From Inserted inner join PRODUCT On Inserted.pID = PRODUCT.ID
	
	Update DETAILORDER Set VALUE = @vlue Where pID = @pID
/* Số lượng sản phẩm trong DETAILPRODUCT không đc > số lượng sản phẩm trong kho. */
CREATE TRIGGER DETAILORDER_QUANTUM
ON DETAILORDER
FOR INSERT, UPDATE
AS
	Declare @dorder_qtm int, @p_qtm int
	Select @dorder_qtm = Inserted.Quantum, @p_qtm = PRODUCT.Quantum
	From Inserted, PRODUCT
	Where Inserted.pID = PRODUCT.ID
IF (@dorder_qtm > @p_qtm)
BEGIN
	Print ('Số lượng sản phẩm mua không được phép vượt quá số lượng hàng trong kho')
	ROLLBACK TRAN
END

/* Khi tăng/giảm số lượng sản phẩm trong CTHĐ phải giảm/tăng số lượng sản phẩm trong kho. */
CREATE TRIGGER DETAILORDER_QTM_CHANGE
ON DETAILORDER
INSTEAD OF UPDATE
AS
	Declare @dorder_qtm_old int, @dorder_qtm_new int, @p_qtm int, @sub int, @p_ID char(10), @oID char(10)
	Select @dorder_qtm_old = DETAILORDER.Quantum,
		   @dorder_qtm_new = Inserted.Quantum,
		   @sub = @dorder_qtm_new - @dorder_qtm_old,
		   @p_ID = Inserted.pID,
		   @oID = Inserted.oID
	From Inserted, DETAILORDER
	
	Select @p_qtm = PRODUCT.Quantum
	From Inserted inner join PRODUCT On Inserted.pID = PRODUCT.ID
	
	Update PRODUCT Set Quantum = (@p_qtm - @sub) Where ID = @p_ID
	Update DETAILORDER Set Quantum = @dorder_qtm_new Where pID = @p_ID
	/* Sẵn update giá của hóa đơn luôn */
	Update ORDERS Set Total = 0 Where ID = @oID
/* Khi thêm SP vào CTHĐ, giảm số lượng hàng trong kho */
CREATE TRIGGER DETAILORDER_ADD_PRODUCT
ON DETAILORDER
FOR INSERT
AS
	Declare @do_qtm int, @p_qtm int, @pID char(10), @oID char(10)
	Select @do_qtm = Inserted.Quantum, @p_qtm = PRODUCT.Quantum, @pID = pID, @oID = oID
	From Inserted inner join PRODUCT On Inserted.pID = PRODUCT.ID
	UPDATE PRODUCT Set Quantum = (@p_qtm - @do_qtm) Where ID = @pID
	/* Sẵn update giá của hóa đơn luôn */
	Update ORDERS Set Total = 0 Where ID = @oID
/* Khi xóa CTHĐ phải tăng lại lượng SP trong kho */
CREATE TRIGGER DETAILORDER_DELETE
ON DETAILORDER
FOR DELETE
AS
	Declare @qtm int, @pID char(10)
	Select @qtm = Deleted.Quantum, @pID = pID
	From Deleted inner join PRODUCT On Deleted.pID = PRODUCT.ID
	UPDATE PRODUCT Set Quantum = (PRODUCT.Quantum + @qtm) Where ID = @pID
	
/* Total của hóa đơn = tổng Value các CTHĐ có cùng mã HĐ */
	/* Khi thêm 1 Hóa đơn thì set mặc định Total = 0 */
		CREATE TRIGGER ORDERS_INSERT
		ON ORDERS
		FOR INSERT
		AS
			Declare @oID char(10)
			Select @oID = ID
			From Inserted
			
			Update ORDERS set Total = 0 Where ID = @oID
/* TRIGGER khi thêm 1 user mới */
CREATE TRIGGER  USERS_ADD_NEW
ON USERS
FOR INSERT
AS
	Declare @uID char(10)
	Select @uid = ID
	From Inserted
	
	Update USERS Set joinDate = GetDate(), Stt = 'WORKING', Revenue = 0  Where ID = @uID
	
CREATE FUNCTION GETREVENUE (@uID char(10))
returns money
as
begin
	declare @rvn money
	Select @rvn = SUM(Total) from ORDERS Where userID = @uID
	return @rvn
end


/* Tổng thu nhập của nhân viên bằng tổng value các hóa đơn có userID = mã nhân viên đó */
CREATE TRIGGER USERS_EDIT_REVENUE
ON USERS
FOR UPDATE
AS
	IF UPDATE (Revenue)
	Declare @uID char(10)
	Select @uID = ID from Inserted
	Update USERS Set Revenue = (select dbo.GETREVENUE(@uID)) Where ID = @uID
Drop trigger ORDERS_UPDATE_TOTAL	

/* Khi chỉnh sửa trị giá của Hóa đơn thì set Total = tổng Value các CTHĐ cùng mã HĐ */
	
	CREATE TRIGGER ORDERS_UPDATE_TOTAL
	ON ORDERS
	FOR UPDATE
	AS
		IF UPDATE(Total)
		Declare @oID char(10), @uID char(10), @ttl money
		
		Select @oID = ID, @uID = userID From Inserted
		Select @ttl = SUM(Value)
		From Inserted inner join DETAILORDER ON Inserted.ID = DETAILORDER.oID
		Group by DETAILORDER.oID
		
		Update ORDERS Set Total = @ttl Where ID = @oID
		Update USERS Set Revenue = 0 Where ID = @uID

/* Khi thêm sản phẩm đã có rồi */
	CREATE TRIGGER INSERT_PRODUCT
	ON PRODUCT
	instead of INSERT
	AS
		DECLARE @ID CHAR(10), @QUANTUM INT ,@Name nvarchar(40), @pdcID char(10), @Unit nvarchar(20), @Price money
		SELECT @ID = ID, @QUANTUM = Quantum, @Name = Name, @pdcID = pdcID, @Unit = Unit , @Price = Price
		FROM inserted
		
		IF EXISTS ( SELECT ID FROM PRODUCT WHERE ID = @ID)
			BEGIN
				UPDATE PRODUCT SET  Quantum += @QUANTUM
			END
		ELSE
			BEGIN
				INSERT INTO PRODUCT (ID, Name, pdcID, Price, Quantum, Unit) VALUES (@ID, @Name, @pdcID, @Price, @QUANTUM, @Unit)
			END


	 
	 
/* STORED PROCEDURES */

/* Check Login */
CREATE PROCEDURE CheckLogin @userID char(10), @userPass varchar(20)
AS
	Select * from USERS where ID = @userID and Pass = @userPass
Go





/* Add User */
CREATE PROCEDURE AddUser
	@userID char(10),
	@userPass varchar(20),
	@userName nvarchar(40),
	@userBirth smalldatetime,
	@userCID char(9),
	@userPhoneNo char(11),
	@userAddress nvarchar(50),
	@userRole varchar(7),
	@userImg Image
As
	Insert into USERS (ID, Pass, Name, dBirth, cID, phoneNo, Adrs, Roles, Img) values (@userID, @userPass, @userName, @userBirth, @userCID, @userPhoneNo, @userAddress, @userRole, @userImg)





	
CREATE PROCEDURE DeleteUser @uID char(10)
As
	Delete USERS where ID = @uID


CREATE PROCEDURE EditUser
	@userID char(10),
	@userPass varchar(20),
	@userName nvarchar(40),
	@userBirth smalldatetime,
	@userCID char(9),
	@userPhoneNo char(11),
	@userAddress nvarchar(50),
	@userRole varchar(7),
	@userOutDate smalldatetime,
	@userImg Image
AS
BEGIN

	UPDATE USERS
	SET Name = @userName, dBirth = @userBirth, cID = @userCID,
		phoneNo = @userPhoneNo, Adrs = @userAddress, Roles = @userRole, Img = @userImg, outDate = @userOutDate
	where ID = @userID 
END

/* Thêm hóa đơn */
	CREATE PROCEDURE AddOrders
		@ID char(10) ,
		@oDate smalldatetime,
		@userID char(10),
		@Total money
	AS
	BEGIN
		Insert into ORDERS ( ID, oDate , userID , Total ) values ( @ID, @oDate, @userID, @Total) 
	END

/* Tìm hoa đơn bằn ID */
	CREATE PROCEDURE FindOrderByID
		@ID char(10)
	AS
	BEGIN 
		If exists ( select ID from ORDERS where ID = @ID )
			Begin
				Select * From ORDERS Where ID = @ID
			End
	END

/* Tìm hóa đơn bằng userID */
	CREATE PROCEDURE FindOrderByuserID
		@userID char(10)
	AS
	BEGIN 
		If exists ( select ID from ORDERS where userID = @userID )
			Begin
				Select * From ORDERS Where ID = @userID
			End
		
	END	

/* Tìm hóa đơn theo ngày, tháng , năm */
	CREATE PROCEDURE FindOrderByDate
		@oDate smalldatetime
	AS
	BEGIN 
		if @oDate <= GETDATE()
			begin
				Select  *
				From ORDERS
				Where oDate = @oDate		
			end
	END

/* Tìm hóa đơn theo năm */
	CREATE PROCEDURE FindOrderByYear
		@oYear int
	AS
	BEGIN 
		if @oYear <= YEAR(GETDATE())
			begin
				Select *
				From ORDERS
				Where YEAR( oDate) = @oYear
			end
	END

/* Get list data base on table's name*/
CREATE PROCEDURE GetData @tableName varchar(128)
As
Begin
	Declare @sql nvarchar(max);
	if (@tableName = 'USERS')
		Set @sql = N'Select * from ' + @tableName + ' order by Stt desc'
	else
		Set @sql = N'Select * from ' + @tableName
	Exec sp_executesql @sql
End

/* New changes */
drop proc FindOrderByMonth

CREATE PROCEDURE FindOrderByMonth
		@oMonth int, @oYear int
	AS
	BEGIN 
		if @oMonth <= MONTH(GETDATE()) and @oYear <= YEAR(GETDATE())
			begin
				Select *
				From ORDERS
				Where MONTH( oDate) = @oMonth and YEAR( oDate) = @oYear
			end
	END



select * from USERS order by Stt desc