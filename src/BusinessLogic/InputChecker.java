/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import javax.swing.JOptionPane;


/**
 *
 * @author Duc Tai
 */
public class InputChecker implements Cloneable, Serializable{
    private InputChecker () {};
    @Override
    protected Object clone () throws CloneNotSupportedException{
        return new CloneNotSupportedException();
    }
    protected Object readResolve () {
        return getInstance();
    }
    private static class Nested {
        private static final InputChecker checker = new InputChecker();
    }
    public static InputChecker getInstance () {
        return Nested.checker;
    }
    
    
    public boolean checkIsNumber (java.awt.event.KeyEvent e) {
        char c =e.getKeyChar();
        // neu khac ki tu so thi e.comsume ko cho cac keyevent do xay ra
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
            e.consume();//
            return false;
        }
        return true;
    }   
}
