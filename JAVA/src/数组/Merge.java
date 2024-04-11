package 数组;

import java.util.Arrays;

/*
 *@ClassName Merge 合并两个有效数组
 *@Author Freie  stellen
 *@Date 2024/4/11 20:33
 * 思路1：将一个数组中的数全部加进另一个数组，在调用数组排序
 * 时间复杂度：o（（m+n）log m+n）
 * 空间复杂度：o（log m+n）
 * 四路2：双指针逆向对比插入数组中
 * 时间复杂度：o（m+n）最坏的情况将每个元素都要插入一遍
 * 空间复杂度：因为空间是num1的数组空间，不需要额外空间
 */
public class Merge {
    public static void main(String[] args) {
        merge1(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge2(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    //方法一：用数组排序
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {

        //将num2数组的元素全部插到num1里面
        for (int i = (m + n) - 1; i >= m; i--) {
            nums1[(m + n) - 1] = nums2[n - 1];
            n--;
        }
        //调用数组排序
        Arrays.sort(nums1);
        for (int sa : nums1) {
            System.out.println(sa);
        }

    }

    //方法二：逆向双指针,比较两个指针的大小，将大的值放在数组的最后
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        //代表num1实际数组的最后一个元素
        int p = m - 1;

        //代表num2数组的最后一个元素
        int q = n - 1;

        //代表num1扩大数组的最后一个元素
        int pq = m + n - 1;

        while (p >= 0 || q >= 0) {
            //如果num1的长度为0，将num2的元素倒叙插入
            if (p == -1) {
                nums1[pq--] = nums2[q--];
                //如果num2的长度为0，将num1的元素排序
            } else if (q == -1) {
                nums1[pq--] = nums1[p--];
            } else if (nums1[p] > nums2[q]) {
                nums1[pq--] = nums1[p--];
            } else {
                nums1[pq--] = nums2[q--];
            }
        }
        for (int sa : nums1) {
            System.out.println(sa);
        }
    }
}
