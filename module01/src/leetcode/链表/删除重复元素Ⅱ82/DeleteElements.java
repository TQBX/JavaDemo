package leetcode.链表.删除重复元素Ⅱ82;

/**
 * @auther Summerday
 */
//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
public class DeleteElements {
    public ListNode deleteDuplicates(ListNode head) {
        //创建哨兵节点，指向head
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel,curr = head;
        //当前位置且下一位置都不为空
        while(curr!=null&&curr.next!=null){
            //如果下一位和这位重复
            if(curr.val == curr.next.val){
                //向后寻找，知道curr为不重复的元素
                int val = curr.val;
                while(curr!=null&&curr.val==val){
                    curr = curr.next;
                }
                //删去重复元素
                prev.next = curr;
            }else{
                //不重复的情况
                //两个指针分别向后移动
                prev = curr;
                curr = curr.next;
            }
        }
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