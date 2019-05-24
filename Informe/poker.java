/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulación;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Sandro Córdova
 */
public class poker {

    private static int contPares = 0, contDosPares = 0, contTripe = 0, contFull = 0, contQuintilla = 0, contPoker = 0, contDiferentes = 0;

    public static void main(String[] args) {
        String resultado = "";
        String resultados = "";
        try {
            File archivo = new File("C:/Users/Sandro Córdova/Documents/SandroCordova.CSV");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            while ((linea = br.readLine()) != null) {
                resultado += linea + ";" + analizar(linea) + "\n";
            }
            br.close();
            String ruta = "C:/Users/Sandro Córdova/Documents/SandroCordova2.CSV";
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(resultado);
            bw.newLine();
            resultados = "\nDiferentes: " + contDiferentes + " \nPares: " + contPares
                    + " \nDoble Par: " + contDosPares + " \nTriple: " + contTripe
                    + " \nFull: " + contFull + " \nQuintilla: " + contQuintilla;
            bw.write(resultados);
            bw.close();
        } catch (Exception e) {
        }
        System.out.println(resultado);
        System.out.println(resultados);
    }

    public static String analizar(String entrada) {
        String aux = entrada;
        String str = aux.substring(aux.indexOf(".") + 1, aux.length());
        String resultado = "", arreglo = "";
        int cont = 0, contPar = 0, contTriple = 0;
        for (int i = 0; i < aux.length() - 2; i++) {
            String base = String.valueOf(str.charAt(i));
            if (!arreglo.contains(base)) {
                for (int j = i; j < aux.length() - 2; j++) {
                    String alternador = String.valueOf(str.charAt(j));
                    if (base.contains(alternador)) {
                        cont++;
                    }
                }
                if (cont == 2) {
                    resultado = "Un par";
                    contPares++;
                    contPar++;
                } else if (cont == 3) {
                    resultado = "Triple";
                    contTripe++;
                    contTriple++;
                } else if (cont == 4) {
                    resultado = "full";
                    contFull++;
                } else if (cont == 5) {
                    resultado = "Quintilla";
                    contQuintilla++;
                }
                cont = 0;
                arreglo += base;
            }

        }
        if (contPar == 2) {
            resultado = "Doble Par";
            contDosPares++;
        } else if (contTriple == 1 && contPar == 1) {
            resultado = "Poker";
            contPoker++;
        } else if (resultado.length() == 0) {
            resultado = "Todos diferentes";
            contDiferentes++;
        }
        return resultado;
    }

}
