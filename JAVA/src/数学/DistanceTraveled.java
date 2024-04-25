package 数学;

/*
 *@ClassName DistanceTraveled 总行驶距离
 *@Author Freie  stellen
 *@Date 2024/4/25 15:23
 * 思路1：模拟数学，根据提议进行数学推导，while循环加if判断即可
 * 时间复杂度：o（n）==o（n/4）————空间复杂度o（1）
 */
public class DistanceTraveled {
    public static void main(String[] args) {
        int distanceTraveled = distanceTraveled(9, 2);
        System.out.println(distanceTraveled);
    }

    public static int distanceTraveled(int mainTank, int additionalTank) {

        int distance = 0;

        while (mainTank > 0) {
            //主邮箱大于5L且副油箱大于1L
            if (mainTank >= 5 && additionalTank >= 1) {
                distance += 50;
                mainTank -= 4;
                additionalTank--;

            } else {
                distance += mainTank * 10;
                mainTank -= mainTank;
            }

        }
        return distance;
    }
}
