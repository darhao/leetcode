package leetcode.array_string;

public class ReversWords {

    public String reverseWords(String s) {
    	String[] ss = s.split("\\s+");
		int a = 0, b = ss.length - 1;
    	while(a < b) {
    		String temp = ss[b];
    		ss[b] = ss[a];
    		ss[a] = temp;
    		a++;
    		b--;
    	}
    	StringBuilder sb = new StringBuilder();
    	for (String string : ss) {
			sb.append(string + " ");
		}
    	return sb.toString().trim();
    }
    
    public static void main(String[] args) {
		System.out.println(new ReversWords().reverseWords("a good   example"));
	}
	
}
