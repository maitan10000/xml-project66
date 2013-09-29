/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FastFood.Common.Utility;

import FastFood.Common.Constants.FastFoodContants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Everything
 */
public class DBUtility {

    //make connection
    public static Connection makeConnection() {
        try {
            ResourceBundle rb = ResourceBundle.getBundle(FastFoodContants.DB);
            Class.forName(rb.getString(FastFoodContants.DRIVER));
            String url = rb.getString(FastFoodContants.URL);
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
