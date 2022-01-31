package com.learning.BalancingBrackets;

import java.util.*;

public class BalancingBrackets {
	
	static boolean isBracketsBalanced(String str) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if(ch == '{' || ch == '[' || ch == '(') {
				stack.push(ch);
			}
			else {
				//Check empty stack to ensure opening bracket is present in stack to match with the closing bracket
				//If we get closing bracket in the beginning, we can end the function
				if(stack.isEmpty())
					return false;
				
				switch (ch) {
				case '}':
					if(stack.pop() != '{') {
						return false;
					}
					break;
				case ']':
					if(stack.pop() != '[') {
						return false;
					}
					break;
				case ')':
					if(stack.pop() != '(') {
						return false;
					}
					break;
				}
			}
		}
		//Check empty stack to ensure all opening brackets gets a match with a closing bracket
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		
		System.out.println("Balancing Brackets check =>");
		
		String str1 = "([[{}]])";
		String str2 = "([[{}]]))";
				
		System.out.println("1. "+str1);
		if(isBracketsBalanced(str1)) {
			System.out.println("The entered String has Balanced Brackets");
		}
		else {
			System.out.println("The entered String do not contain Balanced brackets");
		}
		
		System.out.println("2. "+str2);
		if(isBracketsBalanced(str2)) {
			System.out.println("The entered String has Balanced Brackets");
		}
		else {
			System.out.println("The entered String do not contain Balanced brackets");
		}
		
		/*
		String str3 = "}]])([[{";
		System.out.println("3. "+str3);
		if(isBracketsBalanced(str3)) {
			System.out.println("The entered String has Balanced Brackets");
		}
		else {
			System.out.println("The entered String do not contain Balanced brackets");
		}
		*/
	}

}
