package linkedList;

/**
 * 删除倒数第k个节点
 */
public class Code_02_removeLastKthNode {
    public Node removeLastKthNode(Node head, int lastKth){
        if(head == null || lastKth < 1){
            return head;
        }
        Node cur = head;
        //让链表从头走到尾 每次k减一
        while(cur != null){
            lastKth --;
            cur = cur.next;
        }
        //头节点就是要找的
        if(lastKth == 0){
            head = head.next;
        }
        //k<0 说明点在中间 要找到删除节点的前一节点 第N-K
        if(lastKth < 0){
            //重新从头节点开始 第一次k变为K-N 第二次为0就停在N-k上
            cur = head;
            while(++lastKth != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    /**
     * 双链表 last指针要进行重连
     * @param head
     * @param lastKth
     * @return
     */
    public DoubleNode removeLastKthNode(DoubleNode head,int lastKth){
        if (head == null || lastKth < 1){
            return head;
        }
        DoubleNode cur = head;
        while(cur != null){
            lastKth--;
            cur = cur.next;
        }
        if(lastKth == 0){
            head = head.next;
            head.last = null;
        }
        if(lastKth < 0){
            cur = head;
            while(++lastKth != 0){
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if(newNext != null){
                newNext.last = cur;
            }
        }
        return head;
    }
}
