package pers.jz.algorithms.leetcode.linkedlist;

/**
 * @author Jemmy Zhang on 2019/7/31.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode sentry = new ListNode(-1);
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = sentry.next;
            sentry.next = temp;
        }
        return sentry.next;
    }
}
