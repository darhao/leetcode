package leetcode.hash;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

	class Frequent {
		int num;
		int times;
		@Override
		public int hashCode() {
			return num;
		}
		@Override
		public boolean equals(Object obj) {
			return obj.hashCode() == hashCode();
		}
		public Frequent(int num) {
			this.num = num;
		}
	}
	
	class FrequentComparator implements Comparator<Frequent>{
		@Override
		public int compare(Frequent o1, Frequent o2) {
			return o1.times - o2.times;
		}
	}
	
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Frequent> frequents = new HashMap<>();
        for (int i : nums) {
			if(frequents.containsKey(i)) {
				frequents.get(i).times++;
			}else {
				frequents.put(i, new Frequent(i));
			}
		}
        List<Frequent> list = new LinkedList<>(frequents.values());
        list.sort(new FrequentComparator());
        list = list.subList(list.size() - k, list.size());
        List<Integer> list2 = new LinkedList<Integer>();
        for (int i = 0; i < list.size(); i++) {
			list2.add(list.get(i).num);
		}
        return list2;
    }

	public static void main(String[] args) {
		new TopKFrequent().topKFrequent(new int[] {1,1,2,3,3,3}, 2);
	}
	
}
