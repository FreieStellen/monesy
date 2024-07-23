package 字符串;

/*
 *@ClassName IsFlipedString 字符串轮转
 *@Author Freie  stellen
 *@Date 2024/7/23 18:59
 */
public class IsFlipedString {
    public static void main(String[] args) {
        boolean flag = isFlipedString("waterbottle", "erbottlewat");
        System.out.println(flag);
    }

    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String s = s2 + s2;

        return s.contains(s1);
    }
}
