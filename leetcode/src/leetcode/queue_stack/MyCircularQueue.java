package leetcode.queue_stack;

public class MyCircularQueue {
	
	private int[] data;
	private int head;
	private int tail;
	private boolean lastActionIsEnQuene;
	
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
    	if(isFull()) {
    		return false;
    	}
    	data[tail] = value;
    	tail = (tail + 1) % data.length;
    	lastActionIsEnQuene = true;
    	return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) {
        	return false;
        }
        head = (head + 1) % data.length;
        lastActionIsEnQuene = false;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	if(isEmpty()) {
    		return -1;
    	}
        return data[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	if(isEmpty()) {
    		return -1;
    	}
    	if(tail == 0) {
    		return data[data.length - 1];
    	}else {
    		return data[tail - 1];
    	}
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == tail && !lastActionIsEnQuene;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return head == tail && lastActionIsEnQuene;
    }
    
    
    public static void main(String[] args) {
    	MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3

    	circularQueue.enQueue(1);  // 返回 true

    	circularQueue.enQueue(2);  // 返回 true

    	circularQueue.enQueue(3);  // 返回 true
    	
    	circularQueue.Front();

    	circularQueue.enQueue(4);  // 返回 false，队列已满

    	circularQueue.Rear();  // 返回 3

    	circularQueue.isFull();  // 返回 true

    	circularQueue.deQueue();  // 返回 true

    	circularQueue.enQueue(4);  // 返回 true

    	circularQueue.Rear();  // 返回 4
	}

}
