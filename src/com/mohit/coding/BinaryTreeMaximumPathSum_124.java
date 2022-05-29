package com.mohit.coding;
public class BinaryTreeMaximumPathSum_124 {
/*
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. 
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * 
 * Input: root = [1,2,3] Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * 
 * Input: root = [-10,9,20,null,null,15,7] Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(maxPathSum(root));
	}
    static int max_sum;
    public static int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        maxPathSumUtil(root);
        return max_sum;
    }
	private static int maxPathSumUtil(TreeNode root) {
		if(root == null)return 0;
        int left = Math.max(0,maxPathSumUtil(root.left));
        int right = Math.max(0,maxPathSumUtil(root.right));
        max_sum = Math.max(max_sum, right+left+root.val);
        System.out.println(max_sum);
        return Math.max(left + root.val, right + root.val);		
	}

}
