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
public class Product extends PrimalObject{
    private String pdcID;
    private AppPublic.productUnits Unit;
    private double Price;
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Product(String ID) {
        super(ID);
        this.tableName = "PRODUCT";
    }
    public Product(String ID,String name, String pdcID, AppPublic.productUnits Unit, double Price) {
        super(ID);
        this.tableName = "PRODUCT";
        this.Name = name;
        this.pdcID = pdcID;
        this.Unit = Unit;
        this.Price = Price;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public String getPdcID() {
        return pdcID;
    }

    public AppPublic.productUnits getUnit() {
        return Unit;
    }

    public double getPrice() {
        return Price;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setPdcID(String pdcID) {
        this.pdcID = pdcID;
    }

    public void setUnit(AppPublic.productUnits Unit) {
        this.Unit = Unit;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    // </editor-fold>
    
    
    @Override
    public void ShowOnTable(JTable tb, Vector colName) {
        // Do somethings
		
    }
    
}
