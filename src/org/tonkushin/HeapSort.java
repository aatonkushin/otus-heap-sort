package org.tonkushin;

import java.util.Arrays;

/**
 * Пирамидальная сортировка
 * <p>
 * l = 2x+1
 * r = 2x+2
 * p = (x-1)/2
 */

public class HeapSort implements Sort {
    int[] arr;
    boolean enableLogging = false;
    int stepCounter;

    public HeapSort(int[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
    }

    public void sort() {
        if (enableLogging) {
            System.out.println();
            System.out.println(Arrays.toString(arr));
        }

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

        if (enableLogging) {
            print(++stepCounter, x, root);
        }


        moveMaxToRoot(x, size);
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
        int x = getArray()[a];
        getArray()[a] = getArray()[b];
        getArray()[b] = x;
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
