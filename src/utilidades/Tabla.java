/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;
 
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.text.DecimalFormat;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Ramiro
 */
public class Tabla {


    static public void PonerCombo(TableColumn Columnatabla, JComboBox jcb) {
        Columnatabla.setCellEditor(new DefaultCellEditor(jcb));

        //Añadimos el combo a la columna.
        DefaultTableCellRenderer renderer =  new DefaultTableCellRenderer();
        renderer.setToolTipText("Click para escoger");
        Columnatabla.setCellRenderer(renderer);
        //Columnatabla.setHeaderRenderer(new MyHeaderRenderer());
    }

    static public void PonerTextField(TableColumn Columnatabla, JTextField jtf) {
        //lleno el combo.
        Columnatabla.setCellEditor(new DefaultCellEditor(jtf));

        //Añadimos el combo a la columna.
       // DefaultTableCellRenderer renderer =  new DefaultTableCellRenderer();
        //renderer.setToolTipText("Doble Click para editar");
       // Columnatabla.setCellRenderer(renderer);
        //Columnatabla.setHeaderRenderer(new MyHeaderRenderer());
        Columnatabla.setHeaderRenderer(new ColumnaRenderer());
        Columnatabla.setCellRenderer(new CeldaRenderer());

    }

    static public void PonerTextField(TableColumn Columnatabla, JFormattedTextField jtf) {
        //lleno el combo.
        Columnatabla.setCellEditor(new DefaultCellEditor(jtf));

        //Añadimos el combo a la columna.
        //DefaultTableCellRenderer renderer =  new DefaultTableCellRenderer();
        //renderer.setToolTipText("Doble Click para editar");
        //Columnatabla.setCellRenderer(renderer);
        //Columnatabla.setHeaderRenderer(new MyHeaderRenderer());
        Columnatabla.setHeaderRenderer(new ColumnaRenderer());
        Columnatabla.setCellRenderer(new CeldaRenderer());
    }

    static public void ResaltarColumna(TableColumn Columnatabla) {
        Columnatabla.setHeaderRenderer(new ColumnaRenderer());
//        Columnatabla.setCellRenderer(new CeldaRenderer());
    }

    static public void ResaltarTitulo(TableColumn Columnatabla) {
        Columnatabla.setHeaderRenderer(new ColumnaRenderer());
//        Columnatabla.setCellRenderer(new CeldaRenderer());
    }

    static public void ResaltarColumnaEnable(TableColumn Columnatabla, Boolean sw) {
        Columnatabla.setHeaderRenderer(new ColumnaRenderer());
        Columnatabla.setCellRenderer(new CeldaRenderer());

        DefaultTableCellRenderer renderer =  new DefaultTableCellRenderer();
//        renderer.setToolTipText("Click para escoger");
        renderer.setEnabled(sw);
        Columnatabla.setCellRenderer(renderer);

    }

static public void puedeEditar(JTable jtTabla, Boolean sw, int columna) {

    int colCount=jtTabla.getColumnCount();
    String[] colNombres = new String[colCount];
    final Class[] colTypes = new Class [colCount];
    final boolean pEdit=sw;
    final int pColumna=columna;
    int[] minWith=  new int[colCount];
    int[] preWith=  new int[colCount];
    int[] maxWith=  new int[colCount];

    for (int k=0; k<colCount; k++){
        colNombres[k] = jtTabla.getColumnName(k);
        colTypes[k] = jtTabla.getColumnClass(k);
        minWith[k]= jtTabla.getColumnModel().getColumn(k).getMinWidth();
        preWith[k]= jtTabla.getColumnModel().getColumn(k).getPreferredWidth();
        maxWith[k]= jtTabla.getColumnModel().getColumn(k).getMaxWidth();
    }
    jtTabla.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {                },
                 colNombres
                ) {
                    public Class getColumnClass(int columnIndex) {
                        return colTypes [columnIndex];
                    }
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        if (columnIndex== pColumna)
                             return pEdit;
                        else return false;
                    }
                });
    for (int k=0; k<colCount; k++){
        jtTabla.getColumnModel().getColumn(k).setMinWidth(minWith[k]);
        jtTabla.getColumnModel().getColumn(k).setPreferredWidth(preWith[k]);
        jtTabla.getColumnModel().getColumn(k).setMaxWidth(maxWith[k]);
    }
    ResaltarColumna(jtTabla.getColumnModel().getColumn(columna));
  }

