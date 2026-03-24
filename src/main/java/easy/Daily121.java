package easy;

public class Daily121 {
    public int maxProfit(int[] prices) {
        var smallestPrice = Integer.MAX_VALUE;
        var bestProfit =0;
        for(int currentPrice : prices){
            if(currentPrice < smallestPrice) {
                smallestPrice = currentPrice;
            }else {
                bestProfit = Math.max(bestProfit,currentPrice - smallestPrice);
            }
        }
        return bestProfit;
    }
}
