package leetcode.链表.移除链表指定元素203;


/**
 * @auther Summerday
 */

/*删除链表中等于给定值 val 的所有节点。*/
public class RemoveElements {

    public ListNode sentinelRemove(ListNode head,int val){
        //创建哨兵节点，指向head
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        //定义两个指针，前向指向哨兵节点，当前指向head
        ListNode prev = sentinel;
        ListNode curr = head;

        while(curr!=null){

            if(curr.val == val){
                //当前节点值就是指定值，则让上一个节点的next指向下一个节点
                prev.next = curr.next;
            }else{
                //上一个节点向后移
                prev = curr;
            }
            //遍历下一节点
            curr = curr.next;

        }
        //返回哨兵节点的下一节点
        return sentinel.next;

    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }

}