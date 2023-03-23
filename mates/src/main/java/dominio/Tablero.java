package dominio;

import java.io.File;
import java.util.Random;

public class Tablero {
    private static int DIMENSION = 30; // Dimensiones del tablero
    private int[][] estadoActual;
    private int[][] estadoSiguiente = new int[DIMENSION][DIMENSION];
    File archivo = new File("matriz.txt"); //crea un archivo matriz

    public void leerEstadoActual() {

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (estadoSiguiente[i][j] == 1) {
                    System.out.println("X");
                } else { //si es 0, te imprime un espacio en blanco
                    System.out.println(" ");
                }
                System.out.println();
            }
        }

        for (int i=0; i<DIMENSION; i++) {
            for (int j=0; j<DIMENSION; j++) {
                estadoActual[i][j] = estadoSiguiente[i][j];
            }
        }


        for (int i=0; i<DIMENSION; i++) {
            for (int j=0; j<DIMENSION; j++) {
                estadoSiguiente[i][j] = 0;
            }
        }
    }


    public void generarEstadoActualPorMontecarlo() {
        Random rand = new Random();
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoSiguiente[i][j] = rand.nextInt(2);
            }
        }
        leerEstadoActual();

    }


    public void transitarAlEstadoSiguiente() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                int vecinos = 0;
                if (i > 0 && j > 0 && estadoSiguiente[i - 1][j - 1] == 1) {
                    vecinos++;
                }
                if (i > 0 && estadoSiguiente[i - 1][j] == 1) {
                    vecinos++;
                }
                if (i > 0 && j < DIMENSION - 1 && estadoSiguiente[i - 1][j + 1] == 1) {
                    vecinos++;
                }
                if (j > 0 && estadoSiguiente[i][j - 1] == 1) {
                    vecinos++;
                }
                if (j < DIMENSION - 1 && estadoSiguiente[i][j + 1] == 1) {
                    vecinos++;
                }
                if (i < DIMENSION - 1 && j > 0 && estadoSiguiente[i + 1][j - 1] == 1) {
                    vecinos++;
                }
                if (i < DIMENSION - 1 && estadoSiguiente[i + 1][j] == 1) {
                    vecinos++;
                }
                if (i < DIMENSION - 1 && j < DIMENSION - 1 && estadoSiguiente[i + 1][j + 1] == 1) {
                    vecinos++;
                }
                if (estadoSiguiente[i][j] == 1) {
                    if (vecinos < 2 || vecinos > 3) {
                        estadoSiguiente[i][j] = 0;
                    }
                } else {
                    if (vecinos == 3) {
                        estadoSiguiente[i][j] = 1;
                    }
                }
            }
        }

    }

    @Override
    public String toString() {
        // Esta línea hay que modificarla. }
        String estado = "";
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (estadoSiguiente[i][j] == 1) {
                    estado += "X";
                } else {
                    estado += " ";
                }
            }
            estado += "";

        }
        return estado;
    }
}
