package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Pow {

	Map<Integer, Double> cache  = new HashMap<>();
	
    public double myPow(double x, int n) {
    	if(n < 0) { //¸ºÅÐ¶Ï
    		x = 1 / x;
    	}
    	return pow(x, n);
    }
    
    public double pow(double x, int n) {
    	if(n == 0) { //»ù´¡Çé¿ö
    		return 1;
    	}
    	
    	if(cache.containsKey(n)) { //»º´æÅÐ¶Ï
    		return cache.get(n);
    	}
    	
    	double result = pow(x, n/2) * pow(x, n/2);
    	
    	if(n % 2 != 0) { //ÆæÅ¼ÅÐ¶Ï
    		result *= x;
    	}
    	cache.put(n, result);//»º´æ¹«Ê½
    	return result;
    }
    
    public static void main(String[] args) {
    	Double a = (double) System.nanoTime();	
    	new Pow().myPow(0.00001, 2147483647);
		System.out.println("ºÄÊ±£º" + (System.nanoTime() - a) / (1000*1000) + "ms");
	}
	
}
