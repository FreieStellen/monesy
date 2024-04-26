package 哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 *@ClassName ContainsDuplicate 存在重复元素
 *@Author Freie  stellen
 *@Date 2024/4/26 10:15
 * 思路1：利用Hashmap集合特性，如果遇到重复元素就将值+1，在遍历出map集合中所有的value值进行判断
 * 时间复杂度：o（n+m）n代表数组中的元素个数，m代表map集合中的值的个数
 * 空间复杂度：o（n）开辟了Hash表
 * 思路2：利用set集合不能添加重复元素的特性，遍历数组将其一一添加到set集合中，如果不能添加则证明有重复元素
 * 时间复杂度：o（n）——————空间复杂度：o（n）
 */
public class ContainsDuplicate {
    public static void main(String[] args) {

        boolean duplicate1 = containsDuplicate1(new int[]{2, 3, 1});
        System.out.println(duplicate1);
        boolean duplicate2 = containsDuplicate2(new int[]{2, 3, 1, 1});
        System.out.println(duplicate2);
    }

    //Hashmap集合
    public static boolean containsDuplicate1(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }

    //Hashset集合
    public static boolean containsDuplicate2(int[] nums) {

        HashSet<Integer> setmap = new HashSet<>();

        for (int num : nums) {
            if (!setmap.add(num)) {
                return true;
            }
        }
        return false;
    }
}
