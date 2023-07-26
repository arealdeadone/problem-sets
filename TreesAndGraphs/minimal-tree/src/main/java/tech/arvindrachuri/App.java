package tech.arvindrachuri;

import java.util.Stack;

import tech.arvindrachuri.tree.TraversalOrder;
import tech.arvindrachuri.tree.Tree;

/**
 * Hello world!
 *
 */
public class App 
{

    public Tree makeMinimal(Tree tree, int[] sorted, int low, int high) {
        if(low > high) {
            return null;
        }
        int mid = (low+high)/2;
        tree.id = sorted[mid];
        tree.leftTree = makeMinimal(new Tree(), sorted, low, mid-1);
        tree.rightTree = makeMinimal(new Tree(), sorted, mid+1, high);
        return tree;
    }

    public String printTree(Tree tree, TraversalOrder order) {
        switch (order) {
            case INORDER: return inOrder(tree);
            case PREORDER: return preOrder(tree);
            case POSTORDER: return postOrder(tree);
            default: return "";
        }
    }
    public static void main( String[] args )
    {
        int[] sorted = {1,2,3,4,5,6,7};
        Tree tree = new Tree();
        tree.size = sorted.length;
        App app = new App();
        tree = app.makeMinimal(tree, sorted, 0, sorted.length-1);
        app.printTree(tree, TraversalOrder.PREORDER);
        app.printTree(tree, TraversalOrder.INORDER);
        app.printTree(tree, TraversalOrder.POSTORDER);
    }

    private String preOrder(Tree tree) {
        StringBuilder preBuilder = new StringBuilder();
        Stack<Tree> recurStack = new Stack<>();
        recurStack.add(tree);
        while(!recurStack.empty()) {
            Tree curr = recurStack.pop();
            if(curr != null) {
                preBuilder.append(curr.id).append(" ");
                recurStack.add(curr.rightTree);
                recurStack.add(curr.leftTree);
            }
        }
        return preBuilder.toString();
    }

    private String postOrder(Tree tree) {
        StringBuilder postBuilder = new StringBuilder();
        if(tree == null) {
            return postBuilder.toString();
        }
        postBuilder.append(postOrder(tree.leftTree));
        postBuilder.append(postOrder(tree.rightTree));
        postBuilder.append(tree.id).append(" ");
        return postBuilder.toString();
    }

    private String inOrder(Tree tree) {
        StringBuilder inBuilder = new StringBuilder();
        if(tree == null) {
            return inBuilder.toString();
        }
        inBuilder.append(inOrder(tree.leftTree));
        inBuilder.append(tree.id).append(" ");
        inBuilder.append(inOrder(tree.rightTree));
        return inBuilder.toString();
    }
}
