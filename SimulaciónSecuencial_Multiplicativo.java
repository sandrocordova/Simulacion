/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulación;

import javax.swing.JOptionPane;

/**
 *
 * @author camila
 */
public class SimulaciónSecuencial_Multiplicativo {

    public static void main(String[] args) {
        int R, c, primo = 0;
        String cadena = "";//almacena el resultado en una cadena de caracteres

        int contador = 1;//contabiliza el periodo total 

        double d = Double.parseDouble(JOptionPane.showInputDialog(null, "Para poder obtener m =2^d," + "/n"
                + "  Igrese el valor de D", "Valor D", JOptionPane.INFORMATION_MESSAGE));// Para obtener m la sacamos de la formula
        //m=2^d, asi que m se calcula a partir de este valor

        double m = Math.pow(2, d);

        boolean aux = true;//valor booleano para saber si k es un entero

        int num = 0;//esta variable almacenara el valor para k que ingrese el ususario

        //el bucle while se repetira hasta que el usuario ingrese un numero entero
        while (aux) {
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de K para calcular a = 3 + (8 * k)", JOptionPane.ERROR_MESSAGE));
                aux = false;
            } catch (NumberFormatException e) {
            }
        }

        int k = num;//una vez comprobado que la variable num almacena unicamente un numero entero a la variable K se le asigna este valo
        int a = 3 + (8 * k);//para obtener el valor de a se lo hace a partir de este formulo o bien con la sigiente: 5 + (8 * k)

        
        //lo que se hace en este for es encontrar el primo maximo de todos los numero, incia la comprobacion a partir de la 
        //variable (m-1)
        //la variable primo sera la que almacene al primo maximo
        for (int i = (int) (m - 1) ; i >= 0; i--) {
            if (esPrimo(i)) { 
                primo = i;
                cadena += "El primo maximo es:" + i;
                break;
            }
        }
        
        
        
        //a la variable c le asignamos el valor de primo
        c = primo;
        
        //se pide ingresar el valor para la semilla
        int x = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el valor de la semilla=x", JOptionPane.INFORMATION_MESSAGE));
        
        //periodo calcula el valor del periodo actual
        double periodo = x / m;
        
        
        for (int i = 0; i < m; i++) {
            R = (int) (((a * x)) % m);//la variable R almacena el resulatdos de aplicar la formula para el secuencial multiplicativo
            x = R;//a la variable de la semilla le asignamos un nuevo valor en este caso R
            cadena += "\n" + R;
            
            //en el bucle if se comprueba si el valor de la variable periodo es igual a (R/m)
            //si se cumple empleamos un contador incrementara y sesabra el total de periodos
            if (periodo == R / m) {
                cadena += "\n Va " + contador + " periodo(s)";
                System.out.println("\n Va " + contador + " periodo(s)");
                contador++;
            }
        }
        JOptionPane.showMessageDialog(null, cadena);
    }

    
    //Metodo que al ingresar un valor numerico nos retorna true si se ha ingresado un valor primo, caso contrario retornara false
    public static boolean esPrimo(int numero) {
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != numero)) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }

        return primo;
    }

}
