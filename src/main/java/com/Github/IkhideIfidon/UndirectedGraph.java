package com.Github.IkhideIfidon;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/** we use the names 0 through V - 1 for the vertices in a V-vertex graph.**/
public class UndirectedGraph {
    private final int V;                                // number of vertices
    private final int E;                                // number of edges
    private final List<Integer>[] adjacent;             // adjacent lists

    public UndirectedGraph(int V) {
        this.V = V;
        this.E = 0;
        //noinspection unchecked
        adjacent = (List<Integer>[]) new LinkedList[V];
        for (int i = 0; i < V; i++)
            adjacent[i] = new LinkedList<>();
    }

    public UndirectedGraph(FileInputStream in) throws IOException {
        this(in.read());
        int E = in.read();
        for (int i = 0; i < E; i++) {
            int v = in.read();
            int w = in.read();
            addEdge(v, w);
        }
        in.close();
    }

    public int V() { return V; }
    public int E() { return E; }

    public void addEdge(int v, int w) {
        if ((0 <= v && v < V) && (0 <= w && w < V)) {
            adjacent[v].add(w);
            adjacent[w].add(v);
        }
    }

    public Iterable<Integer> neighbors(int v)  {
        if (0 <= v && v < V)
            return adjacent[v];
        throw new ArrayIndexOutOfBoundsException(v + " is not a valid vertex");
    }

    public int degree(int v) {
        int degree = 0;
        if (0 <= v && v < V)
            return adjacent[v].size();
        return degree;
    }

    public int maximumDegree() {
        int maximumDegree = 0;
        for (int i = 0; i < V; i++) {
            if (degree(i) > maximumDegree)
                maximumDegree = degree(i);
        }
        return maximumDegree;
    }

    public int numberOfSelfLoops() {
        int numberOfSelfLoops = 0;
        for (int i = 0; i < V; i++) {
            for (int w : neighbors(i)) {
                if (i == w)
                    numberOfSelfLoops++;
            }
        }
        return numberOfSelfLoops / 2;                       // each edge counted twice.
    }

    public int averageDegree() { return 2 * E() / V(); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < V; i++) {
            sb.append(neighborsToString(i));
            if (i + 1 != V)
                sb.append(" ,");
        }
        sb.append("]");
        return sb.toString();
    }

    private String neighborsToString(int v) {
        StringBuilder sb = new StringBuilder("[");

        Iterator<Integer> iter = neighbors(v).iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext())
                sb.append("-->");
        }
        sb.append("]");
        return sb.toString();
    }



}