static public void puedeEditar(JTable jtTabla, Boolean sw, int col1, int col2) {

    int colCount=jtTabla.getColumnCount();
    String[] colNombres = new String[colCount];
    final Class[] colTypes = new Class [colCount];
    final boolean pEdit=sw;
    final int pCol1=col1;
    final int pCol2=col2;
    int[] minWith=  new int[colCount];
    int[] preWith=  new int[colCount];
    int[] maxWith=  new int[colCount];

    for (int k=0; k<colCount; k++){
        colNombres[k] = jtTabla.getColumnName(k);
        colTypes[k] = jtTabla.getColumnClass(k);
        minWith[k]= jtTabla.getColumnModel().getColumn(k).getMinWidth();
        preWith[k]= jtTabla.getColumnModel().getColumn(k).getPreferredWidth();
        maxWith[k]= jtTabla.getColumnModel().getColumn(k).getMaxWidth();
    }
    jtTabla.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {                },
                 colNombres
                ) {
                    public Class getColumnClass(int columnIndex) {
                        return colTypes [columnIndex];
                    }
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        if (columnIndex==pCol1 || columnIndex==pCol2)
                             return pEdit;
                        else return false;
                    }
                });
    for (int k=0; k<colCount; k++){
        jtTabla.getColumnModel().getColumn(k).setMinWidth(minWith[k]);
        jtTabla.getColumnModel().getColumn(k).setPreferredWidth(preWith[k]);
        jtTabla.getColumnModel().getColumn(k).setMaxWidth(maxWith[k]);
    }
    ResaltarColumna(jtTabla.getColumnModel().getColumn(col1));
    ResaltarColumna(jtTabla.getColumnModel().getColumn(col2));
  }

static public void puedeEditar(JTable jtTabla, Boolean sw, int col1, int col2,int col3) {

    int colCount=jtTabla.getColumnCount();
    String[] colNombres = new String[colCount];
    final Class[] colTypes = new Class [colCount];
    final boolean pEdit=sw;
    final int pCol1=col1;
    final int pCol2=col2;
    final int pCol3=col3;
    int[] minWith=  new int[colCount];
    int[] preWith=  new int[colCount];
    int[] maxWith=  new int[colCount];

    for (int k=0; k<colCount; k++){
        colNombres[k] = jtTabla.getColumnName(k);
        colTypes[k] = jtTabla.getColumnClass(k);
        minWith[k]= jtTabla.getColumnModel().getColumn(k).getMinWidth();
        preWith[k]= jtTabla.getColumnModel().getColumn(k).getPreferredWidth();
        maxWith[k]= jtTabla.getColumnModel().getColumn(k).getMaxWidth();
    }
    jtTabla.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {                },
                 colNombres
                ) {
                    public Class getColumnClass(int columnIndex) {
                        return colTypes [columnIndex];
                    }
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        if (columnIndex==pCol1 || columnIndex==pCol2 || columnIndex==pCol3)
                             return pEdit;
                        else return false;
                    }
                });
    for (int k=0; k<colCount; k++){
        jtTabla.getColumnModel().getColumn(k).setMinWidth(minWith[k]);
        jtTabla.getColumnModel().getColumn(k).setPreferredWidth(preWith[k]);
        jtTabla.getColumnModel().getColumn(k).setMaxWidth(maxWith[k]);
    }
    ResaltarColumna(jtTabla.getColumnModel().getColumn(col1));
    ResaltarColumna(jtTabla.getColumnModel().getColumn(col2));
    ResaltarColumna(jtTabla.getColumnModel().getColumn(col3));
  }

