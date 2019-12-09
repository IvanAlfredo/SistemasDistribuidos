/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import controlcolas.vista.cliente.ObtenerFicha_cola;

/**
 *
 * @author Franz
 */
public class ObtenerFicha extends javax.swing.JPanel {

    /**
     * Creates new form ObtenerFicha
     */
    public ObtenerFicha() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        buttonModeloA1 = new mibuttonmodeloa.ButtonModeloA();
        buttonModeloA2 = new mibuttonmodeloa.ButtonModeloA();

        setBackground(new java.awt.Color(242, 199, 120));
        setFocusCycleRoot(true);
        setMaximumSize(new java.awt.Dimension(960, 540));
        setMinimumSize(new java.awt.Dimension(960, 540));
        setPreferredSize(new java.awt.Dimension(960, 540));
        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(9, 32, 64));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(960, 150));
        jPanel1.setMinimumSize(new java.awt.Dimension(960, 150));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 150));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("OBTENER FICHAS");
        jLabel1.setAlignmentX(288.0F);
        jLabel1.setAlignmentY(43.0F);
        jLabel1.setMaximumSize(new java.awt.Dimension(384, 65));
        jLabel1.setMinimumSize(new java.awt.Dimension(384, 65));
        jLabel1.setPreferredSize(new java.awt.Dimension(384, 65));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        buttonModeloA1.setColor_hover(new java.awt.Color(242, 70, 56));
        buttonModeloA1.setColor_icono_hover(new java.awt.Color(192, 42, 43));
        buttonModeloA1.setColor_icono_normal(new java.awt.Color(192, 42, 43));
        buttonModeloA1.setColor_icono_pressed(new java.awt.Color(192, 42, 43));
        buttonModeloA1.setColor_normal(new java.awt.Color(242, 70, 56));
        buttonModeloA1.setColor_pressed(new java.awt.Color(242, 70, 56));
        buttonModeloA1.setDimension_boton(new java.awt.Dimension(300, 100));
        buttonModeloA1.setDimension_icono(new java.awt.Dimension(100, 100));
        buttonModeloA1.setDoubleBuffered(false);
        buttonModeloA1.setFuente_texto(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        buttonModeloA1.setIcono_hover(new javax.swing.ImageIcon(getClass().getResource("/white/png/cur_euro_icon&48.png"))); // NOI18N
        buttonModeloA1.setIcono_normal(new javax.swing.ImageIcon(getClass().getResource("/white/png/cur_euro_icon&48.png"))); // NOI18N
        buttonModeloA1.setTexto_boton("CAJA");
        buttonModeloA1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonModeloA1MouseClicked(evt);
            }
        });

        buttonModeloA2.setColor_hover(new java.awt.Color(2, 74, 89));
        buttonModeloA2.setColor_icono_hover(new java.awt.Color(9, 32, 64));
        buttonModeloA2.setColor_icono_normal(new java.awt.Color(9, 32, 64));
        buttonModeloA2.setColor_icono_pressed(new java.awt.Color(9, 32, 64));
        buttonModeloA2.setColor_normal(new java.awt.Color(2, 74, 89));
        buttonModeloA2.setColor_pressed(new java.awt.Color(2, 74, 89));
        buttonModeloA2.setDimension_boton(new java.awt.Dimension(300, 100));
        buttonModeloA2.setDimension_icono(new java.awt.Dimension(100, 100));
        buttonModeloA2.setDoubleBuffered(false);
        buttonModeloA2.setFuente_texto(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        buttonModeloA2.setIcono_hover(new javax.swing.ImageIcon(getClass().getResource("/white/png/users_icon&48.png"))); // NOI18N
        buttonModeloA2.setIcono_normal(new javax.swing.ImageIcon(getClass().getResource("/white/png/users_icon&48.png"))); // NOI18N
        buttonModeloA2.setTexto_boton("ATENCION \nAL \nCLIENTE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonModeloA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonModeloA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(buttonModeloA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonModeloA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonModeloA1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonModeloA1MouseClicked
        // TODO add your handling code here:
        ObtenerFicha_cola ofc = new ObtenerFicha_cola();
        ofc.show();
    }//GEN-LAST:event_buttonModeloA1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mibuttonmodeloa.ButtonModeloA buttonModeloA1;
    private mibuttonmodeloa.ButtonModeloA buttonModeloA2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}