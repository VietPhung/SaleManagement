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
public class ProducerManagement {
    
        // <editor-fold defaultstate="collapsed" desc="SingletonPattern">
    private ProducerManagement () {}
     @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }
    protected Object readResolve() {
        return getInstance();
    }
    private static class Nested {
        private static final ProducerManagement producerMng = new ProducerManagement ();
    }
    public static ProducerManagement getInstance() {
        return Nested.producerMng;
    }
    // </editor-fold>
    
    
    public void addProducer(String ID,String Name, String Address, String phoneNo)
    {
        //Tao doi tuong them xuong data
        Producer ProducerData = new Producer(ID,Name,Address,phoneNo);
        
        //Toa doi tuong them len GUI
        Vector ProducerGUI = new Vector();
        ProducerGUI.addElement(ID);
        ProducerGUI.addElement(Name);
        ProducerGUI.addElement(Address);
        ProducerGUI.addElement(phoneNo);
        
        //xu ly them xuong data
        //xu ly them len GUI
    }
    
    public Producer findProducer(String ID)
    {
        List<Producer> listProducer = new ArrayList<Producer>();
        for (Producer i : listProducer)
        {
            if (i.ID.equals(ID))
            {
                return i;
            }
        }
        return null;
    }
    
    public void updateProducer(String ID,String Name, String Address, String phoneNo)
    {
        //update doi tuong xuong data
        Producer ProducerData = findProducer(ID);
        ProducerData.setName(Name);
        ProducerData.setAddress(Address);
        ProducerData.setPhoneNo(phoneNo);
    }
    
    public void deleteProducer(String ID)
    {
        Producer ProducerData = findProducer(ID);
        
        Vector ProducerGUI = new Vector();
        ProducerGUI.addElement(ProducerData.getID());
        ProducerGUI.addElement(ProducerData.getName());
        ProducerGUI.addElement(ProducerData.getAddress());
        ProducerGUI.addElement(ProducerData.getPhoneNo());
        
        //Xoa ProducerData tren Data
        //Xoa ProducerGUI tren GUI
    }
}
