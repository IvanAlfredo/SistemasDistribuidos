/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;
 
/** 
 *
 * @author Ramiro
 */
public class Validacion {

   static public void validarletras(java.awt.event.KeyEvent evt, javax.swing.JTextField campo){
        Character c=new Character(evt.getKeyChar());
        Character aux;
        // 16=shift 10=enter 20=bloq mayus 8=backspace 37=flecha izq 39=flecha der 127=supr
        if(!(Character.isLetter(c))&&c!=' '&&c!=8&&evt.getKeyCode()!=16&&c!=10&&evt.getKeyCode()!=20&&evt.getKeyCode()!=37&&evt.getKeyCode()!=39&&evt.getKeyCode()!=127)
        {
            String texto="";
            for(int i=0; i<campo.getText().length();i++)
            {
                aux=new Character(campo.getText().charAt(i));
                if((Character.isLetter(aux))||aux==' '||aux==8||aux==13||evt.getKeyCode()==16||c==10||evt.getKeyCode()==20||evt.getKeyCode()==37||evt.getKeyCode()==39||evt.getKeyCode()==127)
                    texto += aux;
            }
            campo.setText(texto);
//            getToolkit().beep();
        }
    }

    static public void validarletras(java.awt.event.KeyEvent evt, javax.swing.JTextArea campo){
        Character c=new Character(evt.getKeyChar());
        Character aux;
        // 16=shift 10=enter 20=bloq mayus 8=backspace 37=flecha izq 39=flecha der 127=supr
        if(!(Character.isLetter(c))&&c!=' '&&c!=8&&evt.getKeyCode()!=16&&c!=10&&evt.getKeyCode()!=20&&evt.getKeyCode()!=37&&evt.getKeyCode()!=39&&evt.getKeyCode()!=127)
        {
            String texto="";
            for(int i=0; i<campo.getText().length();i++)
            {
                aux=new Character(campo.getText().charAt(i));
                if((Character.isLetter(aux))||aux==' '||aux==8||aux==13||evt.getKeyCode()==16||c==10||evt.getKeyCode()==20||evt.getKeyCode()==37||evt.getKeyCode()==39||evt.getKeyCode()==127)
                    texto += aux;
            }
            campo.setText(texto);
//            getToolkit().beep();
        }
    }
    
    static public void validarletrasynum(java.awt.event.KeyEvent evt, javax.swing.JTextField campo){
        Character c=new Character(evt.getKeyChar());
        Character aux;
        // 16=shift 10=enter 20=bloq mayus 8=backspace 37=flecha izq 39=flecha der 127=supr
        if(!(Character.isDigit(c))&&!(Character.isLetter(c))&&c!=' '&&c!=8&&evt.getKeyCode()!=16&&c!=10&&evt.getKeyCode()!=20&&evt.getKeyCode()!=37&&evt.getKeyCode()!=39&&evt.getKeyCode()!=127)
        {
            String texto="";
            for(int i=0; i<campo.getText().length();i++)
            {
                aux=new Character(campo.getText().charAt(i));
                if((Character.isDigit(aux))&&(Character.isLetter(aux))||aux==' '||aux==8||aux==13||evt.getKeyCode()==16||c==10||evt.getKeyCode()==20||evt.getKeyCode()==37||evt.getKeyCode()==39||evt.getKeyCode()==127)
                    texto += aux;
            }
            campo.setText(texto);
//            getToolkit().beep();
        }
    }
  
    static public void validarletrasynum(java.awt.event.KeyEvent evt, javax.swing.JTextArea campo){
        Character c=new Character(evt.getKeyChar());
        Character aux;
        // 16=shift 10=enter 20=bloq mayus 8=backspace 37=flecha izq 39=flecha der 127=supr
        if(!(Character.isDigit(c))&&!(Character.isLetter(c))&&c!=' '&&c!=8&&evt.getKeyCode()!=16&&c!=10&&evt.getKeyCode()!=20&&evt.getKeyCode()!=37&&evt.getKeyCode()!=39&&evt.getKeyCode()!=127)
        {
            String texto="";
            for(int i=0; i<campo.getText().length();i++)
            {
                aux=new Character(campo.getText().charAt(i));
                if((Character.isDigit(aux))&&(Character.isLetter(aux))||aux==' '||aux==8||aux==13||evt.getKeyCode()==16||c==10||evt.getKeyCode()==20||evt.getKeyCode()==37||evt.getKeyCode()==39||evt.getKeyCode()==127)
                    texto += aux;
            }
            campo.setText(texto);
//            getToolkit().beep();
        }
    }
    
