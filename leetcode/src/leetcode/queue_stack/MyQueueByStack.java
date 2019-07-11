package leetcode.queue_stack;

import java.util.Stack;

public class MyQueueByStack {

	class MyQueue {

		private Stack<Integer> stack;
		
		
	    /** Initialize your data structure here. */
	    public MyQueue() {
	    	stack = new Stack<>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        stack.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        Stack<Integer> temp = new Stack<Integer>();
	        while(!stack.isEmpty()) {
	        	temp.push(stack.pop());
	        }
	        int result = temp.pop();
	        while(!temp.isEmpty()) {
	        	stack.push(temp.pop());
	        }
	        return result;
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	    	Stack<Integer> temp = new Stack<Integer>();
	        while(!stack.isEmpty()) {
	        	temp.push(stack.pop());
	        }
	        int result = temp.peek();
	        while(!temp.isEmpty()) {
	        	stack.push(temp.pop());
	        }
	        return result;
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return stack.isEmpty();
	    }
	    
	}

	
}
