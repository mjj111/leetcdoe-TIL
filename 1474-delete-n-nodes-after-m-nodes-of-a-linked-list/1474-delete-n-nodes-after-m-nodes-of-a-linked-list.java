class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode current = head;
        ListNode lastM = head;
        
        while (current != null) {
            for (int i = 0; i < m && current != null; i++) {
                lastM = current;
                current = current.next;
            }
            
            for (int i = 0; i < n && current != null; i++) {
                current = current.next;
            }
            
            lastM.next = current;
        }
        
        return head;
    }
}