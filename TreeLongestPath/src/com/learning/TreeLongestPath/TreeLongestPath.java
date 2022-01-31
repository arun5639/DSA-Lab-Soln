package com.learning.TreeLongestPath;

import java.util.ArrayList;

class Node {
	int data;
	Node left;
	Node right;	
}

public class TreeLongestPath {
	
	static Node newNode(int data) {
		
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;
		
		return node;
	}
	
	private static ArrayList<Integer> findTreeLongestPath(Node root){
		
		if (root == null) {
			return new ArrayList<Integer>();
		}
		
		ArrayList<Integer> leftNode = findTreeLongestPath(root.left);
		ArrayList<Integer> rightNode = findTreeLongestPath(root.right);
		
		if(leftNode.size() > rightNode.size()) {
			leftNode.add(root.data);
		}
		else {
			rightNode.add(root.data);
		}
		
		return (leftNode.size() > rightNode.size() ? leftNode : rightNode);
	}

	public static void main(String[] args) {
		
		Node root = newNode(100);
		
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);
		
		ArrayList<Integer> longestPath = findTreeLongestPath(root);
		
		System.out.println(longestPath);
		
		for(int i = longestPath.size()-1; i>=0; i--) {
			System.out.print("->"+longestPath.get(i));
		}
	}
}
