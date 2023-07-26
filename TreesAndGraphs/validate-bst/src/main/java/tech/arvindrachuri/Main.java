package tech.arvindrachuri;

import tech.arvindrachuri.Tree.Child;

public class Main {

  public static void main(String[] args) {
    Tree bst = new Tree(4,
        new Tree(2,
            new Tree(1, null, null),
            new Tree(3, null, null)),
        new Tree(6,
            new Tree(5, null, null),
            new Tree(7, null, null)));
    System.out.println(bst.isBinarySearchTree());

    Tree nonBst = new Tree(1, null, null);
    nonBst.insert(1, 2, Child.LEFT);
    nonBst.insert(1, 3, Child.RIGHT);
    nonBst.insert(2, 4, Child.LEFT);
    nonBst.insert(2, 5, Child.RIGHT);
    nonBst.insert(3, 6, Child.LEFT);
    nonBst.insert(3, 7, Child.RIGHT);

    System.out.println(nonBst.isBinarySearchTree());
  }
}