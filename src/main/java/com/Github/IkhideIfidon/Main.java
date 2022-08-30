package com.Github.IkhideIfidon;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UndirectedGraph graph = new UndirectedGraph(13);
        int[][] edges = {{0, 5}, {4, 3}, {0, 1}, {9, 12}, {6, 4}, {5, 4},
                {0, 2}, {11, 12}, {9, 10}, {0, 6}, {7, 8}, {9, 11}, {5, 3}};

        int[][] edges2 = {{0, 1}, {0, 2}, {0, 5}, {1, 2}, {2, 3}, {2, 4}, {3, 4}, {3, 5}};

        for (int[] edge : edges)
            graph.addEdge(edge[0], edge[1]);

        System.out.println(graph);
        System.out.println(graph.degree(5));
        System.out.println(graph.maximumDegree());
        System.out.println(graph.neighbors(0));
        System.out.println(graph.numberOfSelfLoops());

        int source = 0;
        int destination = 3;
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, source);
        System.out.println(depthFirstPaths.pathTo(destination));
        System.out.println(depthFirstPaths.allPathsFromSource(source));
        System.out.println(depthFirstPaths.connectedVertexCount());


        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph, source);
        System.out.println(breadthFirstSearch.marked(2));
        System.out.println(breadthFirstSearch.pathTo(3));
        System.out.println(breadthFirstSearch.allPathsFromSource());


//        FileInputStream file = new FileInputStream("graph.txt");
//        UndirectedGraph graph2 = new UndirectedGraph(file);
//        System.out.println(graph2.neighbors(0));
    }
}