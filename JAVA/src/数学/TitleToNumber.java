package 数学;

/*
 *@ClassName TitleToNumber Exxel表序列号
 *@Author Freie  stellen
 *@Date 2024/5/6 17:59
 * 思路：观察每个字符串的值应该是ans = ans * 26 + num的形式，例如AB就是ans=1*26+1，再加加，因为每个字母对A的减法应该加1（A是从1开始）
 * 时间复杂度：o（n）n为字符串的长度——————空间复杂度：o（1）
 */
public class TitleToNumber {
    public static void main(String[] args) {
        int titleToNumber = titleToNumber("A");
        System.out.println(titleToNumber);
    }

    public static int titleToNumber(String columnTitle) {

        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int num = columnTitle.charAt(i) - 'A';
            ans = ans * 26 + num;
            ans++;
        }
        return ans;
    }
}
