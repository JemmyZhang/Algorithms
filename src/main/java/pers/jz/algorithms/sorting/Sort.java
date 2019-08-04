package pers.jz.algorithms.sorting;

/**
 * @author Jemmy Zhang on 2019/8/4.
 */
public class Sort {

    public static int[] bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            boolean isOrdered = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isOrdered = false;
                }
            }
            if (isOrdered) {
                break;
            }
            System.out.println("Sort times: " + (i + 1));
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                }
            }
            array[j + 1] = temp;
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int position = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    position = j;
                }
            }
            if (position != i) {
                array[position] = array[i];
                array[i] = min;
            }
        }
        return array;
    }

    private static void print(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(i);
            if (i != array.length - 1) {
                builder.append(",");
            }
        }
        System.out.println(builder);
    }

    private static int[] arrayCopy(int[] origin) {
        int[] array = new int[origin.length];
        System.arraycopy(origin, 0, array, 0, array.length);
        return array;
    }


    public static void main(String[] args) {
        int[] array = {5, 1, 2, 3, 4, 6};
        print(bubbleSort(arrayCopy(array)));
        print(insertionSort(arrayCopy(array)));
        print(selectionSort(arrayCopy(array)));
    }
}
