package 数学;

/*
 *@ClassName CountPrimes 计数质数
 *@Author Freie  stellen
 *@Date 2024/9/10 11:30
 * 知识点1：质数指的是除了1与本身之外没有其他因数的数
 * 知识点2：质数的倍数一定不是质数
 * 知识点3：2是最小的质数
 * 知识点4：质数的两个正因数中一定有一个正因数小于质数本身开根号
 * 思路：埃氏筛法：与传统的暴力枚举法（试除法）不同的在于排除质数的倍数，再统计个数。
 * 时间复杂度：o（nloglogn）———————空间复杂度：o（n）
 */
public class CountPrimes {
    public static void main(String[] args) {

        int primes = countPrimes(12);
        System.out.println(primes);
    }

    public static int countPrimes(int n) {

        boolean[] booleans = new boolean[n];

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!booleans[i]) {
                for (int j = i * i; j < n; j += i) {//注意点在于i此时已经是质数了。为了避免重复排除倍数j的初始值为i的平方
                    booleans[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < booleans.length; i++) {
            if (!booleans[i]) {
                count++;
            }
        }
        return count;
    }
}
