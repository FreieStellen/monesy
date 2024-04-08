package 哈希表;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 *@ClassName WordPattern 单词规律
 *@Author Freie  stellen
 *@Date 2024/4/8 20:34
 * 思路：Hash表的使用，由题可知，每一个字母对应着一个单词，所以利用hash表的原理。
 * 建立两个hash集合，一个以字母为键，单词为值，另一个以单词为键，字母为值。判断所取得单词和字母是否存在两个hash表中的
 * 时间复杂度为o（pattern和s的长度，因为要将他们放到集合中，每个字符被遍历一次）
 */
public class WordPattern {

    public static void main(String[] args) {
        boolean pattern1 = wordPattern1("abba", "dog cat cat dog");

        boolean pattern2 = wordPattern2("abba", "dog cat cat dog");

        if (pattern1 && pattern2) {
            System.out.println("遵循规律");
        }
    }

    public static boolean wordPattern1(String pattern, String s) {

        //将单词以空格分割
        String[] sd = s.split(" ");

        if (sd.length != pattern.length()) {

            return false;
        }

        //map1用来以字母为键，单词为值存储
        Map<Character, String> map1 = new HashMap<>();

        //map2用来以值为键，单词为字母存储
        Map<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char sa = pattern.charAt(i);
            String sb = sd[i];

            //map1存在sa这个key且对应的sb不相等的话就说明没有规律，map2同理
            if (map1.containsKey(sa) && !Objects.equals(map1.get(sa), sb) || map2.containsKey(sb) && !Objects.equals(map2.get(sb), sa)) {
                return false;
            }
            map1.put(sa, sb);
            map2.put(sb, sa);
        }
        return true;
    }

    public static boolean wordPattern2(String pattern, String s) {

        //将单词以空格分割
        String[] sd = s.split(" ");

        if (pattern.length() != sd.length) {
            return false;
        }

        Map<Object, Integer> map1 = new HashMap<>();


        for (int i = 0; i < pattern.length(); i++) {

            //每当一个新元素put成功时会返回null，插入重复key时会返回对应的value
            if (!Objects.equals(map1.put(pattern.charAt(i), i), map1.put(sd[i], i))) {
                return false;
            }
        }
        return true;
    }
}
