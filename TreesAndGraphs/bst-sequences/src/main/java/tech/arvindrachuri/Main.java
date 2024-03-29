package tech.arvindrachuri;

import tech.arvindrachuri.tree.BinarySearchTree;

public class Main {

  public static void main(String[] args) {
    BinarySearchTree tree = BinarySearchTree.create(4);
    tree.insert(2);
    tree.insert(5);
    tree.insert(1);
    tree.insert(3);
    tree.insert(6);
    System.out.println(tree.bstSequence());

    tree = BinarySearchTree.create(2);
    tree.insert(1);
    tree.insert(3);
    System.out.println(tree.bstSequence());

    tree = BinarySearchTree.create(3);
    tree.insert(2);
    tree.insert(4);
    tree.insert(1);
    tree.insert(5);
    System.out.println(tree.bstSequence());
  }
}