    static public void validarnumeros(java.awt.event.KeyEvent evt, javax.swing.JTextField campo){
        Character c=new Character(evt.getKeyChar());
        Character aux;
        // 16=shift 10=enter 20=bloq mayus 8=backspace 37=flecha izq 39=flecha der 127=supr
        if(!(Character.isDigit(c))&&c!='.'&&c!=8&&evt.getKeyCode()!=16&&c!=10&&evt.getKeyCode()!=20&&evt.getKeyCode()!=37&&evt.getKeyCode()!=39&&evt.getKeyCode()!=127)
        {
            String texto="";
            for(int i=0; i<campo.getText().length();i++)
            {
                aux=new Character(campo.getText().charAt(i));
                if((Character.isDigit(aux))||aux=='.'||aux==8||aux==13||evt.getKeyCode()==16||c==10||evt.getKeyCode()==20||evt.getKeyCode()==37||evt.getKeyCode()==39||evt.getKeyCode()==127)
                    texto += aux;
            }
            campo.setText(texto);
//            getToolkit().beep();
        }
        if(campo.getText().length()>8)
        {
            campo.setText(campo.getText().substring(0,8));
//            getToolkit().beep();
        }        
    }

    static public void validardigitos(java.awt.event.KeyEvent evt, javax.swing.JTextField campo){
        Character c=new Character(evt.getKeyChar());
        Character aux;
        // 16=shift 10=enter 20=bloq mayus 8=backspace 37=flecha izq 39=flecha der 127=supr
        if(!(Character.isDigit(c))&&c!=8&&evt.getKeyCode()!=16&&c!=10&&evt.getKeyCode()!=20&&evt.getKeyCode()!=37&&evt.getKeyCode()!=39&&evt.getKeyCode()!=127)
        {
            String texto="";
            for(int i=0; i<campo.getText().length();i++)
            {
                aux=new Character(campo.getText().charAt(i));
                if((Character.isDigit(aux))||aux==8||aux==13||evt.getKeyCode()==16||c==10||evt.getKeyCode()==20||evt.getKeyCode()==37||evt.getKeyCode()==39||evt.getKeyCode()==127)
                    texto += aux;
            }
            campo.setText(texto);
//            getToolkit().beep();
        }
        if(campo.getText().length()>10)
        {
            campo.setText(campo.getText().substring(0,10));
//            getToolkit().beep();
        }        
    }

    static public void validardigitosLargo(java.awt.event.KeyEvent evt, javax.swing.JTextField campo){
        Character c=new Character(evt.getKeyChar());
        Character aux;
        // 16=shift 10=enter 20=bloq mayus 8=backspace 37=flecha izq 39=flecha der 127=supr
        if(!(Character.isDigit(c))&&c!=8&&evt.getKeyCode()!=16&&c!=10&&evt.getKeyCode()!=20&&evt.getKeyCode()!=37&&evt.getKeyCode()!=39&&evt.getKeyCode()!=127)
        {
            String texto="";
            for(int i=0; i<campo.getText().length();i++)
            {
                aux=new Character(campo.getText().charAt(i));
                if((Character.isDigit(aux))||aux==8||aux==13||evt.getKeyCode()==16||c==10||evt.getKeyCode()==20||evt.getKeyCode()==37||evt.getKeyCode()==39||evt.getKeyCode()==127)
                    texto += aux;
            }
            campo.setText(texto);
//            getToolkit().beep();
        }
        if(campo.getText().length()>15)
        {
            campo.setText(campo.getText().substring(0,15));
//            getToolkit().beep();
        }        
    }
    
