package 位运算;

import java.util.HashMap;
import java.util.Map;

/*
 *@ClassName SingleNumberII
 *@Author Freie  stellen
 *@Date 2024/4/26 10:57
 */
public class SingleNumberII {
    public static void main(String[] args) {
        int number1 = singleNumber1(new int[]{1, 2, 2});
        System.out.println(number1);
        int number2 = singleNumber2(new int[]{1, 2, 2, 2});
        System.out.println(number2);
    }

    public static int singleNumber1(int[] nums) {

        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return temp;
    }

    //Hash表法
    public static int singleNumber2(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        int temp = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                temp = entry.getKey();
            }
        }
        return temp;
    }
}
