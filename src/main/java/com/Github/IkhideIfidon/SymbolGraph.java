package com.Github.IkhideIfidon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SymbolGraph {
    private final Map<String, Integer> map;
    private String[] keys;
    private UndirectedGraph G;

    public SymbolGraph(String stream, String delimiter) {
        map = new LinkedHashMap<>();
        File file = new File(stream);
         try ( Scanner in = new Scanner(file) ) {
             while (in.hasNextLine()) {
                 String[] vertices = in.nextLine().split(delimiter);
                 for (String vertex : vertices) {
                     if (!map.containsKey(vertex))
                         map.put(vertex, map.size());
                 }
             }

             keys = new String[map.size()];
             for (String vertex : map.keySet())
                 keys[map.get(vertex)] = vertex;

             // Build the graph
             G = new UndirectedGraph(map.size());
             Scanner input = new Scanner(file);

             while (input.hasNextLine()) {
                 String[] edgeArray = input.nextLine().split(delimiter);
                 int v = map.get(edgeArray[0]);
                 for (int i = 1; i < edgeArray.length; i++)
                     G.addEdge(v, map.get(edgeArray[i]));
             }
         } catch (FileNotFoundException e ) {
             e.printStackTrace();
         }
    }

    public boolean contains(String s) {
        String key = s.toUpperCase();
        return map.containsKey(key);
    }

    public int index(String s) {
        String key = s.toUpperCase();
        return map.get(key);
    }

    public String name(int v) { return keys[v]; }
    public UndirectedGraph G() { return G; }

    @Override
    public String toString() { return G.toString(); }

}
