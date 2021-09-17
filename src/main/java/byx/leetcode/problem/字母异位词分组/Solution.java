package byx.leetcode.problem.字母异位词分组;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Map<Character, Integer>> maps = Arrays.stream(strs)
                .map(this::strToMap)
                .collect(Collectors.toList());

        Map<Map<Character, Integer>, List<String>> group = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            Map<Character, Integer> m = maps.get(i);
            if (group.containsKey(m)) {
                group.get(m).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                group.put(m, list);
            }
        }

        return new ArrayList<>(group.values());
    }

    private Map<Character, Integer> strToMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(solution.groupAnagrams(new String[]{""}));
        System.out.println(solution.groupAnagrams(new String[]{"a"}));
    }
}
