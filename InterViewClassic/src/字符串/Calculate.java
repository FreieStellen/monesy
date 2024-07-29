package 字符串;

/*
 *@ClassName Calculate 速算机器人
 *@Author Freie  stellen
 *@Date 2024/7/29 15:46
 */
public class Calculate {
    public static void main(String[] args) {
        int calculate1 = calculate1("ABAA");
        System.out.println(calculate1);

        int calculate2 = calculate2("ABAA");
        System.out.println(calculate2);
    }

    public static int calculate1(String s) {
        int x = 1;
        int y = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (s.charAt(i) == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }

    public static int calculate2(String s) {
        return (int) Math.pow(2, s.length());
    }
}
