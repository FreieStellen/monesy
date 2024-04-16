package 哈希表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 *@ClassName MajorityElement 多数元素
 *@Author Freie  stellen
 *@Date 2024/4/11 22:21
 * 思路：方式一：哈希表，通过Hash映射来计数
 * 时间复杂度：o(n)---空间复杂度：o（n）
 * 方式二：投票选举的方法，从头到尾遍历数组中的数，将选举权交给第一个数，遇到相同的数就加一，遇到不相同的数就减一，当次数为0时将选举权交给下一个数
 * 时间复杂度：只遍历了数组一次0（n）-----空间复杂度：只开辟了一个常量的空间
 * 方式三：使用数组自带的排序方法进行排序然后返回数组中间的数字必然是众数
 * 时间复杂度：o（nlog n）-------空间复杂度：需要o（log n）空间
 */
public class MajorityElement {

    public static void main(String[] args) {

        int majorityElement1 = majorityElement1(new int[]{2, 2, 1, 1, 1, 2, 2});
        int majorityElement2 = majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2});
        int majorityElement3 = majorityElement3(new int[]{2, 2, 1, 1, 1, 2, 2});

        System.out.println(majorityElement1);
        System.out.println(majorityElement2);
        System.out.println(majorityElement3);
    }

    //方法一：哈希表，通过Hash映射来计数
    public static int majorityElement1(int[] nums) {

        assert nums.length > 0;

        HashMap<Integer, Integer> map1 = new HashMap<>();

        //for循环遍历数组取除数组中的每一个元素进行计数，遇到重复元素时值+1
        for (int num : nums) {
            if (!map1.containsKey(num)) {
                map1.put(num, 1);
            } else {
                map1.put(num, map1.get(num) + 1);
            }
        }

        //定义一个空的键值对集合
        Map.Entry<Integer, Integer> challenger = null;

        //遍历map集合键值对，首先和空集合对比如果空集合为空则将对象添加到空集合中。类似于守擂台的形式谁大就谁进空集合中
        for (Map.Entry<Integer, Integer> map2 : map1.entrySet()) {

            if (challenger == null || challenger.getValue() < map2.getValue()) {
                challenger = map2;
            }
        }

        //最后返回空集合的值即可
        return challenger.getKey();
    }


    //方法二：投票选举的方法，从头到尾遍历数组中的数，将选举权交给第一个数，遇到相同的数就加一，遇到不相同的数就减一，当次数为0时将选举权交给下一个数
    public static int majorityElement2(int[] nums) {

        //将选举权交给第一个数
        int candidate = nums[0];

        //以此来开始计数
        int count = 1;

        //遍历数组开始选举
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;

                //当投票数为0时将选举权交给下一个数
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        // 验证方法是否为最大数
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        if (count > nums.length / 2) {
            return candidate;
        } else {
            return -1;
        }
    }

    //使用数组自带的排序方法进行排序然后返回数组中间的数字必然是众数
    public static int majorityElement3(int[] nums) {

        Arrays.sort(nums);

        return nums[nums.length / 2];
    }
}
