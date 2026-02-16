package pset4;

import static org.junit.Assert.*;
import java.util.TreeSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class GraphTester {

    // tests for method "addEdge" in class "Graph"
    @Test public void testAddEdge0(){
        Graph g = new Graph(2); //2 nodes in the graph, edges is [2][2]
        g.addEdge(0, 1);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 2\nedges: [[false, true], [false, false]]");
    
    }

    /*
        provide at least 4 test methods such that together they provide full statement
        coverage of your implmentation of addEdge and any helper methods;

        each test method has at least 1 invocation of addEdge;

        each test method creates exactly 1 graph;

        each test method creates a unique graph wrt "equals" method;

        each test method has at least 1 test assertion;

        each test assertion correctly characterizes expected behavior wrt the spec;

    */

    //your tests for method "addEdge" in class "Graph" go here
    @Test public void testAddEdge1(){
        Graph g = new Graph(4); 
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(3, 2);
        g.addEdge(2, 0);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 4\nedges: [[false, false, true, false], [false, false, true, false], [true, false, false, false], [false, false, true, false]]");
    
    }

    //your tests for method "addEdge" in class "Graph" go here
    @Test public void testAddEdge2(){
        Graph g = new Graph(3); 
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(2, 2);
        g.addEdge(2, 0);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 3\nedges: [[false, true, false], [true, false, false], [true, false, true]]");
    
    }


    //your tests for method "addEdge" in class "Graph" go here
    @Test public void testAddEdge3(){
        Graph g = new Graph(3); 
        g.addEdge(0, 0);
        g.addEdge(1, 1);
        g.addEdge(2, 2);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 3\nedges: [[true, false, false], [false, true, false], [false, false, true]]");
    
    }

     //your tests for method "addEdge" in class "Graph" go here
    @Test public void testAddEdge4(){
        Graph g = new Graph(4); 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(3, 1);
        g.addEdge(1, 3);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 4\nedges: [[false, true, true, false], [false, false, true, true], [false, false, false, false], [false, true, false, false]]");
    
    }


    //test for method "reachable" in class "Graph"
    @Test public void testReachable0() {
        Graph g = new Graph(1);
        Set<Integer> nodes = new TreeSet<Integer>();
        nodes.add(0);
        assertTrue(g.reachable(nodes, nodes));
    }


    //your tests for method "reachable" in class "Graph" go here

    /*
        provide at least 6 test methods such that together they provide full statement
        coverage of your implementation of reachable and any helper methods;

        each test method has at least 1 invocation of reachable;

        each test method has at least 1 test assertion;

        at least 2 test methods have at least 1 invocation of addEdge;
    
    */

    //test for method "reachable" in class "Graph"
    @Test public void testReachable1() {
        Graph g = new Graph(2);
        Set<Integer> nodes = new TreeSet<Integer>();
        nodes.add(0);
        nodes.add(1);
        g.addEdge(0, 1);
        assertTrue(g.reachable(nodes, nodes));
    }

    //test for method "reachable" in class "Graph"
    @Test public void testReachable2() {
        Graph g = new Graph(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 1);
        
        Set<Integer> sources = new TreeSet<>();
        sources.add(1);

        Set<Integer> targets = new TreeSet<>();
        targets.add(2);

        assertTrue(g.reachable(sources, targets));
    }

    //test for method "reachable" in class "Graph"
    @Test public void testReachable3() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        
        Set<Integer> sources = new TreeSet<>();
        sources.add(1);

        Set<Integer> targets = new TreeSet<>();
        targets.add(2);

        assertFalse(g.reachable(sources, targets));
    }


    //test for method "reachable" in class "Graph"
    @Test public void testReachable4() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        
        Set<Integer> sources = new TreeSet<>();
        sources.add(0);

        Set<Integer> targets = new TreeSet<>();
        targets.add(3);

        assertTrue(g.reachable(sources, targets));
    }

    //test for method "reachable" in class "Graph"
    @Test public void testReachable5() {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(3, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(4, 1);
        
        Set<Integer> sources = new TreeSet<>();
        sources.add(4);

        Set<Integer> targets = new TreeSet<>();
        targets.add(1);

        assertTrue(g.reachable(sources, targets));
        assertTrue(g.reachable(targets, sources));
    }

    //test for method "reachable" in class "Graph"
    @Test public void testReachable6() {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(3, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(4, 1);
        
        Set<Integer> sources = new TreeSet<>();
        sources.add(3);

        Set<Integer> targets = new TreeSet<>();
        targets.add(2);

        assertTrue(g.reachable(sources, targets));
        assertFalse(g.reachable(targets, sources));
    }


     
    
}
