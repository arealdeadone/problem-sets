package tech.arvindrachuri.tree;

import lombok.Data;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

@Data
public class Tree {
  Integer id;

  Tree parent;
  Tree left;
  Tree right;

  public static Tree create(Integer id) {
    return new Tree(id, null, null, null);
  }

  private Tree(Integer id, Tree left, Tree right, Tree parent) {
    this.id = id;
    this.left = left;
    this.right = right;
    this.parent = parent;
  }

  public void insert(int parent, int child, boolean isLeft) {
    if(this.id == null) return;
    Tree iParent = find(parent);
    if(iParent == null) return;
    if(isLeft) {
      iParent.setLeft(new Tree(child, null, null, iParent));
    } else {
      iParent.setRight(new Tree(child, null, null, iParent));
    }
  }

  public Tree find(Integer val) {
    if(val == null) return null;
    Queue<Tree> bfsQueue = new LinkedList<>();
    bfsQueue.add(this);
    while(!bfsQueue.isEmpty()) {
      Tree curr = bfsQueue.remove();
      if(curr != null) {
        if(curr.getId() == val) return curr;
        if(curr.getLeft() != null) bfsQueue.add(curr.getLeft());
        if(curr.getRight() != null) bfsQueue.add(curr.getRight());
      }
    }
    return null;
  }

  public Tree firstCommonAncestor(Integer u, Integer v) {
    Tree uNode = find(u);
    Tree vNode = find(v);
    if(uNode == null) return null;
    if(vNode == null) return null;
    Stack<Character> uStack = new Stack<>();
    Stack<Character> vStack = new Stack<>();
    while(uNode.getParent() != null) {
      uStack.add(uNode.getParent().getLeft() == uNode ? 'L' : 'R');
      uNode = uNode.getParent();
    }
    while (vNode.getParent() != null) {
      vStack.add(vNode.getParent().getLeft() == vNode ? 'L' : 'R');
      vNode = vNode.getParent();
    }
    Tree ancestor = this;
    while (!uStack.isEmpty() && !vStack.isEmpty() && uStack.peek() == vStack.peek()) {
      ancestor = uStack.pop() == 'L' ? ancestor.getLeft() : ancestor.getRight();
      vStack.pop();
    }
    return ancestor;
  }

  public Tree commonAncestorDfs(Integer u, Integer v) {
    return find(dfsAncestor(this, u,v)[2]);
  }

  private Integer[] dfsAncestor(Tree root, Integer u, Integer v) {
    if(root == null) return new Integer[]{0,0,null};
    if(Objects.equals(root.getId(), u)) return new Integer[]{1,0,null};
    if(Objects.equals(root.getId(), v)) return new Integer[]{0,1, null};

    Integer[] leftAns = dfsAncestor(root.getLeft(), u, v);
    Integer[] rightAns = dfsAncestor(root.getRight(), u, v);
    Integer ancestral = leftAns[2] != null ? leftAns[2] : rightAns[2] != null ? rightAns[2] : null;
    Integer[] merged = {leftAns[0]|rightAns[0], leftAns[1]|rightAns[1], ancestral};
    if(merged[0] == 1 && merged[1] == 1 && merged[2] == null) merged[2] = root.getId();
    return merged;
  }

  @Override public String toString() {
    Integer leftVal = null == this.getLeft() ? null : this.getLeft().id;
    Integer rightVal = null == this.getRight() ? null : this.getRight().id;
    return String.format("%s={L: %s, R: %s}", this.getId(), leftVal, rightVal);
  }
}
