# Sorting Algorithms Benchmarking

This is a Java-based benchmarking project that uses various sorting algorithms to sort an array of integers and
characters.
Sorting Algorithms

The following sorting algorithms are implemented:

* Heap Sort
* Insertion Sort
* Merge Sort
* Quick Sort (Hoare)
* Quick Sort (Lomuto)
* Selection Sort
* Shell Sort
* Three Way Merge Sort

## Benchmarking

The project uses the Java Microbenchmark Harness (JMH) to benchmark the performance of the sorting algorithms.
The benchmarking process measures the average time taken by each algorithm to sort an array of 10,000 integers as well
as character arrays of sizes 16K, 32K, 64K, 128K, and 256K.

## Results

| Algorithm           | 32K Characters | 64K Characters | 128K Characters | 256K Characters |
|---------------------|----------------|----------------|-----------------|-----------------|
| Heap Sort           | 3.45ms         | 7.27ms         | 15.00ms         | 33.09ms         |
| Insertion Sort      | 392.49ms       | 1562.43ms      | 6475.71ms       | 127300.75ms     |
| Merge Sort          | 2.68ms         | 5.62ms         | 12.06ms         | 24.78ms         |
| Quick Sort (Hoare)  | 13.46ms        | 37.95ms        | 171.84ms        | 826.64ms        |
| Quick Sort (Lomuto) | 56.42ms        | 216.19ms       | 865.12ms        | 3922.36ms       |
| Selection Sort      | 528.86ms       | 2113.45ms      | 8441.46ms       | 33727.43ms      |
| Shell Sort          | 2.85ms         | 6.25ms         | 14.24ms         | 37.51ms         |
| 3-Way Merge Sort    | 2.23ms         | 4.82ms         | 9.86ms          | 21.17ms         |
