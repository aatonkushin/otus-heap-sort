package org.tonkushin;

import java.util.Arrays;

/**
 * Сортировка выбором
 */

public class SelectionSort implements Sort {
    int[] arr;
    boolean enableLogging = false;

    public SelectionSort(int[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
    }

    public void sort() {
        if (enableLogging) {
            System.out.println();
            System.out.println(Arrays.toString(arr));
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int maxIndex = i;

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            swap(maxIndex, i);

            if (enableLogging) {
                print(arr.length - i, maxIndex, i);
            }
        }
    }

    public int[] getArray() {
        return arr;
    }

    @Override
    public void enableLogging() {
        // Журналирование доступно только до 20 элементов в массиве
        if (this.arr.length <= 20) {
            this.enableLogging = true;
        }
    }

    private void swap(int a, int b) {
        int x = arr[a];
        arr[a] = arr[b];
        arr[b] = x;
    }

    private void print(int step, int i1, int i2) {
        System.out.println(step + ": ");

        String[] stringArray = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            stringArray[i] = String.valueOf(arr[i]);
        }

        System.out.println(Arrays.toString(stringArray));

        stringArray[i1] = "^";
        stringArray[i2] = "^";

        System.out.println(Arrays.toString(stringArray));
    }
}
