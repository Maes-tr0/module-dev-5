package ua.example.algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

class FibonacciTest {

    static Stream<FibonacciCalculator> provideCalculators() {
        return Stream.of(new IterativeFibonacci(), new RecursiveFibonacci(), new DynamicFibonacci());
    }

    @ParameterizedTest
    @MethodSource("provideCalculators")
    void calculateFibonacci_GivenValidDefaultInput_ShouldReturnCorrectValue(FibonacciCalculator calculator) {
        List<Integer> inputIndex = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));

        List<Integer> expectedResults = new LinkedList<>(List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55));

        inputIndex.forEach(index -> {
            long expectedResult = expectedResults.get(inputIndex.indexOf(index));
            long actualResult = calculator.findNumberByIndex(index);

            assertEquals(expectedResult, actualResult, "Фібоначчі для індексу " + index + " не збігається");
        });
    }

    @ParameterizedTest
    @MethodSource("provideCalculators")
    void calculateFibonacci_GivenLargeInput_ShouldReturnCorrectValue(FibonacciCalculator calculator) {
        List<Integer> largeIndexes = List.of(31, 41, 51);
        List<Long> expectedResults = List.of(832040L, 102334155L, 12586269025L);

        largeIndexes.forEach(index -> {
            long expectedResult = expectedResults.get(largeIndexes.indexOf(index));
            long actualResult = calculator.findNumberByIndex(index);

            assertEquals(expectedResult, actualResult, "Фібоначчі для індексу " + index + " не збігається");
        });
    }

    @ParameterizedTest
    @MethodSource("provideCalculators")
    void calculateFibonacci_GivenInvalidInput_ShouldThrowIllegalArgumentException(FibonacciCalculator calculator) {
        List<Integer> invalidIndex = new LinkedList<>(List.of(-1, -100, 0));

        invalidIndex.forEach(index -> {
            assertThrows(IllegalArgumentException.class, () -> calculator.findNumberByIndex(index),
                    "Очікувався IllegalArgumentException для індексу: " + index);
        });
    }
}
