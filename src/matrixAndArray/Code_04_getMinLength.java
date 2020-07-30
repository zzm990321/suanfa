package matrixAndArray;

/**
 *需要排序的最短数组长度
 *  1   5   3   4   2   6   7 返回 4
 *  因为 5    3   4   2 需要排序
 */
public class Code_04_getMinLength {
    public int getMinLength(int[] arr){
        if(arr== null || arr.length < 2){
            return 0;
        }
        /**
         * 从右向左遍历，记录右侧出现过最小值 如果 arr[i]>min 则min一定要移动 找出左侧最大的值
         */
        int min = arr[arr.length - 1];
        int noMinIndex = -1;
        for(int i = arr.length - 2;i != -1; i--){
            if(arr[i] > min){
                noMinIndex = i;
            }else{
                min = Math.min(min,arr[i]);
            }
        }
        if(noMinIndex == -1){
            return 0;
        }
        /**
         * 从左向右 左侧出现最大值 再找出比他小的最右面的值
         */
        int max = arr[0];
        int noMaxIndex = -1;
        for(int i =1;i != arr.length ;i++){
            if(arr[i] < max){
                noMaxIndex = i;
            }else{
                max = Math.max(max,arr[i]);
            }
        }
        //两个相减为所求最短数组长度
        return noMaxIndex-noMinIndex +1;
    }
}
