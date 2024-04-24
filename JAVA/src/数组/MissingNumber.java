package 数组;

import java.util.HashSet;

/*
 *@ClassName MissingNumber 丢失的数字
 *@Author Freie  stellen
 *@Date 2024/4/22 17:17
 * 思路1：做差法。给定的数组相较于原数组的差距就是少了一个数字，可以利用前后数组的值差来得到缺失的数字是多少
 * 时间复杂度：o（n）遍历了数组————空间复杂度为o（1）只开辟了常数空间
 * 思路2：原地哈希法，将数组看做成一个哈希表。每次遍历到一个小于数组长度并且不等于数组下标的值的时候，将数字与数字减一的数交换并且循环i
 * 减一(当大数在前小数在后时没办法全部将数字归位，所以当遇到大数在前时应该将循环次数不算在内)
 * 时间复杂度：o（n）———————空间复杂度：o（1）
 * 思路3：哈希表法，将数组元素全部放入set集合，遍历集合寻找集合内不存在的元素即可
 * 时间复杂度：o（n）————————空间复杂度：o（n）
 * 思路4：位运算，异或运算遵从相同为0不同为1的运算法则，所以利用异或运算的性质将异或数分别异或两次，最后在和数组的长度异或，相当于将数组中
 * 所有的数复制再去异或，每个数出现了两次。唯独留下一个不重复的数
 * 时间复杂度：o（n）————————空间复杂度：o（1）
 */
public class MissingNumber {
    public static void main(String[] args) {
        int missingNumber1 = missingNumber1(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
        int missingNumber2 = missingNumber2(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
        int missingNumber3 = missingNumber3(new int[]{3, 0, 1});
        int missingNumber4 = missingNumber4(new int[]{3, 0, 1});
        System.out.println(missingNumber3);
        System.out.println(missingNumber1);
        System.out.println(missingNumber2);
        System.out.println(missingNumber4);
    }

    //做差法
    public static int missingNumber1(int[] nums) {
        int sum1 = 0;
        int sum2;
        for (int num : nums) {
            sum1 += num;
        }
        sum2 = ((nums.length + 1) * (nums.length)) / 2;

        return sum2 - sum1;
    }

    //原地哈希法
    public static int missingNumber2(int[] nums) {
        //每次遍历到一个小于数组长度并且不等于数组下标的值的时候，将数字与数字减一的数交换并且循环i
        // * 减一(当大数在前小数在后时没办法全部将数字归位，所以当遇到大数在前时应该将循环次数不算在内)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i && nums[i] < nums.length) {
                swap(nums, nums[i], i--);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    static void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }

    //哈希表法
    public static int missingNumber3(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            hashSet.add(num);
        }
        int temp = 0;
        //查找hash表中不存在的元素并返回
        for (int i = 0; i < hashSet.size(); i++) {
            if (!hashSet.contains(i)) {
                temp = i;
            }
        }
        return temp;
    }

    //异或法
    public static int missingNumber4(int[] nums) {

        int missingNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            missingNumber ^= nums[i];
            missingNumber ^= i;
        }
        missingNumber ^= nums.length;
        return missingNumber;
    }
}
