package secuenciales;

import javax.swing.JOptionPane;

/**
 *
 * @author camila
 */
public class Secuencial_Multiplicativo {

    public static void main(String[] args) {
        int a, x, k, R, c, primo = 0;
        double m, periodo, d;
        boolean aux;
        int contador = 1;//contabiliza el periodo total 

        d = Double.parseDouble(JOptionPane.showInputDialog(null, "Para poder obtener el modulo 'm =2^d'\n"
                + "Ingrese un valor para 'd'" + "Valor D",
                JOptionPane.INFORMATION_MESSAGE)); // Para obtener m la sacamos de la formula

        m = Math.pow(2, d);// Para obtener m 'm=2^d' se utiliza el valor ingreado de 'd'
        aux = true;//valor booleano para saber si k es un entero
        int num = 0;//esta variable almacenara el valor para k que ingrese el ususario

        while (aux) {//el bucle while se repetira hasta que el usuario ingrese un numero entero
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de K para calcular a = 5 + (8 * k)", JOptionPane.ERROR_MESSAGE));
                aux = false;
            } catch (NumberFormatException e) {
            }
        }
       k = num;//una vez comprobado que la variable num almacena unicamente un numero entero a la variable K se le asigna este valo
        a = 5 + (8 * k);//para obtener el valor del multiplicador 'a' se lo hace a partir de:
        //  5 + (8 * k)

        //El for permite encontrar el primo maximo de todos los numero, se inicia el bucle a partir de la 
        //variable (m-1)
        //la variable 'primo' sera la que almacene al 'primo maximo'
        for (int i = (int) (m /4); i >= 0; i--) {
            if (esPrimo(i)) {
                primo = i;
                System.out.println("El primo maximo es: " + i);
                break;
            }
        }

        c = primo;//a la variable c le asignamos el valor de primo

        x = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el valor de la semilla=x",
                JOptionPane.INFORMATION_MESSAGE));//se pide ingresar el valor para la semilla

        periodo = m / 4;//La variable periodo almacena periodo actual a partir de la 'semilla sobre el modulo' (x/m)

        System.out.println("n" + "     Xn   " + "    Xn+1   ");

        for (int i = 0; i < m/4; i++) {
            R = (int) (((a * x)) % m);//la variable R almacena el resulatdos de aplicar la formula para el secuencial multiplicativo
            System.out.println(i + "      " + x + "        " + R);
            x = R;//a la variable de la semilla le asignamos un nuevo valor en este caso R

            //en el bucle if se comprueba si el valor de la variable periodo es igual a (R/m)
            //si se cumple empleamos un contador incrementara y sesabra el total de periodos
            if (i == (m / 4)-1) {
                System.out.println("\n Va " + contador + " periodo(s)");
                contador++;
            }
        }
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
