package leetcode;

/*
 * 0
 * 01
 * 0110
 * 01101001
 * 0110100110010110
 * 01101001100101101001011001101001
 * 每行前半部分和前一行一样，每行后半部分和当前行前半部分相反
 */
public class KthGrammer {

    public int kthGrammar(int N, int K) {
    	int halfLength = (int) (Math.pow(2, N-1) / 2);
    	if(halfLength == 0) {
    		return 0;
    	}
    	if(K <= halfLength) {
    		return kthGrammar(N-1, K);
    	}else {
    		return (kthGrammar(N-1, K - halfLength) + 1) % 2;
    	}
    }
    
    
    public static void main(String[] args) {
    	Double a = (double) System.nanoTime();	
    	System.out.println(new KthGrammer().kthGrammar(30, 5));
		System.out.println("耗时" + (System.nanoTime() - a) / (1000*1000) + "ms");
	}
	
}
