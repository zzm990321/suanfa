package sort;

import static utils.Swap.swap;

public class Code_00_BubbleSort {
    /**
     * 冒泡排序
     * 做n次循环 每次一个一个数比较将最大的数移动到最后 在开始下一次循环
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        if(arr == null|| arr.length<2){
            return;
        }
        for(int i=arr.length-1;i>0;i--){
            for(int n=0;n<i;n++){
                //一个一个比较 如冒泡
                if(arr[n]>arr[n+1]){
                    swap(arr,n,n+1);
                }
            }
        }
    }
}
