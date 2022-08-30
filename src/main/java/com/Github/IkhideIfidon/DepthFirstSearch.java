package com.Github.IkhideIfidon;

import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstSearch {
    private final boolean[] marked;
    private int count;

    public DepthFirstSearch(UndirectedGraph graph, int source) {
        marked = new boolean[graph.V()];
        dfs(graph, source);

    }

    private void dfs(UndirectedGraph graph, int source) {
        marked[source] = true;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            for (int w : graph.neighbors(current)) {
                if (!marked[w]) {
                    marked[w] = true;
                    count++;
                    stack.push(w);
                }
            }
        }
    }

    public boolean marked(int w) { return marked[w]; }

    public int count() { return count; }
}
