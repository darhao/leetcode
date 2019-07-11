package leetcode.queue_stack;

import java.util.Stack;

public class EffectiveBracket {

    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
    	for (int i = 0; i < s.length(); i++) {
			char fromStringChar = s.charAt(i);
			if(fromStringChar == '(' || fromStringChar == '[' || fromStringChar == '{') {
				brackets.push(fromStringChar);
			} else {
				if(brackets.isEmpty()) {
					return false;
				}
				char fromStackChar = brackets.pop();
				boolean b1 = fromStackChar == '(' && fromStringChar == ')';
				boolean b2 = fromStackChar == '[' && fromStringChar == ']';
				boolean b3 = fromStackChar == '{' && fromStringChar == '}';
				if(!b1 && !b2 && !b3) {
					return false;
				}
			}
		}
    	//如果栈空就true
    	return brackets.isEmpty();
    }
    
    
    public static void main(String[] args) {
		System.out.println(new EffectiveBracket().isValid("{[]}"));
		System.out.println(new EffectiveBracket().isValid("()[]{}"));
		System.out.println(new EffectiveBracket().isValid("(]"));
		System.out.println(new EffectiveBracket().isValid("([)]"));
	}
}
