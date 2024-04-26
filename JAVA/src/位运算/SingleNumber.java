package 位运算;

/*
 *@ClassName SingleNumber 只出现一次的数字
 *@Author Freie  stellen
 *@Date 2024/4/24 11:18
 *思路：在限制时间复杂度和空间复杂度的情况下，可以利用异或位运算来排除数组中的重复元素，异或运算的本质是模2加法运算（对运算中所有的二进制数相加）
 * 例如：13^13本质上是13的二进制数1101+1101=2202，再对二进制的每一位数对2取余得到结果
 * 时间复杂度：o（n）——————空间复杂度：o（1）
 */
public class SingleNumber {
    public static void main(String[] args) {
        int number1 = singleNumber1(new int[]{4, 1, 2, 1, 2});
        System.out.println(number1);
    }

    //异或位运算
    public static int singleNumber1(int[] nums) {
        int numbers = 0;

        for (int num : nums) {
            numbers ^= num;
        }
        return numbers;
    }
}
