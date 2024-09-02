package 字符串;

/*
 *@ClassName IsSubsequence 判断子序列
 *@Author Freie  stellen
 *@Date 2024/8/30 14:41
 * 思路：朴素无华的双指针解法，匹配即可向右移动
 * 时间复杂度：o（n）n为t字符串的长度————空间复杂度：o（1）
 */
public class IsSubsequence {
    public static void main(String[] args) {

        boolean subsequence1 = isSubsequence1("abc", "ahbgdc");
        System.out.println(subsequence1);
    }

    //普通版的双指针法
    public static boolean isSubsequence1(String s, String t) {

        if (s.length() == 0) {
            return true;
        }
        int begin = 0;

        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(begin) == t.charAt(i)) {
                if (++begin == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

}
