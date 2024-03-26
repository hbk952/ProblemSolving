package Array;
//choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
public class BuySellStocks {

	public static void main(String[] args) {
		int prices[] = {7,6,4,8,3,1};
		int min_price = prices[0];
		int max_profit = 0;
		for(int i=1;i<prices.length-1;i++) {
			max_profit = Math.max(max_profit, prices[i]-min_price);
			min_price = Math.min(min_price, prices[i]);
		}
		System.out.println(max_profit);
	}

}
