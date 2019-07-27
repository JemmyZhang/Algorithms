package pers.jz.algorithms.linkedlist;

import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author Jemmy Zhang on 2019/7/27.
 */
public class LinkedListSamples {


    public static <T> SinglyNode<T> singlyLinkedListReverse(SinglyNode<T> head) {
        if (Objects.isNull(head)) {
            return null;
        }
        if (Objects.isNull(head.getNext())) {
            return head;
        }
        SinglyNode<T> before = head;
        SinglyNode<T> now = head.getNext();
        SinglyNode<T> after = head.getNext().getNext();
        before.setNext(null);
        while (now != after) {
            now.setNext(before);
            before = now;
            now = after;
            if (after != null) {
                after = after.getNext();
            }
        }
        return before;
    }

    public static <T> SinglyNode<T> singlyLinkedListReverseWithSentinel(SinglyNode<T> head) {
        if (Objects.isNull(head)) {
            return null;
        }
        SinglyNode<T> newHead = new SinglyNode<>();
        SinglyNode<T> current = head;
        while (Objects.nonNull(current)) {
            SinglyNode<T> tempNode = SinglyNode.<T>builder().data(current.getData()).build();
            tempNode.setNext(newHead.getNext());
            newHead.setNext(tempNode);
            current = current.getNext();
        }
        return newHead.getNext();
    }


    public static SinglyNode<Integer> initSinglyNode(int number) {
        Preconditions.checkArgument(number > 0);
        SinglyNode<Integer> head = SinglyNode.<Integer>builder().data(0).build();
        for (int i = number; i > 0; i--) {
            SinglyNode<Integer> next = SinglyNode.<Integer>builder().data(i).build();
            next.setNext(head.getNext());
            head.setNext(next);
        }
        return head;
    }

    public static <T> void print(SinglyNode<T> head) {
        StringBuilder builder = new StringBuilder();
        SinglyNode<T> node = head;
        while (Objects.nonNull(node)) {
            builder.append(node.getData());
            builder.append(",");
            node = node.getNext();
        }
        if (builder.length() != 0) {
            System.out.println(builder.subSequence(0, builder.length() - 1));
        } else {
            System.out.println("Linked list is empty.");
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SinglyNode<T> {
        private T data;
        private SinglyNode<T> next;
    }

    public static void main(String[] args) {
        SinglyNode<Integer> tenItemList = initSinglyNode(10);
        print(tenItemList);
        print(singlyLinkedListReverse(tenItemList));
        SinglyNode<Integer> tenItemList2 = initSinglyNode(10);
        print(singlyLinkedListReverseWithSentinel(tenItemList2));

    }

}
