package 位运算;

/*
 *@ClassName HammingDistance 汉明距离
 *@Author Freie  stellen
 *@Date 2024/4/24 16:29
 * 思路1：Brian Kernighan算法也称布莱恩，科林汉算法，底层原理是与位运算，首先将汉明两个数字异或，然后统计得到的数的二进制1的个数即可。
 * 将二进制数的最后一位数变为0，一直到整数为0再返回
 * 时间复杂度：o（n）——————空间复杂度：o（1）
 * 思路2：移位实现位计数法， 将异或数字和1进行与运算进行计数，再将二进制整体向右移动一位在进行判断
 * 时间复杂度：o（n）——————空间复杂度：o（1）
 */
public class HammingDistance {
    public static void main(String[] args) {
        int hammingDistance1 = hammingDistance1(1, 3);
        int hammingDistance2 = hammingDistance2(1, 3);
        System.out.println(hammingDistance1);
        System.out.println(hammingDistance2);
    }

    //
    public static int hammingDistance1(int x, int y) {
        x = x ^ y;
        int count = 0;

        while (x > 0) {
            x &= (x - 1);
            count++;
        }
        return count;
    }

    public static int hammingDistance2(int x, int y) {

        x = x ^ y;
        int count = 0;

        while (x > 0) {
            count += x & 1;
            x >>= 1;
        }
        return count;
    }
}
