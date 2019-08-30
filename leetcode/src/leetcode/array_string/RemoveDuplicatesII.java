package leetcode.array_string;

public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int fast = 1, slow = 0;
        boolean canDuplicate = true;
        while(fast < nums.length) {
        	if(nums[fast] != nums[slow]) {
        		canDuplicate = true;
        		slow++;
        		nums[slow] = nums[fast];
        	}else if(canDuplicate) {
        		canDuplicate = false;
        		slow++;
        		nums[slow] = nums[fast];
        	}
        	fast++;
        }
    	return slow + 1;	
    }
    
    
    public static void main(String[] args) {
		System.out.println(new RemoveDuplicatesII().removeDuplicates(new int[] {1}));
	}
	
}
