package tech.arvindrachuri;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Getter
@Setter
@AllArgsConstructor
public class Tree {
  private int id;

  private Tree left;

  private Tree right;

  public boolean isBinarySearchTree() {
    return validateBst(this);
  }

  public void insert(int rootId, int nodeId, Child type) throws IllegalArgumentException {
    insert(rootId, nodeId, null, null, type);
  }

  public void insert(int rootId, int nodeId, Tree left, Tree right, Child type) throws IllegalArgumentException {
    Tree parent = findInsertionRoot(rootId);
    if(parent == null) throw new IllegalArgumentException("Incorrect root id, does not exist in the tree");
    Tree child = new Tree(nodeId, left, right);
    switch (type) {
      case LEFT -> parent.setLeft(child);
      case RIGHT -> parent.setRight(child);
    }
  }

  private Tree findInsertionRoot(int rootId) {
    Queue<Tree> queue = new LinkedBlockingQueue<>();
    queue.add(this);

    while(!queue.isEmpty()) {
      Tree curr = queue.remove();
      if(curr != null) {
        if(curr.getId() == rootId) return curr;
        if(curr.getLeft() != null) queue.add(curr.getLeft());
        if(curr.getRight() != null) queue.add(curr.getRight());
      }
    }
    return null;
  }

  private boolean validateBst(Tree root) {
    if(root == null) return true;

    Tree left = root.getLeft();
    Tree right = root.getRight();

    boolean leftBst = true, rightBst = true;

    if(left != null && left.getId() >= root.getId()) leftBst = false;
    if(right != null && right.getId() < root.getId()) rightBst = false;
    return leftBst && rightBst;
  }

  public enum Child {
    LEFT, RIGHT
  }
}
