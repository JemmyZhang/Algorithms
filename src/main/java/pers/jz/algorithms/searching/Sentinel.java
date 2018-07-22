package pers.jz.algorithms.searching;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Jemmy Zhang
 */
public class Sentinel {

    public static <T> int search(SentinelArray<T> array, T key) {
        if (Objects.isNull(array)) {
            throw new NullPointerException();
        }
        array.put(0, key); //Set sentinel the key words;
        int i = array.length;
        for (; !Objects.equals(key, array.get(i)); i--) ;
        return i;
    }

    public static class SentinelArray<T> {
        private Object[] array;
        private int length;

        public SentinelArray(int size) {
            int maxSize = size + 1;
            this.array = new Object[maxSize];
            this.array[0] = null; //Sentinel
            this.length = size;
        }

        public T get(int index) {
            checkBoundary(index);
            return (T) array[index];
        }

        public void put(int index, T element) {
            checkBoundary(index);
            array[index] = element;
        }

        public void delete(int index) {
            checkBoundary(index);
            array[index] = null;
        }

        public T[] rep() {
            return (T[]) array;
        }//Sentinel

        public int getLength() {
            return length;
        }

        private void checkBoundary(int index) {
            if (index < 0 || index > length) {
                throw new NoSuchElementException();
            }
        }
    }

    public static void main(String[] args) {
        int len = 10;
        SentinelArray<Integer> array = new SentinelArray<>(10);
        for (int i = 1; i <= len; i++) {
            array.put(i, i);
        }
        System.out.println(array.length);
        System.out.println(search(array, 2));
    }
}
