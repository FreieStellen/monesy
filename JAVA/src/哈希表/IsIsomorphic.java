package 哈希表;

import java.util.HashMap;
import java.util.Map;

/*
 *@ClassName IsIsomorphic 同构字符串
 *@Author Freie  stellen
 *@Date 2024/4/8 21:38
 * 思路：Hash表的使用，由题可知，每一个字母对应着一个单词，所以利用hash表的原理。
 * 建立两个hash集合，一个以s字符串字母为键，t字符串字母为值，另一个以t字符串字母为键，s字符串字母为值。判断所取得单词和字母是否存在两个hash表中的
 * 时间复杂度为o（t和s的长度，因为要将他们放到集合中，每个字符被遍历一次）
 */
public class IsIsomorphic {

    public static void main(String[] args) {
        boolean isomorphic = isIsomorphic("foo", "bar");

        if (isomorphic) {
            System.out.println("遵循规律");
        }
    }

    public static boolean isIsomorphic(String s, String t) {

        //一个以s字符串字母为键，t字符串字母为值
        Map<Character, Character> charMap1 = new HashMap<>();

        //一个以t字符串字母为键，s字符串字母为值
        Map<Character, Character> charMap2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            //charMap1存在s1这个key且对应的t1不相等的话就说明没有规律，charMap2同理
            if (charMap1.containsKey(s1) && charMap1.get(s1) != t1 || charMap2.containsKey(t1) && charMap2.get(t1) != s1) {
                return false;
            }
            charMap1.put(s1, t1);
            charMap2.put(t1, s1);
        }
        return true;
    }
}
