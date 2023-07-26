package tech.arvindrachuri;

import tech.arvindrachuri.tree.Tree;
import tech.arvindrachuri.tree.Tree.Child;

public class Main {

  public static void main(String[] args) {
    Tree tree = new Tree(4, null, null);
    tree.insert(4, 2, Child.LEFT);
    tree.insert(4, 6, Child.RIGHT);
    tree.insert(2, 1, Child.LEFT);
    tree.insert(2, 3, Child.RIGHT);
    tree.insert(6, 5, Child.LEFT);
    tree.insert(6, 7, Child.RIGHT);
    tree.insert(7, 8, Child.RIGHT);
    tree.insert(8, 9, Child.RIGHT);

    System.out.println("The tree is balanced = " + tree.isBalanced());
  }
}