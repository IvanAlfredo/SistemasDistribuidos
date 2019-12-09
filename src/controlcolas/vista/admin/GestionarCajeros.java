/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * 
 *
 * Created on 06-05-2011, 11:07:31 AM
 */

package controlcolas.vista.admin;

import controlcolas.control.CajaJpaController;
import controlcolas.control.CajeroJpaController;
import controlcolas.control.ColaJpaController;
import controlcolas.modelo.Caja;
import controlcolas.modelo.Cajero;
import controlcolas.modelo.Cola;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilidades.Fmt;
import utilidades.Tabla;

/**
 *
 * @author Ramiro Duran
 */
//public class ColaVista extends javax.swing.JFrame {
public class GestionarCajeros extends javax.swing.JDialog {
    private CajeroJpaController ctrlCajero = new CajeroJpaController();
    private CajaJpaController ctrlCaja = new CajaJpaController();
    private Cajero cajero=null;
    private Caja caja = null;
    private List<Cajero> cajeroList;
    private List<Caja> cajaList;
    private int uIndex=0;
//    private String MODULO;
//    private Usuario USUARIO;

    //private int uIndex=0;
    /** Creates new form Vista */
    public GestionarCajeros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Fmt.initForm(this);
        
        cajeroList = ctrlCajero.findCajeroEntities();
        cajaList = ctrlCaja.findCajaEntities();
        if (cajeroList==null) cajeroList = ctrlCajero.findCajeroEntities(0,1);
        if (!cajeroList.isEmpty() && cajeroList.size()>0)  {
            cajero=cajeroList.get(0);
            uIndex=0;
        } 
        else cajero=null;
        mostrarTabla();
        estadoEstable();
        FillComboBox();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbCerrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbPrimer = new javax.swing.JButton();
        jbAnterior = new javax.swing.JButton();
        jbSiguiente = new javax.swing.JButton();
        jbUltimo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlCola = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jlCola1 = new javax.swing.JLabel();
        jtfCaja = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Codificador de Colas");
        setMinimumSize(new java.awt.Dimension(470, 400));
        setResizable(false);

        jbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(jbNuevo);

        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/disk.png"))); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jbGuardar);

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbEliminar);

        jbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/door_out.png"))); // NOI18N
        jbCerrar.setText("Cerrar");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCerrar);

        jbPrimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/first.png"))); // NOI18N
        jbPrimer.setText("Primer");
        jbPrimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPrimerActionPerformed(evt);
            }
        });
        jPanel2.add(jbPrimer);

        jbAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/previous.png"))); // NOI18N
        jbAnterior.setText("Anterior");
        jbAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnteriorActionPerformed(evt);
            }
        });
        jPanel2.add(jbAnterior);

        jbSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/next.png"))); // NOI18N
        jbSiguiente.setText("Siguiente");
        jbSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSiguienteActionPerformed(evt);
            }
        });
        jPanel2.add(jbSiguiente);

        jbUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/last.png"))); // NOI18N
        jbUltimo.setText("Ultimo");
        jbUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUltimoActionPerformed(evt);
            }
        });
        jPanel2.add(jbUltimo);

        jlCola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlCola.setText("Caja");

        jtfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombreKeyTyped(evt);
            }
        });

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cajero", "Caja"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTabla.getTableHeader().setReorderingAllowed(false);
        jtTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaMouseClicked(evt);
            }
        });
        jtTabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtTablaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabla);
        if (jtTabla.getColumnModel().getColumnCount() > 0) {
            jtTabla.getColumnModel().getColumn(0).setMinWidth(50);
            jtTabla.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        jlCola1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlCola1.setText("Nombre:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlCola)
                    .addComponent(jlCola1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfNombre)
                    .addComponent(jtfCaja, 0, 229, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCola1))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCola)
                    .addComponent(jtfCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        if (!validacion()) {
            return;
        }
        
        if (jbGuardar.getToolTipText().equals("Guardar nuevo registro")) {
                cajero = new Cajero();
        } 
        Date fecha = new Date();
        cajero.setNombre(jtfNombre.getText().toUpperCase());        
        cajero.setFechaAct(fecha);
        for(int i=0; i<cajaList.size();i++){
            if (cajaList.get(i).getNombre() == jtfCaja.getSelectedItem()){
                        caja = cajaList.get(i);
            }
        }
        cajero.setCaja(caja);        
        try {
            if (jbGuardar.getToolTipText().equals("Guardar nuevo registro"))  {
                    ctrlCajero.create(cajero);
                    cajeroList.add(cajero);
                    uIndex=cajeroList.size()-1;
            }
            else  {
                ctrlCajero.edit(cajero);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No es posible registrar o editar  el registro,\n puede existir un registro duplicado.");
        }
        mostrarTabla();        
        estadoEstable();

    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // TODO add your handling code here:
        jbNuevo.setEnabled(false);
        jbGuardar.setEnabled(true);
        jbGuardar.setToolTipText("Guardar nuevo registro");
        jbEliminar.setEnabled(true);
        jbEliminar.setText("Cancelar");
        jbEliminar.setToolTipText("Cancelar registro");
        jbAnterior.setEnabled(false);
        jbSiguiente.setEnabled(false);
        jbPrimer.setEnabled(false);
        jbUltimo.setEnabled(false);
        
        jtfNombre.setEnabled(true);
        jtfCaja.setEnabled(true);
        jtfNombre.setText("");
        jtfNombre.requestFocus();

    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        if(jbEliminar.getText().equals("Cancelar")) {
            estadoEstable();
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Esta seguro de eliminar este registro?","Confirmar",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
            try {
                ctrlCajero.destroy(cajero.getId());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No es posible eliminar el registro");
            }
            cajeroList.remove(cajero);
            uIndex = uIndex>0?uIndex-1:0;
            if (!cajeroList.isEmpty())  cajero=cajeroList.get(uIndex);
            else cajero=null;
        }
        mostrarTabla();
        estadoEstable();
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void jbPrimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPrimerActionPerformed
        // TODO add your handling code here:
        uIndex=0;
        if (!cajeroList.isEmpty()) cajero=cajeroList.get(uIndex);
        else cajero=null;
        estadoEstable();
    }//GEN-LAST:event_jbPrimerActionPerformed

    private void jbAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnteriorActionPerformed
        // TODO add your handling code here:
        uIndex = uIndex>0?uIndex-1:0;
        if (!cajeroList.isEmpty() && uIndex<cajeroList.size()) cajero=cajeroList.get(uIndex);
        else cajero=null;
        estadoEstable();
    }//GEN-LAST:event_jbAnteriorActionPerformed

    private void jbSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSiguienteActionPerformed
        // TODO add your handling code here:
        uIndex = (uIndex < cajeroList.size()-1)?uIndex+1:uIndex;
        if (!cajeroList.isEmpty() && uIndex<cajeroList.size()) cajero=cajeroList.get(uIndex);
        else cajero=null;
        estadoEstable();
    }//GEN-LAST:event_jbSiguienteActionPerformed

    private void jbUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUltimoActionPerformed
        // TODO add your handling code here:
        if (!cajeroList.isEmpty()) {
            uIndex=cajeroList.size()-1;
            cajero=cajeroList.get(uIndex);
        }
        else cajero=null;
        estadoEstable();
    }//GEN-LAST:event_jbUltimoActionPerformed

    private void jtfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyTyped
        // TODO add your handling code here:
        estadoModificacion();
    }//GEN-LAST:event_jtfNombreKeyTyped

    private void jtfNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyChar()==10) jbGuardar.doClick();
    }//GEN-LAST:event_jtfNombreKeyReleased

    private void jtTablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTablaKeyReleased
        // TODO add your handling code here:
        jtTablaMouseClicked(null);
    }//GEN-LAST:event_jtTablaKeyReleased

    private void jtTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaMouseClicked
        // TODO add your handling code here:
        int k = jtTabla.getSelectedRow();
        if (k>=0 && k<cajeroList.size()) {
                uIndex=k;
                if (!cajeroList.isEmpty()) cajero=cajeroList.get(uIndex);
                else cajero=null;
        }
        estadoEstable();
    }//GEN-LAST:event_jtTablaMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionarCajeros(null,true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAnterior;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbPrimer;
    private javax.swing.JButton jbSiguiente;
    private javax.swing.JButton jbUltimo;
    private javax.swing.JLabel jlCola;
    private javax.swing.JLabel jlCola1;
    private javax.swing.JTable jtTabla;
    private javax.swing.JComboBox<String> jtfCaja;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables

    private void estadoEstable() {
        jbNuevo.setEnabled(true);
        jbGuardar.setEnabled(false);
        jbEliminar.setText("Eliminar");
        jbEliminar.setToolTipText("Eliminar registro");
        jbEliminar.setEnabled(true);
        jbAnterior.setEnabled(true);
        jbSiguiente.setEnabled(true);
        jbPrimer.setEnabled(true);
        jbUltimo.setEnabled(true);

        if (cajero!=null) {
                jtfNombre.setText(cajeroList.get(uIndex).getNombre());
        } else {
        
            jbEliminar.setEnabled(false);
            jbAnterior.setEnabled(false);
            jbSiguiente.setEnabled(false);
            jbPrimer.setEnabled(false);
            jbUltimo.setEnabled(false);

            jtfNombre.setEnabled(false);
            jtfNombre.setText("");
            jtfCaja.setEnabled(false);
        }
        if(cajeroList.size()<=1) {
                jbAnterior.setEnabled(false);
                jbSiguiente.setEnabled(false);
                jbPrimer.setEnabled(false);
                jbUltimo.setEnabled(false);
        }
        if(uIndex == (cajeroList.size()-1)) {
                jbSiguiente.setEnabled(false);
                jbUltimo.setEnabled(false);
        }
        if(uIndex==0) {
                jbAnterior.setEnabled(false);
                jbPrimer.setEnabled(false);
            }
        if (!cajeroList.isEmpty() && uIndex>=0 && uIndex<jtTabla.getRowCount())
                jtTabla.setRowSelectionInterval(uIndex, uIndex);
        
    }
    

    private boolean validacion() {
        if (jtfNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre o la sigla del registro esta en blanco");
            jtfNombre.requestFocus();
            return false;
        }
        return true;
    }

    private void estadoModificacion() {
        if(jbNuevo.isEnabled()) {
            jbNuevo.setEnabled(false);
            jbGuardar.setEnabled(true);
            jbGuardar.setToolTipText("Guardar registro modificado");
            jbEliminar.setEnabled(true);
            jbEliminar.setText("Cancelar");
            jbEliminar.setToolTipText("Cancelar modificar registro");
            jbAnterior.setEnabled(false);
            jbSiguiente.setEnabled(false);
            jbPrimer.setEnabled(false);
            jbUltimo.setEnabled(false);            
        }
    }

    private void mostrarTabla() {

        Tabla.limpiarTabla(jtTabla);
        for(int i=0;i<cajeroList.size();i++) {
           ((DefaultTableModel) jtTabla.getModel()).addRow(new Object[]{
                    cajeroList.get(i).getNombre(),
                    cajeroList.get(i).getCaja().getNombre()
                });
        }
       
    }
    
    private void FillComboBox(){
        for(int i=0; i<cajaList.size();i++){
            jtfCaja.addItem(cajaList.get(i).getNombre());
        }
    }
}