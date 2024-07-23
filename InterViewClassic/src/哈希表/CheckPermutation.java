package 哈希表;

/*
 *@ClassName CheckPermutation 判断是否互为字符重排
 *@Author Freie  stellen
 *@Date 2024/7/23 7:46
 */
public class CheckPermutation {
    public static void main(String[] args) {
        boolean flag = checkPermutation("abca", "bca");
        System.out.println(flag);
    }

    public static boolean checkPermutation(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        int[] array = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            array[index]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i) - 'a';
            array[index]--;

            if (array[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
