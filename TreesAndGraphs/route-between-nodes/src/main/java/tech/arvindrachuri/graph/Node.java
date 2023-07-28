package tech.arvindrachuri.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    private int id;
    private List<Node> children;
    public boolean visited = false;

    public Node(int id) {
        this(id, new ArrayList<>());
    }

    public Node(int id, Node[] chilNodes) {
        this(id, Arrays.asList(chilNodes));
    }

    public Node(int id, List<Node> children) {
        this.id = id;
        this.children = children;
    }

    public void addChild(Node n) {
        this.children.add(n);
    }

    public List<Node> children() {
        return this.children;
    }

    public int getId() {
        return id;
    }
}
