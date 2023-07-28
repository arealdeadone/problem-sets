package tech.arvindrachuri;

import tech.arvindrachuri.tree.Tree;

public class Main {

  public static void main(String[] args) {
    Tree ancestral = Tree.create(1);
    ancestral.insert(1, 2, true);
    ancestral.insert(1, 3, false);
    ancestral.insert(2, 5, false);
    ancestral.insert(3, 6, false);
    ancestral.insert(2, 4, true);
    ancestral.insert(4, 8, false);
    ancestral.insert(5, 10, false);
    ancestral.insert(4, 7, true);
    ancestral.insert(5, 9, true);
    ancestral.insert(8, 11, true);
    ancestral.insert(9, 12, false);
    ancestral.insert(12, 14, false);
    ancestral.insert(11, 13, true);

    System.out.println(ancestral.firstCommonAncestor(13, 9).getId());
    System.out.println(ancestral.commonAncestorDfs(13, 6).getId());
    System.out.println(ancestral.firstCommonAncestor(12, 14).getId());
  }
}