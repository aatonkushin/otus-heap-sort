package org.tonkushin;

import java.util.Arrays;

/**
 * Пирамидальная сортировка
 *
 * l = 2x+1
 * r = 2x+2
 * p = (x-1)/2
 */

public class HeapSort implements Sort {
    int[] arr;

    public HeapSort(int[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
    }

    public void sort() {

        for (int root = arr.length / 2 - 1; root >= 0; root--) {
            moveMaxToRoot(root, arr.length);
        }


        for (int i = arr.length - 1; i > 0; i--) {
            swap(0, i);
            moveMaxToRoot(0, i);
        }
    }

    private void moveMaxToRoot(int root, int size) {
        int l = 2 * root + 1;
        int r = 2 * root + 2;

        int x = root;

        if (l < size && arr[l] > arr[x]) {
            x = l;
        }
        if (r < size && arr[r] > arr[x]) {
            x = r;
        }

        if (x == root) {
            return;
        }

        swap(x, root);
        moveMaxToRoot(x, size);
    }

    public int[] getArray() {
        return arr;
    }

    private void swap(int a, int b) {
        int x = getArray()[a];
        getArray()[a] = getArray()[b];
        getArray()[b] = x;
    }
}
