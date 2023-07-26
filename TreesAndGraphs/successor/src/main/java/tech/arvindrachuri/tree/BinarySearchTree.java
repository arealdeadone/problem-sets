package tech.arvindrachuri.tree;

import java.util.LinkedList;
import java.util.Queue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinarySearchTree {

    private TreeNode root;

    public void insert(int nodeVal) {
        this.root = bstInsert(this.root, null, nodeVal);
    }

    public TreeNode successor(int val) {
        TreeNode predecessor = find(val);
        return nextNode(predecessor, val);
    }

    public TreeNode find(int val) {
        return search(this.root, val);
    }

    private TreeNode nextNode(TreeNode current, int val) {
        if (current.getRight() == null) {
            current = current.getParent();
            while (current != null && current.getId() < val) current = current.getParent();
            return current;
        }
        return nextNode(current.getRight(), val);
    }

    private TreeNode bstInsert(TreeNode current, TreeNode parent, int val) {
        if (current == null) {
            current = new TreeNode(val, null, null, parent);
            return current;
        }
        if (val >= current.getId()) {
            current.setRight(bstInsert(current.getRight(), current, val));
        } else {
            current.setLeft(bstInsert(current.getLeft(), current, val));
        }
        return current;
    }

    private TreeNode search(TreeNode current, int searchKey) {
        if (current.getId() == searchKey) return current;
        if (current.getId() > searchKey) return search(current.getLeft(), searchKey);
        return search(current.getRight(), searchKey);
    }

    @Override
    public String toString() {
        if (this.root == null) return "[]";
        StringBuilder bstStringBuilder = new StringBuilder();
        bstStringBuilder.append('[').append('\n');
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        queue.add(null);

        StringBuilder innerBuilder = new StringBuilder();
        innerBuilder.append('\t').append('[').append(' ');
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if (curr != null) {
                innerBuilder.append(curr.getId()).append(' ');
                if (curr.getLeft() != null) queue.add(curr.getLeft());
                if (curr.getRight() != null) queue.add(curr.getRight());
            } else {
                innerBuilder.append(']').append('\n');
                bstStringBuilder.append(innerBuilder);
                innerBuilder.setLength(0);
                innerBuilder.append('\t').append('[').append(' ');
                if (!queue.isEmpty()) queue.add(null);
            }
        }
        bstStringBuilder.append(']');
        return bstStringBuilder.toString();
    }
}
