package 链表;

import java.util.HashMap;

/*
 *@ClassName FirstUniqChar 字符串中的第一个唯一字符
 *@Author Freie  stellen
 *@Date 2024/5/6 11:06
 * 思路：hash表法，将所有字符首先遍历一遍，加入hash表中。如果出现重复字符计数加1即可，然后再次遍历字符查找对应计数为1的字符并返回对应下标
 * 时间复杂度：o（n）n为字符的长度————————空间复杂度：o（n）n为字符集，最多为26位
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        int leetcode = firstUniqChar("loveleetcode");
        System.out.println(leetcode);
    }

    public static int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
