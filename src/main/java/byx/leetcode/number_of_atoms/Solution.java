package byx.leetcode.number_of_atoms;

// https://leetcode.cn/problems/number-of-atoms/

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private String formula;
    private int index;

    public String countOfAtoms(String formula) {
        this.formula = formula;
        this.index = 0;
        Map<String, Integer> atoms = parseFormula();
        return atoms.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> {
                    if (e.getValue() > 1) {
                        return e.getKey() + e.getValue();
                    } else {
                        return e.getKey();
                    }
                })
                .collect(Collectors.joining());
    }

    // 是否到达输入串末尾
    private boolean end() {
        return index == formula.length();
    }

    // 获取下一个字符
    private char peek() {
        return formula.charAt(index);
    }

    // 获取下一个字符，并向前移动一个字符
    private char next() {
        return formula.charAt(index++);
    }

    private String parseAtom() {
        StringBuilder sb = new StringBuilder();
        sb.append(next());
        while (!end() && Character.isLowerCase(peek())) {
            sb.append(next());
        }
        return sb.toString();
    }

    private int parseCount() {
        if (end() || !Character.isDigit(peek())) {
            return 1;
        }

        int cnt = 0;
        while (!end() && Character.isDigit(peek())) {
            cnt = cnt * 10 + (next() - '0');
        }
        return cnt;
    }

    private Map<String, Integer> parseTerm() {
        char c = peek();
        if (Character.isAlphabetic(c)) {
            String atom = parseAtom();
            int cnt = parseCount();
            return Map.of(atom, cnt);
        } else if (c == '(') {
            next(); // 读取'('
            Map<String, Integer> atoms = parseFormula();
            next(); // 读取')'
            int cnt = parseCount();
            return atoms.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue() * cnt));
        }
        throw new RuntimeException("unexpected character: " + c);
    }

    private Map<String, Integer> parseFormula() {
        Map<String, Integer> atoms = new HashMap<>();
        while (!end() && peek() != ')') {
            atoms = merge(atoms, parseTerm());
        }
        return atoms;
    }

    private Map<String, Integer> merge(Map<String, Integer> m1, Map<String, Integer> m2) {
        Map<String, Integer> m = new HashMap<>();
        m1.forEach((k, v) -> m.merge(k, v, Integer::sum));
        m2.forEach((k, v) -> m.merge(k, v, Integer::sum));
        return m;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("H2O", s.countOfAtoms("H2O"));
        assertEquals("H2MgO2", s.countOfAtoms("Mg(OH)2"));
        assertEquals("K4N2O14S4", s.countOfAtoms("K4(ON(SO3)2)2"));
    }
}
