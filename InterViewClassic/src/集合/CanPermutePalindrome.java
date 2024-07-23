package 哈希表;

import java.util.HashSet;

/*
 *@ClassName CanPermutePalindrome 回文排列
 *@Author Freie  stellen
 *@Date 2024/7/23 16:05
 */
public class CanPermutePalindrome {
    public static void main(String[] args) {
        boolean flag = canPermutePalindrome("tactcoa");
        System.out.println(flag);
    }

    public static boolean canPermutePalindrome(String s) {

        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }
}
