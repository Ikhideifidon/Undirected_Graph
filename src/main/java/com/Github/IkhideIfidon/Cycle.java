package com.Github.IkhideIfidon;

public class Cycle {

    // Instance Variables
    private final boolean[] marked;
    private boolean hasCycle;

    public Cycle(UndirectedGraph graph) {
        marked = new boolean[graph.V()];
        for (int s = 0; s < graph.V(); s++) {
            if (!marked[s])
                dfs(graph, s, s);
        }
    }

    private void dfs(UndirectedGraph graph, int s, int v) {
        marked[s] = true;
        for (int neighbor : graph.neighbors(s)) {
            if (!marked[neighbor])
                dfs(graph, neighbor, s);
            else
                if (neighbor != v)
                    hasCycle = true;
        }
    }

    public boolean hasCycle() { return hasCycle; }
}
