package leetcode.queue_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack;
	private List<Integer> list;
	
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }
    
    public void push(int x) {
    	stack.push(x);
		for (int i = 0; i < list.size(); i++) {
			if(x < list.get(i)) {
				list.add(i, x);
				return;
			}
		}
		list.add(x);
    }
    
    public void pop() {
    	int x = stack.pop();
    	for (int i = 0; i < list.size(); i++) {
			if(x == list.get(i)) {
				list.remove(i);
				return;
			}
		}
    }
    
    public int top() {
       return stack.peek();
    }
    
    public int getMin() {
        return list.get(0);
    }
    
    
    public static void main(String[] args) {
    	MinStack minStack = new MinStack();
    	minStack.push(0);
    	minStack.push(1);
    	minStack.push(0);
    	minStack.getMin();   
    	minStack.pop();
    	minStack.getMin();   
	}
	
}
