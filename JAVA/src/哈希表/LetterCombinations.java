package 哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@ClassName LetterCombinations 电话号码的字母组合
 *@Author Freie  stellen
 *@Date 2024/7/19 15:42
 * 思路：回溯法，将数字的组合转化为二叉树的遍历，首先第一个数字的三个字母分别与接下来的数字所对应的字母一一进行结合。每结合成一个元素放进集合后开始回溯到直到遍历结束。
 * 时间复杂度：3的m次方（m代表三个字母的数字）×4的n次方（n代表四个字母的数字）————————空间复杂度：o（n+m）
 */
public class LetterCombinations {

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer stringBuffer) {
        //限定条件使得下标和输入数字个数相等
        //因为本题的隐含条件是字母的组合个数与输入数字的长度个数相等
        //条件达到后加入元素到集合中
        if (index == digits.length()) {
            combinations.add(String.valueOf(stringBuffer));
        } else {
            //获取数字的第一个元素
            char charAt = digits.charAt(index);
            //找到对应的hash表中的元素
            String number = phoneMap.get(charAt);
            for (int i = 0; i < number.length(); i++) {
                stringBuffer.append(number.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
    }
}
