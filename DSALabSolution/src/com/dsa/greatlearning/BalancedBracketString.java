package com.dsa.greatlearning;

import java.util.Stack;

public class BalancedBracketString {
	public static boolean checkBalancedStatus(String bracketsToCheck) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < bracketsToCheck.length(); i++) {
			char myChar = bracketsToCheck.charAt(i);
			if(myChar =='(' || myChar == '[' || myChar == '{') {
				stack.push(myChar);
				continue;
			}
			
			if(stack.isEmpty()) {
				return false;
			}
			
			char brack;
			if(myChar == '}') {
				brack = stack.pop();
				if(myChar == '(' || myChar == '[') {
					return false;
				}
			}
			if(myChar == ')') {
				brack = stack.pop();
				if(myChar == '{' || myChar == '[') {
					return false;
				}
			}
			if(myChar == ']') {
				brack = stack.pop();
				if(myChar == '(' || myChar == '{') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String bracketsToCheck="([[{}]])";
		if(checkBalancedStatus(bracketsToCheck)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered String has Unbalanced Brackets");
		}
	}
}
