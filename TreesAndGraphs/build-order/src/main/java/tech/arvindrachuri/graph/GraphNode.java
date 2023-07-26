package tech.arvindrachuri.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphNode {
  private String p_name;
  private List<GraphNode> incoming;
  private List<GraphNode> outgoing;

  @Override
  public String toString() {
    String outList = outgoing.stream().map(GraphNode::getP_name).toList().toString();
    String inList  = incoming.stream().map(GraphNode::getP_name).toList().toString();
    return p_name + " incoming = " + inList + " outgoing = " + outList;
  }
}
