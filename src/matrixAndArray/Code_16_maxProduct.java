package matrixAndArray;

/**
 * 子数组最大累乘积
 */
public class Code_16_maxProduct {
    public double maxProduct(double[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        double max = arr[0];
        double min = arr[0];
        double res = arr[0];
        double maxEnd = 0;
        double minEnd = 0;
        for (int i = 1; i < arr.length; ++i) {
            /**
             * arr[i]结尾的最大乘积有三种可能
             * 1： max*arr[i] 【3，4，5】
             * 2： min*arr[i] [-2,3,-4]
             * 3 arr[i]  [0.1,0.1,1000]
             */
            maxEnd = max * arr[i];
            minEnd = min * arr[i];
            max = Math.max(Math.max(maxEnd,minEnd),arr[i]);
            min = Math.min(Math.min(maxEnd,minEnd),arr[i]);
            res = Math.max(res,max);
        }
        return res;
    }
}
