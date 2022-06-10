package byx.leetcode.group_anagrams;

// https://leetcode.cn/problems/group-anagrams/

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> group = new HashMap<>();
        for (String s : strs) {
            Map<Character, Integer> m = strToMap(s);
            List<String> list = group.getOrDefault(m, new ArrayList<>());
            list.add(s);
            group.put(m, list);
        }
        return group.values().stream().toList();
    }

    private Map<Character, Integer> strToMap(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        }
        return m;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        verify(List.of(List.of("bat"), List.of("nat","tan"), List.of("ate","eat","tea")), s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        verify(List.of(List.of("")), s.groupAnagrams(new String[]{""}));
        verify(List.of(List.of("a")), s.groupAnagrams(new String[]{"a"}));
    }

    private void verify(List<List<String>> expected, List<List<String>> actual) {
        assertEquals(expected.stream().map(HashSet::new).collect(Collectors.toSet()), actual.stream().map(HashSet::new).collect(Collectors.toSet()));
    }
}
