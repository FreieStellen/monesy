package 字符串;

/*
 *@ClassName ReverseString 反转字符串
 *@Author Freie  stellen
 *@Date 2024/4/29 15:57
 * 思路：在规定空间复杂度只能为o（1）时，利用双指针的思想交换前后字符即可
 * 时间复杂度：o（n）——————空间复杂度：o（1）
 */
public class ReverseString {
    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

    public static void reverseString(char[] s) {


        int end = s.length - 1;
        char temp;

        for (int begin = 0; begin < end; begin++) {

            temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;

            end--;
        }
    }
}
