package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Fib {

	Map<Integer, Integer> cache = new HashMap<>();
	
    public int fib(int N) {
        if(cache.containsKey(N)) {
        	return cache.get(N);
        }
        
        if(N < 2) {
        	return N;
        }
        
        int result = fib(N - 1) + fib(N - 2);
        
        cache.put(N, result);
        
        return result;
    }
    
    
    public static void main(String[] args) {
    	long a = System.currentTimeMillis();	
    	new Fib().fib(30);
		System.out.println("ºÄÊ±£º" + (System.currentTimeMillis() - a));
	}
	
}
