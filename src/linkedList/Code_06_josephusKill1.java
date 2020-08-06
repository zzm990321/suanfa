package linkedList;

/**
 * 环形约瑟夫问题
 */
public class Code_06_josephusKill1 {
    public Node josephusKill1(Node head, int m){
        if(head == null || head.next == head || m < 1){
            return head;
        }
        Node last = head;
        while(last.next != head){
            last = last.next;
        }
        int count = 0;
        while(head != last){
            //报数等于m就删除当前报数的节点
            if(++count == m){
                last.next = head.next;
                count = 0;
            }else{
                last = last.next;
            }
            //每次让head变为last的笑一个
            head = last.next;
        }
        return head;
    }
}
