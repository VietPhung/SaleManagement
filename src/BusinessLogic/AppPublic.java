/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;
import Data.*;
import GUI.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author COMPUTER
 */
public abstract class AppPublic {
    public static FormMain frmMain = new FormMain ();
    public static FormLogin frmLogin = new FormLogin ();
    public static GUI.FormMngUser frmMngUser = new GUI.FormMngUser ();
    public static FormMngProduct frmMngProduct = new FormMngProduct();
    
    public enum userRoles {Admin, Manager, Seller};
    public enum productUnits {Cay, Hop, Chai, Cai};
    public enum userStatus {WORKING, LEFT};
    
    public static ArrayList<Product> listProduct;
    public static ArrayList<Producer> listProducer;
    public static ArrayList<Order> listOrder;
    
    public static Product FindProduct(String pID) {
        int i = 0;
        while (i < listProduct.size()) {
            Product product = listProduct.get(i);
            if (product.getID().equals(pID))
                return product;
            i++;
        }
        return null;
    }
   public static void DeserializeData (String tableName, ResultSet rs) {
       try {
            switch (tableName) {
               case "USERS":
                   ArrayList<User> listUser = new ArrayList<User> ();
                   while (rs.next()) {
                       AppPublic.userRoles Role = AppPublic.userRoles.valueOf(rs.getString("Roles"));
                       User usr = new User (rs.getString("ID"), rs.getString("Pass"), rs.getString("Name"), rs.getDate("dBirth"), rs.getString("cID"), rs.getString("phoneNo"), rs.getString("Adrs"), Role, rs.getBytes("Img"));
                       usr.setJoinDate(rs.getDate("joinDate"));
                       usr.setStatus(AppPublic.userStatus.valueOf(rs.getString("Stt")));
                       usr.setRevenue(rs.getDouble("Revenue"));
                       listUser.add(usr);
                   }
                   for (User usr : listUser)
                       frmMngUser.getListUser().add(usr);
                   frmMngUser.ShowAllObjectsToTable();
                   break;
            }
       }  catch (SQLException ex) {
               Logger.getLogger(AppPublic.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
