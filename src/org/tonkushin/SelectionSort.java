package org.tonkushin;

import java.util.Arrays;

/**
 * Сортировка выбором
 */

public class SelectionSort implements Sort {
    int[] arr;

    public SelectionSort(int[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
    }

    public void sort() {
        for (int i = arr.length - 1; i > 0; i--) {
            int maxIndex = i;

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }

            swap(maxIndex, i);
        }
    }

    public int[] getArray() {
        return arr;
    }

    private void swap(int a, int b) {
        int x = arr[a];
        arr[a] = arr[b];
        arr[b] = x;
    }
}
