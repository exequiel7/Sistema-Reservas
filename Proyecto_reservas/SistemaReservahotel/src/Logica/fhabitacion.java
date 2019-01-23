/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vhabitacion;
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

public class fhabitacion {
    
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        String [] titulos = {"ID", "Numero", "Piso", "Descripcion", "Caracteristicas", "Precio","Estado","Tipo de hanitacion"};
        String [] registro = new String [8];
  
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select * from habitacion where piso like '%" + buscar + "%' order by idhabitacion";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idhabitacion");
                registro [1] = rs.getString("numero");
                registro [2] = rs.getString("piso");
                registro [3] = rs.getString("descripcion");
                registro [4] = rs.getString("caracteristicas");
                registro [5] = rs.getString("precio_diario");
                registro [6] = rs.getString("estado");
                registro [7] = rs.getString("tipo_habitacion");
                
                totalregistros++;
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return null;
        }
        
    }
    
    public boolean insertar(vhabitacion dts){
        sSQL = "insert into habitacion(numero,piso,descripcion,caracteristicas,precio_diario,estado,tipo_habitacion)" +
                "values (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setString(1, dts.getNumero());//send one to one all values to my PreparedStatement
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_habitacion());
            
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
    
    public boolean editar(vhabitacion dts){
        sSQL = "update habitacion set numero=?,piso=?, descripcion=?, caracteristicas=?,precio_diario=?, estado=?, tipo_habitacion=?" +
                "where idhabitacion=?"; //will set my keys, only if id is correct
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setString(1, dts.getNumero());//send one to one all values to my PreparedStatement
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_habitacion());
            pst.setInt(8, dts.getIdhabitacion());
            
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
    
    public boolean desocupar(vhabitacion dts){
        sSQL = "UPDATE habitacion SET estado='Disponible'" +
                "WHERE idhabitacion=?"; //will set my keys, only if id is correct
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setInt(1, dts.getIdhabitacion());//send one to one all values to my PreparedStatement
            
            
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
    
    public boolean ocupar(vhabitacion dts){
        sSQL = "UPDATE habitacion SET estado='Ocupado'" +
                "WHERE idhabitacion=?"; //will set my keys, only if id is correct
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setInt(1, dts.getIdhabitacion());//send one to one all values to my PreparedStatement
            
            
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
    
    
    public boolean eliminar(vhabitacion dts){
        sSQL = "delete from habitacion where idhabitacion =?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setInt(1, dts.getIdhabitacion());
            
            
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
    
    public DefaultTableModel mostrarVista(String buscar){
        DefaultTableModel modelo;
        String [] titulos = {"ID", "Numero", "Piso", "Descripcion", "Caracteristicas", "Precio","Estado","Tipo de hanitacion"};
        String [] registro = new String [8];
  
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "SELECT * FROM habitacion WHERE piso LIKE '%" + buscar + "%' AND estado='Disponible' ORDER BY idhabitacion";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idhabitacion");
                registro [1] = rs.getString("numero");
                registro [2] = rs.getString("piso");
                registro [3] = rs.getString("descripcion");
                registro [4] = rs.getString("caracteristicas");
                registro [5] = rs.getString("precio_diario");
                registro [6] = rs.getString("estado");
                registro [7] = rs.getString("tipo_habitacion");
                
                totalregistros++;
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return null;
        }
        
    }
}
