package tech.arvindrachuri.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Data
public class BinarySearchTree {

  private BinarySearchTreeNode root;

  private BinarySearchTree(Integer id, BinarySearchTreeNode left, BinarySearchTreeNode right) {
    this.root = new BinarySearchTreeNode(id, left, right);
  }

  public static BinarySearchTree create(int id) {
    return new BinarySearchTree(id, null, null);
  }

  public void insert(Integer val) {
    this.root = _insert(this.root, val);
  }

  public List<List<Integer>> bstSequence() {
    List<List<Integer>> sequences = new ArrayList<>();
    List<List<Integer>> levelOrder = getListDepths();
    List<List<Integer>> perms = new ArrayList<>();
    perms = allPossiblePermutations(perms, levelOrder.get(0).toArray(new Integer[]{}), 0, levelOrder.get(0).size()-1);
    GenericTree permTree = new GenericTree(0, perms.get(0), new ArrayList<>());
    List<GenericTree> prevGen = new ArrayList<>();
    prevGen.add(permTree);
    for(int i=1; i < levelOrder.size(); i++) {
      List<GenericTree> nextGen = new ArrayList<>();
      for(GenericTree pp: prevGen) {
        perms = new ArrayList<>();
        perms = allPossiblePermutations(perms, levelOrder.get(i).toArray(new Integer[]{}), 0, levelOrder.get(i).size()-1);
        for(List<Integer> perm: perms) nextGen.add(permTree.insert(pp, perm, i));
      }
      prevGen = nextGen;
    }
    return permTree.dfs(permTree);
  }



  private List<List<Integer>> getListDepths() {
    final List<List<Integer>> depthList = new ArrayList<>();
    Queue<BinarySearchTreeNode> queue = new LinkedList<>();
    queue.add(this.root);
    queue.add(null);
    LinkedList<Integer> currentList = new LinkedList<>();
    while(!queue.isEmpty()) {
      BinarySearchTreeNode curr = queue.remove();
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

  private BinarySearchTreeNode _insert(BinarySearchTreeNode root, Integer val) {
    if(root == null) return new BinarySearchTreeNode(val, null, null);
    if(root.getId() <= val) root.setRight(_insert(root.getRight(), val));
    if(root.getId() > val) root.setLeft(_insert(root.getLeft(), val));
    return root;
  }

  private List<List<Integer>> allPossiblePermutations(List<List<Integer>> permutations, Integer[] levelElements, int l, int r) {
    if(l == r) {
      List<Integer> perm = new ArrayList<>();
      for(Integer i: levelElements) {
        perm.add(i.intValue());
      }
      permutations.add(perm);
    } else {
      for(int i=l; i<=r; i++) {
        Integer temp = levelElements[l];
        levelElements[l] = levelElements[i];
        levelElements[i] = temp;
        permutations = allPossiblePermutations(permutations, levelElements, l+1, r);
        temp = levelElements[l];
        levelElements[l] = levelElements[i];
        levelElements[i] = temp;
      }
    }
    return permutations;
  }

  @Override
  public String toString() {
    final List<List<Integer>> depthList = getListDepths();
    final StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('[').append('\n');
    for(List<Integer> list : depthList) {
      stringBuilder.append('\t').append('[').append(' ');
      for(Integer i : list) {
        stringBuilder.append(i).append(' ');
      }
      stringBuilder.append(']').append('\n');
    }
    stringBuilder.append(']');
    return stringBuilder.toString();
  }

  @AllArgsConstructor
  @Data
  private static class BinarySearchTreeNode {
    private Integer id;

    private BinarySearchTreeNode left;

    private BinarySearchTreeNode right;
  }
}
