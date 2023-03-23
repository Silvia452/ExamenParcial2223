package mates;

import java.util.Random;
import java.util.Scanner;

public class Matematicas {
    //esta dando pistas pero no se enterran

    public static double generarNumeroPi(double pasos) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Inserte número de puntos a generar: ");
        int puntosTotales = sn.nextInt();
        int aciertos = 0;
        double areaCuadrado = 4.0;

        Random rnd = new Random(); //se hace random

        for (int i = 1; i <= puntosTotales; i++) {
            double x = rnd.nextDouble() * 2 - 1; // número aleatorio entre -1 y 1
            double y = rnd.nextDouble() * 2 - 1; // número aleatorio entre -1 y 1
            if (Math.sqrt(x * x + y * y) <= 1) {
                aciertos++; // dentro del círculo se suman
            }
        }

        return areaCuadrado * aciertos/puntosTotales;

    }
}