    static public void validartelefono(java.awt.event.KeyEvent evt, javax.swing.JTextField campo){
        Character c=new Character(evt.getKeyChar());
        Character aux;
        // 16=shift 10=enter 20=bloq mayus 8=backspace 37=flecha izq 39=flecha der 127=supr
        if(!(Character.isDigit(c))&&c!='-'&&c!='('&&c!=')'&&c!=8&&evt.getKeyCode()!=16&&c!=10&&evt.getKeyCode()!=20&&evt.getKeyCode()!=37&&evt.getKeyCode()!=39&&evt.getKeyCode()!=127)
        {
            String texto="";
            for(int i=0; i<campo.getText().length();i++)
            {
                aux=new Character(campo.getText().charAt(i));
                if((Character.isDigit(aux))||aux=='-'||aux=='('||aux==')'||aux==8||aux==13||evt.getKeyCode()==16||c==10||evt.getKeyCode()==20||evt.getKeyCode()==37||evt.getKeyCode()==39||evt.getKeyCode()==127)
                    texto += aux;
            }
            campo.setText(texto);
//            getToolkit().beep();
        }
        if(campo.getText().length()>15)
        {
            campo.setText(campo.getText().substring(0,15));
//            getToolkit().beep();
        }
    }

    static public void validaremail(java.awt.event.KeyEvent evt, javax.swing.JTextField campo){
        Character c=new Character(evt.getKeyChar());
        Character aux;
        // 16=shift 10=enter 20=bloq mayus 8=backspace 37=flecha izq 39=flecha der 127=supr
        if(!(Character.isDigit(c))&&!(Character.isLetter(c))&&c!='@'&&c!='-'&&c!='_'&&c!='.'&&c!=8&&evt.getKeyCode()!=16&&c!=10&&evt.getKeyCode()!=20&&evt.getKeyCode()!=37&&evt.getKeyCode()!=39&&evt.getKeyCode()!=127)
        {
            String texto="";
            for(int i=0; i<campo.getText().length();i++)
            {
                aux=new Character(campo.getText().charAt(i));
                if((Character.isDigit(aux))||(Character.isLetter(aux))||aux=='@'||aux=='-'||aux=='_'||aux=='.'||aux==8||aux==13||evt.getKeyCode()==16||c==10||evt.getKeyCode()==20||evt.getKeyCode()==37||evt.getKeyCode()==39||evt.getKeyCode()==127)
                    texto += aux;
            }
            campo.setText(texto);
//            getToolkit().beep();
        }
    }

  static public void validarcodigo(java.awt.event.KeyEvent evt, javax.swing.JTextField campo){
        Character c=new Character(evt.getKeyChar());
        Character aux;
        // 16=shift 10=enter 20=bloq mayus 8=backspace 37=flecha izq 39=flecha der 127=supr
        if(!(Character.isDigit(c))&&!(Character.isLetter(c))&&c!='-'&&c!='_'&&c!='.'&&c!=8&&evt.getKeyCode()!=16&&c!=10&&evt.getKeyCode()!=20&&evt.getKeyCode()!=37&&evt.getKeyCode()!=39&&evt.getKeyCode()!=127)
        {
            String texto="";
            for(int i=0; i<campo.getText().length();i++)
            {
                aux=new Character(campo.getText().charAt(i));
                if((Character.isDigit(aux))||(Character.isLetter(aux))||aux=='-'||aux=='_'||aux=='.'||aux==8||aux==13||evt.getKeyCode()==16||c==10||evt.getKeyCode()==20||evt.getKeyCode()==37||evt.getKeyCode()==39||evt.getKeyCode()==127)
                    texto += aux;
            }
            campo.setText(texto);
//            getToolkit().beep();
        }
    }

