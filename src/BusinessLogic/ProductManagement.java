/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Nguyen Thai Sang
 */
public class ProductManagement 
{
        // <editor-fold defaultstate="collapsed" desc="SingletonPattern">
    private ProductManagement () {}
     @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }
    protected Object readResolve() {
        return getInstance();
    }
    private static class Nested {
        private static final ProductManagement productMng = new ProductManagement ();
    }
    public static ProductManagement getInstance() {
        return Nested.productMng;
    }
    // </editor-fold>
    
    
    public void addProduct(String ID,String Name, String pdcID, AppPublic.productUnits Unit, double Price)
    {
        //Doi tuong Product update xuong Data
        Product ProductData = new Product(ID,Name,pdcID,Unit,Price);
        
        //Doi tuong Product update len GUI
        Vector ProductGUI = new Vector();
        ProductGUI.addElement(ID);
        ProductGUI.addElement(Name);
        ProductGUI.addElement(pdcID);
        ProductGUI.addElement(Unit);
        ProductGUI.addElement(Price);
        
        //Update doi tuong xuong Data
        //Update doi tuong len Gui
    }
    
    public Product findProduct(String ID)
    {
        List<Product> listProduct = new ArrayList<Product>();
        for (Product i : listProduct)
        {
            if (i.ID.equals(ID))
            {
                return i;
            }
        }
        return null;
    }
    
    public void updateProduct(String ID,String Name, String pdcID, AppPublic.productUnits Unit, double Price)
    {
        Product ProductData = findProduct(ID);
        ProductData.setName(Name);
        ProductData.setPdcID(pdcID);
        ProductData.setPrice(Price);
        ProductData.setUnit(Unit); 
    }
    
    public void deleteProduct(String ID)
    {
        Product ProductData = findProduct(ID);
        
        Vector ProductGUI = new Vector();
        ProductGUI.addElement(ProductData.getID());
        ProductGUI.addElement(ProductData.getName());
        ProductGUI.addElement(ProductData.getPdcID());
        ProductGUI.addElement(ProductData.getUnit());
        ProductGUI.addElement(ProductData.getPrice());
        
        //Xoa ProductData tren Data
        //Xoa ProductGUI tren GUI
    }
}
