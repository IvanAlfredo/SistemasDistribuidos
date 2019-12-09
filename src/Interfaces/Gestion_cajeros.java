/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Franz
 */
public class Gestion_cajeros extends javax.swing.JPanel {

    /**
     * Creates new form Gestion_cajeros
     */
    JPanel panel_contenedor;
    public Gestion_cajeros() {
        initComponents();
        this.setSize(1126,700);
        this.setPreferredSize(new Dimension(1126,700));
        this.setBounds(0, 0, 1126,700);
        setVisible(false);
        cargar_tabla();
    }
    public Gestion_cajeros(JPanel panel_contenedor) {
        initComponents();
        this.setSize(1126,700);
        this.setPreferredSize(new Dimension(1126,700));
        this.setBounds(0, 0, 1126,700);
        setVisible(false);
        this.panel_contenedor=panel_contenedor;
        cargar_tabla();
    }
    public void cargar_tabla(){
        tabla1.setBackground(Color.WHITE);
        tabla1.getTableHeader().setBackground(new Color(0,153,102));
        tabla1.getTableHeader().setForeground(Color.WHITE);
        tabla1.getTableHeader().setOpaque(false);
        tabla1.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabla1.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla1.getColumnModel().getColumn(2).setPreferredWidth(150);
        tabla1.getColumnModel().getColumn(3).setPreferredWidth(150);
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnNuevoCajero = new javax.swing.JButton();
        btnNuevoCajero3 = new javax.swing.JButton();
        btnNuevoCajero1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 199, 120));
        setMaximumSize(new java.awt.Dimension(945, 500));
        setMinimumSize(new java.awt.Dimension(945, 500));
        setPreferredSize(new java.awt.Dimension(945, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 80));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 80));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 80));
        jPanel1.setRequestFocusEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(9, 32, 64));
        jLabel5.setText("Cajeros");

        btnNuevoCajero.setBackground(new java.awt.Color(5, 166, 121));
        btnNuevoCajero.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNuevoCajero.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoCajero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/white/png/doc_new_icon&32.png"))); // NOI18N
        btnNuevoCajero.setText("Nuevo");
        btnNuevoCajero.setContentAreaFilled(false);
        btnNuevoCajero.setOpaque(true);
        btnNuevoCajero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoCajeroMouseClicked(evt);
            }
        });
        btnNuevoCajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCajeroActionPerformed(evt);
            }
        });

        btnNuevoCajero3.setBackground(new java.awt.Color(246, 182, 4));
        btnNuevoCajero3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevoCajero3.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoCajero3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/white/png/doc_new_icon&32.png"))); // NOI18N
        btnNuevoCajero3.setText("Modificar");
        btnNuevoCajero3.setContentAreaFilled(false);
        btnNuevoCajero3.setOpaque(true);
        btnNuevoCajero3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoCajero3MouseClicked(evt);
            }
        });
        btnNuevoCajero3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCajero3ActionPerformed(evt);
            }
        });

        btnNuevoCajero1.setBackground(new java.awt.Color(201, 11, 51));
        btnNuevoCajero1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevoCajero1.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoCajero1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/white/png/doc_new_icon&32.png"))); // NOI18N
        btnNuevoCajero1.setText("Eliminar");
        btnNuevoCajero1.setContentAreaFilled(false);
        btnNuevoCajero1.setOpaque(true);
        btnNuevoCajero1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoCajero1MouseClicked(evt);
            }
        });
        btnNuevoCajero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCajero1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevoCajero, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevoCajero3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevoCajero1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevoCajero3, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addComponent(btnNuevoCajero1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addComponent(btnNuevoCajero, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(900, 650));
        jPanel2.setMinimumSize(new java.awt.Dimension(900, 650));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 650));

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "María Cortez", null, "Activo"},
                {"2", "Sara Torrez", null, "Activo"},
                {"3", "Monica Llanos", null, "Activo"},
                {"4", "Luis Castro", null, "Inactivo"},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombres", "Fecha actual", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tabla1);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(9, 32, 64));
        jLabel6.setText("Lista de cajeros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoCajeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoCajeroMouseClicked
        Registrar_cajeros cajeros = new Registrar_cajeros();
        panel_contenedor.removeAll();
        panel_contenedor.add(cajeros);
        cajeros.setVisible(true);
        
    }//GEN-LAST:event_btnNuevoCajeroMouseClicked

    private void btnNuevoCajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCajeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoCajeroActionPerformed

    private void btnNuevoCajero3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoCajero3MouseClicked

    }//GEN-LAST:event_btnNuevoCajero3MouseClicked

    private void btnNuevoCajero3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCajero3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoCajero3ActionPerformed

    private void btnNuevoCajero1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoCajero1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoCajero1MouseClicked

    private void btnNuevoCajero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCajero1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoCajero1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoCajero;
    private javax.swing.JButton btnNuevoCajero1;
    private javax.swing.JButton btnNuevoCajero3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
