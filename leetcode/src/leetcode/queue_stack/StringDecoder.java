package leetcode.queue_stack;

import java.util.Stack;

public class StringDecoder {

    public String decodeString(String s) {
    	if(s.isEmpty()) {
    		return "";
    	}
    	Stack<String> stack = new Stack<>();
    	char[] cs = s.toCharArray();
    	for (int i = 0; i < cs.length; i++) {
			char c = cs[i];
			if(isNumber(c)) {
				if(!stack.isEmpty() && isNumber(stack.peek().charAt(0))) {
					stack.push(Integer.parseInt(stack.pop() + String.valueOf(c)) + "");
				}else {
					stack.push(String.valueOf(c));
				}
			}else if(isLetter(c)) {
				if(!stack.isEmpty() && isLetter(stack.peek().charAt(0))) {
					stack.push(stack.pop() + String.valueOf(c));
				}else {
					stack.push(String.valueOf(c));
				}
			}else if(c == ']') {
				String string = stack.pop();
				stack.pop();//弹出分隔符
				int count = Integer.parseInt(stack.pop());
				String decodeString = decode(string, count);
				if(!stack.isEmpty() && isLetter(stack.peek().charAt(0))) {
					stack.push(stack.pop() + decodeString);
				}else {
					stack.push(decodeString);
				}
			}else if(c == '[') {
				stack.push("*");
			}
		}
		return stack.pop();
    }

    
	private String decode(String string, int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(string);
		}
		return sb.toString();
	}
	
	
	private boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}
	
	
	private boolean isLetter(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
	
	
	public static void main(String[] args) {
		System.out.println(new StringDecoder().decodeString("3[2[a]]"));
		System.out.println(new StringDecoder().decodeString("3[2[ab]]"));
		System.out.println(new StringDecoder().decodeString("3[2[Ha]1[Darhao]]"));
		System.out.println(new StringDecoder().decodeString("3[1[Ha]1[Darhao]]"));
		System.out.println(new StringDecoder().decodeString("3[Bobo2[Ha]Kiki]"));
	}
	
}
