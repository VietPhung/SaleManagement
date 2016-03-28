/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author COMPUTER
 */
public class User extends PrimalObject {
    private String Password;
    private Date dBirth;
    private String cID;
    private String phoneNo;
    private String Address;
    private Date joinDate;
    private AppPublic.userStatus Status;
    private double Revenue;
    private Date outDate;
    private AppPublic.userRoles Role;
    private byte[] AvatarBytes;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public User(String ID) {
        super(ID);
        this.tableName = "USERS";
        AvatarBytes = null;
    }
    public User () {
        super();
        AvatarBytes = null;
    }
    public User(String ID, String Password, String Name, Date dBirth, String cID, String phoneNo, String Address, AppPublic.userRoles Role, byte[] AvatarBytes) {
        super(ID);
        this.tableName = "USERS";
        this.Password = Password;
        this.Name = Name;
        this.dBirth = dBirth;
        this.cID = cID;
        this.phoneNo = phoneNo;
        this.Address = Address;
        this.Role = Role;
        this.AvatarBytes = AvatarBytes;
    }
    // </editor-fold>

    
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public String getPassword() {
        return Password;
    }

    public Date getdBirth() {
        return dBirth;
    }

    public String getcID() {
        return cID;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAddress() {
        return Address;
    }

    public AppPublic.userRoles getRole() {
        return Role;
    }

    public byte[] getAvatarBytes() {
        return AvatarBytes;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public AppPublic.userStatus getStatus() {
        return Status;
    }

    public double getRevenue() {
        return Revenue;
    }

    public Date getOutDate() {
        return outDate;
    }
    
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setters">

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setdBirth(Date dBirth) {
        this.dBirth = dBirth;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setRole(AppPublic.userRoles Role) {
        this.Role = Role;
    }
    
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setStatus(AppPublic.userStatus Status) {
        this.Status = Status;
    }

    public void setRevenue(double Revenue) {
        this.Revenue = Revenue;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public void setAvatarBytes(byte[] AvatarBytes) {
        this.AvatarBytes = AvatarBytes;
    }
    //</editor-fold>

    

   
    
    @Override
    public void ShowOnTable(JTable tb, Vector colName) {
        // Do somethings
        Vector Data = new Vector ();
        
        // Make table's conlumns
        colName.addElement("Mã nhân viên");
        colName.addElement("Password");
        colName.addElement("Tên nhân viên");
        colName.addElement("CMND");
        colName.addElement("Ngày sinh");
        colName.addElement("Số điện thoại");
        colName.addElement("Địa chỉ");
        colName.addElement("Chức vụ");
        colName.addElement("Ảnh đại diện");
        
        
        Vector usrData = new Vector ();
        usrData.addElement(this.getID());
        usrData.addElement(this.getPassword());
        usrData.addElement(this.getName());
        usrData.addElement(this.getcID());
        usrData.addElement(this.getdBirth());
        usrData.addElement(this.getPhoneNo());
        usrData.addElement(this.getAddress());
        usrData.addElement(this.getRole().toString());
        usrData.addElement(this.GetImage());
        Data.add(usrData); //test thay doi
        
        tb.setModel(new DefaultTableModel(Data, colName));
    }
    public ImageIcon GetImage () {
        ByteArrayInputStream bis = new ByteArrayInputStream (AvatarBytes);
        try {
            return new ImageIcon(ImageIO.read(bis)); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public String toString () {
        String str = "";
        str += "id: " + ID;
        str += "\npass: " + Password;
        str += "\nname: " + Name;
        str += "\ndate of birth: " + dBirth;
        return str;
    }
    
}
