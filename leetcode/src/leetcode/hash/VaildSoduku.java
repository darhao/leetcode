package leetcode.hash;

public class VaildSoduku {

	private char[][] board;
	
    public boolean isValidSudoku(char[][] board) {
    	this.board = board;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] != '.') {
					if(!checkRow(i, j) || !checkCol(i, j) ||!checkRoom(i, j)) {
						return false;
					}
				}
			}
		}
		return true;
    }

	private boolean checkRoom(int i, int j) {
		int roomRow = i / 3;
		int roomCol = j / 3;
		for (int k = roomRow * 3; k < roomRow * 3 + 3; k++) {
			for (int m = roomCol * 3; m < roomCol * 3 + 3; m++) {
				if(k != i && m != j) {
					if(board[k][m] == board[i][j]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean checkRow(int i, int j) {
		for (int m = 0; m < 9; m++) {
			if(m != j) {
				if(board[i][m] == board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean checkCol(int i, int j) {
		for (int m = 0; m < 9; m++) {
			if(m != i) {
				if(board[m][j] == board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		new VaildSoduku().isValidSudoku(new char[][] {{'5','3','.','.','7','.','.','.','2'},{'6','.','.','1','9','5','.','2','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
	}
	
}
