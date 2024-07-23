package 哈希表;

import java.util.HashMap;
import java.util.Map;

/*
 *@ClassName CompressString 字符串压缩
 *@Author Freie  stellen
 *@Date 2024/7/23 17:10
 */
public class CompressString {
    public static void main(String[] args) {
        String string = compressString("aabcccccaa");
        System.out.println(string);
    }

    public static String compressString(String S) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : S.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        StringBuilder stringBuffer = new StringBuilder();
        for (Map.Entry<Character, Integer> map1 : map.entrySet()) {
            stringBuffer.append(map1.getKey());
            stringBuffer.append(map1.getValue());
        }
        return String.valueOf(stringBuffer);
    }
}
