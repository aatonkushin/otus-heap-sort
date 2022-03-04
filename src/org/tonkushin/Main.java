package org.tonkushin;

public class Main {

    public static void main(String[] args) {
        for (int n = 100; n <= 1_000_000; n *= 10) {
//        for (int n = 10; n <= 10; n *= 10) {
            int[] array = generateArray(n);

            Sort sort = new SelectionSort(array);
            sort.enableLogging();
            process(sort, "Selection sort");

            sort = new HeapSort(array);
            sort.enableLogging();
            process(sort, "Heap sort");

            System.out.println();
        }
    }

    private static void process(Sort sort, String name) {
        Stopwatch sw = new Stopwatch();
        System.out.printf("%s %d: ", name, sort.getArray().length);
        sw.start();
        sort.sort();
        sw.stop();
        System.out.println(sw + ", " + sort.checkSortedArray());
    }

    private static int[] generateArray(int n) {
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = getRandomNumber(0, n);
        }

        return array;
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
