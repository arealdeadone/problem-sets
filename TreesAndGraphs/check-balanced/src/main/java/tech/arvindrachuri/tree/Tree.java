package tech.arvindrachuri.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Data
@AllArgsConstructor
public class Tree {

  public enum Child {
    LEFT, RIGHT
  }
  private int id;
  private Tree left;
  private Tree right;

  private static final Integer h_err = -1000;

  public void insert(int u, int v, Child direction) throws IllegalArgumentException {
    Tree child = new Tree(v, null, null);
    Tree parent = this.getInsertionRoot(u);
    if(parent == null) {
      throw new IllegalArgumentException("Incorrect node value");
    }
    switch (direction) {
      case LEFT -> parent.setLeft(child);
      case RIGHT -> parent.setRight(child);
    }
  }

  public boolean isBalanced() {
    return checkHeight(this) != h_err;
  }

  private int checkHeight(Tree tree) {
    if(tree == null) return -1;

    int leftHeight = checkHeight(tree.getLeft());
    if(leftHeight == h_err) return h_err;

    int rightHeight = checkHeight(tree.getRight());
    if(rightHeight == h_err) return h_err;

    if(Math.abs(leftHeight - rightHeight) > 1) return h_err;

    return Math.max(leftHeight, rightHeight) + 1;
  }

  private Tree getInsertionRoot(int u) {
    Queue<Tree> queue = new LinkedBlockingQueue<>();
    queue.add(this);
    while(!queue.isEmpty()) {
      Tree curr = queue.remove();
      if(curr != null) {
        if(curr.getId() == u) return curr;
        if(curr.getLeft() != null) queue.add(curr.getLeft());
        if(curr.getRight() != null) queue.add(curr.getRight());
      }
    }
    return null;
  }
}
