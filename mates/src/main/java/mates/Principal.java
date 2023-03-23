package mates;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args){
        int puntos = 1000; // valor por defecto
        if (args.length > 0) {
            puntos = Integer.parseInt(args[0]);
        }
        System.out.println("El número PI es " + Matematicas.generarNumeroPi(puntos));
    }


}