static public void alinearColumnas(JTable jtTabla, char[] alineamiento) {

  for (int k=0;k<alineamiento.length;k++) {
     DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
     if (alineamiento[k]=='i')
       tcr.setHorizontalAlignment(SwingConstants.LEFT);
     else if (alineamiento[k]=='c')
       tcr.setHorizontalAlignment(SwingConstants.CENTER);
     else if (alineamiento[k]=='d')
                    tcr.setHorizontalAlignment(SwingConstants.RIGHT);
     jtTabla.getColumnModel().getColumn(k).setCellRenderer(tcr);
     }
    }

static public void limpiarTabla(JTable jtTabla) {
        DefaultTableModel temp = (DefaultTableModel) jtTabla.getModel();
        for(int i=temp.getRowCount()-1;i>=0;i--)
                temp.removeRow(i);

}

static public void mostrarFocoFinal(JTable jtTabla){
    
    int row = jtTabla.getRowCount()-1;
    if (row<1) return;
    Rectangle rect=jtTabla.getCellRect(row, 0, true);
    jtTabla.scrollRectToVisible(rect);
    jtTabla.clearSelection();
    jtTabla.setRowSelectionInterval(row, row);
    DefaultTableModel modelo = (DefaultTableModel) jtTabla.getModel();
    modelo.fireTableDataChanged();
}

static public void mostrarFoco(JTable jtTabla, int row){
    
    if (row>=jtTabla.getRowCount()) return;
    Rectangle rect=jtTabla.getCellRect(row, 0, true);
    jtTabla.scrollRectToVisible(rect);
    jtTabla.clearSelection();
    jtTabla.setRowSelectionInterval(row, row);
    DefaultTableModel modelo = (DefaultTableModel) jtTabla.getModel();
    modelo.fireTableDataChanged();
}


static public void eliminarFila(JTable jtTabla, int fila) {
         DefaultTableModel temp = (DefaultTableModel) jtTabla.getModel();
            temp = (DefaultTableModel) jtTabla.getModel();
            temp.removeRow(fila);
    }

}

class MyHeaderRenderer implements TableCellRenderer
{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {

        String txt = value.toString();
        JLabel label = new JLabel("<html><b>" + txt + "</b></html>");
        return label;
    }

}

class CeldaRenderer extends DefaultTableCellRenderer
{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {

        setBackground(Color.getHSBColor(1.60f, 0.31f, 0.98f));
        setText((value == null) ? "" : value.toString());
        setToolTipText("Doble Click para editar");
        setHorizontalAlignment(SwingConstants.RIGHT);
        return this;
    }

}

class ColumnaRenderer extends DefaultTableCellRenderer
{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        setOpaque(true);
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        setHorizontalAlignment(CENTER);
        setForeground(Color.LIGHT_GRAY);
        setBackground(Color.GRAY);
        setFont(new Font("TimesRoman", Font.BOLD, 12));
        setText((value == null) ? "" : value.toString());
        return this;
    }

static public void formatoDecimal(JTable jtTabla, int col) {
    jtTabla.getColumnModel().getColumn(col).setCellRenderer(new DecimalFormatRenderer() );
 }

static public void formatoDecimal(JTable jtTabla, int col1, int col2, int col3) {
    jtTabla.getColumnModel().getColumn(col1).setCellRenderer(new DecimalFormatRenderer() );
    jtTabla.getColumnModel().getColumn(col2).setCellRenderer(new DecimalFormatRenderer() );
    jtTabla.getColumnModel().getColumn(col3).setCellRenderer(new DecimalFormatRenderer() );

 }

static class DecimalFormatRenderer extends DefaultTableCellRenderer {
    private static final DecimalFormat formatter = new DecimalFormat( "#,##0.00" );

    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // First format the cell value as required
        value = formatter.format((Number)value);
        // And pass it on to parent class
        setHorizontalAlignment(SwingConstants.RIGHT);        
        return super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column );
    }
}    
    
}

