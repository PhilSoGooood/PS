package LeetCode.best_time_to_buy_and_sell_stock;

class Solution {
	public int maxProfit(int[] prices) {
		int max = prices[prices.length - 1];
		int ans = 0;
		for (int i = prices.length - 2; i >= 0; i--) {
			if (max < prices[i]) max = prices[i];
			else if (max - prices[i] > ans) {
				ans = max - prices[i];
			}
		}
		return ans;
	}
}
