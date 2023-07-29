package tech.arvindrachuri.tree;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

@Data
public class Tree {
  private int id;
  private Tree left;
  private Tree right;

  private Tree(int id, Tree left, Tree right) {
    this.id = id;
    this.left = left;
    this.right = right;
  }

  public static Tree create(int id) {
    return new Tree(id, null, null);
  }

  public Tree insert(int parent, int child, boolean isLeft) {
    Tree iParent = find(parent);
    if(iParent == null) return this;
    Tree iChild = new Tree(child, null, null);
    if(isLeft) iParent.left = iChild; else iParent.right = iChild;
    return this;
  }

  public Boolean contains(Tree tree) {
    return vDfs(find(tree.id), tree);
  }

  public Tree find(int val) {
    Queue<Tree> bfs = new LinkedList<>();
    bfs.add(this);
    while (!bfs.isEmpty()) {
      Tree current = bfs.remove();
      if(current.getId() == val) return current;
      if(current.getLeft() != null) bfs.add(current.getLeft());
      if(current.getRight() != null) bfs.add(current.getRight());
    }
    return null;
  }

  private boolean vDfs(Tree t1, Tree t2) {
    if(t1 == null && t2 == null) return true;
    if(t1 == null || t2 == null) return false;

    boolean root = t1.getId() == t2.getId();
    boolean left = vDfs(t1.getLeft(), t2.getLeft());
    boolean right = vDfs(t1.getRight(), t2.getRight());

    return root && left && right;
  }

  @Override
  public String toString() {
    Integer left = this.left != null ? this.left.id : null;
    Integer right = this.right != null ? this.right.id : null;
    return String.format("[ %d=[ L=%s R=%s ] ]",id, left, right);
  }

}
