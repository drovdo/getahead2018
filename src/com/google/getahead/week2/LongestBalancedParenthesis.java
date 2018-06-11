package com.google.getahead.week2;


import java.util.Stack;

/**
 Given a string of parentheses, find the size of the longest continuous substring of balanced parenthesis. Parentheses are considered balanced when there is a valid closing parenthesis for an opening one.

 Test Cases
 Note that there may be other valid answers.
 For parentheses "( ) ) ( ( ) )", the longest continuous set would be 4 characters long (the last 4 characters of the input)
 For ") ( ( ) ) ) ) ) ( ( ( ( ( )" , the max length would be 4
 */

public class LongestBalancedParenthesis {

	private static int getLongestBalancedParathensisCount(String str) {
		Stack<Integer> stack = new Stack<>();
		int backParenthesisFlag = -1;
		int maxCount = 0;
		int lastCount = 0;
		int currentTime = 0;

		for(char c : str.toCharArray()) {
			if(c == '(') {
				stack.push(currentTime - lastCount);
			} else if(c == ')') {
				if(stack.empty()) {
					stack.push(backParenthesisFlag);
					lastCount = 0;
				} else {
					if(stack.peek() != backParenthesisFlag) {
						int time = stack.pop();
						lastCount = currentTime - time + 1;
						if(lastCount > maxCount) {
							maxCount = lastCount;
						}
					} else {
						stack.push(backParenthesisFlag);
						lastCount = 0;
					}
				}
			} else {
				throw new RuntimeException("String should contain only parenthesis");
			}
			currentTime++;
		}

		return maxCount;
	}

	private static void test(String str, int expectedAnswer) {
		int answer = getLongestBalancedParathensisCount(str);
		if(answer != expectedAnswer) {
			throw new RuntimeException("Validation failed, expected " + expectedAnswer + " but found " + answer);
		}
	}

	public static void main(String[] args) {
		test("())(())", 4);
		test(")(()))))((((()", 4);
		test("()()", 4);
		test("())()", 2);
		test("())()(()()))", 8);
		test("())()())(()()))", 6);
		test("())()())())()()))", 4);
	}
}
