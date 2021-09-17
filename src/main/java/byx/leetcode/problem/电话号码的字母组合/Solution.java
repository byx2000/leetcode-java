package byx.leetcode.problem.电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        dfs(0, digits, map, "", result);

        return result;
    }

    private void dfs(int index, String digits, Map<Character, String> map, String word, List<String> result) {
        if (index == digits.length()) {
            result.add(word);
            return;
        }

        String alpha = map.get(digits.charAt(index));
        for (int i = 0; i < alpha.length(); ++i) {
            dfs(index + 1, digits, map, word + alpha.charAt(i), result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations(""));
        System.out.println(solution.letterCombinations("2"));
    }
}
