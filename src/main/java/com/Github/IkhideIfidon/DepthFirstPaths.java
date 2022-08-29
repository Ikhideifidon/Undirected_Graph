package com.Github.IkhideIfidon;

import java.util.*;

/**
 * This API finds paths in a Graph G from source
 * **/
public class DepthFirstPaths {

    // Instance Variables
    private final boolean[] marked;
    private final int[] edgeTo;                     // last vertex on known path to this vertex
    private final int source;
    private int connectedVertexCount;

    public DepthFirstPaths(UndirectedGraph graph, int source) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.source = source;
        dfs(graph, source);
    }

    private void dfs(UndirectedGraph graph, int v) {
        marked[v] = true;
        connectedVertexCount++;
        for (int w : graph.neighbors(v)) {
            if (!marked[w]) {                   // Not visited
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v) { return marked[v]; }
    public  int connectedVertexCount() { return connectedVertexCount; }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;

        Deque<Integer> path = new LinkedList<>();
        for (int value = v; value != source; value = edgeTo[value])
            path.push(value);
        path.push(source);
        return path;
    }

    public List<List<Integer>> allPathsFromSource(int source) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = source; i < connectedVertexCount(); i++) {
            result.add((List<Integer>) pathTo(i));
        }
        return result;
    }

}
