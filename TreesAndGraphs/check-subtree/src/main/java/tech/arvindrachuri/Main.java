package tech.arvindrachuri;

import tech.arvindrachuri.tree.Tree;
import tech.arvindrachuri.utils.TreeUtils;

public class Main {

  public static void main(String[] args) {
    TreeUtils treeUtils = new TreeUtils();
    Tree t1 = Tree.create(1);
    t1.insert(1,2, true)
        .insert(1, 3, false)
        .insert(2, 4, true)
        .insert(2, 5, false)
        .insert(3, 6, true)
        .insert(3, 7, false)
        .insert(4, 8, true)
        .insert(4,9, false)
        .insert(5, 10, true)
        .insert(5, 11, false)
        .insert(6, 12, true)
        .insert(6, 13, false)
        .insert(7, 14, true)
        .insert(7, 15, false)
        .insert(8, 16, true)
        .insert(8, 17, false)
        .insert(9, 18, true)
        .insert(9, 19, false)
        .insert(10, 20, true)
        .insert(10, 21, false)
        .insert(11, 22, true)
        .insert(11, 23, false)
        .insert(12, 24, true)
        .insert(12, 25, false)
        .insert(13, 26, true)
        .insert(13, 27, false)
        .insert(14, 28, true)
        .insert(14, 29, false)
        .insert(15, 30, true)
        .insert(15, 31, false);

    Tree t2 = Tree.create(4);
    t2.insert(4, 8, true)
        .insert(4,9, false)
        .insert(8, 16, true)
        .insert(8, 17, false)
        .insert(9, 18, true)
        .insert(9, 19, false);

    Tree t3 = Tree.create(4);
    t3.insert(4, 8, true)
        .insert(4,9, false)
        .insert(8, 16, true)
        .insert(8, 20, false)
        .insert(9, 18, true)
        .insert(9, 22, false);

    System.out.println(treeUtils.ppBinaryTree(t1));
    System.out.println(treeUtils.ppBinaryTree(t2));
    System.out.println(treeUtils.ppBinaryTree(t3));

    System.out.println(t1.contains(t2));
    System.out.println(t1.contains(t3));
    System.out.println(t1.contains(t1));
  }
}