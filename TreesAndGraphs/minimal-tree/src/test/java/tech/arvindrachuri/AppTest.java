package tech.arvindrachuri;

import static org.junit.Assert.assertTrue;

import tech.arvindrachuri.tree.TraversalOrder;
import tech.arvindrachuri.tree.Tree;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void getMinimalTreeTest()
    {
       Tree tree = new Tree();
       int[] sorted = {1,2,3,4,5,6,7};
       App app = new App();
       app.makeMinimal(tree, sorted, 0, sorted.length - 1);
       assertTrue("Actual inorder = " + app.printTree(tree, TraversalOrder.INORDER), "1 2 3 4 5 6 7 ".equalsIgnoreCase(app.printTree(tree, TraversalOrder.INORDER)));
       assertTrue("Actual preorder = " + app.printTree(tree, TraversalOrder.PREORDER), "4 2 1 3 6 5 7 ".equalsIgnoreCase(app.printTree(tree, TraversalOrder.PREORDER)));
       assertTrue("Actual postorder = " + app.printTree(tree, TraversalOrder.POSTORDER), "1 3 2 5 7 6 4 ".equalsIgnoreCase(app.printTree(tree, TraversalOrder.POSTORDER)));
    }
}
