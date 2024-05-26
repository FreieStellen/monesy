package 字符串;

/*
 *@ClassName longestPalindrome 最长回文子串
 *@Author Freie  stellen
 *@Date 2024/5/26 16:56
 * 思路1：上指针中心扩展法，从头开始遍历字符串进行中心扩展，必须要考虑到回文子串的奇偶性
 * 时间复杂度：o（n2）——————空间复杂度o（1）
 */
public class longestPalindrome {
    public static void main(String[] args) {

        String reverse1 = longestPalindrome1("bcacbad");
        System.out.println(reverse1);
    }

    //中心扩展法
    public static String longestPalindrome1(String s) {

        //1.定义三个变量作为载体
        String a;
        String b;
        String c = "";

        //2.循环从头便利开始向两边扩展对比
        for (int i = 0; i < s.length(); i++) {
            //2.1应对回文数有可能是偶数的情况
            a = expandAroundCenter(s, i, i);
            c = a.length() > c.length() ? a : c;
            //2.2应对回文数有可能是奇数的情况
            b = expandAroundCenter(s, i, i + 1);
            c = b.length() > c.length() ? b : c;
        }
        return c;
    }

    private static String expandAroundCenter(String s, int left, int right) {

        int L = left;
        int R = right;
        String sub = "";
        //循环条件是左指针不能小于0，右指针不能大于整个字符串长度且左右两边相等
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            //截取字符串包含左下标但不包含右下标
            sub = s.substring(L, R + 1);
            L--;
            R++;
        }
        return sub;
    }
}
