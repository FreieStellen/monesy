package 数组;

/*
 *@ClassName SingleNumber 只出现一次的数字
 *@Author Freie  stellen
 *@Date 2024/4/24 11:18
 *思路：在限制时间复杂度和空间复杂度的情况下，可以利用异或位运算来排除数组中的重复元素
 * 时间复杂度：o（n）——————空间复杂度：o（1）
 */
public class SingleNumber {
    public static void main(String[] args) {
        int number1 = singleNumber1(new int[]{4, 1, 2, 1, 2});
        System.out.println(number1);
    }

    //异或位运算
    public static int singleNumber1(int[] nums) {
        int number = 0;

        for (int num : nums) {
            number ^= num;
        }
        return number;
    }
}
