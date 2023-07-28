package tech.arvindrachuri.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class GenericTree {
  private Integer id;
  private List<Integer> data;
  private List<GenericTree> children;

  public GenericTree insert(GenericTree parent, List<Integer> child, int id) {
    if(parent == null) return null;
    GenericTree childTree = new GenericTree(id, child, new ArrayList<>());
    parent.children.add(childTree);
    return childTree;
  }

  public List<List<Integer>> dfs(GenericTree root) {
    List<List<Integer>> allPaths = new ArrayList<>();
    if(root.children.isEmpty()){
      allPaths.add(root.data);
      return allPaths;
    }
    for(GenericTree child: root.children) {
      List<List<Integer>> childPerms = dfs(child);
      for(List<Integer> childPerm : childPerms) {
        List<Integer> present = new ArrayList<>();
        present.addAll(root.data);
        present.addAll(childPerm);
        allPaths.add(present);
      }
    }

    return allPaths;
  }

  @Override public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(data.toString()).append('\n');
    stringBuilder.append("[ ");
    children.forEach(c -> stringBuilder.append(c.data.toString()).append(' '));
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
}
