package 数组;

/*
 *@ClassName MinCount 拿硬币
 *@Author Freie  stellen
 *@Date 2024/7/29 15:14
 */
public class MinCount {
    public static void main(String[] args) {
        int count = minCount(new int[]{9, 3, 1});
        System.out.println(count);
    }

    public static int minCount(int[] coins) {

        int res = 0;
        for (int coin : coins) {
            res += (coin - 1) / 2 + 1;
        }
        return res;
    }
}
