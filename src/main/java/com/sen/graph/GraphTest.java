package com.sen.graph;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/22 00:33
 * @Description:
 */
public class GraphTest {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        Graph graph = new Graph(5);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("C", "B");
        graph.addEdge("E", "B");
        graph.addEdge("D", "B");

        System.out.println(graph);

        for (int[] ints : graph.getAdjmat()) {
            System.out.println(Arrays.toString(ints));
        }

        graph.show();


    }
}
