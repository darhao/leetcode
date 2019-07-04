package leetcode.array_string;

public class TwoSum {

    /**
     * 双指针
     */
    public int[] twoSum(int[] numbers, int target) {
    	int start = 0;
    	int end = numbers.length - 1;
    	while(start < end) {
    		if(numbers[start] + numbers[end] > target) {
    			end--;
    		}else if(numbers[start] + numbers[end] < target) {
    			start++;
    		}else {
    			break;
    		}
    	}
    	int[] result = new int[2];
    	result[0] = start + 1;
    	result[1] = end + 1;
    	return result;
    }
    
//    二分法查找
//    private Integer getIndex(int numbers[], int value) {
//    	if(value > numbers[numbers.length / 2]) {
//    		if(numbers.length == 1) {
//    			return null;
//    		}
//    		int[] right = new int[numbers.length / 2 + numbers.length % 2];
//    		for (int i = 0; i < numbers.length / 2 + numbers.length % 2; i++) {
//    			right[i] = numbers[i + numbers.length / 2];
//    		}
//    		Integer temp = getIndex(right, value);
//    		if(temp != null) {
//    			return temp + numbers.length / 2;
//    		}else {
//    			return null;
//    		}
//    	}else if(value < numbers[numbers.length / 2]) {
//    		if(numbers.length == 1) {
//    			return null;
//    		}
//    		int[] left = new int[numbers.length / 2];
//    		for (int i = 0; i < numbers.length / 2; i++) {
//    			left[i] = numbers[i];
//    		}
//    		return getIndex(left, value);
//    	}else {
//    		return numbers.length / 2;
//    	}
//    }
    
	public static void main(String[] args) {
		int[] result = new TwoSum().twoSum(new int[] {-1, 0}, -1);
		System.out.println(result[0] + "," + result[1]);
		result = new TwoSum().twoSum(new int[] {2,7,11,15}, 9);
		System.out.println(result[0] + "," + result[1]);
		result = new TwoSum().twoSum(new int[] {0,2,6,6,7}, 9);
		System.out.println(result[0] + "," + result[1]);
	}
	
}