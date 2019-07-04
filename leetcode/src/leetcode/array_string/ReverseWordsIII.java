package leetcode.array_string;

public class ReverseWordsIII {

    public String reverseWords(String s) {
        String[] data = s.split("\\s");
        for (int i = 0; i < data.length; i++) {
			data[i] = revers(data[i]);
		}
        StringBuilder sb = new StringBuilder();
        for (String string : data) {
			sb.append(string + " ");
		}
        return sb.toString().trim();
    }
    

	private String revers(String string) {
		char[] chars = string.toCharArray();
		int a = 0, b = chars.length - 1;
		while(a < b) {
			char temp = chars[a];
			chars[a] = chars[b];
			chars[b] = temp;
			a++;
			b--;
		}
		return new String(chars);
	}
	
	
	public static void main(String[] args) {
		new ReverseWordsIII().reverseWords("abc def hij");
	}
}
