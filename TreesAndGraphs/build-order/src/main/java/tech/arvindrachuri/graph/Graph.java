package tech.arvindrachuri.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

@NoArgsConstructor
public class Graph {
  private final Map<String, GraphNode> vertices = new HashMap<>();

  public void addNodes(GraphNode node) {
    vertices.put(node.getP_name(), node);
  }

  public void addEdge(String u, String v) {
    vertices.get(v).getOutgoing().add(vertices.get(u));
    vertices.get(u).getIncoming().add(vertices.get(v));
  }

  public List<String> build_order() throws Exception {
    List<String> build_order = new ArrayList<>();
    Queue<GraphNode> startingNodes = new LinkedList<>();
    Set<String> processed = new HashSet<>();
    for(Map.Entry<String, GraphNode> vertex : vertices.entrySet()) {
      if(vertex.getValue().getIncoming().size() == 0) startingNodes.add(vertex.getValue());
    }
    if(startingNodes.isEmpty()) throw new Exception("The processes contain circular dependencies, cannot build");
    while(!startingNodes.isEmpty()) {
      GraphNode start = startingNodes.remove();
      processed.add(start.getP_name());
      build_order.add(start.getP_name());
      Queue<GraphNode> subQueue = new LinkedList<>(start.getOutgoing());
      while(!subQueue.isEmpty()) {
        GraphNode dependent = subQueue.remove();
        if(processed.contains(dependent.getP_name())) continue;
        boolean addNode = true;
        for(GraphNode otherDependency : dependent.getIncoming()) {
          if(!processed.contains(otherDependency.getP_name())) {
            addNode = false;
            break;
          }
        }
        if(addNode) {
          processed.add(dependent.getP_name());
          build_order.add(dependent.getP_name());
          subQueue.addAll(dependent.getOutgoing());
        }

      }
    }
    if(build_order.size() != vertices.size()) throw new Exception("The processes contain circular dependencies, cannot build");
    return build_order;
  }
}
