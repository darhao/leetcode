package leetcode.array_string;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int oldIndex = 0, newIndex = 0;
        for (oldIndex = 0; oldIndex < nums.length; oldIndex++) {
			if(nums[oldIndex] != val) {
				nums[newIndex] = nums[oldIndex];
				newIndex++;
			}
		}
        return newIndex;
    }
	
}
