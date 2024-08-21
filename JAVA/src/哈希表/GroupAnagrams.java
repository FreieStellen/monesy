package 哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 *@ClassName GroupAnagrams 字母异位词分组
 *@Author Freie  stellen
 *@Date 2024/8/21 15:46
 * 思路：字母异位词代表着无论怎么样字母都是相同的，只是顺序不一样而已。所以考虑将字母排序后作为哈希表的key，所对应的是集合。
 * 再将hash表中的value值转化为list集合返回即可
 * 时间复杂度：o（nk logn）n代表数组元素个数，k代表元素最大长度，nlogn是排序的时间复杂度
 * 空间复杂度：o（nk）
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        for (List<String> list : groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})) {
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String temp : strs) {
            char[] array = temp.toCharArray();
            Arrays.sort(array);
            String chap = new String(array);
            List<String> list = map.getOrDefault(chap, new ArrayList<>());
            list.add(temp);

            map.put(chap, list);
        }

        return new ArrayList<>(map.values());
    }
}
