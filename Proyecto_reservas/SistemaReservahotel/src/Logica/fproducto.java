/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vproducto;
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
public class fproducto {
    
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        String [] titulos = {"ID", "Producto", "Descripcion", "Unidad Medida", "Precio Venta"};
        String [] registro = new String [5];
  
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select * from producto where nombre like '%" + buscar + "%' order by idproducto";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idproducto");
                registro [1] = rs.getString("nombre");
                registro [2] = rs.getString("descripcion");
                registro [3] = rs.getString("unidad_medida");
                registro [4] = rs.getString("precio_venta");
                
                totalregistros++;
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return null;
        }
        
    }
    
    public boolean insertar(vproducto dts){
        sSQL = "insert into producto(nombre,descripcion,unidad_medida,precio_venta)" +
                "values (?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setString(1, dts.getNombre());//send one to one all values to my PreparedStatement
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getUnidad_medida());
            pst.setDouble(4, dts.getPrecio_venta());
                        
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
    
    public boolean editar(vproducto dts){
        sSQL = "update producto set nombre=?, descripcion=?, unidad_medida=?,precio_venta=?" +
                "where idproducto=?"; //will set my keys, only if id is correct
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setString(1, dts.getNombre());//send one to one all values to my PreparedStatement
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getUnidad_medida());
            pst.setDouble(4, dts.getPrecio_venta());
            
            pst.setInt(5, dts.getIdproducto());
           
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
    
    public boolean eliminar(vproducto dts){
        sSQL = "delete from producto where idproducto =?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setInt(1, dts.getIdproducto());
            
            
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
