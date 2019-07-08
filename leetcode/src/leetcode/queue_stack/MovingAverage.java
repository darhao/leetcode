package leetcode.queue_stack;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

	private Queue<Integer> queue;
	private int size;
	
	
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
    	this.size = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        if(queue.size() == size) {
        	queue.poll();
        }
        queue.offer(val);
        int sum = 0;
        for (Integer integer : queue) {
			sum += integer;
		}
        return sum * 1.0 / queue.size();
    }
	
}
