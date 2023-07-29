package tech.arvindrachuri.utils;

import tech.arvindrachuri.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {
  public String ppBinaryTree(Tree tree) {
    StringBuilder stringBuilder = new StringBuilder();
    List<List<Integer>> depthList = getListDepths(tree);
    LinkedList<String> levelLists = new LinkedList<>();
    for(int i=depthList.size()-1; i>=0; i--) {
      int spaces = (1<<(depthList.size()-1-i))-1;
      StringBuilder sb = new StringBuilder();
      sb.append(" ".repeat(Math.max(0, spaces)));
      int gaps = 2*spaces + 1;
      for(int j: depthList.get(i)){
        sb.append(j);
        sb.append(" ".repeat(Math.max(0, gaps)));
      }
      sb.append(" ".repeat(Math.max(0, spaces-1)));
      levelLists.addFirst(sb.toString());
    }

    for(String list: levelLists) {
      stringBuilder.append(list).append('\n');
    }
    return stringBuilder.toString();
  }

  private List<List<Integer>> getListDepths(Tree tree) {
    List<List<Integer>> depthList = new ArrayList<>();
    Queue<Tree> queue = new LinkedList<>();
    queue.add(tree);
    queue.add(null);
    LinkedList<Integer> currentList = new LinkedList<>();
    while(!queue.isEmpty()) {
      Tree curr = queue.remove();
      if(curr != null) {
        currentList.add(curr.getId());
        if(curr.getLeft() != null) queue.add(curr.getLeft());
        if(curr.getRight() != null) queue.add(curr.getRight());
      } else {
        depthList.add(currentList);
        currentList = new LinkedList<>();
        if(!queue.isEmpty()) queue.add(null);
      }
    }

    return depthList;
  }
}
