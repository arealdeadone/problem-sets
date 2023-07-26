package tech.arvindrachuri.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListDepths {
    private final Tree tree;
    private final List<LinkedList<Integer>> depthList = new ArrayList<>();

    public ListDepths(Tree tree) {
        this.tree = tree;
    }

    public List<LinkedList<Integer>> getListDepths() {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        queue.add(null);
        LinkedList<Integer> currentList = new LinkedList<>();
        while(!queue.isEmpty()) {
            Tree curr = queue.remove();
            if(curr != null) {
                currentList.add(curr.getId());
                if(curr.getLeftTree() != null) queue.add(curr.getLeftTree());
                if(curr.getRightTree() != null) queue.add(curr.getRightTree());
            } else {
                depthList.add(currentList);
                currentList = new LinkedList<>();
                if(!queue.isEmpty()) queue.add(null);
            }
        }

        return depthList;
    }

    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[').append('\n');
        for(LinkedList<Integer> list : depthList) {
            stringBuilder.append('\t').append('[').append(' ');
            for(Integer i : list) {
                stringBuilder.append(i).append(' ');
            }
            stringBuilder.append(']').append('\n');
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
