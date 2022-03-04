package org.tonkushin;

public interface Sort {
    void sort();
    int[] getArray();
    void enableLogging();

    /**
     * Проверяет отсортированный массив
     * @return CHECK OK - если массив отсортирован по возрастанию, иначе - CHECK FAILED
     */
    default String checkSortedArray() {
        for (int i = 1; i < getArray().length; i++) {
            if (getArray()[i] < getArray()[i - 1]) {
                return "CHECK FAILED";
            }
        }

        return "CHECK OK";
    }
}
