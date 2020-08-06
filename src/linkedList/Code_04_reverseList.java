package linkedList;

public class Code_04_reverseList {
    /**
     * 反转单向链表
     *
     * 使用pre保存上一个节点 next指向下一节点
     * 首先用next保存下一节点 然后将head指针指向上次保存的pre节点
     *
     * @param head
     * @return
     */
    public Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 双向链表 还要把last指针指向next
     * @param head
     * @return
     */
    public DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
