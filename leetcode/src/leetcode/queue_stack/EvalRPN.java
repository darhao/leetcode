package leetcode.queue_stack;

import java.util.Stack;

public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
        	String result = null;
        	int o1, o2;
			switch (token) {
			case "+":
				o1 = Integer.parseInt(stack.pop());
				o2 = Integer.parseInt(stack.pop());
				result = (o2 + o1) + "";
				break;
			case "-":
				o1 = Integer.parseInt(stack.pop());
				o2 = Integer.parseInt(stack.pop());
				result = (o2 - o1) + "";
				break;
			case "*":
				o1 = Integer.parseInt(stack.pop());
				o2 = Integer.parseInt(stack.pop());
				result = (o2 * o1) + "";
				break;
			case "/":
				o1 = Integer.parseInt(stack.pop());
				o2 = Integer.parseInt(stack.pop());
				result = (o2 / o1) + "";
				break;
			default:
				result = token;
				break;
			}
			stack.push(result);
		}
        return Integer.parseInt(stack.pop());
    }
	
}
