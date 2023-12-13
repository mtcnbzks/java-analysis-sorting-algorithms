package benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class Main {
    @State(Scope.Benchmark)
    public static class BenchmarkState {
        Integer[] arr;

        @Setup(Level.Trial)
        public void setup() {
            arr = Utils.generateRandomIntegerArray(10000); // 10K
            // arr = Utils.generateSortedIntegerArray(10000); // 10K
            // arr = Utils.generateReverseSortedIntegerArray(10000); // 10K
        }
    }

    @Benchmark
    public void heapSort(BenchmarkState state) {
        HeapSort.sort(state.arr.clone());
    }

    @Benchmark
    public void insertionSort(BenchmarkState state) {
        InsertionSort.sort(state.arr.clone());
    }

    @Benchmark
    public void mergeSort(BenchmarkState state) {
        MergeSort.sort(state.arr.clone());
    }

    @Benchmark
    public void quickSortHoare(BenchmarkState state) {
        QuickSortHoare.sort(state.arr.clone());
    }

    @Benchmark
    public void quickSortLomuto(BenchmarkState state) {
        QuickSortLomuto.sort(state.arr.clone());
    }

    @Benchmark
    public void selectionSort(BenchmarkState state) {
        SelectionSort.sort(state.arr.clone());
    }

    @Benchmark
    public void shellSort(BenchmarkState state) {
        ShellSort.sort(state.arr.clone());
    }

    @Benchmark
    public void threeWayMergeSort(BenchmarkState state) {
        ThreeWayMergeSort.sort(state.arr.clone());
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Main.class.getSimpleName())
                .shouldDoGC(true)
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.MILLISECONDS)
                .warmupIterations(2)
                .measurementIterations(5)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}