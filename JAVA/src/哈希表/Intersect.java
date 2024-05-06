package 哈希表;

import java.util.Arrays;
import java.util.HashMap;

/*
 *@ClassName Intersect 两个数组的交集
 *@Author Freie  stellen
 *@Date 2024/5/1 18:17
 * 思路1：hash表法，如果有两个不同大小的数组时，可以考虑首先将小长度的数组先添加进hash表中并计数，因为数组的合并一定是看小数组有多少元素
 * 小数组元素计数后，遍历大数组并且和hash表中的元素比较，出现相同的就将hash表中元素计数减一，每次比较成功时将元素添加进新数组（可以
 * 声明一个和小长度数组相同长度的新数组）,最后调用Arrays.copyOfRange()方法截取需要的长度即可
 * 时间复杂度：O（m+n）————————空间复杂度：o（n）n为最短数组的长度
 * 思路2：如果在数组长度相等且有序的情况下，可以用双指针法进行比较，如果不相等就小的指针向后移动一位，如果相等就都向后移动一位
 * 时间复杂度：o（m+n）————————空间复杂度：o（n）n为返回数组的长度
 */
public class Intersect {
    public static void main(String[] args) {
        for (int i : intersect1(new int[]{9, 4, 9, 8, 4}, new int[]{4, 9, 5})) {
            System.out.println(i);
        }
    }

    //hash表法
    public static int[] intersect1(int[] nums1, int[] nums2) {

        if (nums2.length > nums1.length) {
            return intersect1(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j : nums2) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            } else {
                map.put(j, map.get(j) + 1);
            }
        }

        int[] result = new int[nums2.length];

        int temp = 0;
        for (int j : nums1) {
            if (map.containsKey(j)) {

                if (map.get(j) != 0) {

                    map.put(j, map.get(j) - 1);

                    result[temp++] = j;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, temp);
    }
}
