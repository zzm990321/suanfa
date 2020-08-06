package linkedList;

import static utils.Swap.swap;

/**
 * 将链表分成左边小 中间相等 右边大的形式
 */
public class Code_08_listPartition1 {
    /**
     * 将链表放到一个数组中
     * @param head
     * @param pivot
     * @return
     */
    public Node listPartition1(Node head, int pivot){
        if(head == null){
            return head;
        }
        Node cur = head;
        int i = 0;
        while(cur != null){
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length ; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr,pivot);
        for(i = 1; i != nodeArr.length; i++){
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[i-1].next = null;
        return nodeArr[0];
    }

    public void arrPartition(Node[] nodeArr,int pivot){
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while(index != big){
            if(nodeArr[index].value < pivot){
                swap(nodeArr, ++small, index++);
            }else if (nodeArr[index].value == pivot){
                index++;
            }else{
                swap(nodeArr, --big, index);
            }
        }
    }

    /**
     * 内部也要按原来的顺序
     * @param head
     * @param pivot
     * @return
     */
    public static Node listPartition2(Node head, int pivot){
        //小的头和尾
        Node sH = null;
        Node sT = null;
        //相等的头和尾
        Node eH = null;
        Node eT = null;
        //大的头和尾
        Node bH = null;
        Node bT = null;
        //保存下一个节点
        Node next = null;
        //所有的节点分进三链表中
        while(head != null){
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = head;
                }
            }else if(head.value == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else{
                if(bH == null){
                    bH = head;
                    bT = head;
                }else{
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if(sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if(eT != null){
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH :bH;
    }
}
