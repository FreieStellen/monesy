package 字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 *@ClassName lengthOfLongestSubstring 无重复字符的最长子串
 *@Author Freie  stellen
 *@Date 2024/5/26 15:25
 * 思路1：双指针法，左指针在起始时不动，右指针一直遍历向下，直到存在了重复元素时首先记录左右指针的差即为最大值存储，然后左指针指向重复元素，右指针继续遍历。
 * 将以上过程一直重复直到遍历结束
 * 时间复杂度：o（n）n为字符串长度——————空间复杂度：o（n）n为集合长度
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {

        int length1 = lengthOfLongestSubstring1("dvdf");
        System.out.println(length1);
        int length2 = lengthOfLongestSubstring2("dvdf");
        System.out.println(length2);
    }

    //1.双指针法
    public static int lengthOfLongestSubstring1(String s) {

        //1.判断字符串的长度是否小于等于1
        if (s.length() <= 1) {
            //1.1如果小于等于1就直接返回
            return s.length() == 0 ? 0 : 1;
        }

        //2.创建hash表set集合（无序且唯一）
        HashMap<Character, Integer> map = new HashMap<>();

        //3.定义双指针
        int max = 0;
        int left = -1;

        for (int right = 0; right < s.length(); right++) {

            //4.判断集合中是否存在此元素
            if (map.containsKey(s.charAt(right))) {
                //4.1如果存在就将左指针移动到重复元素的下标处
                left = Math.max(left, map.get(s.charAt(right)));
            }
            //5.不存在即加入集合中
            map.put(s.charAt(right), right);
            //6。将最大值存储下来直到循环结束
            max = Math.max(max, right - left);
        }
        //返回
        return max;
    }

    //2.滑动窗口法
    public static int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
