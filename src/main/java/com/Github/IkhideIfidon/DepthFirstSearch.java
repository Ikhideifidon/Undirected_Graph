package com.Github.IkhideIfidon;

public class DepthFirstSearch {
    private final boolean[] marked;
    private int count;

    public DepthFirstSearch(UndirectedGraph graph, int source) {
        marked = new boolean[graph.V()];
        dfs(graph, source);

    }

    private void dfs(UndirectedGraph graph, int source) {
        marked[source] = true;
        count++;

        for(int w : graph.neighbors(source)) {
            if (!marked[w])
                dfs(graph, w);
        }
    }

    public boolean marked(int w) { return marked[w]; }

    public int count() { return count; }
}
