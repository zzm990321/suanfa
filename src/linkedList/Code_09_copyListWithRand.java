package linkedList;

import java.util.HashMap;

/**
 * 复制含有随机指针节点的链表
 */
public class Code_09_copyListWithRand {
    /**
     * 使用哈希表来保存
     * @param head
     * @return
     */
    public RandNode copyListWithRand1(RandNode head){
        HashMap<RandNode,RandNode> map = new HashMap<>();
        RandNode cur = head;
        while(cur != null){
            map.put(cur, new RandNode(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }
}
