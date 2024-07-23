package 字符串;

/*
 *@ClassName ReplaceSpaces URL化
 *@Author Freie  stellen
 *@Date 2024/7/23 9:05
 */
public class ReplaceSpaces {
    public static void main(String[] args) {

        String spaces = replaceSpaces("               ", 5);
        System.out.println(spaces);
    }

    public static String replaceSpaces(String S, int length) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                builder.append("%20");
            } else {
                builder.append(S.charAt(i));
            }

        }
        return String.valueOf(builder);
    }
}
