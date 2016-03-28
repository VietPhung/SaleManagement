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
public class DetailOrder {
    private String oID;
    private String pID;
    private String tableName;
    private int Quantum;
    private double Value;

    
    public DetailOrder(String oID, String pID, int Quantum) {
        this.oID = oID;
        this.pID = pID;
        this.tableName = "DETAILORDER";
        this.Quantum = Quantum;
        
        Product product = AppPublic.FindProduct(pID);
        if (product != null) {
            this.Value =product.getPrice() * Quantum;
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public String getoID() {
        return oID;
    }

    public String getpID() {
        return pID;
    }

    public String getTableName() {
        return tableName;
    }

    public int getQuantum() {
        return Quantum;
    }

    public double getValue() {
        return Value;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setoID(String oID) {
        this.oID = oID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setQuantum(int Quantum) {
        this.Quantum = Quantum;
    }

    public void setValue(double Value) {
        this.Value = Value;
    }
    // </editor-fold>
    
    
    
    public void ShowOnTable(JTable tb, Vector colName) {
        // Do somethings
    }
    
}
