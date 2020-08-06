package stackAndQueue;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序 从顶到底从大到小排序
 */
public class Code_04_sortStackByStack {
    /**
     * 申请的栈为help栈 原始的要从大到小 因此help为小到大
     * 先弹出 元素 cur
     * 如果 cur 小于等于 help顶 直接压入
     * 如果 大于 将help元素弹出压到stack 直到又满足一条件 将刚保存的cur又压入help
     *
     * 一直执行 直到stack全部压入help 最后将help所有又压入到stack
     * @param stack
     */
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!help.isEmpty() && help.peek() < cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
