package matrixAndArray;

/**
 * 数组排序后相邻数最大插值
 * 可排序实现 也可借助桶排序
 */
public class Code_25_maxGap {
    public int maxGap(int[] nums){
        if(nums == null || nums.length < 2){
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        if(min == max){
            return 0;
        }
        //有长度+1 个桶
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            //求出应该在的桶数
            bid = bucket(nums[i],len, min, max);
            //判断是否是最小的
            mins[bid] = hasNum[bid] ? Math.min(mins[bid],nums[i]):nums[i];
            //判断是否最大的
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid],nums[i]):nums[i];
           //就这个桶设置为有数字
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for(;i<=len;i++){
            if(hasNum[i]){
                //将这个桶最小与前面最大的比较
                res = Math.max(res,mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public int bucket(long num, long len, long min, long max){
        return(int)((num - min) * len/(max - min));
    }
}
