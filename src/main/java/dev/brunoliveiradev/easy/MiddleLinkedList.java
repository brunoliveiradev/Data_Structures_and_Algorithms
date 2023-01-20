package dev.brunoliveiradev.easy;

import java.util.ArrayList;

public class MiddleLinkedList {

    /**
     * First Approach: interate over the LinkedList copying this content into an Array,
     * then getting the middle by length / 2.
     * || Time and Space Complexity: O(n)
     *
     * @param head LinkedList
     * @return middleNode index = n / 2
     */
    public ListNode middleNodeFirstApproach(ListNode head) {
        ArrayList<ListNode> array = new ArrayList<>();

        int length = 0;
        while (head != null) {
            array.add(head);
            head = head.next;
            length++;
        }
        return array.get(length / 2);
    }

    /**
     * Second and my favorite Approach: Using the LinkedList to solve this, without using ArrayList,
     * using two pointers to track the middle.
     * || Time complexity: O(n) | Space Complexity: O(1)
     * @param head - LinkedList
     * @return middleNode
     */
    public ListNode middleNode(ListNode head) {
        ListNode middle = head;
        ListNode end = head;

        while(end != null && end.next != null) {
            middle = middle.next;
            end = end.next.next;
        }
        return middle;
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
