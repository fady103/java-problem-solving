/**
 * Problem: Linked List Cycle
 * Source: https://leetcode.com/problems/linked-list-cycle/
 *
 * Description:
 * Given head, the head of a singly linked list, determine if the linked list has a cycle in it.
 * A cycle exists if some node in the list can be reached again by continuously following the next pointer.
 * Return true if there is a cycle, otherwise return false.
 *
 * You must solve it using O(1) (i.e., constant) memory.
 *
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 *
 * Approach:
 * Use Floyd’s Cycle Detection Algorithm (Tortoise and Hare):
 * - Use two pointers, slow and fast.
 * - Move slow one step at a time and fast two steps at a time.
 * - If they ever meet, there is a cycle.
 * - If fast reaches the end (null), then no cycle exists.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */


public class LinkedListCycle {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Main method to detect cycle
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        // Move slow by 1 step, fast by 2 steps
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;

            slow = slow.next;
            fast = fast.next.next;
        }

        // Cycle detected
        return true;
    }

    // Test the method
    public static void main(String[] args) {
        // Create a cycle: 3 → 2 → 0 → -4 → (points back to 2)
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // cycle here

        boolean result = hasCycle(node1);
        System.out.println("Has cycle: " + result); // Output: true
    }
}