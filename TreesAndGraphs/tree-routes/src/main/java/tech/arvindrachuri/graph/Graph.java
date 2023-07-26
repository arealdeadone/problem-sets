package tech.arvindrachuri.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tech.arvindrachuri.graph.exceptions.NodeNotFoundException;

public class Graph {
    private List<Node> nodes;
    private boolean undirected;

    public Graph() {
        this(new ArrayList<>(), false);
    }

    public Graph(List<Node> nodes, boolean undirected) {
        this.nodes = nodes;
        this.undirected = undirected;
    }

    public void makeUndirectedGraph(boolean flag) {
        this.undirected = flag;
    }

    public void addEdge(Node n1, Node n2) throws NodeNotFoundException {
        if(n1.getId() < maxNodeId() && n2.getId() < maxNodeId()) {
            if(undirected) {
                n2.addChild(n1);
            }
            n1.addChild(n2);
        } else {
            throw new NodeNotFoundException("Either of the given nodes do not exist in the graph");
        }
    }

    public void addNodes(Node ...nodes) {
        this.nodes.addAll(Arrays.asList(nodes));
    }

    public int maxNodeId() {
        return nodes.size();
    }

    public Node node(int id) {
        return nodes.get(id);
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("[\n");
        for (Node node : nodes) {
            sBuilder.append("  ").append(node.getId()).append(": ");
            for (Node child : node.children()) {
                sBuilder.append(child.getId()).append(" ");
            }
            sBuilder.append('\n');
        }
        sBuilder.append(']');
        return sBuilder.toString();
    }
}
