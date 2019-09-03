package leetcode.array_string;

public class IntegerReverse {

    public int reverse(int x) {
    	StringBuilder xx = new StringBuilder(String.valueOf(x));
    	//判断是否是负数
    	boolean isNegative = xx.charAt(0) == '-';
    	if(isNegative) {
    		xx.deleteCharAt(0);
    	}
    	//反转
    	for (int i = 0; i < xx.length() / 2; i++) {
			char c = xx.charAt(i);
			xx.setCharAt(i, xx.charAt(xx.length() - 1 - i));
			xx.setCharAt(xx.length() - 1 - i, c);
		}
    	//截断前面的0
    	while(xx.length() != 1 && xx.charAt(0) == '0') {
    		xx.deleteCharAt(0);
    	}
    	//补符号
    	if(isNegative) {
    		xx.insert(0, '-');
    	}
    	//转成数字
    	try {
			return Integer.valueOf(xx.toString());
		} catch (NumberFormatException e) {
			return 0;
		}
    }
	
    
    public static void main(String[] args) {
		System.out.println(new IntegerReverse().reverse(123));
		System.out.println(new IntegerReverse().reverse(-123));
		System.out.println(new IntegerReverse().reverse(0));
		System.out.println(new IntegerReverse().reverse(10086));
		System.out.println(new IntegerReverse().reverse(-100));
		System.out.println(new IntegerReverse().reverse(2147483647));
	}
}
