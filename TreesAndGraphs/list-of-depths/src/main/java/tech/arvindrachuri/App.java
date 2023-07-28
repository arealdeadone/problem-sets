package tech.arvindrachuri;


import tech.arvindrachuri.tree.ListDepths;
import tech.arvindrachuri.tree.Tree;

public class App
{
    public static void main( String[] args )
    {
        Tree tree = new Tree();
        int[] treeVals = {1,2,3,4,5,6,7};
        Tree.createBalanced(tree, treeVals);
        ListDepths listDepths = new ListDepths(tree);
        listDepths.getListDepths();
        System.out.println(listDepths);
    }
}
