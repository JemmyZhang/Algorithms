package pers.jz.algorithms.leetcode.linkedlist;

/**
 * @author Jemmy Zhang on 2019/7/30.
 */
public class FindNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode front = head;
        ListNode end = head;
        int move = n - 1;
        while (move > 0) {
            if (end.next == null && move > 0) {
                return null;
            } else if (end.next == null) {
                break;
            }
            end = end.next;
            move--;
        }
        while (end.next != null) {
            front = front.next;
            end = end.next;
        }
        return front;
    }
}

