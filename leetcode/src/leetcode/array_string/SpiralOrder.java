package leetcode.array_string;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SpiralOrder {

	private Set<Integer> temp = new LinkedHashSet<>();

	public List<Integer> spiralOrder(int[][] matrix) {
		// �շ���
		if (matrix.length == 0) {
			return new ArrayList<>();
		}
		runCycle(matrix, 0, 0, matrix.length, matrix[0].length);
		return new ArrayList<>(temp);
	}

	private void runCycle(int[][] matrix, int startRow, int startCol, int rows, int cols) {
		if (startRow >= rows) {
			return;
		}

		try {
			for (int i = startCol; i < cols; i++) {
				temp.add(matrix[startRow][i]);
			}
		} catch (Exception ig) {
		}
		try {
			for (int i = startRow; i < rows; i++) {
				temp.add(matrix[i][cols - 1]);
			}
		} catch (Exception ig) {
		}
		try {
			for (int i = cols - 1; i > startCol - 1; i--) {
				temp.add(matrix[rows - 1][i]);
			}
		} catch (Exception ig) {
		}
		try {
			for (int i = rows - 1; i > startRow - 1; i--) {
				temp.add(matrix[i][startCol]);
			}
		} catch (Exception ig) {
		}
		runCycle(matrix, startRow + 1, startCol + 1, rows - 1, cols - 1);
	}

	public static void main(String[] args) {
		new SpiralOrder().spiralOrder(new int[][] { { 1 }, { 2 }, { 3 } });
	}

}
