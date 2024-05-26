package 数组;

/*
 *@ClassName maxArea 盛最多水的容器
 *@Author Freie  stellen
 *@Date 2024/5/26 22:01
 * 思路1：双指针法，移动小的指针的原因是因为(end - begin) * min无论何种条件下高度都是小的指针，对于体积来说我们当然希望高度越高越好
 * 时间复杂度：o（n）——————空间复杂度：o（1）
 */
public class maxArea {
    public static void main(String[] args) {
        int area1 = maxArea1(new int[]{2, 3, 4, 5, 18, 17, 6});
        System.out.println(area1);
    }

    //1.双指针法
    public static int maxArea1(int[] height) {

        //1.定义两个双指针分别指向数组的第一个和最后一个元素
        int end = height.length - 1;
        int max = 0;
        int begin = 0;

        //2.循环遍历条件是左指针一直小于右指针
        while (begin < end) {
            //3.得到容器的高度
            int min = Math.min(height[begin], height[end]);
            //4.算出容器的体积
            int count = (end - begin) * min;
            max = Math.max(max, count);
            //5.小的指针需要移动
            if (height[begin] > height[end]) {
                end--;
            } else {
                begin++;
            }
        }
        return max;
    }
}
