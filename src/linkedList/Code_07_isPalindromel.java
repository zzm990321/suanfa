package linkedList;

import java.util.Stack;

/**
 * 判断链表是否回文
 */
public class Code_07_isPalindromel {
    /**
     * 方法一 利用栈 将元素都放入栈中 在一个一个比较 若有不相同则不满足
     * @param head
     * @return
     */
    public boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(head != null){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 方法2 只取出一半元素 放入栈中
     * @param head
     * @return
     */
    public boolean isPalindrome2(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node right = head.next;
        Node cur = head;
        //找出中间节点
        while(cur.next != null && cur.next.next != null){
            right = right.next;
            cur=cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while(right != null){
            stack.push(right);
            right = right.next;
        }
        while(!stack.isEmpty()){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 不用其他结构 将链表的、右半部分反转 使用两个变量移动一步比较一下
     * 最后将链表回复
     * @param head
     * @return
     */
    public boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while(n2.next != null && n2.next.next != null){
            //查找中间节点
            n1 = n1.next;
            n2 = n2.next.next;
        }
        //右部分第一个节点
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        //反转右半区
        while(n2 != null){
            //保存下一节点
            n3 = n2.next;
            //指向上一个
            n2.next = n1;
            //n1移动
            n1 = n2;
            //n2移动
            n2 = n3;
        }
        //n3保存最后一个节点
        n3 = n1;
        //n2为左面第一个节点
        n2 = head;
        boolean res = true;
        while(n1 != null && n2 != null){
            if(n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        //反转回去
        n1 = n3.next;
        n3.next = null;
        while(n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
