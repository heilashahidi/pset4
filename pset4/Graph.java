package pset4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Graph {
    private int numNodes; //number of nodes in the graph

    private boolean[][] edges;
    //edges[i][j] is true if and only if there is an edge from node i to node j



    //class invariant: edges != null; edges is a square matrix;
    //                 numNodes >= 0; numNodes is number of rows in edges
    public Graph(int size){
        numNodes = size;

        //initialize the edges array as a size x size boolean matrix
        edges = new boolean[size][size];
    }

    
    @Override
    public String toString(){
        return "numNodes: " + numNodes + "\n" + "edges: " + Arrays.deepToString(edges);
    }

    @Override
    public boolean equals(Object o){
        if (o.getClass() != Graph.class) return false;
        return toString().equals(o.toString());
    }

    public void addEdge(int from, int to){
        //postcondition: adds a directed edge "from" -> "to" to this graph

        //your code goes here
        edges[from][to] = true;
    }

    public boolean reachable(Set<Integer> sources, Set<Integer> targets){
        if (sources == null || targets == null) throw new IllegalArgumentException();

        // post-condition: returns true if (1) "sources" does not contain an illegal node,
        //                                 (2) "targets" does not contain an illegal node, and
        //                                 (3) for each node "m" in set "targets", there is some 
        //                                     node "n" in set "sources" such that there is a directed
        //                                     path that starts at "n" and ends at "m" in "this"; and
        //                                     false otherwise

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> reachableNodes = new HashSet<>();

        // Start from ALL sources, not just node 0
        for (Integer source : sources) {
            queue.add(source);
            reachableNodes.add(source);
        }

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
                // Check ALL possible neighbors (all nodes in the graph)
                for (int neighbor = 0; neighbor < numNodes; neighbor++) {
                    // Is there an edge from currentNode to neighbor?
                    if (edges[currentNode][neighbor] && !reachableNodes.contains(neighbor)) {
                        reachableNodes.add(neighbor);
                        queue.add(neighbor);
                    }       
                }
        }       

        // Check if all targets are reachable
        for (Integer target : targets) {
            if (!reachableNodes.contains(target)) {
                return false;
            }
        }       
        return true;

    }

        
}
