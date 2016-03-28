/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author COMPUTER
 */
public class Producer extends PrimalObject {
    private String Address;
    private String phoneNo;
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Producer(String ID) {
        super(ID);
        this.tableName = "PRODUCER";
    }

    public Producer(String ID,String Name, String Address, String phoneNo) {
        super(ID);
        this.tableName = "PRODUCER";
        this.Name = Name;
        this.Address = Address;
        this.phoneNo = phoneNo;
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public String getPhoneNo() {    
        return phoneNo;
    }
    public String getAddress() {    
        return Address;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setPhoneNo(String phoneNo) {    
        this.phoneNo = phoneNo;
    }
    public void setAddress(String Address) {    
        this.Address = Address;
        // Do somethings
    }
    // </editor-fold>
    
    @Override
    public void ShowOnTable(JTable tb, Vector colName) {
        // Do somethings
    }
    
}
