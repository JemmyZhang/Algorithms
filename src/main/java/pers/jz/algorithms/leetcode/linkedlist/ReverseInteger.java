package pers.jz.algorithms.leetcode.linkedlist;

/**
 * @author Jemmy Zhang on 2020/2/18.
 */
public class ReverseInteger {
    class Solution {
        public int reverse(int x) {
            int result = 0;
            while (x != 0) {
                int c = x % 10;
                x = x / 10;
                if ((c > 0 && result > (Integer.MAX_VALUE - c) / 10) || (c < 0 && result < (Integer.MIN_VALUE - c) / 10)) {
                    return 0;
                }
                result = result * 10 + c;
            }
            return result;
        }
    }
}
