package 数组;

/*
 *@ClassName Rotate 轮转数组
 *@Author Freie  stellen
 *@Date 2024/8/22 17:59
 * 思路：在不使用任何额外空间的前提下需要三次反转数组，首先整体反转数组，然后反转0到k-1位置上的数字，再反转k到最后一位位置上的所有数字
 * 时间复杂度：o（n）——————空间复杂度o（1）
 */
public class Rotate {
    public static void main(String[] args) {

        rotate(new int[]{-1}, 2);
    }

    public static void rotate(int[] nums, int k) {

        k %= nums.length;
        Reverse(nums, 0, nums.length - 1);
        System.out.println();
        Reverse(nums, 0, k - 1);
        System.out.println();
        Reverse(nums, k, nums.length - 1);
    }

    public static void Reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        for (int temp :
                nums) {
            System.out.print(temp);
        }
    }
}
