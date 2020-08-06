package stackAndQueue;


import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置。
 如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值
 */
public class Code_05_getMaxWindow {
    /**
     * 利用双端队列qmax 中存放数组的下标
     * 放入规则 ：要存的下标为i
     *          1 qmax为空就放入
     *          2 不为空  [1] arr[j]>arr[i] 放入队尾
     *                   [2] arr[j<=arr[i] 弹出j
     *                   总结为最前面都是最大的 大的把小的挤出去
     * 弹出规则 当遍历到i时 如果队头下标等于i-w 说明过期弹出
     * 最大值的下标就是队头下标
     * @param arr
     * @param w
     * @return
     */
    public int[] getMaxWindow(int[] arr,int w){
        if(arr == null || w < 1 || arr.length < w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == i - w){
                qmax.pollFirst();
            }
            if(i >= w - 1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
