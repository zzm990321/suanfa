package matrixAndArray;

import java.util.PriorityQueue;

/**
 * 给定一个正数数组arr，arr的累加和代表金条的总长度，arr的每个数代表金条要分成的长度。
 * 规定长度为K的金条只需分成两块，费用为K个铜板。返回把金条分出arr中的每个数字需要的最小代价
 */
public class Code_27_getMinSplitCost {
    /**
     * 贪心算法
     * 假设最小代价为ans首先把arr的数字放入小根堆
     * 1  从小根堆弹出两个数字 a，b ans = ans + a + b 然后把a+b的和放入小根堆
     * 2 重复1 直到只剩一个数字
     * @param arr
     * @return
     */
    public int getMinSplitCost(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }
        int ans = 0;
        while(minHeap.size() != -1){
            int sum = minHeap.poll() + minHeap.poll();
            ans += sum;
            minHeap.add(sum);
        }
        return ans;
    }
}
