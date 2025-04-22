/**
 * Problem: Intersection of Two Linked Lists
 * Source: https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Description:
 * Given the heads of two singly linked-lists headA and headB,
 * return the node at which the two lists intersect. If no intersection, return null.
 *
 * Constraints:
 * - No cycles in the lists
 * - Must not modify the lists
 * - Must run in O(m + n) time and O(1) space
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */

public class LinkedListIntersection {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Core logic
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; // could be intersection node or null
    }

    // Test the method
    public static void main(String[] args) {
        // Shared part (the intersection)
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        // List A: 4 → 1 → 8 → 4 → 5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;

        // List B: 5 → 6 → 1 → 8 → 4 → 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        // Run the intersection finder
        ListNode result = getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersected at '" + result.val + "'");
        } else {
            System.out.println("No intersection.");
        }
    }
}
