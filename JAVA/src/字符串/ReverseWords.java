package 字符串;

/*
 *@ClassName ReverseWords 反转字符串中的单词III
 *@Author Freie  stellen
 *@Date 2024/7/30 13:48
 * 思路1：使用java内置方法StringBuilder类，首先分割字符串成为一个字符型数组，然后遍历字符数组，没遇到空格就反转字符加到新的StringBuilder里面
 * 最后删除开头的空格。
 * 时间复杂度：o（n）——————空间复杂度：o（n）
 * 思路2：使用双指针字符串遍历，直到遍历空格由右指针记录位置开始交换左右指针的位置，每次交换完左指针加一，直到遍历结束交换顺序输出即可
 * 时间复杂度：o（n）——————空间复杂度：o（1）
 */
public class ReverseWords {
    public static void main(String[] args) {
        String reverseWords1 = reverseWords1("Let's take LeetCode contest");
        System.out.println(reverseWords1);

        String reverseWords2 = reverseWords2("Mr Ding");
        System.out.println(reverseWords2);
    }

    //1.java内置springbuilder类
    public static String reverseWords1(String s) {

        String[] split = s.split(" ");
        StringBuilder builder = new StringBuilder();

        for (String value : split) {
            builder.append(" ").append(new StringBuilder(value).reverse());
        }
        builder.delete(0, 1);
        return builder.toString();
    }

    //2.双指针字符串遍历
    public static String reverseWords2(String s) {
        char[] ch = s.toCharArray();
        int left = 0, right;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                right = i - 1;
                reverse(ch, left, right);
                left = i + 1;
            }
        }
        reverse(ch, left, ch.length - 1);
        return String.valueOf(ch);
    }

    public static void reverse(char[] ch, int left, int right) {
        while (left < right) {
            char c = ch[left];
            ch[left++] = ch[right];
            ch[right--] = c;
        }
    }
}
