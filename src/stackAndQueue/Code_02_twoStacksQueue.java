package stackAndQueue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 思路 ：一个压入栈 一个输出栈
 * 但有两个关键 1 stackpush要往stackpop中压入时 必须一次性压入
 *             2 stackpop不为空 stackpush绝对不能压入数据
 */
public class Code_02_twoStacksQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;
    public Code_02_twoStacksQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    private void pushToPop(){
        //确保为空
        if(stackPop.empty()){
            //确保一次全部插入
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
        pushToPop();
    }

    public int poll(){
        if(stackPush.empty() &&stackPop.empty()){
            throw new RuntimeException("empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if(stackPush.empty() &&stackPop.empty()){
            throw new RuntimeException("empty");
        }
        pushToPop();
        return stackPop.peek();
    }
}
