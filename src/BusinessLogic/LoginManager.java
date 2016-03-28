/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.ConnectionManager;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author COMPUTER
 */
public class LoginManager implements Cloneable, Serializable{

    private LoginManager() {
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }
    protected Object readResolve() {
        return getInstance();
    }
    private static class Nested {
        private static final LoginManager loginMng = new LoginManager ();
    }
    public static LoginManager getInstance() {
        return Nested.loginMng;
    }



    public User CheckLogin (String userName, String Password) {
        
        try {
            User usr = new User ();
            ResultSet rs = ConnectionManager.getInstance().CheckLogin(userName, Password);
            if (rs.next()) {
                AppPublic.userRoles Role = AppPublic.userRoles.valueOf(rs.getString("Roles"));
                usr = new User (rs.getString("ID"), rs.getString("Pass"), rs.getString("Name"), rs.getDate("dBirth"), rs.getString("cID"), rs.getString("phoneNo"), rs.getString("Adrs"), Role, rs.getBytes("Img"));
            }
            return usr;
        } catch (SQLException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
