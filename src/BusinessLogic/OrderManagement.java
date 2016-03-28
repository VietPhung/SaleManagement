/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.ConnectionManager;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Nguyen Thai Sang
 */
public class OrderManagement {
        // <editor-fold defaultstate="collapsed" desc="SingletonPattern">
    private OrderManagement () {}
     @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }
    protected Object readResolve() {
        return getInstance();
    }
    private static class Nested {
        private static final OrderManagement orderMng = new OrderManagement ();
    }
    public static OrderManagement getInstance() {
        return Nested.orderMng;
    }
    // </editor-fold>
    
    public void addOrder(String ID,String Name, Date oDate, String uID, double Total, ArrayList<DetailOrder> listDetail) {
        
        // Them order moi
        Order OrderData = new Order(ID, Name, oDate, uID, Total, listDetail);
        
        // Update vao Database
        ConnectionManager.getInstance().AddOrders(OrderData);
        
        // Update len GUI
        
        
        }
}
