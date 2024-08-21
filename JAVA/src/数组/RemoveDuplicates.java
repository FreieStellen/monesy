package 数组;

/*
 *@ClassName RemoveDuplicates 删除有序数组中的重复项II
 *@Author Freie  stellen
 *@Date 2024/8/21 18:10
 * 思路：首先数组是升序的，我们保留多少个相同的数字不重要，重要的是保证前k个数字是相同的，然后再去比较当前写入的与前k个位置的元素进行比较
 * 相同则跳过，不同则保留。
 * 时间复杂度：o（n）————————空间复杂度：o（1）
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int length = removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
        System.out.println(length);
    }


    public static int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }

    public static int process(int[] nums, int k) {

        int begin = 0;
        for (int temp : nums
        ) {
            if (begin < k || nums[begin - k] != temp) {
                nums[begin++] = temp;
            }
        }
        return begin;
    }

}
