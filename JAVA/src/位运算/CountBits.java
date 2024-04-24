package 位运算;

import java.util.Objects;

/*
 *@ClassName CountBits 比特位计数
 *@Author Freie  stellen
 *@Date 2024/4/24 11:30
 * 思路1：暴力遍历，将每个数字遍历并且转为二进制的形式，再遍历每个二进制找1的次数并存在新数组中
 * 时间复杂度：o（n*n）——————空间复杂度：除了返回数组的空间，其他都是常数操作
 * 思路2：Brian Kernighan算法也称布莱恩，科林汉算法，底层原理是与位运算，将二进制数的最后一位数变为0，一直到整数为0再返回
 * 时间复杂度：o（olog2n）——————时间复杂度o（1）
 */
public class CountBits {
    public static void main(String[] args) {
        for (int i : countBits1(5)) {
            System.out.println("二进制中1的个数111:--" + i);
        }
        System.out.println("=======================");
        for (int i : countBits2(5)) {
            System.out.println("二进制中1的个数222:--" + i);
        }

    }

    //暴力遍历
    public static int[] countBits1(int n) {

        int count = 0;

        int[] ints = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                ints[i] = 0;
            } else {
                String number = Integer.toBinaryString(i);
                for (int j = 0; j < number.length(); j++) {
                    if (Objects.equals(number.charAt(j), '1')) {
                        count++;
                    }
                    ints[i] = count;
                }
                count = 0;
            }

        }
        return ints;
    }

    //Brian Kernighan算法也称布莱恩，科林汉算法
    public static int[] countBits2(int n) {

        int[] countOne = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            countOne[i] = countOne(i);
        }
        return countOne;
    }

    static int countOne(int n) {
        int count = 0;
        while (n > 0) {

            n &= (n - 1);
            count++;
        }
        return count;
    }
}
