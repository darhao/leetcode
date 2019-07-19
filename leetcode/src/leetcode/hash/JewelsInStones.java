package leetcode.hash;

import java.util.HashSet;
import java.util.Set;

public class JewelsInStones {

    public int numJewelsInStones(String J, String S) {
    	Set<Character> jewels = new HashSet<Character>();
    	for (Character character : J.toCharArray()) {
			jewels.add(character);
		}
    	int sum = 0;
    	for (Character character : S.toCharArray()) {
			if(jewels.contains(character)) {
				sum++;
			}
		}
    	return sum;
    }
	
}
