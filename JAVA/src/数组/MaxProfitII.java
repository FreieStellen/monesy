package 数组;

/*
 *@ClassName MaxProfitII 买卖股票的最佳时机II
 *@Author Freie  stellen
 *@Date 2024/8/30 9:06
 * 思路:股票数组的构成形式会出现三种情况：1.出现单独购买日，数组不是有序的。2.出现连续上涨交易日，数组是升序的。3.出现连续下降交易日，数组
 * 是降序的。对于第一二种形式来说，只需要累加盈利日即可，对于第三种形式来说是一直亏损的。
 * 时间复杂度：o（n）——————空间复杂度：o（1）
 */
public class MaxProfitII {

    public static void main(String[] args) {
        int maxProfit = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];

            if (temp > 0) {
                maxProfit += temp;
            }
        }
        return maxProfit;
    }
}
