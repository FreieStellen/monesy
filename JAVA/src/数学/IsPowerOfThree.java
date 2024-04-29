package 数学;

/*
 *@ClassName IsPowerOfThree 3的幂
 *@Author Freie  stellen
 *@Date 2024/4/29 16:14
 * 思路：将这个数不断除以3，看除数取3的余数是否等于0，如果最后的除数等于1时说明是3的幂
 * 时间复杂度：o（logn）——————空间复杂度：o（1）
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        boolean powerOfThree = isPowerOfThree(1);
        System.out.println(powerOfThree);
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        while (n != 0 && n % 3 == 0) {

            n /= 3;

            if (n == 1) {
                return true;
            }
        }
        return false;
    }
}
