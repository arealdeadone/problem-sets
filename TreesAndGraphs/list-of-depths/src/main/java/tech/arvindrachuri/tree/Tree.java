package tech.arvindrachuri.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tree {
    private int id;
    private Tree leftTree;
    private Tree rightTree;

    public static Tree createBalanced(Tree tree, int[] values) {
        return makeMinimal(tree, values, 0, values.length-1);
    }

    private static Tree makeMinimal(Tree tree, int[] values, int start, int end) {
        if(end < start) {
            return null;
        }
        int mid = (start+end)/2;
        tree.setId(values[mid]);
        tree.setLeftTree(makeMinimal(new Tree(), values, start, mid-1));
        tree.setRightTree(makeMinimal(new Tree(), values, mid+1, end));
        return tree;
    }
}
