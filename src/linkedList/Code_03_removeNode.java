package linkedList;

/**
 * 删除指定节点
 */
public class Code_03_removeNode {
    /**
     * 删除中间节点
     * @param head
     * @return
     */
    public  Node removeMidNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        if(head.next.next == null){
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while(cur.next != null && cur.next.next != null){
            //链表长度每增加二 删除的节点就后移一个
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    /**
     * 删除 a/b的节点
     * @param head
     * @param a
     * @param b
     * @return
     */
    public Node removeBByRatio(Node head, int a, int b){
        if(a < 1 || a > b){
            return head;
        }
        int n = 0;
        Node cur = head;
        while(cur != null){
            n++;
            cur = cur.next;
        }
        n = (int)Math.ceil(((double)(a * n))/(double) b);
        if( n == 1){
            head = head.next;
        }
        if (n > 1){
            cur = head;
            while(--n != 1){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
