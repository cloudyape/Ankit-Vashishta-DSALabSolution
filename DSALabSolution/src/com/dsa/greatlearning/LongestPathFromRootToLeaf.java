package com.dsa.greatlearning;

import java.util.ArrayList;

class Node {
	Node leftPortion;
	Node rightPortion;
	int enteredData;
}

public class LongestPathFromRootToLeaf {
	
	static Node newNode(int NodeDataToShow) {
		Node node = new Node();
		node.enteredData = NodeDataToShow;
		node.leftPortion = node.rightPortion = null;
		
		return node;
	}
	
	static ArrayList<Integer> biggestNode(Node root) {
		if(root == null) {
			return new ArrayList<Integer>();
		}
		
		ArrayList<Integer> rightNode = biggestNode(root.rightPortion);
		ArrayList<Integer> leftNode = biggestNode(root.leftPortion);
		if(rightNode.size() < leftNode.size()) {
			leftNode.add(root.enteredData);
		} else {
			rightNode.add(root.enteredData);
		}
		if(leftNode.size() > rightNode.size()) {
			return leftNode;
		} else {
			return rightNode;	
		}
	}
	
	public static void main(String[] args) {
		Node Root = newNode(100);
		Root.leftPortion = newNode(20);
		Root.rightPortion = newNode(130);
		Root.leftPortion.leftPortion = newNode(10);
		Root.leftPortion.rightPortion = newNode(50);
		Root.rightPortion.leftPortion = newNode(110);
		Root.rightPortion.rightPortion = newNode(140);
		Root.leftPortion.leftPortion.leftPortion = newNode(5);
		
		ArrayList<Integer> biggestNode = biggestNode(Root);
		int nodeLength = biggestNode.size();
		System.out.print("Longest path");
		for(int i = nodeLength-1; i >= 0; i--) {	
			System.out.print("->" + biggestNode.get(i));
		}
	}

}
