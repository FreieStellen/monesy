package 数组;

import java.util.ArrayList;
import java.util.List;

/*
 *@ClassName FindDisappearedNumbers 找到所有数组中所缺失的数字
 *@Author Freie  stellen
 *@Date 2024/4/18 16:46
 * 思路：基本思路是我们将数组排序，因为数组是遵从区间[1,n]的，所以每个数字排序过后都对应的下标是n-1，再查看每个哪个下标所对应的数字没有就返回。
 * 但在考虑空间复杂度为o（1）的情况下就不能开辟list集合或者hash表为他们排序（返回的数组不算入其中）。此时思路应该是这样的
 * 每遍历到一个数字我们就让他排序好的对应的下标数字加上n，例如：遍历到5，就在数组下标4的地方加上n。为了解决数组下标越界的问题
 * 应该取余n之后再去处理数字，这样比较整个数组小于或者等于n的数字即可。开辟一个新数组用来返回（不计入空间复杂度中），但此时我们需要注意数组下标是从
 * 0开始，但原数组的值区间是[1，n],所以加入新数组的下标应该需要+1
 * 时间复杂度：o（n）+o（n）=o(2n)=o(n)
 * 空间复杂度：返回数组不算则为o（1）
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {

        List<Integer> disappearedNumbers = findDisappearedNumbers(new int[]{1, 1});

        System.out.println(disappearedNumbers);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        for (int num1 : nums) {
            nums[(num1 - 1) % nums.length] += nums.length;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= nums.length) {

                arrayList.add(i + 1);
            }
        }
        return arrayList;
    }
}
