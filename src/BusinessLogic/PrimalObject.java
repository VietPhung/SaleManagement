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
public abstract class PrimalObject {
    protected String ID;
    protected String Name;
    protected String tableName;

    public PrimalObject(String ID) {
        this.ID = ID;
    }

    public PrimalObject() {
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getTableName() {
        return tableName;
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setters">

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
        
    // </editor-fold>
    public abstract void ShowOnTable (JTable tb, Vector colName);
}
