package 数学;

/*
 *@ClassName MySqrt x的平方根
 *@Author Freie  stellen
 *@Date 2024/4/26 16:02
 * 思路1：二分查找，首先明确一个知识，一个数的平方根一定小于这个数的一半（0和1除外），找到一个区间并选择这个区间内的一点，左右比较无限逼近，
 * 如果这个点的平方等于这个数，则找到了这个数。如果这个点的平方小于这个数则左区间等于这个点继续查找。如果这个点的平方大于这个数，则右区间等于这个点减一
 * 时间复杂度：o(logx)每次搜索的时间约为原来大小的1/2————————空间复杂度o（1）
 * 思路2：使用java内置类Math计算
 * 时间复杂度o（1）——————空间复杂度：o（1）
 */
public class MySqrt {
    public static void main(String[] args) {
        int mySqrt1 = mySqrt1(8);
        System.out.println(mySqrt1);
        int mySqrt2 = mySqrt2(8);
        System.out.println(mySqrt2);
    }

    //二分查找
    public static int mySqrt1(int x) {

        if (x == 1 || x == 0) {
            return x == 1 ? 1 : 0;
        }

        int left = 1;
        int right = x / 2;

        while (left < right) {
            //这里必须要加一，因为当区间内只有两个数时会造成死循环
            int mid = ((left + right) / 2) + 1;
            if (mid == x / mid) {
                return mid;
            }
            if (mid > x / mid) {
                //这里也必须要加一，区间内只有两个数时也会造成死循环
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    //使用java内置库函数
    public static int mySqrt2(int x) {

        if (x == 1 || x == 0) {
            return x == 1 ? 1 : 0;
        }
        //相当于[loge x）/2]的e次方
        int ans = (int) Math.exp(Math.log(x) * 0.5);
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}

