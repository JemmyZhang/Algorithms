package pers.jz.algorithms.sorting;

import java.util.Objects;

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

    public static ListNode bubbleSortLinkedList(final ListNode head) {
        ListNode lengthCounter = head;
        int length = 0;
        while (lengthCounter != null) {
            length++;
            lengthCounter = lengthCounter.next;
        }

        ListNode sentry = new ListNode();
        sentry.next = head;

        for (int i = 0; i < length; i++) {
            ListNode beforeBefore = sentry;
            ListNode before = sentry.next;
            ListNode after = before.next;
            for (int j = 1; j < length - i; j++) {
                ListNode afterAfter = after.next;
                if (before.val > after.val) {
                    after.next = before;
                    before.next = afterAfter;
                    if (beforeBefore != null) {
                        beforeBefore.next = after;
                    }
                    beforeBefore = after;
                } else {
                    beforeBefore = before;
                    before = after;
                }
                after = afterAfter;
            }
        }
        return sentry.next;
    }

    public static ListNode insertionSortLinkedList(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        if (Objects.isNull(head.next)) {
            return head;
        }
        ListNode sentry = new ListNode();
        sentry.setNext(head);
        ListNode before = sentry.next;
        ListNode after = sentry.next.next;
        while (Objects.nonNull(after)) {
            if (after.getVal() < before.getVal()) {
                ListNode searcher = sentry;
                while (searcher.getNext().getVal() < after.getVal()) {
                    searcher = searcher.getNext();
                }
                before.setNext(after.getNext());
                after.setNext(searcher.getNext());
                searcher.setNext(after);
                after = before.getNext();
            } else {
                before = before.getNext();
                after = after.getNext();
            }
        }
        return sentry.getNext();
    }

    public static ListNode selectionSortLinkedList(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        if (Objects.isNull(head.getNext())) {
            return head;
        }
        ListNode sentry = new ListNode();
        sentry.setNext(head);
        ListNode iter = sentry;
        ListNode before = sentry;
        ListNode after = before.getNext();
        while (iter.getNext() != null) {
            ListNode minBefore = after;
            while (after != null) {
                if (minBefore.getVal() > after.getVal()) {
                    minBefore = before;
                }
                before = before.getNext();
                after = after.getNext();
            }

            ListNode min = minBefore.getNext();
            if (Objects.nonNull(min)) {
                minBefore.setNext(min.getNext());
                min.setNext(iter.getNext());
                iter.setNext(min);
            }

            iter = iter.getNext();
            before = iter;
            after = before.getNext();
        }
        return sentry.getNext();

    }

    public static int[] mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
        return array;
    }


    public static void mergeSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int midIndex = startIndex + ((endIndex - startIndex) >> 1);
        mergeSort(array, startIndex, midIndex);
        mergeSort(array, midIndex + 1, endIndex);
        merge(array, startIndex, midIndex, endIndex);
    }

    private static void merge(int[] array, int startIndex, int midIndex, int endIndex) {
        int l1Index = startIndex;
        int l2Index = midIndex + 1;
        int[] tempArray = new int[endIndex - startIndex + 1];
        int counter = 0;
        while (l1Index <= midIndex && l2Index <= endIndex) {
            if (array[l1Index] < array[l2Index]) {
                tempArray[counter++] = array[l1Index++];
            } else {
                tempArray[counter++] = array[l2Index++];
            }
        }

        for (int i = l1Index; i <= midIndex; i++) {
            tempArray[counter++] = array[i];
        }

        for (int j = l2Index; j <= endIndex; j++) {
            tempArray[counter++] = array[j];
        }

        for (int i = 0; i < tempArray.length; i++) {
            array[startIndex + i] = tempArray[i];
        }
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

    private static void print(ListNode listNode) {
        StringBuilder builder = new StringBuilder();
        while (listNode != null) {
            builder.append(listNode.val);
            builder.append(",");
            listNode = listNode.next;
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
        print(ListNode.initReverseListNode(6));
        print(bubbleSortLinkedList(ListNode.initReverseListNode(6)));
        print(insertionSortLinkedList(ListNode.initReverseListNode(6)));
        print(selectionSortLinkedList(ListNode.initReverseListNode(6)));
        print(mergeSort(arrayCopy(array)));
    }
}
