/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades; 

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propiedad {
  
    public static String get(String propiedad) {
    String valor="";
    Properties propiedades = new Properties();
    InputStream entrada = null;

    try {
      entrada = new FileInputStream("src/resources/configuracion.properties");
        // cargamos el archivo de propiedades
        propiedades.load(entrada);
        // obtenemos las propiedades y las imprimimos
          //        System.out.println(propiedades.getProperty("clave"));
        valor = propiedades.getProperty(propiedad);
    } catch (IOException ex) {
         ex.printStackTrace();
    } finally {
        if (entrada != null) {
            try {
                entrada.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    return valor;
  }
}