package stackAndQueue;

import java.util.Stack;

/**
 * 单调栈 给定一个不含有重复值的数组 找到每一个i位置左边和右边
 * 离i最近且值比他小的位置
 */
public class Code_06_rightWay {
    /**
     *  需要找小 因此让stack从栈顶到栈底 代表的值严格递减
     *  若不满足 就要弹出 他下面的值为左面比他小 当前要进去的值为右面比他小
     *  若下面没有值 则说明没有 序号为-1
     *  在最后结束时对剩下的值进行清算 右面都没有为-1
     * @param arr
     * @return
     */
    public int[][] getNearLessNoRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty()&&arr[stack.peek()] > arr[i]){
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }
}
