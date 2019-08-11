package leetcode.tree.BST;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	TreeSet<Integer> set = new TreeSet<>();
    	for (int i = 0; i < nums.length; i++) {
    		//��ȡ��ǰֵ
    		Long cur = (long) nums[i];
    		
    		//��ȡ�ȵ�ǰֵ�����Сֵ
    		Integer ceiling = set.ceiling(cur.intValue());
			//�ж��Ƿ���ڲ����Ƿ��뵱ǰֵ��಻����t
    		if(ceiling != null && ceiling.longValue() - cur <= t) {
				return true;
			}
			
    		//��ȡ�ȵ�ǰֵС�����ֵ
    		Integer floor = set.floor(cur.intValue());
			//�ж��Ƿ���ڲ����Ƿ��뵱ǰֵ��಻����t
    		if(floor != null && cur - floor.longValue() <= t) {
				return true;
			}
				
			//��Ԫ�ؼ�����
			set.add(cur.intValue());
			
			//������Ĵ���k�����Ƴ����ȼ����Ԫ�أ���ά��һ����СΪk�Ļ�������
			if(set.size() > k) {
				set.remove(nums[i - k]);
			}
		}
    	return false;
    }
	
}
