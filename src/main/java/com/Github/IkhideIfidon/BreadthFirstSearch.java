package com.Github.IkhideIfidon;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {

    // Instance Variables
    private final boolean[] marked;                           // Keep track of visited vertices
    private final int[] edgeTo;      // Keep track of the last vertex to the part of this vertex
    private final int source;            // Source vertex


    public BreadthFirstSearch(UndirectedGraph graph, int source) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.source = source;
        bfs(graph, source);
    }

    private void bfs(UndirectedGraph graph, int source) {
        marked[source] = true;
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for (int w : graph.neighbors(current)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = current;
                    queue.offer(w);
                }
            }
        }
    }

    public boolean marked(int v) {                       // Reachability
        if (0 <= v && v < marked.length)
            return marked[v];
        throw new ArrayIndexOutOfBoundsException(v + " is not a valid vertex");
    }


    public Iterable<Integer> pathTo(int v) {
        Deque<Integer> path = new LinkedList<>();
        for (int value = v; value != source; value = edgeTo[value])
            path.push(value);
        path.push(source);
        return path;
    }

    public List<List<Integer>> allPathsFromSource() {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < marked.length; i++) {
            if (marked[i])
                result.add((List<Integer>) pathTo(i));
        }
        return result;
    }


}
