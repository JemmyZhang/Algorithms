package pers.jz.algorithms.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Jemmy Zhang
 */
public class BinarySearch {
    public static <E extends Comparable> int search(List<E> list, E key) {
        int left, right;
        final int VALUE_NOT_FOUND = -1;
        left = 0;
        right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            E value = list.get(mid);
            if (value.compareTo(key) < 0) {
                left = mid + 1;
            } else if (value.compareTo(key) > 0) {
                right = mid - 1;
            } else
                return mid;
        }
        return VALUE_NOT_FOUND;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int result = search(list, 9);
        System.out.println(result);
    }
}
