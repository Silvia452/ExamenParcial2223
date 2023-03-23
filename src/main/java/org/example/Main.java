package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Graph<Integer> g = new Graph<>();

        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);

        System.out.println("Graph:");
        System.out.println(g.onePath(1,6));

        /*List<Integer> expectedPath = new ArrayList<>(); expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4);*/

        //Se comprueba si el camino devuelto es igual al esperado. assertEquals(expectedPath, g.onePath(1, 4));


    }

}
