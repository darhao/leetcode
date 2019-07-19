package leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RestaurantFinder {

    public String[] findRestaurant(String[] list1, String[] list2) {
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	for (int i = 0; i < list1.length; i++) {
			for (int j = 0; j < list2.length; j++) {
				if(list1[i].equals(list2[j])) {
					map.put(list1[i], i+j);
					break;
				}
			}
		}
    	int minIndexSum = 999 * 2;
    	for (Integer indexSum : map.values()) {
			if(indexSum.intValue() < minIndexSum) {
				minIndexSum = indexSum;
			}
		}
    	Set<String> resultSet = new HashSet<String>();
    	for (String restaurant : map.keySet()) {
			if(map.get(restaurant).intValue() == minIndexSum) {
				resultSet.add(restaurant);
			}
		}
    	String[] result = new String[resultSet.size()];
    	int i = 0;
    	for (String string : resultSet) {
			result[i] = string;
			i++;
		}
    	return result;
    }
    
    public static void main(String[] args) {
    	String[] list1 = new String[] {"Shogun","Tapioca Express","Burger King","KFC"};
    	String[] list2 = new String[] {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
		new RestaurantFinder().findRestaurant(list1, list2);
	}
	
}
