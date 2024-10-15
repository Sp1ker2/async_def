package com.example;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamBenchmark {

    private static final int COLLECTION_SIZE = 10_000_000;

    public static void main(String[] args) {
        List<Integer> numbers = generateRandomNumbers(COLLECTION_SIZE);

        System.out.println("Stream API Results:");
        System.out.println("Sum: " + calculateSum(numbers));
        System.out.println("Average: " + calculateAverage(numbers));
        System.out.println("Standard Deviation: " + calculateStandardDeviation(numbers));
        System.out.println("Multiplied by 2: " + multiplyByTwo(numbers).size());
        System.out.println("Filtered: " + filterByEvenAndDivisibleBy3(numbers).size());

        System.out.println("\nParallel Stream API Results:");
        System.out.println("Sum: " + calculateSumParallel(numbers));
        System.out.println("Average: " + calculateAverageParallel(numbers));
        System.out.println("Standard Deviation: " + calculateStandardDeviationParallel(numbers));
        System.out.println("Multiplied by 2: " + multiplyByTwoParallel(numbers).size());
        System.out.println("Filtered: " + filterByEvenAndDivisibleBy3Parallel(numbers).size());
    }

    public static List<Integer> generateRandomNumbers(int size) {
        Random random = new Random();
        return IntStream.range(0, size)
                .map(i -> random.nextInt(100) + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public static long calculateSum(List<Integer> numbers) {
        return numbers.stream().mapToLong(Integer::longValue).sum();
    }

    public static double calculateAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static double calculateStandardDeviation(List<Integer> numbers) {
        double average = calculateAverage(numbers);
        double variance = numbers.stream()
                .mapToDouble(i -> Math.pow(i - average, 2))
                .average()
                .orElse(0);
        return Math.sqrt(variance);
    }

    public static List<Integer> multiplyByTwo(List<Integer> numbers) {
        return numbers.stream().map(i -> i * 2).collect(Collectors.toList());
    }

    public static List<Integer> filterByEvenAndDivisibleBy3(List<Integer> numbers) {
        return numbers.stream()
                .filter(i -> i % 2 == 0 && i % 3 == 0)
                .collect(Collectors.toList());
    }

    public static long calculateSumParallel(List<Integer> numbers) {
        return numbers.parallelStream().mapToLong(Integer::longValue).sum();
    }

    public static double calculateAverageParallel(List<Integer> numbers) {
        return numbers.parallelStream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static double calculateStandardDeviationParallel(List<Integer> numbers) {
        double average = calculateAverageParallel(numbers);
        double variance = numbers.parallelStream()
                .mapToDouble(i -> Math.pow(i - average, 2))
                .average()
                .orElse(0);
        return Math.sqrt(variance);
    }

    public static List<Integer> multiplyByTwoParallel(List<Integer> numbers) {
        return numbers.parallelStream().map(i -> i * 2).collect(Collectors.toList());
    }

    public static List<Integer> filterByEvenAndDivisibleBy3Parallel(List<Integer> numbers) {
        return numbers.parallelStream()
                .filter(i -> i % 2 == 0 && i % 3 == 0)
                .collect(Collectors.toList());
    }
}
