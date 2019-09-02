package leetcode.array_string;

public class StockOpportunityCheckerII {

    public int maxProfit(int[] prices) {
    	Integer buyPrice = null;
    	int profitSum = 0;
    	for (int i = 0; i < prices.length; i++) {
			if(i == prices.length - 1) {
				if(buyPrice != null) {
					profitSum += prices[i] - buyPrice;
				}
				break;
			}
			if(prices[i + 1] > prices[i] && buyPrice == null) {
				buyPrice = prices[i];
				continue;
			}
			if(prices[i + 1] < prices[i] && buyPrice != null) {
				profitSum += prices[i] - buyPrice;
				buyPrice = null;
				continue;
			}
		}
    	return profitSum;
    }
	
    
    public static void main(String[] args) {
		new StockOpportunityCheckerII().maxProfit(new int[] {7,1,5,3,6,4});
	}
}
