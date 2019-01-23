/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vpago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deferrari.exequiel
 */

public class fpago {
    
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        String [] titulos = {"IDpago", "IDreserva", "Comprobante", "Numero", "IGV", "Total", "Fecha Emision", "Fecha Pago"};
        String [] registro = new String [8];
  
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "SELECT * FROM pago WHERE idreserva=" + buscar + " ORDER BY idpago desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idpago");
                registro [1] = rs.getString("idreserva");
                registro [2] = rs.getString("tipo_comprobante");
                registro [3] = rs.getString("num_comprobante");
                registro [4] = rs.getString("igv");
                registro [5] = rs.getString("total_pago");
                registro [6] = rs.getString("fecha_emision");
                registro [7] = rs.getString("fecha_pago");
                
                totalregistros++;
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return null;
        }
        
    }
    
    public boolean insertar(vpago dts){
        sSQL = "INSERT INTO pago(idreserva, tipo_comprobante, num_comprobante, igv, total_pago, fecha_emision, fecha_pago)" +
                "VALUES (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setInt(1, dts.getIdreserva());//send one to one all values to my PreparedStatement
            pst.setString(2, dts.getTipo_comprobante());
            pst.setString(3, dts.getNum_comprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotal_pago());
            pst.setDate(6, dts.getFecha_emision());
            pst.setDate(7, dts.getFecha_pago());
                        
            int n = pst.executeUpdate(); //save result of statement execute 
            if (n!=0)
                return true;
            else
                return false;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
    public boolean editar(vpago dts){
        sSQL = "UPDATE pago SET idreserva=?, tipo_comprobante=?, num_comprobante=?, igv=?, total_pago=?, fecha_emision=?, fecha_pago=?" +
                "WHERE idpago=?"; //will set my keys, only if id is correct
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setInt(1, dts.getIdreserva());//send one to one all values to my PreparedStatement
            pst.setString(2, dts.getTipo_comprobante());
            pst.setString(3, dts.getNum_comprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotal_pago());
            pst.setDate(6, dts.getFecha_emision());
            pst.setDate(7, dts.getFecha_pago());
            
            pst.setInt(8, dts.getIdpago()); //For update the payment -> idpago
           
            int n = pst.executeUpdate(); //save result of statement execute 
            if (n!=0)
                return true;
            else
                return false;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
    public boolean eliminar(vpago dts){
        sSQL = "DELETE FROM pago WHERE idpago=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setInt(1, dts.getIdpago());
            
            
            int n = pst.executeUpdate(); //save result of statement execute 
            if (n!=0)
                return true;
            else
                return false;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
       
}
