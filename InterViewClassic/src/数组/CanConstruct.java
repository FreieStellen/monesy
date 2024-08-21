package 数组;

/*
 *@ClassName CanConstruct 赎金信
 *@Author Freie  stellen
 *@Date 2024/8/21 15:27
 * 思路：选用数组代替哈希表首先统计2号字符串的出现频率并加加，再去统计1号字符串的出现频率并减减，如果出现某个位置上的数字小于0则返回
 * false。反之，true。
 * 时间复杂度：o（n）——————空间复杂度：o（m）m为26
 */
public class CanConstruct {

    public static void main(String[] args) {
        boolean construct = canConstruct("aa", "ab");
        System.out.println(construct);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] ints = new int[26];

        for (char temp : magazine.toCharArray()) {
            ints[temp - 'a']++;
        }
        for (char lunch : ransomNote.toCharArray()) {
            ints[lunch - 'a']--;

            if (ints[lunch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
