/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author COMPUTER
 */
public class Order extends PrimalObject{
    private Date oDate;
    private String uID;
    private double Total;
    private ArrayList<DetailOrder> listDetail;
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Order(String ID) {
        super(ID);
        this.tableName = "ORDER";
    }

    public Order(String ID,String Name, Date oDate, String uID, double Total, ArrayList<DetailOrder> listDetail) {
        super(ID);
        this.tableName = "ORDER";
        this.Name = Name;
        this.oDate = oDate;
        this.uID = uID;
        this.Total = Total;
        this.listDetail = listDetail;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Date getoDate() {
        return oDate;
    }

    public String getuID() {
        return uID;
    }

    public double getTotal() {
        return Total;
    }

    public ArrayList<DetailOrder> getListDetail() {
        return listDetail;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public void setListDetail(ArrayList<DetailOrder> listDetail) {
        this.listDetail = listDetail;
        double sum = 0;
        for (DetailOrder dOrder : listDetail) {
            sum += dOrder.getValue();
        }
        this.Total = sum;
    }
    // </editor-fold>
    
    public DetailOrder FindDetailOrder (String pID) {
        int i = 0;
        while (i < listDetail.size()) {
            DetailOrder dOrder = listDetail.get(i);
            if (dOrder.getpID().equals(pID)) {
                return dOrder;
            }
            i++;
        }
        
        return null;
    }
    public void AddDetailOrder (String pID, int Quantum) {
        DetailOrder dOrder = new DetailOrder(this.ID, pID, Quantum);
        this.listDetail.add(dOrder);
    }
    @Override
    public void ShowOnTable(JTable tb, Vector colName) {
        // Do somethings
    }
    
}
