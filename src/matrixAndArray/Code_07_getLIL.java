package matrixAndArray;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个整型数组arr，请返回其中最大可整合子数组的长度。例如，[5，5，3，2，6，4，3]的最大可整合子数组为[5，3，2，6，4]，所以返回5。
 */
public class Code_07_getLIL {
    /**
     * 解法1  对每个子数组排序然后判断记录最大的长度
     * @param arr
     * @return
     */
    public int getLIL1(int[] arr){
        if(arr == null || arr.length == 0 ){
            return 0;
        }
        int len = 0;
        //取出每个子数组
        for(int i = 0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(isIntegrated(arr,i,i)){
                    len = Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }

    //判断是否满足递增
    private boolean isIntegrated(int[] arr, int left, int right) {
        int[] newArr = Arrays.copyOfRange(arr,left,right+1);
        Arrays.sort(newArr);
        for(int i = 1;i < newArr.length; i++){
            if(newArr[i-1] != newArr[i]-1){
                return false;
            }
        }
        return true;
    }

    /**
     * 若一个数组如果没有重复元素 并且最大值减去最小值再加一的结果等于元素个数 那么就满足条件
     * @param arr
     * @return
     */
    public int getLIL2(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int len = 0;
        int max = 0;
        int min = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for(int j = i; j< arr.length; j++){
                if(set.contains(arr[j])){
                    break;
                }
                set.add(arr[j]);
                max = Math.max(max,arr[j]);
                min = Math.min(min,arr[j]);
                if(max - min == j-i){
                    len = Math.max(len, j-i+1);
                }
            }
            set.clear();
        }
        return len;
    }
}
