package leetcode.queue_stack;

public class FindTargetSumWays {

	private int ways = 0;
	
    public int findTargetSumWays(int[] nums, int S) {
        dfs(0, 0, nums, S);
        return ways;
    }
    
    
    private void dfs(int sum, int index, int[] nums, int S) {
    	if(index == nums.length) {
    		if(S == sum) {
    			ways++;
    		}
    		return;
    	}
    	int newIndex = index + 1;
    	dfs(sum + nums[index], newIndex, nums, S);
    	dfs(sum - nums[index], newIndex, nums, S);
    }
    
    
    public static void main(String[] args) {
		System.out.println(new FindTargetSumWays().findTargetSumWays(new int[] {1, 1, 1, 1, 1,1, 1, 1, 1, 1,1, 1, 1, 1, 1,1, 1, 1, 1, 1}, 3));
	}
}
