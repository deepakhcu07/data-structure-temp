package com.deepak.datastructure.nonlinear.tree;

public class BinaryTree {

	private Node root;
	
	public Node getRoot() {
		return root;
	}
	
	
	
	public void createCompleteBinaryTree(int []numbers) {
		root = createBinaryTree(numbers, 0);
	}
	
	private Node createBinaryTree(int []numbers, int start) {
		int size = numbers.length;
		
		Node current = new Node(numbers[start], null, null);
		
		int left = 2 * start + 1;
		int right = 2* start + 2;
		
		if(left < size) {
			current.left = createBinaryTree(numbers, left);
		}
		
		if(right < size) {
			current.right = createBinaryTree(numbers, right);
		}
		return current;
	}
	
	public void print() {
		System.out.println(" IN ORDER");
		inorder(root);
		
		System.out.println("\n PRE ORDER");
		preorder(root);
		
		System.out.println("\n POST ORDER");
		postorder(root);
	}
	
	private void inorder(Node node) {
		if(node !=null) {
			inorder(node.left);
			System.out.print(" " + node.data);
			inorder(node.right);
		}
	}
	
	private void preorder(Node node) {
		if(node !=null) {
			System.out.print(" " + node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	private void postorder(Node node) {
		if(node !=null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(" " + node.data);
		}
	}
	
	
	
	private static class Node{
		private int data;
		private Node left;
		private Node right;
		
		Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public String toString() {
			return data+"";
		}
	}
	
	
	public static void main(String []args) {
		BinaryTree binaryTree = new BinaryTree();
		int []numbers = {1,2,3,4,5,6,7,8};
		binaryTree.createCompleteBinaryTree(numbers);
		binaryTree.print();
	}
}
