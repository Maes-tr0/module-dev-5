package ua.example.algorithm;

/**
 * DynamicFibonacci method
 *
 * Time Complexity: O(n).
 * Space Complexity: O(n).
 *
 */

public class DynamicFibonacci implements FibonacciCalculator {
    @Override
    public long findNumberByIndex(int userIndex) {
        int index = userIndex - 1;

        if (index == 0) return INITIAL_FIRST_VALUE;
        if (index == 1) return INITIAL_SECOND_VALUE;
        if (index < 0) throw new IllegalArgumentException("Index must be greater than 0");

        long[] fibArray = new long[index + 1];

        fibArray[0] = INITIAL_FIRST_VALUE;
        fibArray[1] = INITIAL_SECOND_VALUE;

        for (int i = 2; i <= index; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }

        return fibArray[index];
    }
}

