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
    public ListNode partition(ListNode head, int x) {
        ListNode curr=head;
        ListNode dummy1=new ListNode(0);
        ListNode dummy2=new ListNode(0);
        ListNode less=dummy1;
        ListNode greter =dummy2;
        while(curr!=null){
            if(curr.val <x){
                less.next=curr;
                less=curr;
            }else{
                greter.next=curr; 
                greter=curr;
            }
            curr=curr.next;
        }
        greter.next=null;
        less.next=dummy2.next;
        return dummy1.next;
        
    }
}