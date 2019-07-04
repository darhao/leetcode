package leetcode.array_string;

public class Rotate {

    public void rotate(int[] nums, int k) {
        int moveTimes = k % nums.length;
        for (int i = 0; i < moveTimes; i++) {
        	int temp =  nums[nums.length - 1];
			for (int j = nums.length - 1; j > 0; j--) {
				nums[j] = nums[j - 1];
			}
			nums[0] = temp;
		}
    }
    
    
    public static void main(String[] args) {
    	int[] nums = new int[] {1,2,3,4};
    	new Rotate().rotate(nums, 10);
		for (int i : nums) {
			System.out.print(i+", ");
		}
	}
	
}
