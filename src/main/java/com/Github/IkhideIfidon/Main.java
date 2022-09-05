package com.Github.IkhideIfidon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        UndirectedGraph graph = new UndirectedGraph(13);
        int[][] edges = {{0, 5}, {4, 3}, {0, 1}, {9, 12}, {6, 4}, {5, 4},
                {0, 2}, {11, 12}, {9, 10}, {0, 6}, {7, 8}, {9, 11}, {5, 3}, {6, 7}};

        int[][] bipartiteEdges = {{0, 5}, {0, 6}, {0, 1}, {0, 2}, {1, 3}, {3, 5}, {4, 5},
                {4, 6}, {6, 8}, {8, 10}, {9, 10}, {9, 11}, {10, 12}, {11, 12}};

        int[][] edges2 = {{0, 1}, {0, 2}, {0, 5}, {1, 2}, {2, 3}, {2, 4}, {3, 4}, {3, 5}};

        for (int[] edge : edges)
            graph.addEdge(edge[0], edge[1]);

        System.out.println(graph);
        UndirectedGraph g = new UndirectedGraph(graph);
        System.out.println(g);
        g.addEdge(1, 3);
        System.out.println(g);
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


        final String file = "src/main/resources/graph.txt";
        try ( FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader) )

        {   UndirectedGraph graphFromFile = new UndirectedGraph(reader);
            System.out.println("This is from the input stream:\n" + graphFromFile.neighbors(0));
            System.out.println(graphFromFile.V());
            System.out.println(graphFromFile.E());
            System.out.println(graphFromFile);
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ConnectedComponents cc = new ConnectedComponents(graph);
        System.out.println(cc.id(11));

        Bipartiteness bipartite = new Bipartiteness(graph);
        System.out.println(bipartite.isTwoColorable());

        Cycle cycle = new Cycle(graph);
        System.out.println(cycle.hasCycle());

        String myFile = "src/main/resources/routes.txt";
        SymbolGraph st = new SymbolGraph(myFile, " ");
        System.out.println(st.G());

        Cycle cycle2 = new Cycle(st.G());
        System.out.println(cycle2.hasCycle());
        System.out.println(st.contains("atl"));
        System.out.println(st.index("Mco"));
        System.out.println(st.name(5));



    }
}