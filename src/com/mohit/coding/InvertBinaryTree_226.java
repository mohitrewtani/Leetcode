package com.mohit.coding;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
}
public class InvertBinaryTree_226 {
/*
 * Given the root of a binary tree, invert the tree, and return its root.
 * Input: root = [4,2,7,1,3,6,9] Output: [4,7,2,9,6,3,1]
 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
		root = invertTree(root);
		printTree(root);
	} 
    public static TreeNode invertTree(TreeNode root) {
    	if(root == null)
    		return null;
    	
    	TreeNode tmp = root.left;
    	root.left = root.right;
    	root.right = tmp;
    	
    	invertTree(root.left);
    	invertTree(root.right);
    	
        return root;
    }
	public static void printTree(TreeNode root) {  
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int levelNodes = q.size();
			while(levelNodes>0){
				TreeNode n = (TreeNode)q.remove();
				System.out.print(" " + n.val);
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;
			}

		}

	} 
}
