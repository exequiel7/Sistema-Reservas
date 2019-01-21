/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vtrabajador;
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
public class ftrabajador {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";//for person
    private String sSQL2 = "";//for client, because extends from 'Persona'
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno", "Doc", "Numero Documento", "Direccion", "Telefono", "Email", "Sueldo", "Acceso", "Login", "Clave", "Estado"};
        String[] registro = new String[14];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT p.idpersona, p.nombre, p.apaterno, p.amaterno, p.tipo_documento, p.num_documento, p.direccion, p.telefono, p.email, t.sueldo, t.acceso, t.login, t.password, t.estado "
                + "FROM persona p INNER JOIN Trabajador t ON p.idpersona = t.idpersona "
                + "WHERE num_documento LIKE '%" + buscar + "%' ORDER BY p.idpersona desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                registro[4] = rs.getString("tipo_documento");
                registro[5] = rs.getString("num_documento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("sueldo");
                registro[10] = rs.getString("acceso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("password");
                registro[13] = rs.getString("estado");

                totalregistros++;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return null;
        }

    }

    public boolean insertar(vtrabajador dts) {
        sSQL = "insert into persona(nombre, apaterno, amaterno, tipo_documento, num_documento, direccion, telefono, email)"
                + "values (?, ?, ?, ?, ?, ?, ?, ?)"; //record data of a person

        sSQL2 = "insert into trabajador(idpersona, sueldo, acceso, login, password, estado)" //record data of a employee
                + "values ((select idpersona from persona order by idpersona desc limit 1), ?, ?, ?, ?, ?)"; //get the latest registration from personas table

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            PreparedStatement pst2 = cn.prepareStatement(sSQL2); //preparing the query2

            //PreparedStatement 1
            pst.setString(1, dts.getNombre());//send one to one all values to my PreparedStatement
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());

            //PreparedStatement 2
            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());

            int n = pst.executeUpdate(); //save result of statement execute 
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean editar(vtrabajador dts) {
        sSQL = "update persona set nombre=?, apaterno=?, amaterno=?, tipo_documento=?, num_documento=?,"
                + "direccion=?, telefono=?, email=? where idpersona=?"; //will set my keys, only if id is correct

        sSQL2 = "update trabajador set sueldo=?, acceso=?, login=?, password=?, estado=?"
                + "where idpersona=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            PreparedStatement pst2 = cn.prepareStatement(sSQL2); //preparing the query2

            //PreparedStatement 1
            pst.setString(1, dts.getNombre());//send one to one all values to my PreparedStatement
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            pst.setInt(9, dts.getIdpersona());

            //PreparedStatement 2
            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());
            pst2.setInt(6, dts.getIdpersona());

            int n = pst.executeUpdate(); //save result of statement execute 
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean eliminar(vtrabajador dts) {
        sSQL = "delete from trabajador where idpersona =?";
        sSQL2 = "delete from persona where idpersona =?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); //preparing the query
            PreparedStatement pst2 = cn.prepareStatement(sSQL2); //preparing the query2

            //PreparedStatement 1
            pst.setInt(1, dts.getIdpersona());

            //PreparedStatement 2
            pst2.setInt(1, dts.getIdpersona());

            int n = pst.executeUpdate(); //save result of statement execute 
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }
    
    public DefaultTableModel login(String login, String password) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno", "Acceso", "Login", "Clave", "Estado"};
        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT p.idpersona, p.nombre, p.apaterno, p.amaterno, t.acceso, t.login, t.password, t.estado "
                + "FROM persona p INNER JOIN Trabajador t ON p.idpersona = t.idpersona "
                + "WHERE t.login='" + login + "' and t.password='" + password + "' and t.estado='A'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                
                registro[4] = rs.getString("acceso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("estado");

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
