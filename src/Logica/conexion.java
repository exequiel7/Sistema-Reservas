/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author deferrari.exequiel
 */

public class conexion {
    public String db = "basereserva";
    public String url = "jdbc:mysql://localhost/" + db;
    public String user = "root"; //para xampp
    public String pass = "";

    public conexion() {
    
    }
    
    public Connection conectar(){
        Connection link = null; //connection instance
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); //load connection driver
            link = DriverManager.getConnection(this.url, this.user, this.pass); //link to DB
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        
        return link;              
    }
    
}
