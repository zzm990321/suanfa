package stackAndQueue;

import java.util.Stack;

/**
 * 仅用递归函数和栈操作逆序一个栈
 */
public class Code_03_reverse {
    /**
     * 返回栈底元素并删除
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()) {
            return result;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    /**
     * 逆序栈
     * @param stack
     */
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
