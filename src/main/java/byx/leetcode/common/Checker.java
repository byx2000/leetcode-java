package byx.leetcode.common;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Checker {
    public static void check(Class<?> solutionClass, Object retVal, Object... params) {
        List<Method> methods = Arrays.stream(solutionClass.getMethods()).
                filter(m -> m.isAnnotationPresent(Check.class)).
                collect(Collectors.toList());

        if (methods.size() != 1) {
            throw new RuntimeException("Solution class must has a method");
        }

        Object solution;
        try {
            solution = solutionClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Solution class must has a default constructor.");
        }

        Object actualRetVal;
        try {
            actualRetVal = methods.get(0).invoke(solution, params);
        } catch (Exception e) {
            throw new RuntimeException("Cannot invoke method: " + methods.get(0));
        }

        if (!equal(actualRetVal, retVal)) {
            throw new RuntimeException("Not equal: " + actualRetVal + " " + retVal);
        }
    }

    private static boolean equal(Object o1, Object o2) {
        if (o1.getClass() != o2.getClass()) {
            return false;
        }

        if (o1.getClass().isArray()) {
            int len1 = Array.getLength(o1);
            int len2 = Array.getLength(o2);
            if (len1 != len2) {
                return false;
            }
            for (int i = 0; i < len1; ++i) {
                if (!Array.get(o1, i).equals(Array.get(o2, i))) {
                    return false;
                }
            }
            return true;
        } else {
            return o1.equals(o2);
        }
    }
}
