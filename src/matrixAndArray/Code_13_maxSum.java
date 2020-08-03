package matrixAndArray;

/**
 * 给定一个数组arr，返回子数组的最大累加和。
 * 例如，arr=[1，-2，3，5，-2，6，-1]，
 * 所有的子数组中，[3，5，-2，6]可以累加出最大的和12，所以返回12。
 */
public class Code_13_maxSum {
    public int maxSum(int[] arr){
        if(arr== null || arr.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for(int i = 0;i != arr.length; i++){
            cur += arr[i];
            max = Math.max(max,cur);
            //若小于0对后面的没有帮助 不用相加
            cur = cur <0 ? 0 : cur;
        }
        return max;
    }
}
