package pers.jz.algorithms.sorting;

import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jemmy Zhang on 2019/7/31.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode initReverseListNode(int number) {
        Preconditions.checkArgument(number >= 0);
        ListNode head = ListNode.builder().val(number).build();
        for (int i = 0; i < number; i++) {
            ListNode next = ListNode.builder().val(i).build();
            next.setNext(head.getNext());
            head.setNext(next);
        }
        return head;
    }
}
