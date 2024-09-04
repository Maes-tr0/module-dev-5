package ua.example.algorithm;

/**
 * IterativeFibonacci method
 *
 * Time Complexity: O(n).
 * Space Complexity: O(1).
 *
 */

public class IterativeFibonacci implements FibonacciCalculator {
    @Override
    public long findNumberByIndex(int userIndex) {
        int index = userIndex - 1;

        if (index == 0) return INITIAL_FIRST_VALUE;
        if (index == 1) return INITIAL_SECOND_VALUE;
        if (index < 0) throw new IllegalArgumentException("Index must be greater than 0");

        long first = INITIAL_FIRST_VALUE;
        long second = INITIAL_SECOND_VALUE;

        for (int i = 1; i < index; i++) {
            long numberFibonacci = first + second;
            first = second;
            second = numberFibonacci;
        }

        return second;
    }
}