package 哈希表;

import java.util.HashMap;

/*
 *@ClassName TwoSum 两数相加
 *@Author Freie  stellen
 *@Date 2024/8/20 16:56
 * 思路1：哈希表。一般来说暴力枚举需要o（n2）的时间复杂度，利用哈希表键值对的存储结构来获取目标值和每个元素的插值是否包含在hash表中
 * 时间复杂度：o（n）——————空间复杂度o（n）
 */
public class TwoSum {
    public static void main(String[] args) {
        for (int i : twoSum(new int[]{2, 7, 11, 15}, 9)) {
            System.out.println(i);
        }

    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {

                return new int[]{map.get(target - nums[i]), i};

            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
