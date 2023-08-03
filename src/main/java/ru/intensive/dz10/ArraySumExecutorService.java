package ru.intensive.dz10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ArraySumExecutorService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            array[i] = i + 1;
        }

        int threads = 5;
        int chunkSize = 200000;

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        List<Future<Long>> futures = new ArrayList<>();

        for (int i = 0; i < threads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = startIndex + chunkSize;
            ArraySumCalculator task = new ArraySumCalculator(array, startIndex, endIndex);
            Future<Long> future = executorService.submit(task);
            futures.add(future);
        }

        long totalSum = 0;
        for (Future<Long> future : futures) {
            totalSum += future.get();
        }

        executorService.shutdown();
        System.out.println("Total sum: " + totalSum);
    }
}

class ArraySumCalculator implements Callable<Long> {
    private int[] array;
    private int startIndex;
    private int endIndex;

    public ArraySumCalculator(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public Long call() {
        long sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += array[i];
        }
        return sum;
    }
}
