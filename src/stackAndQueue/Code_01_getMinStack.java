package stackAndQueue;

import java.util.Stack;

/**
 * 设计带有getMin功能的栈
 */
public class Code_01_getMinStack {
    /**
     * 第一种设计方案
     * 压入规则： 压入数据 先加入stackData 然后判断stackMin是否为空
     *          为空 则压入小栈
     *          不为空 则比较当前元素与小栈的栈顶元素哪个更小 如果当前小或者相等 则压入
     *  弹出规则： 先弹出元素栈 与小栈的栈顶比较 若相等 弹出小栈栈顶
     *  */
    public class MyStack1{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1(){
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum){
            if(this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if(newNum <= this.getmin()){
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop(){
            if(this.stackData.isEmpty()){
                throw new RuntimeException("your stack is empty");
            }
            int value = this.stackData.pop();
            if(value == this.getmin()){
                this.stackMin.pop();
            }
            return value;
        }

        public int getmin(){
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("your stack is empty");
            }
            return this.stackMin.peek();
        }
    }

    /**
     * 方法二 才插入时判断小于便插入小栈 否则将刚才最小的的在插入一次
     * 这样弹出的时候就不用判断
     */
    public class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;


        public MyStack2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum){
            if(this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if(newNum < this.getmin()){
                this.stackMin.push(newNum);
            }else{
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            this.stackData.push(newNum);
        }

        public int pop(){
            if(this.stackData.isEmpty()){
                throw new RuntimeException("your stack is empty");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public int getmin(){
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("your stack is empty");
            }
            return this.stackMin.peek();
        }
    }
}
