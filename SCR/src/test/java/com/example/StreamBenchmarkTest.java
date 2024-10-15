package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StreamBenchmarkTest {

    @Test
    void testCalculateSum() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        long expectedSum = 15;
        assertEquals(expectedSum, StreamBenchmark.calculateSum(numbers));
    }

    @Test
    void testCalculateAverage() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        double expectedAverage = 3.0;
        assertEquals(expectedAverage, StreamBenchmark.calculateAverage(numbers));
    }

    @Test
    void testCalculateStandardDeviation() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        double expectedStandardDeviation = Math.sqrt(2.0);
        assertEquals(expectedStandardDeviation, StreamBenchmark.calculateStandardDeviation(numbers), 0.0001);
    }

    @Test
    void testMultiplyByTwo() {
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> expected = List.of(2, 4, 6);
        assertEquals(expected, StreamBenchmark.multiplyByTwo(numbers));
    }

    @Test
    void testFilterByEvenAndDivisibleBy3() {
        List<Integer> numbers = List.of(2, 3, 6, 12, 18, 19);
        List<Integer> expected = List.of(6, 12, 18);
        assertEquals(expected, StreamBenchmark.filterByEvenAndDivisibleBy3(numbers));
    }

    @Test
    void testCalculateSumParallel() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        long expectedSum = 15;
        assertEquals(expectedSum, StreamBenchmark.calculateSumParallel(numbers));
    }

    @Test
    void testCalculateAverageParallel() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        double expectedAverage = 3.0;
        assertEquals(expectedAverage, StreamBenchmark.calculateAverageParallel(numbers));
    }

    @Test
    void testCalculateStandardDeviationParallel() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        double expectedStandardDeviation = Math.sqrt(2.0);
        assertEquals(expectedStandardDeviation, StreamBenchmark.calculateStandardDeviationParallel(numbers), 0.0001);
    }

    @Test
    void testMultiplyByTwoParallel() {
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> expected = List.of(2, 4, 6);
        assertEquals(expected, StreamBenchmark.multiplyByTwoParallel(numbers));
    }

    @Test
    void testFilterByEvenAndDivisibleBy3Parallel() {
        List<Integer> numbers = List.of(2, 3, 6, 12, 18, 19);
        List<Integer> expected = List.of(6, 12, 18);
        assertEquals(expected, StreamBenchmark.filterByEvenAndDivisibleBy3Parallel(numbers));
    }
}
