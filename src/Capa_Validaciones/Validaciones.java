package Capa_Validaciones;

import CapaInterfaces.Registro_Solicitud_Mantenimiento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class Validaciones {
    //Esta funcion se utiliza para validar tanto modelo como serie en activos
    public static String validarmayusculasynumeros(String texto){
        String validos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        int i,j,coinci = 0;
        String cadena = texto;
        String mensaje="";
        for (j = 0; j <= cadena.length(); j++) {
            for (i = 0; i < validos.length(); i++) {

                if (cadena.charAt(j) == validos.charAt(i)) {
                    coinci++;

                }

            }

        }
        if (cadena.length() == coinci) {
             System.out.println("todos los caracteres son validos");
             mensaje="caracteres correctos";
         } else {
             System.out.println("hay al menos algún caracter que no es valido. Solo se consideran validos los siguientes carecteres" + "  " + validos);
             mensaje="hay al menos algún caracter que no es valido. Solo se consideran validos los siguientes carecteres "+validos;
           
        }
         return mensaje;
    }
    //Esta funcion se utiliza para validar el codigo de oficio interno
    public static String validarmaynumguion(String texto){
        String validos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-";

        int i,j,coinci = 0;
        String cadena = texto;
        String mensaje="";
        for (j = 0; j <= cadena.length(); j++) {
            for (i = 0; i < validos.length(); i++) {

                if (cadena.charAt(j) == validos.charAt(i)) {
                    coinci++;

                }

            }

        }
        if (cadena.length() == coinci) {
             System.out.println("todos los caracteres son validos");
            mensaje="caracteres correctos";
            
        } else {
            
            System.out.println("hay al menos algún caracter que no es valido. Solo se consideran validos los siguientes carecteres" + "  " + validos);
            mensaje="hay al menos algún caracter que no es valido. Solo se consideran validos los siguientes carecteres "+validos;
           
        }
         return mensaje;
    }
    //Esta funcion se utiliza para validar el codigo institucional
    public static String validarmayminnumguion(String texto){
        String validos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-";

        int i,j,coinci = 0;
        String cadena = texto;
        String mensaje="";
        for (j = 0; j <= cadena.length(); j++) {
            for (i = 0; i < validos.length(); i++) {

                if (cadena.charAt(j) == validos.charAt(i)) {
                    coinci++;

                }

            }

        }
        if (cadena.length() == coinci) {
             System.out.println("todos los caracteres son validos");
            mensaje="caracteres correctos";
            
        } else {
            
            System.out.println("hay al menos algún caracter que no es valido. Solo se consideran validos los siguientes carecteres" + "  " + validos);
            mensaje="hay al menos algún caracter que no es valido. Solo se consideran validos los siguientes carecteres "+validos;
           
        }
         return mensaje;
    }
    // Con este metodo validamos la fecha minima y la fecha maxima que se puede ingresar
    //OJO esto se llama despues del initComponents()
    public void validaciondefecha(com.toedter.calendar.JDateChooser fecha_docSolicitud ){
        ((JTextField) fecha_docSolicitud.getDateEditor()).setEditable(false);  
        SimpleDateFormat simpleDateFormat_formatoFecha = new SimpleDateFormat("d/MM/yyyy");                 
        Date date_fechaMinima=null;
        Date date_fechaMaxima = new Date();        
        try {            
            date_fechaMinima= simpleDateFormat_formatoFecha.parse("01/01/2015");
        } catch (ParseException ex) {
            Logger.getLogger(Registro_Solicitud_Mantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }   
        fecha_docSolicitud.setSelectableDateRange(date_fechaMinima, date_fechaMaxima);
    }
    private com.toedter.calendar.JDateChooser date_fecha_docSolicitud;
}
