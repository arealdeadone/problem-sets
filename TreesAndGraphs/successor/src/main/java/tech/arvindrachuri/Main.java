package tech.arvindrachuri;

import tech.arvindrachuri.tree.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] elements = {7, 2, 10, 1, 6, 8, 11, 3, 9, 4, 5};
        for (int i : elements) bst.insert(i);
        System.out.println(bst);
        System.out.println(bst.successor(1).getId() == 2);
        System.out.println(bst.successor(5).getId() == 6);
        System.out.println(bst.successor(11) == null);
    }
}
