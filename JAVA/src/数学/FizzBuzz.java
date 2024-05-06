package 数学;

import java.util.ArrayList;
import java.util.List;

/*
 *@ClassName FizzBuzz FizzBuzz
 *@Author Freie  stellen
 *@Date 2024/5/6 17:21
 * 思路：指针循环遍历数字，判断每个数字是否为3或者5的倍数
 * 时间复杂度：o（n）n为数字大小——————空间复杂度：o（1）
 */
public class FizzBuzz {
    public static void main(String[] args) {
        for (String buzz : fizzBuzz(5)) {
            System.out.println(buzz);
        }
    }

    public static List<String> fizzBuzz(int n) {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            if (i % 3 == 0) {
                stringBuffer.append("Fizz");
            }
            if (i % 5 == 0) {
                stringBuffer.append("Buzz");
            }
            if (stringBuffer.length() == 0) {
                stringBuffer.append(i);
            }
            list.add(stringBuffer.toString());
        }
        return list;
    }
}
