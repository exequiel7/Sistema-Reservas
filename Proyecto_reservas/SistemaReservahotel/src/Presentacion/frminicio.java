/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author deferrari.exequiel
 */
public class frminicio extends javax.swing.JFrame {

    /**
     * Creates new form frminicio
     */
    public frminicio() {
        initComponents();
        this.setExtendedState(frminicio.MAXIMIZED_BOTH);
        this.setTitle("Sistema de Reserva de Habitaciones y Gestion de ventas - Hotel Favanet");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        lblidpersona = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblapaterno = new javax.swing.JLabel();
        lblacceso = new javax.swing.JLabel();
        lblamaterno = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnusisreserva = new javax.swing.JMenu();
        mnuarchivo = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        mnureservas = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuconsultas = new javax.swing.JMenu();
        mnuconfiguraciones = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuherramientas = new javax.swing.JMenu();
        mnuayuda = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnusalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(0, 153, 153));

        lblidpersona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblidpersona.setText("jLabel1");
        escritorio.add(lblidpersona);
        lblidpersona.setBounds(40, 20, 110, 40);

        lblnombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblnombre.setText("jLabel1");
        escritorio.add(lblnombre);
        lblnombre.setBounds(40, 70, 110, 40);

        lblapaterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblapaterno.setText("jLabel1");
        escritorio.add(lblapaterno);
        lblapaterno.setBounds(40, 120, 110, 40);

        lblacceso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblacceso.setText("jLabel1");
        escritorio.add(lblacceso);
        lblacceso.setBounds(40, 230, 110, 50);

        lblamaterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblamaterno.setText("jLabel1");
        escritorio.add(lblamaterno);
        lblamaterno.setBounds(40, 170, 110, 50);

        mnusisreserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/inicio.png"))); // NOI18N
        mnusisreserva.setMnemonic('f');
        mnusisreserva.setText("Sisreserva");
        menuBar.add(mnusisreserva);

        mnuarchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/archivo.png"))); // NOI18N
        mnuarchivo.setMnemonic('e');
        mnuarchivo.setText("Archivo");

        cutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        cutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/habitaciones.png"))); // NOI18N
        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Habitaciones");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        mnuarchivo.add(cutMenuItem);

        copyMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        copyMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/productos.png"))); // NOI18N
        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Productos");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        mnuarchivo.add(copyMenuItem);

        menuBar.add(mnuarchivo);

        mnureservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/reservas.png"))); // NOI18N
        mnureservas.setMnemonic('h');
        mnureservas.setText("Reservas");

        contentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        contentMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/reservas-consumos.png"))); // NOI18N
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Reservas y Consumos");
        mnureservas.add(contentMenuItem);

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/clientes.png"))); // NOI18N
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Clientes");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        mnureservas.add(aboutMenuItem);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/pagos.png"))); // NOI18N
        jMenuItem1.setText("Pagos");
        mnureservas.add(jMenuItem1);

        menuBar.add(mnureservas);

        mnuconsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/consultas.png"))); // NOI18N
        mnuconsultas.setText("Consultas");
        menuBar.add(mnuconsultas);

        mnuconfiguraciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/configuraciones.png"))); // NOI18N
        mnuconfiguraciones.setText("Configuraciones");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/trabajadores.png"))); // NOI18N
        jMenuItem2.setText("Usuarios y Accesos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuconfiguraciones.add(jMenuItem2);

        menuBar.add(mnuconfiguraciones);

        mnuherramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/herramientas.png"))); // NOI18N
        mnuherramientas.setText("Herramientas");
        menuBar.add(mnuherramientas);

        mnuayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/ayuda.png"))); // NOI18N
        mnuayuda.setText("Ayuda");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Acerca de...");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuayuda.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Ayuda");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnuayuda.add(jMenuItem4);

        menuBar.add(mnuayuda);

        mnusalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salir-sistema.png"))); // NOI18N
        mnusalir.setText("Salir");
        mnusalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnusalirMouseClicked(evt);
            }
        });
        menuBar.add(mnusalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        // TODO add your handling code here:
        frmhabitacion form = new frmhabitacion();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        frmtrabajador form = new frmtrabajador();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        // TODO add your handling code here:
        frmproducto form = new frmproducto();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        // TODO add your handling code here:
        frmcliente form = new frmcliente();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void mnusalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnusalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_mnusalirMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frminicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    public static javax.swing.JLabel lblacceso;
    public static javax.swing.JLabel lblamaterno;
    public static javax.swing.JLabel lblapaterno;
    public static javax.swing.JLabel lblidpersona;
    public static javax.swing.JLabel lblnombre;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu mnuarchivo;
    private javax.swing.JMenu mnuayuda;
    public static javax.swing.JMenu mnuconfiguraciones;
    private javax.swing.JMenu mnuconsultas;
    private javax.swing.JMenu mnuherramientas;
    private javax.swing.JMenu mnureservas;
    private javax.swing.JMenu mnusalir;
    private javax.swing.JMenu mnusisreserva;
    // End of variables declaration//GEN-END:variables

}