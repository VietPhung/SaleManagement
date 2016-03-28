/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.SQLException;
import BusinessLogic.*;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author COMPUTER
 */
public class ConnectionManager {
    // <editor-fold defaultstate="collapsed" desc="SingletonPattern">
    private ConnectionManager () {}
     @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }
    protected Object readResolve() {
        return getInstance();
    }
    private static class Nested {
        private static final ConnectionManager connMng = new ConnectionManager ();
    }
    public static ConnectionManager getInstance() {
        return Nested.connMng;
    }
    // </editor-fold>
    
    
    
    private Connection conn = null;
    
    // 3 constant strings below can be change up to your client.
    final String connectString = "jdbc:sqlserver://127.0.0.1;sqlInstanceName=SQLEXPRESS;databaseName=SalesManagement";
//    final String userName = "sa";
//    final String Password = "1";
    
    public void DisplayError (SQLException ex) {
        // Show Error messages to screen
        AppPublic.frmMain.ShowErrorMessagePane(ex.getMessage(), ex.getSQLState(), ex.getErrorCode());
    }
    public boolean Connect (String Account, String Password) {
        // Connect to DB
        try {
           conn = DriverManager.getConnection(connectString, Account, Password);
        } catch (SQLException ex) {
            DisplayError(ex);
        }
        // Show the response to form main
        if(conn != null) {
            System.out.println("Connection successful!");
            this.GetListData("USERS");
            return true;
        }
        else {
            System.out.println("Connection failed!");
            return false;
        }
    }
    public ResultSet CheckLogin (String userName, String Password) {
        String strCall = "{call CheckLogin(?, ?)}";
        try {
            CallableStatement cStatement = conn.prepareCall(strCall);
            cStatement.setString(1, userName);
            cStatement.setString(2, Password);
        return cStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void GetListData(String tableName)
    {
        String strCall = "{call GetData (?)}";
        try {
            CallableStatement cStatement = conn.prepareCall(strCall);
            cStatement.setString(1, tableName);
            AppPublic.DeserializeData(tableName, cStatement.executeQuery());
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AddNewUser (User usr) {
        String strCall = "{call AddUser(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try {
            CallableStatement cStatement = conn.prepareCall(strCall);
            cStatement.setString(1, usr.getID());
            cStatement.setString(2, usr.getPassword());
            cStatement.setString(3, usr.getName());
            java.sql.Date sqlDate = new java.sql.Date(usr.getdBirth().getTime());
            cStatement.setDate(4,sqlDate);
            cStatement.setString(5, usr.getcID());
            cStatement.setString(6, usr.getPhoneNo());
            cStatement.setString(7, usr.getAddress());
            cStatement.setString(8, usr.getRole().name());
            cStatement.setBytes(9, usr.getAvatarBytes());
            cStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void DeleteUser (String uID) {
        String strCall = "{call DeleteUser(?)}";
        try {
            CallableStatement cStatement = conn.prepareCall(strCall);
            cStatement.setString(1, uID);
            cStatement.executeUpdate();
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void EditUser(User usr){
        String strCall = "{call EditUser(?, ?, ?, ?, ?, ?, ?, ?, ?,?)}";
        try {
            CallableStatement cStatement = conn.prepareCall(strCall);
            cStatement.setString(1, usr.getID());
            cStatement.setString(2, usr.getPassword());
            cStatement.setString(3, usr.getName());
            java.sql.Date sqlBirthDate = new java.sql.Date(usr.getdBirth().getTime());
            cStatement.setDate(4,sqlBirthDate);
            cStatement.setString(5, usr.getcID());
            cStatement.setString(6, usr.getPhoneNo());
            cStatement.setString(7, usr.getAddress());
            cStatement.setString(8, usr.getRole().name());
            java.sql.Date sqlOutDate =  new java.sql.Date(usr.getOutDate().getTime());
            cStatement.setDate(9, sqlOutDate);
            cStatement.setBytes(10, usr.getAvatarBytes());
            cStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void AddOrders(Order ord){
        String strCall="{call AddOrders(?,?,?,? }";
        try{
            CallableStatement cStatement  = conn.prepareCall(strCall);
            cStatement.setString(1, ord.getID());
            java.sql.Date sqlOrderDate = new java.sql.Date(ord.getoDate().getTime());
            cStatement.setDate(2, sqlOrderDate);
            cStatement.setString(3, ord.getuID());
            cStatement.setDouble(4, ord.getTotal());
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
