package leetcode.binarysearch;

public class GuessGame {

	private int answer;
	
	public GuessGame(int answer) {
		this.answer = answer;
	}
	
    public int guessNumber(int n) {
    	int left = 1;
		int right = n;
		int mid;
    	while(left <= right) {
    		mid = left + (right - left) / 2;
    		if(guess(mid) == 0) {
    			return mid;
    		}else if(guess(mid) == -1){
    			right = mid - 1;
    		}else if(guess(mid) == 1){
				left = mid + 1;
    		}
    	}
		return -1;
    }
	
    
    private int guess(int n) {
    	if(n == answer) 
    		return 0;
    	else if(n < answer) 
    		return 1;
    	else 
    		return -1;
    }
    
    
    public static void main(String[] args) {
		System.out.println(new GuessGame(6).guessNumber(10));
		System.out.println(new GuessGame(6).guessNumber(6));
		System.out.println(new GuessGame(1702766719).guessNumber(2126753390));
		System.out.println(new GuessGame(1000).guessNumber(10000));
		System.out.println(new GuessGame(0).guessNumber(10000));
	}
    
}
