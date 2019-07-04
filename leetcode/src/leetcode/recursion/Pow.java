package leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class Pow {

	Map<Integer, Double> cache  = new HashMap<>();
	
    public double myPow(double x, int n) {
    	if(n < 0) { //���ж�
    		x = 1 / x;
    	}
    	return pow(x, n);
    }
    
    public double pow(double x, int n) {
    	if(n == 0) { //�������
    		return 1;
    	}
    	
    	if(cache.containsKey(n)) { //�����ж�
    		return cache.get(n);
    	}
    	
    	double result = pow(x, n/2) * pow(x, n/2);
    	
    	if(n % 2 != 0) { //��ż�ж�
    		result *= x;
    	}
    	cache.put(n, result);//���湫ʽ
    	return result;
    }
    
    public static void main(String[] args) {
    	Double a = (double) System.nanoTime();	
    	new Pow().myPow(0.00001, 2147483647);
		System.out.println("��ʱ��" + (System.nanoTime() - a) / (1000*1000) + "ms");
	}
	
}
