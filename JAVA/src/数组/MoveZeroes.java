package 数组;

import java.util.Arrays;

/*
 *@ClassName MoveZeroes 移动零
 *@Author Freie  stellen
 *@Date 2024/4/16 23:29
 * 思路：快慢双指针，指向同一个时代表不是0并交换位置，碰到0时快指针+1，碰到非0时交换位置
 * 时间复杂度：o（n）
 * 空间复杂度：两个常量空间
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] ints = moveZeroes(new int[]{1, 2, 0, 4, 0, 6});
        System.out.println(Arrays.toString(ints));
    }

    public static int[] moveZeroes(int[] nums) {

        int temp;
        int fast = 0;
        int slow = 0;

        while (fast <= nums.length - 1) {

            //非0时交换位置并且都加1
            if (nums[fast] != 0) {
                temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
            //碰到零时快指针加1
            fast++;
        }
        return nums;
    }
}
