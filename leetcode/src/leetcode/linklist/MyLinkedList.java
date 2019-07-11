package leetcode.linklist;

public class MyLinkedList {

	class Node{
		Node next;
		int data;
	}
	
	
	private Node head;
	private int size;
	
	
	/** Initialize your data structure here. */
    public MyLinkedList() {
    	head = null;
    	size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    	if(index < 0 || index >= size) {
        	return -1;
        }
        Node node = head;
    	for (int i = 0; i < index; i++) {
			node = node.next;
		}
    	return node.data;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	if(head == null) {
    		head = new Node();
    		head.data = val;
    	}else {
    		Node node = new Node();
            node.data = val;
            node.next = head;
            head = node;
    	}
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	if(head == null) {
    		head = new Node();
    		head.data = val;
    	}else {
    		Node node = head;	
			while(node.next != null) {
				node = node.next;
			}
			Node tail = new Node();
			tail.data = val;
			node.next = tail;
    	}
    	size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
    	if(index > size) {
        	return;
        }
    	if(index <= 0) {
    		addAtHead(val);
    		return;
    	}
        Node node = head;
    	for (int i = 0; i < index - 1; i++) {
			node = node.next;
		}
    	Node newNode = new Node();
    	newNode.data = val;
    	newNode.next = node.next;
    	node.next = newNode;
    	size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
        	return;
        }
    	if(index == 0) {
        	head = head.next;
        	return;
        }
        Node node = head;
        for (int i = 0; i < index - 1; i++) {
        	node = node.next;
		}
        node.next = node.next.next;
        size--;
    }
    
    
//    public static void main(String[] args) {
//    	MyLinkedList obj = new MyLinkedList();
//    	obj.addAtHead(1);
//    	obj.addAtIndex(1, 2);
//    	int param_1 = obj.get(1);
//    	int param_2 = obj.get(0);
//    	int param_3 = obj.get(2);
//	}
	
}
