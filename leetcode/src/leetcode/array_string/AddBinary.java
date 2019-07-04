package leetcode.array_string;

public class AddBinary {

    public String addBinary(String a, String b) {
    	StringBuilder A = new StringBuilder(a);
    	StringBuilder B = new StringBuilder(b);
    	StringBuilder result = new StringBuilder();
    	fill0(A, B);
    	int carry = 0;
    	for (int i = A.length() - 1; i > -1; i--) {
			int aa = Character.getNumericValue((A.charAt(i)));
			int bb = Character.getNumericValue((B.charAt(i)));
			int sum = aa + bb + carry;
			carry = 0;
			switch (sum) {
			case 0:
				result.insert(0, '0');
				break;
			case 1:
				result.insert(0, '1');
				break;
			case 2:
				result.insert(0, '0');
				carry = 1;
				break;
			case 3:
				result.insert(0, '1');
				carry = 1;
				break;
			default:
				break;
			}
			
		}
    	if(carry == 1) {
    		result.insert(0, '1');
    	}
    	return result.toString();
    }
    
    
    private void fill0(StringBuilder a, StringBuilder b) {
    	int difference = a.length() - b.length();
    	if(difference > 0) {
    		for (int i = 0; i < difference; i++) {
				b.insert(0, "0");
			}
    	}else if(difference < 0) {
    		for (int i = 0; i < (-difference); i++) {
				a.insert(0, "0");
			}
    	}
    }


	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("1", "111"));
		System.out.println(new AddBinary().addBinary("11", "1"));
		System.out.println(new AddBinary().addBinary("1010", "1011"));
		System.out.println(new AddBinary().addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
	}
}
