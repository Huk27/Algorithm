package LeetCode.DFS;

/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes
 along the longest path from the root node down to the farthest leaf node.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2


Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */
public class MaximumLengthOfBinaryTree {
    static int maxDepth = 0;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode treeBuilder(Integer[] input, int index) {
        int val;
        if (input[index] == null) {
            return null;
        } else {
            val = input[index];
        }
        TreeNode node = new TreeNode(val);

        int leftIndex = 2*index + 1;
        int rightIndex = 2*index + 2;
        if (rightIndex < input.length) {
            node.left = treeBuilder(input, leftIndex);
            node.right = treeBuilder(input, rightIndex);
        }
        return node;
    }

    public static int maxDepth(TreeNode node) {
       return maxDepth2(node, 1);
    }

    public static int maxDepth2(TreeNode node, int currentDepth) {
        if (node == null) {
            return 0;
        }

        currentDepth++;
        int leftDepth = maxDepth2(node.left, currentDepth);
        int rightDepth  =maxDepth2(node.right, currentDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = treeBuilder(new Integer[]{3,9,20,null,null,15,7}, 0);
        System.out.println(maxDepth(root));
        TreeNode root2 = treeBuilder(new Integer[]{1,null,2}, 0);
        System.out.println(maxDepth(root2));
    }

}
