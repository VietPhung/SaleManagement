/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author COMPUTER
 */
public class MoneyFormatter {
    // <editor-fold defaultstate="collapsed" desc="SingletonPattern">
    private MoneyFormatter () {}
     @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }
    protected Object readResolve() {
        return getInstance();
    }
    private static class Nested {
        private static final MoneyFormatter formatter = new MoneyFormatter ();
    }
    public static MoneyFormatter getInstance() {
        return Nested.formatter;
    }
    // </editor-fold>
    
    // This function will format the double value in to string with vietnam's currency
    public String Format (double money) {
        NumberFormat formatter = new DecimalFormat("###,###");
        String resp = formatter.format(money);
        resp = resp.replaceAll(",", ".");
        resp += " đ";
        return resp;
    }
}
