package leetcode.链表.删除重复元素83;

/**
 * @auther Summerday
 */


/*
* 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
*/
public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head){
        //已排序的链表
        ListNode currNode = head;
        //如果后一值和前一值相等，前一值的next指向后一值的next
        while(currNode!=null&&currNode.next!=null){
            if(currNode.val==currNode.next.val){
                currNode.next = currNode.next.next;
            }else{
                //不相等的情况，就让前指针向后移
                currNode = currNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode node = deleteDuplicates(node1);
//        while(node!=null){
//            System.out.println(node.val);
//            node = node.next;
//        }
        for(;node!=null;node = node.next){
            System.out.println(node.val);
        }
    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }

}