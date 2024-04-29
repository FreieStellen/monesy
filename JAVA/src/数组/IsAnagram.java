package 数组;

import java.util.Arrays;

/*
 *@ClassName IsAnagram 有效的字母异位词
 *@Author Freie  stellen
 *@Date 2024/4/27 14:18
 * 思路1：先定义一个拥有26个字母的集合，利用字符串charAt(i)方法，s.charAt(i) - 'a'，求字母的ascii码之间的差值，再加加。就可知道一个字符串中
 * 每个出现了多少次。在遍历第二个字符串进行减减操作，如果出现某个次数为负数则证明两个字符串中字母出现的次数不同
 * 时间复杂度o(n+n)——————空间复杂度：o（26）
 * 思路2：将两个字符串转换为数组在进行排序在对比
 * 时间复杂度：o（nlog2n）————————空间复杂度：O(logn)
 */
public class IsAnagram {
    public static void main(String[] args) {
        boolean anagram1 = isAnagram1("aacc", "ccca");
        System.out.println(anagram1);
        boolean anagram2 = isAnagram2("aacc", "ccca");
        System.out.println(anagram2);
    }

    //以哈希表数组的形式
    public static boolean isAnagram1(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {

            ints[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            ints[t.charAt(i) - 'a']--;

            if (ints[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    //利用内置库进行排序再对比
    public static boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();

        Arrays.sort(chars);
        Arrays.sort(chars1);

        return Arrays.equals(chars, chars1);
    }
}
