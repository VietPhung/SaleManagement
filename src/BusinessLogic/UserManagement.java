/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.ConnectionManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Nguyen Thai Sang
 */
public class UserManagement implements Cloneable, Serializable 
{
    // <editor-fold defaultstate="collapsed" desc="SingletonPattern">
    private UserManagement () {}
     @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }
    protected Object readResolve() {
        return getInstance();
    }
    private static class Nested {
        private static final UserManagement userMng = new UserManagement ();
    }
    public static UserManagement getInstance() {
        return Nested.userMng;
    }
    // </editor-fold>
    
    public void addUser(String ID, String Pass, String Name, Date Birthday, String cID, String PhoneNumber, String Address,  AppPublic.userRoles Role)
    {
        // Doi tuong update xuong database
        User UserData = new User(ID);
        UserData.setPassword(Pass);
        UserData.setName(Name);
        UserData.setdBirth(Birthday);
        UserData.setcID(cID);
        UserData.setPhoneNo(PhoneNumber);
        UserData.setAddress(Address);
  //      UserData.setJoinDate(JoinDate);
//        UserData.setStatus(stt);
//        UserData.setRevenue(Revenue);
//        UserData.setOutDate(OutDate);
        UserData.setRole(Role);
        
        //Update doi tuong xuong Data
        ConnectionManager.getInstance().AddNewUser(UserData);
        //Update doi tuong len Gui
        AppPublic.frmMngUser.getListUser().add(UserData);
        AppPublic.frmMngUser.ShowAllObjectsToTable();
    }
    
    public User findUser(String ID)
    {
        List<User> listUser = AppPublic.frmMngUser.getListUser();
        for (User i : listUser)
        {
            if (i.ID.equals(ID))
            {
                return i;
            }
        }
        return null;
    }
    
    public void updateUser(String ID, String Password, String Name, Date dBirth, String cID, String phoneNo, String Address, AppPublic.userRoles Role, byte[] AvatarBytes)
    {
        User temp = this.findUser(ID);
        temp.setPassword(Password);
        temp.setName(Name);
        temp.setdBirth(dBirth);
        temp.setcID(cID);
        temp.setPhoneNo(phoneNo);
        temp.setAddress(Address);
        temp.setRole(Role);
        //temp.setAvatar
    }
    
    public void deleteUser(String ID)
    {
//        User UserData = this.findUser(ID);
//        
//        Vector UserGUI = new Vector();
//        UserGUI.addElement(UserData.getID());
//        UserGUI.addElement(UserData.getPassword());
//        UserGUI.addElement(UserData.getName());
//        UserGUI.addElement(UserData.getcID());
//        UserGUI.addElement(UserData.getPhoneNo());
//        UserGUI.addElement(UserData.getdBirth());
//        UserGUI.addElement(UserData.getAddress());
//        UserGUI.addElement(UserData.getRole());
//        UserGUI.addElement(UserData.GetImage());
        
        //Xoa UserData tren Data
        ConnectionManager.getInstance().DeleteUser(ID);
        //Xoa UserGUI tren GUI
        
        
    }
}
