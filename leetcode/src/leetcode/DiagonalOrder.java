package leetcode;

public class DiagonalOrder {

	private static final int RU = 3;
	private static final int LD = 2;
	private static final int D = 1;
	private static final int R = 0;
	
    public int[] findDiagonalOrder(int[][] matrix) {
    	//空返回
    	if(matrix.length == 0) {
    		return new int[0];
    	}
    	
    	//获取元素总数
    	int sum = matrix.length * matrix[0].length;
    	int num = 0;
    	
    	//结果集
    	int[] result = new int[sum];
    	
    	//游走
    	int direction = RU;
    	int row = 0;
    	int col = 0;
    	while (num < sum) {
    		switch (direction) {
			case RU:
				try {
    				result[num] = matrix[row][col];
    				num++;
    				row-=1;
    				col+=1;
    			} catch (Exception ig) {
    				row+=1;
    				direction = D;
    			}
				break;
			case D:
				try {
    				result[num] = matrix[row][col];
    				num++;
				}catch (Exception ig) {
    			} finally {
    				row+=1;
    				col-=1;
    				direction = LD;
				}
				break;
			case LD:
				try {
    				result[num] = matrix[row][col];
    				num++;
    				row+=1;
    				col-=1;
    			} catch (Exception ig) {
    				col+=1;
    				direction = R;
    			}
				break;
			case R:
				try {
    				result[num] = matrix[row][col];
    				num++;
				} catch (Exception ig) {
    			} finally {
    				row-=1;
    				col+=1;
    				direction = RU;
				}
				break;
			default:
				break;
			}
		}
    	
		return result;
    }
    
    
    public static void main(String[] args) {
    	int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int[] r = new DiagonalOrder().findDiagonalOrder(matrix);
		for (int i : r) {
			System.out.print(i + ",");
		}
	}
	
}
