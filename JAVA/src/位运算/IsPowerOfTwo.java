package 位运算;

/*
 *@ClassName IsPowerOfTwo 2的幂
 *@Author Freie  stellen
 *@Date 2024/7/29 16:09
 * 思路1:位运算,让n和n-1进行与运算，与运算的特点（遇1得1，其余为0）因为如果是2的幂次方数只会出现一位为1其余为0，与n-1进行与运算后一定会为0
 * 时间复杂度：o（1）—————空间复杂度：o（1）
 * 思路2：循环做法，首先n小于等于0必然不是，再去寻找2的幂次方数的特点，取余必将为0，一直除2最后一定为1。
 * 时间复杂度：o（log n）——————空间复杂度：o（1）
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        boolean flag1 = isPowerOfTwo1(16);
        System.out.println(flag1);
        boolean flag2 = isPowerOfTwo2(15);
        System.out.println(flag2);
    }

    public static boolean isPowerOfTwo1(int n) {

        return n > 0 && (n & (n - 1)) == 0;
    }

    public static boolean isPowerOfTwo2(int n) {

        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
