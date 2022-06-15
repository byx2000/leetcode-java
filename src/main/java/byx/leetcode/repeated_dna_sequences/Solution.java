package byx.leetcode.repeated_dna_sequences;

// https://leetcode.cn/problems/repeated-dna-sequences/

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                result.add(sub);
            } else {
                set.add(sub);
            }
        }

        return new ArrayList<>(result);
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Set.of("AAAAACCCCC","CCCCCAAAAA"), new HashSet<>(s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")));
        assertEquals(Set.of("AAAAAAAAAA"), new HashSet<>(s.findRepeatedDnaSequences("AAAAAAAAAAAAA")));
    }
}
