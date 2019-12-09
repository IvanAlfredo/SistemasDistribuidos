/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades; 

import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.awt.Frame.MAXIMIZED_HORIZ;
import static java.awt.Frame.MAXIMIZED_VERT;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;

/**
 *
 * @author Ramiro
 */
public class Fmt {

    private Locale[] locales = {
        new Locale("fr","FR"),
        new Locale("de","DE"),
        new Locale("en","EN")
    };
    
    private static NumberFormat nf;
    private static DecimalFormat df;

    public Fmt() {
        nf= NumberFormat.getNumberInstance(locales[2]);
      df = (DecimalFormat)nf;
      df.applyPattern("################.00");
    }
    public Fmt(int x) {
          nf= NumberFormat.getNumberInstance(locales[2]);
          df = (DecimalFormat)nf;
          df.applyPattern("################");
    }

    public static void initForm(javax.swing.JFrame form) {
        form.setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon("src/iconos/"+Propiedad.get("logoicono"));
        form.setIconImage(icono.getImage());
        int wForma = form.getWidth();
        int hForma = form.getHeight();
        int wPantalla=Toolkit.getDefaultToolkit().getScreenSize().width;
        int hPantalla=Toolkit.getDefaultToolkit().getScreenSize().height;
        if (wForma>wPantalla && hForma >hPantalla)
            form.setExtendedState(MAXIMIZED_BOTH);            
        else if (wForma>wPantalla)
            form.setExtendedState(MAXIMIZED_HORIZ);            
        else if (hForma >hPantalla)
            form.setExtendedState(MAXIMIZED_VERT);            

    }

    public static void initForm(javax.swing.JDialog form) {
        form.setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon("src/iconos/"+Propiedad.get("logoicono"));
        form.setIconImage(icono.getImage());
    }
    
    public static DecimalFormat getFormatoDecimal(){
        return df;
    }
    public static DecimalFormat getFormatoEntero(){
        return df;
    }
    public static String setFormatDecimal(double num){
        return df.format(num);

    }
    
    public static String redondeoTxt (double num) {
        num = Double.valueOf(Math.round(num*100))/100;        
        return (String.valueOf(num));
    }

    public static String redondeoTxt (float num) {
        num = Float.valueOf(Math.round(num*100))/100;        
        return (String.valueOf(num));
    }    
    
    public static double redondeo (double num) {
        num = Double.valueOf(Math.round(num*100))/100;        
        return (num);
    }

    public static float redondeo (float num) {
        num = Float.valueOf(Math.round(num*100))/100;        
        return (num);
    }

    public static double redondeo (String numstr) {
        double num;
        try {
          num = Double.parseDouble(numstr);
        } catch (Exception e) {
            num=0.0;
        }
        num = Double.valueOf(Math.round(num*100))/100;        
        return (num);
    }

    public static String operacionTxt (int operacion) {
        String operTxt="";
        switch (operacion) {
            case 211:
                operTxt = "211:EFECTIVO";
                break;
            case 212:
                operTxt = "212:CREDITO";
                break;
            case 213:
                operTxt = "213:CONSIGNACION";
                break;
            case 311:
                operTxt = "311:COMPRA";
                break;
            case 312:
                operTxt = "312:IMPORTACION";
                break;
            case 314:
                operTxt = "314:CAMBIO";
                break;
            case 316:
                operTxt = "316:DEVOLUCION";
                break;
            case 317:
                operTxt = "317:DONACION";
                break;
            case 318:
                operTxt = "318:TRASPASO";
                break;
            case 319:
                operTxt = "319:ALTA AUD.";
                break;
            case 321: 
                operTxt = "321:VENTA";
                break;
            case 322:
                operTxt = "322:ENTREGA";
                break;
            case 323:
                operTxt = "322:PRESTAMO";
                break;
            case 324:
                operTxt = "324:CAMBIO";
                break;
            case 325:
                operTxt = "325:";
                break;
            case 326:
                operTxt = "326:DEVOLUCION";
                break;
            case 327:
                operTxt = "327:DONACION";
                break;
            case 328:
                operTxt = "328:TRASPASO";
                break;
            case 329:
                operTxt = "329:BAJA AUD.";
                break;
            case 351:
                operTxt = "351:INTERNAC.";
                break;
            case 352:
                operTxt = "352:NACIONAL";
                break;
            case 353:
                operTxt = "353:LOCAL";
                break;
            case 341:
                operTxt = "341:FABRICA";
                break;
            case 342:
                operTxt = "341:NACIONAL";
                break;
            case 343:
                operTxt = "341:LOCAL";
                break;
            default:
                operTxt = "000:OTROS";
        }        
        return (operTxt);
    }

        
}
    
    