    static public void validarpositivo(java.awt.event.KeyEvent evt, javax.swing.JTextField campo){
        Character c=new Character(evt.getKeyChar());
        Character aux;
        // 16=shift 10=enter 20=bloq mayus 8=backspace 37=flecha izq 39=flecha der 127=supr
        if(!(Character.isDigit(c))&&c!='.'&&c!=8&&evt.getKeyCode()!=16&&c!=10&&evt.getKeyCode()!=20&&evt.getKeyCode()!=37&&evt.getKeyCode()!=39&&evt.getKeyCode()!=127)
        {
            String texto="";
            for(int i=0; i<campo.getText().length();i++)
            {
                aux=new Character(campo.getText().charAt(i));
                if((Character.isDigit(aux))||aux=='.'||aux==8||aux==13||evt.getKeyCode()==16||c==10||evt.getKeyCode()==20||evt.getKeyCode()==37||evt.getKeyCode()==39||evt.getKeyCode()==127)
                    texto += aux;
            }
            campo.setText(texto);
//            getToolkit().beep();
        }
        if(campo.getText().length()>8)
        {
            campo.setText(campo.getText().substring(0,8));
//            getToolkit().beep();
        }
    }
    
    static public void porcentaje(java.awt.event.KeyEvent evt, javax.swing.JTextField campo){
        Double valor= Double.valueOf(campo.getText());
        if(valor>100)
            valor=100.00;
        else
            valor=Double.valueOf(Math.round(valor*100))/100;
        campo.setText(valor+"");
    }

    static public void rangoentero(java.awt.event.KeyEvent evt, javax.swing.JTextField campo, int a, int b){
        Character c=new Character(evt.getKeyChar());
        Character aux;
        int valor=0;
        // 16=shift 10=enter 20=bloq mayus 8=backspace 37=flecha izq 39=flecha der 127=supr
        if(!(Character.isDigit(c))&&c=='.'&&c!=8&&evt.getKeyCode()!=16&&c!=10&&evt.getKeyCode()!=20&&evt.getKeyCode()!=37&&evt.getKeyCode()!=39&&evt.getKeyCode()!=127)
        {
            String texto="";
            for(int i=0; i<campo.getText().length();i++)
            {
                aux=new Character(campo.getText().charAt(i));
                if((Character.isDigit(aux))||aux==8||aux==13||evt.getKeyCode()==16||c==10||evt.getKeyCode()==20||evt.getKeyCode()==37||evt.getKeyCode()==39||evt.getKeyCode()==127)
                    texto += aux;
            }
            campo.setText(texto);
        }
        if(campo.getText().length()>8)
        {
            campo.setText(campo.getText().substring(0,8));
        }
        if (!campo.getText().isEmpty()) {
            try {valor = Integer.parseInt(campo.getText());}
            catch (Exception e) { valor=0;}
            if (valor<a) valor=a;
            else if (valor>b) valor=b;
            campo.setText(valor+"");
        }
    }

    static public void rangoreal(java.awt.event.KeyEvent evt, javax.swing.JTextField campo, double a, double b){
        Character c=new Character(evt.getKeyChar());
        Character aux; double valor=0.0;
        // 16=shift 10=enter 20=bloq mayus 8=backspace 37=flecha izq 39=flecha der 127=supr
        if(!(Character.isDigit(c))&&c!='.'&&c!=8&&evt.getKeyCode()!=16&&c!=10&&evt.getKeyCode()!=20&&evt.getKeyCode()!=37&&evt.getKeyCode()!=39&&evt.getKeyCode()!=127)
        {
            String texto="";
            for(int i=0; i<campo.getText().length();i++)
            {
                aux=new Character(campo.getText().charAt(i));
                if((Character.isDigit(aux))||aux=='.'||aux==8||aux==13||evt.getKeyCode()==16||c==10||evt.getKeyCode()==20||evt.getKeyCode()==37||evt.getKeyCode()==39||evt.getKeyCode()==127)
                    texto += aux;
            }
            campo.setText(texto);
//            getToolkit().beep();
        }
        if(campo.getText().length()>8)
        {
            campo.setText(campo.getText().substring(0,8));
//            getToolkit().beep();
        }
        if (!campo.getText().isEmpty()) {
            try {valor = Double.parseDouble(campo.getText());
                if (valor<a) campo.setText(a+"");
                else if (valor>b) campo.setText(b+"");
            }
            catch (Exception e) { campo.setText("0.0");}
        }
    }
    
    static public double division(double num, double den) {
        double res=0;
        if (den!=0) res= num / den; 
        return res;
    }

    static public double division(int num, int den) {
        double res=0;
        if (den!=0) res= (double) num / den;
        return res;
    }
}
