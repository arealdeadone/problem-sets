package tech.arvindrachuri.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    private int id;

    private TreeNode left;

    private TreeNode right;

    private TreeNode parent;
}
