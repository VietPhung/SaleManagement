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
public interface IManageableForm {
    public void ShowAnObjectToTable (PrimalObject obj);  
    public void ShowAllObjectsToTable ();  
    public void AddDataToDB (PrimalObject obj);                                     // INSERT INTO
    public void LoadDataFromDB ();                                  // SELECT
    public void UpdateDataToDB ();                                  // UPDATE
    public void DeleteDataFromDB ();                                // DELETE
    public void Search (String key);
    public void ClearTable ();
}
