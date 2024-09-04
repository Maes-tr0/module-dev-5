package ua.example.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * DynamicFibonacci method
 *
 * Time Complexity: O(n).
 * Space Complexity: O(n).
 *
 */
public class DynamicFibonacci implements FibonacciCalculator {
    private static List<Long> fibArray = new ArrayList<>();

    static {
        fibArray.add(INITIAL_FIRST_VALUE);  // Відповідає INITIAL_FIRST_VALUE
        fibArray.add(INITIAL_SECOND_VALUE);  // Відповідає INITIAL_SECOND_VALUE
    }

    @Override
    public long findNumberByIndex(int userIndex) {
        int index = userIndex - 1;

        if (index == 0) return INITIAL_FIRST_VALUE;
        if (index == 1) return INITIAL_SECOND_VALUE;
        if (index < 0) throw new IllegalArgumentException("Index must be greater than 0");

        if (index < fibArray.size()) {
            return fibArray.get(index);
        }

        while (fibArray.size() <= index) {
            int size = fibArray.size();
            long nextFib = fibArray.get(size - 1) + fibArray.get(size - 2);  // Сума двох попередніх
            fibArray.add(nextFib);
        }

        return fibArray.get(index);
    }
}
