package tech.arvindrachuri;

import tech.arvindrachuri.graph.Graph;
import tech.arvindrachuri.graph.GraphNode;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws Exception {
    String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h"};
    Graph dependencyGraph = new Graph();
    for(String project : projects) dependencyGraph.addNodes(new GraphNode(project, new ArrayList<>(), new ArrayList<>()));
    dependencyGraph.addEdge("b", "a");
    dependencyGraph.addEdge("g", "a");
    dependencyGraph.addEdge("c", "b");
    dependencyGraph.addEdge("d", "b");
    dependencyGraph.addEdge("c", "h");
    dependencyGraph.addEdge("d", "c");
    dependencyGraph.addEdge("e", "c");
    dependencyGraph.addEdge("f", "d");
    dependencyGraph.addEdge("d", "g");

    System.out.println(dependencyGraph.build_order());

    dependencyGraph = new Graph();
    String[] newProjects = {"a", "b", "c", "d", "e", "f", "g"};
    for(String project : newProjects) dependencyGraph.addNodes(new GraphNode(project, new ArrayList<>(), new ArrayList<>()));
    dependencyGraph.addEdge("g", "d");
    dependencyGraph.addEdge("b", "f");
    dependencyGraph.addEdge("c", "f");
    dependencyGraph.addEdge("a", "f");
    dependencyGraph.addEdge("a", "b");
    dependencyGraph.addEdge("a", "c");
    dependencyGraph.addEdge("e", "a");
    dependencyGraph.addEdge("e", "b");

    System.out.println(dependencyGraph.build_order());
  }
}