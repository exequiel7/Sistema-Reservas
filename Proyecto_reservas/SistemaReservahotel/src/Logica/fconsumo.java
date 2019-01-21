/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vconsumo;
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
public class fconsumo {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    public Double totalConsumo;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "IdReserva", "IdProducto", "Producto", "Cantidad", "Precio Venta", "Estado"};
        String[] registro = new String[7];

        totalregistros = 0;
        totalConsumo = 0.0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT c.idconsumo, c.idreserva, c.idproducto, p.nombre, c.cantidad, c.precio_venta, c.estado "
                + "FROM consumo c INNER JOIN producto p ON c.idproducto = p.idproducto "
                + "WHERE c.idreserva =" + buscar + " ORDER BY c.idconsumo desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idconsumo");
                registro[1] = rs.getString("idreserva");
                registro[2] = rs.getString("idproducto");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("precio_venta");
                registro[6] = rs.getString("estado");

                totalregistros++;
                totalConsumo += (rs.getDouble("cantidad") * rs.getDouble("precio_venta"));
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return null;
        }

    }

    public boolean insertar(vconsumo dts) {
        sSQL = "INSERT INTO consumo (idreserva, idproducto, cantidad, precio_venta, estado)"
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setInt(1, dts.getIdreserva());//send one to one all values to my PreparedStatement
            pst.setInt(2, dts.getIdproducto());
            pst.setDouble(3, dts.getCantidad());
            pst.setDouble(4, dts.getPrecio_venta());
            pst.setString(5, dts.getEstado());

            int n = pst.executeUpdate(); //save result of statement execute 
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean editar(vconsumo dts) {
        sSQL = "UPDATE consumo SET idreserva=?, idproducto=?, cantidad=?, precio_venta=?, estado=?"
                + "WHERE idconsumo=?"; //will set my keys, only if id is correct

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setInt(1, dts.getIdreserva());//send one to one all values to my PreparedStatement
            pst.setInt(2, dts.getIdproducto());
            pst.setDouble(3, dts.getCantidad());
            pst.setDouble(4, dts.getPrecio_venta());
            pst.setString(5, dts.getEstado());

            pst.setInt(6, dts.getIdconsumo());

            int n = pst.executeUpdate(); //save result of statement execute 
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean eliminar(vconsumo dts) {
        sSQL = "DELETE FROM consumo WHERE idproducto =?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            pst.setInt(1, dts.getIdconsumo());

            int n = pst.executeUpdate(); //save result of statement execute 
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

}
