package linkedList;

/**
 * 给定一个单向链表 两个整数from 和 to 将 from到to节点之间反转
 */
public class Code_05_reversePart {
    public Node reversePart(Node head, int from,int to){
        int len = 0;
        Node node1 = head;
        //反转部分前一个节点
        Node fPre = null;
        //反转部分后一个节点
        Node tPos = null;
        //找到两个节点
        while(node1 != null){
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if(from > to || from < 1 || to > len){
            return head;
        }
        //若fPre为null 说明反转部分包含头节点 返回的新节点为反转部分最后一个节点
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        //将第一个顶点与不是反转部分后面的第一个连接起来
        node1.next = tPos;
        Node next = null;
        while(node2 != tPos){
            //反转过程
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if(fPre != null){
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}
