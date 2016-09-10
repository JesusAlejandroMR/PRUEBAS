/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaInterfaces;

import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author jeanp
 */
public class Validacion {

    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;
        try {
            if (cedula.length() == 10) {
                int PrimerDigito = Integer.parseInt(cedula.substring(0, 1)),
                        SegundoDigito = Integer.parseInt(cedula.substring(1, 2));
                if (PrimerDigito == 2 && SegundoDigito >= 5) {
                    JOptionPane.showMessageDialog(null, "La Cédula ingresada es Incorrecta ");
                    return cedulaCorrecta;
                } else if (PrimerDigito > 3) {
                    JOptionPane.showMessageDialog(null, "La Cédula ingresada es Incorrecta ");
                    return cedulaCorrecta;
                } else if (PrimerDigito < 3) {
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }
                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;

                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }

        } catch (NumberFormatException e) {
            cedulaCorrecta = false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }
        if (!cedulaCorrecta) {
            JOptionPane.showMessageDialog(null, "La Cédula ingresada es Incorrecta ");

        }

        return cedulaCorrecta;
    }

    
    public boolean validadorDeNombres(String nombres) {
        Pattern pat = Pattern.compile("[a-ñzA-ÑZ]");
        Matcher mat = pat.matcher(nombres);
        if (mat.matches()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Datos incorrectos ");
            return false;
        }

    }

}
