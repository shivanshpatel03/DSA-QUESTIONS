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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode curr=head;
        int count=1;
        while(curr.next!=null){
            curr=curr.next;
            count++;
        }
        curr.next=head;
        k=k%count;
        int end = count-k;
        ListNode t1=head;
        for(int i =1; i<=end;i++){
            if(i==end){
                ListNode temp =t1;
                t1=t1.next;
                temp.next=null;
            }else{
                t1=t1.next;
            }

        }
        return t1;
    }
}