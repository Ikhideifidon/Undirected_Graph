package com.Github.IkhideIfidon;
/**
 * -1 denotes RED
 * 1 denotes BLUE
 * **/
public class Bipartiteness {

    // Instance Variables
    private final boolean[] color;
    private final boolean[] marked;
    private boolean isTwoColorable = true;

    public Bipartiteness(UndirectedGraph graph) {
        color = new boolean[graph.V()];
        marked = new boolean[graph.V()];

        for (int s = 0; s < graph.V(); s++) {
            if (!marked[s])
                dfs(graph, s);
        }
    }

    private void dfs(UndirectedGraph graph, int v) {
        marked[v] = true;
        for (int w : graph.neighbors(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(graph, w);
            }
             else
                 if (color[w] == color[v])
                     isTwoColorable = false;
        }
    }

    public boolean isTwoColorable() {
        return isTwoColorable;
    }
}
