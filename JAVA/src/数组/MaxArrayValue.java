package 数组;

/*
 *@ClassName MaxArrayValue 合并后数组中的最大元素（贪心数组）
 *@Author Freie  stellen
 *@Date 2024/4/8 21:55
 * 思路：双指针从后向前遍历，如果前一个数大于后一个数，则将前指针的值赋予后指针。反之后指针的值等于后指针的值加前指针的值。
 * 时间复杂度：o（n）n为数组的个数
 */
public class MaxArrayValue {

    public static void main(String[] args) {
        long max = maxArrayValue(new int[]{2, 3, 7, 9, 3});

        System.out.println("最大数为：" + max);
    }

    public static long maxArrayValue(int[] nums) {

        long sa = nums[nums.length - 1];

        //从后向前遍历，如果前一个数大于后一个数，则将前指针的值赋予后指针。反之后指针的值等于后指针的值加前指针的值
        for (int i = nums.length - 2; i >= 0; i--) {

            //利用三目运算符简化代码
            sa = sa >= nums[i] ? sa + nums[i] : nums[i];
        }
        return sa;
    }
}
