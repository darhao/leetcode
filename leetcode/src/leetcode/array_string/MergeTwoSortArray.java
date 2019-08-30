package leetcode.array_string;

public class MergeTwoSortArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int indexInNums1 = 0;
    	for (int indexInNums2 = 0; indexInNums2 < n; indexInNums2++) {
    		while(true) {
    			if(nums2[indexInNums2] < nums1[indexInNums1]) {
    				//1往后推
    				for (int i = m - 1; i >= indexInNums1; i--) {
    					nums1[i + 1] = nums1[i];
					}
    				nums1[indexInNums1] = nums2[indexInNums2];//2插进来
    				m++;//长度加1
    				break;
    			}else if(indexInNums1 == m) {
    				nums1[indexInNums1] = nums2[indexInNums2];
    				m++;
    				break;
    			}
    			indexInNums1++;
    		}
		}
    }
	
}
