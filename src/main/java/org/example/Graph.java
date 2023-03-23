package org.example;

import java.util.*;

public class Graph <V>{
    private Map<V, Set<V>> adjacencyList = new HashMap<>();
    public boolean addVertex(V v) {

        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new HashSet<V>());
            return true;
        }
        return false;
    }

    public boolean addEdge(V v1, V v2) {

        addVertex(v1);
        addVertex(v2);
        Set<V> adyacents1 = adjacencyList.get(v1); //obtiene los adyacentes de v1
        if (adyacents1.contains(v2)) {
            return false;
        }
        adyacents1.add(v2);
        return true;
    }
    public Set<V> obtainAdjacents(V v) throws Exception {
        if (!adjacencyList.containsKey(v)) {
            throw new Exception("Vertex does not exist");
        }
        return adjacencyList.get(v);
    }

    public boolean containsVertex(V v) {
        return adjacencyList.containsKey(v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (V vertex : adjacencyList.keySet()) {
            sb.append(vertex.toString());
            sb.append(": ");
            sb.append(adjacencyList.get(vertex).toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<V> onePath(V v1, V v2) throws Exception {
        Map<V, V> trace = new HashMap<>();
        Stack<V> open = new Stack<>();
        open.push(v1);
        trace.put(v1, null);
        boolean found = false;

        while (!open.isEmpty() && !found) {
            V v = open.pop();
            found = v.equals(v2);
            if (found) {
                break;
            }
            for (V s : obtainAdjacents(v)) {
                if (!trace.containsKey(s)) {
                    open.push(s);
                    trace.put(s, v);
                }
            }
        }

        if (found) {
            List<V> path = new ArrayList<>();
            V curr = v2;
            while (curr != null) {
                path.add(0, curr);
                curr = trace.get(curr);
            }
            return path;
        } else {
            return null;
        }
    }
}



