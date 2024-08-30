package 数组;

/*
 *@ClassName MaxProfit 买股票的最佳时机
 *@Author Freie  stellen
 *@Date 2024/4/18 17:09
 * 思路1：首先要明确买股票的最佳时机应该是我们在最低点买进股票，然后再在买进股票之后的最高点卖出股票达到利益的最大化。
 * 我们先自定义一个最大值和一个最小值，然后遍历数组寻找数组的最小值同时寻找成为最小值后的最大值，在返回最大值和最小值的差值
 * 时间复杂度：o（n）遍历数组一次
 * 空间复杂度：开辟了两个常数的变量为o（1）
 */
public class MaxProfit {

    public static void main(String[] args) {

        int profit1 = maxProfit(new int[]{7, 1, 5, 3, 9, 4});
        System.out.println(profit1);
    }

    public static int maxProfit(int[] prices) {

        //初始化一个最大值
        int maxprice = 0;

        //初始化一个最小值使得不论如何第一个数肯定可以成为最小值
        int minprice = Integer.MAX_VALUE;

        //遍历数组
        for (int price : prices) {

            if (price < minprice) {
                minprice = price;

                //当不成为最小值后利用第二个判断条件（卖出的价格减去买进的价格）使得利益最大化返回最大值
            } else if (price - minprice > maxprice) {
                maxprice = price - minprice;
            }
        }
        return maxprice;
    }

}




















