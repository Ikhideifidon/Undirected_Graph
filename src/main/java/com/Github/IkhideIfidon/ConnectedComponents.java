package com.Github.IkhideIfidon;

public class ConnectedComponents {

    // Instance Variables
    private final boolean[] marked;
    private final int[] id;
    private int count;

    public ConnectedComponents(UndirectedGraph graph) {
        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        for (int s = 0; s < graph.V(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }

    }

    private void dfs(UndirectedGraph graph, int source) {
        marked[source] = true;
        id[source] = count;
        for (int w : graph.neighbors(source)) {
            if (!marked[w])
                dfs(graph, w);
        }
    }

    public boolean connected(int v, int w) { return id[v] == id[w]; }
    public int id(int v) { return id[v]; }
    public int count() { return count; }
}
