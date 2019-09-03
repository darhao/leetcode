package leetcode.array_string;

public class MyAtoi {

    private boolean isNegative;


	public int myAtoi(String str) {
    	try {
    		str = str.trim();
	    	//判断符号
	    	if(str.charAt(0) == '+' && isNumber(str.charAt(1)) || isNumber(str.charAt(0))) {
	    		isNegative = false;
	    		if(str.charAt(0) == '+') {
	    			str = str.substring(1);
	    		}
	    	}else if(str.charAt(0) == '-' && isNumber(str.charAt(1))) {
	    		isNegative = true;
	    	}else {
	    		return 0;
	    	}
	    	//判断是否是负数
	    	int start = isNegative ? 1 : 0;
	    	int end = str.length();
	    	for (int i = start; i < str.length(); i++) {
				if(!isNumber(str.charAt(i))) {
					end = i;
					break;
				}
			}
	    	str = str.substring(0, end);
	    	if(str.equals("")) {
	    		return 0;
	    	}
			return Integer.valueOf(str);
		} catch (Exception e) {
			if(e instanceof NumberFormatException) {
				return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}else{
				return 0;
			}
			
		}
    }
    
    
    private boolean isNumber(char c) {
    	return c >= '0' && c <= '9';
    }
    
    
    public static void main(String[] args) {
		System.out.println(new MyAtoi().myAtoi(""));
		System.out.println(new MyAtoi().myAtoi(null));
		System.out.println(new MyAtoi().myAtoi("000"));
		System.out.println(new MyAtoi().myAtoi("-+1"));
		System.out.println(new MyAtoi().myAtoi("+-1"));
		System.out.println(new MyAtoi().myAtoi("+"));
		System.out.println(new MyAtoi().myAtoi("++"));
		System.out.println(new MyAtoi().myAtoi("-"));
		System.out.println(new MyAtoi().myAtoi("--"));
		System.out.println(new MyAtoi().myAtoi("+5"));
		System.out.println(new MyAtoi().myAtoi("-5"));
		System.out.println(new MyAtoi().myAtoi("-1s"));
		System.out.println(new MyAtoi().myAtoi("+1s"));
		System.out.println(new MyAtoi().myAtoi("  "));
		System.out.println(new MyAtoi().myAtoi("  1s"));
		System.out.println(new MyAtoi().myAtoi("  +1s"));
		System.out.println(new MyAtoi().myAtoi("  5  "));
	}
	
}
