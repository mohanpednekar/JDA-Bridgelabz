package com.jda.programs.ds;

import com.jda.util.Reader;
import com.jda.util.ds.Stack;

public class BalancedParentheses {
  
  public static void main(String[] args) {
    System.out.println("Enter an arithmetic expression");
    Reader reader = new Reader();
    String expression = reader.readLine();
    
    System.out.println(isBalanced(expression));
  }
  
  private static boolean isBalanced(String expression) {
    Stack<Character> stack = new Stack<>();
    for (char ch : expression.toCharArray()) {
      switch (ch) {
        case '(':
          stack.push('(');
          break;
        case ')':
          if (stack.isEmpty()) { return false; }
          stack.pop();
          break;
        default:
      }
    }
    return stack.isEmpty();
  }
}
