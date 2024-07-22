package 数组;

/*
 *@ClassName Game
 *@Author Freie  stellen 猜数字
 *@Date 2024/7/15 18:00
 * 思路：单指针遍历两个数组对比元素数值再返回即可
 * 时间复杂度：o（n）——————空间复杂度：o（1）
 */

public class Game {

    public static void main(String[] args) {
        int number = game(new int[]{2, 2, 3}, new int[]{1, 2, 3});
        System.out.println("猜对了" + number + "次");
    }

    public static int game(int[] guess, int[] answer) {

        int number = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                number++;
            }
        }
        return number;
    }
}
