package leetcode.array_string;

public class CountAndSayer {

    public String countAndSay(int n) {
    	String s = "1";
        int count = 1;
        char curChar = '\0';
        StringBuilder sb;
        for (int i = 0; i < n - 1; i++) {
        	sb = new StringBuilder();
			for (char c : s.toCharArray()) {
				if(c != curChar) {
					if(curChar != '\0') {
						sb.append(count);
						sb.append(curChar);
					}
					curChar = c;
					count = 1;
				}else {
					count++;
				}
			}
			sb.append(count);
			sb.append(curChar);
			curChar = '\0';
			count = 1;
			s = sb.toString();
		}
        return s;
    }
    
    
    public static void main(String[] args) {
    	for (int i = 1; i <= 30; i++) {
    		System.out.println(new CountAndSayer().countAndSay(i));
		}
	}
	
}
