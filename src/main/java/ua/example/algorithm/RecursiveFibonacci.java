package ua.example.algorithm;

/**
 * RecursiveFibonacci method
 *
 * Time Complexity: O(2^n).
 * Space Complexity: O(n).
 *
 */

public class RecursiveFibonacci implements FibonacciCalculator {
    private int currentIndex;
    private int toIndex;

    @Override
    public long findNumberByIndex(int userIndex) {
        int index = userIndex - 1;

        if (index == 0) return INITIAL_FIRST_VALUE;
        if (index == 1) return INITIAL_SECOND_VALUE;
        if (index < 0) throw new IllegalArgumentException("Index must be greater than 0");

        toIndex = index;
        currentIndex = 1;
        return calculate(INITIAL_FIRST_VALUE, INITIAL_SECOND_VALUE);
    }

    private long calculate(long first, long second) {
        if (currentIndex == toIndex) {
            return second;
        }
        currentIndex++;
        return calculate(second, first + second);
    }
}


