package 位运算;

/*
 *@ClassName HammingWeight 位1的个数
 *@Author Freie  stellen
 *@Date 2024/4/26 22:22
 * 思路1：利用位运算中的与运算，n & (n−1)这个运算恰好将n二进制中的1变为0，再用计算器计数，循环结束时计数器数字就是1的个数
 * 时间复杂度：O(logn)。循环次数等于 nnn 的二进制位中 111 的个数，最坏情况下 nnn 的二进制位全部为 111。我们需要循环 nlogn 次。
 * 空间复杂度：o（1）
 * 思路2：利用n与2的n次方幂的与运算进行计数
 * 时间复杂度：o（32）——————空间复杂度：o（1）
 */
public class HammingWeight {
    public static void main(String[] args) {
        int weight1 = hammingWeight1(128);
        System.out.println(weight1);
        int weight2 = hammingWeight2(128);
        System.out.println(weight2);
    }

    //位运算中的与运算
    public static int hammingWeight1(int n) {

        int count = 0;
        while (n > 0) {

            n &= (n - 1);
            count++;
        }
        return count;
    }

    //循环检查二进制位
    public static int hammingWeight2(int n) {

        int ret = 0;
        for (int i = 0; i < 32; i++) {

            //检查n与2的i次方与运算的结果不为0时计数器加一
            //例如11的二进制位1101
            //1<<i的意思相当于循环对比2的n次幂
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;

    }
}
