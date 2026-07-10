/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */



class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // Min Heap based on node value
        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add the first node of each list
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // Process nodes in sorted order
        while (!pq.isEmpty()) {

            ListNode curr = pq.poll();

            tail.next = curr;
            tail = tail.next;

            // Add the next node from the same list
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        return dummy.next;
    }
}
