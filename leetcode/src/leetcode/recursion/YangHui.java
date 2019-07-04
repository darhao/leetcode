package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class YangHui {

	List<List<Integer>> result;

	public List<Integer> getRow(int rowIndex) {
		generate(rowIndex);
		return result.get(result.size() - 1);
	}

	public void generate(int numRows) {
		result = new ArrayList<>();
		for (int rowNum = 1; rowNum <= numRows; rowNum++) {
			List<Integer> row = new ArrayList<>();
			result.add(row);
			for (int colNum = 1; colNum <= rowNum; colNum++) {
				row.add(getValue(rowNum, colNum));
			}
		}
	}

	public int getValue(int rowNum, int colNum) {
		if (colNum == 1 || colNum == rowNum) { // �߱��ϵ�ֵ�͵���1
			return 1;
		} else {
			return result.get((rowNum - 1) - 1).get((colNum - 1) - 1) + result.get((rowNum - 1) - 1).get(colNum - 1);
		}
	}

	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		new YangHui().generate(30);
		System.out.println("��ʱ��" + (System.currentTimeMillis() - a));
	}

}
