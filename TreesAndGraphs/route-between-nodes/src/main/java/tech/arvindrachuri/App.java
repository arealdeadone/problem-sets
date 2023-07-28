package tech.arvindrachuri;

import java.util.LinkedList;
import java.util.Queue;

import tech.arvindrachuri.graph.Graph;
import tech.arvindrachuri.graph.Node;
import tech.arvindrachuri.graph.exceptions.NodeNotFoundException;

public class App 
{
    public boolean routeFinder(Graph graph, int srcId, int destId) {
        Queue<Node> queue = new LinkedList<>();
        Node src = graph.node(srcId);
        Node dest = graph.node(destId);
        src.visited = true;
        queue.add(src);

        while(!queue.isEmpty()) {
            Node r = queue.remove();
            if(r.getId() == dest.getId()) return true;
            r.visited = true;
            for (Node adjNode : r.children()) {
                if(!adjNode.visited) {
                    queue.add(adjNode);
                }
            }
        }
        return false;
    }
    public static void main( String[] args )
    {
        Graph graph = new Graph();
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        graph.addNodes(n0, n1, n2, n3, n4, n5);

        try {
            graph.addEdge(n0, n1);
            graph.addEdge(n1, n4);
            graph.addEdge(n2, n1);
            graph.addEdge(n3, n2);
            graph.addEdge(n3, n4);
            graph.addEdge(n0, n5);
            graph.addEdge(n0, n4);
            graph.addEdge(n1, n3);
        } catch (NodeNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println(graph.toString());

        App app = new App();

        System.out.println(app.routeFinder(graph, 2, 5));
    }
}
