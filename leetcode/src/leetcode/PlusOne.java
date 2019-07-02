package leetcode;

public class PlusOne {

    public int[] plusOne(int[] digits) {
    	//新建一个长度比digits数组多1的以0开头的后续元素与其相同的数组
    	int[] result = new int[digits.length + 1];
    	result[0] = 0;
    	for (int i = 0; i < result.length - 1; i++) {
			result[i+1] = digits[i];
		}
    	//result末位+1
    	result[result.length - 1] += 1;
    	//进位检查遍历
    	for (int i = result.length - 1; i > 0; i--) {
			if(result[i] == 10) {
				result[i] = 0;
				result[i - 1] += 1;
			}
		}
    	//检查首位是否等于0，是就不返回首位
    	if(result[0] == 0) {
    		int[] temp = new int[result.length - 1];
    		for (int i = 0; i < temp.length; i++) {
				temp[i] = result[i + 1];
			}
    		return temp;
    	}else {
    		return result;
    	}
    }
	
}
