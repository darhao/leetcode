package leetcode.binarysearch;

public class UnknowLengthArraySearcher {

	static class ArrayReader{
		int[] data;
		public ArrayReader(int[] data) {
			this.data = data;
		}
		
		public int get(int index){
			if(index >= data.length) {
				return 2147483647;
			}
			return data[index];
		}
	}
	
	
    public int search(ArrayReader reader, int target) {
        //指数遍历到大于目标
    	int n = 0;
    	int index = 0;
    	while(reader.get(index) <= target) {
    		n++;
    		index = (int) Math.pow(2, n);
    	}
    	//二分法
    	return search0(reader, target, index + 1);
    }
    
    
    private int search0(ArrayReader reader, int target, int length) {
    	int left = 0;
    	int right = length - 1;
    	int mid;
    	while(left <= right) {
    		mid = left + (right - left) / 2;
    		if(target == reader.get(mid)) {
    			return mid;
    		}else if(target < reader.get(mid)){
    			right = mid - 1;
    		}else if(target > reader.get(mid)){
				left = mid + 1;
    		}
    	}
		return -1;
    }
	
    
    public static void main(String[] args) {
		new UnknowLengthArraySearcher().search(new ArrayReader(new int[] {-1, 0, 3, 5, 9, 12}), 9);
	}
}
