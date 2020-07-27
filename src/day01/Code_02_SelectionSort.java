package day01;


import static com.sun.tools.javac.jvm.ByteCodes.swap;
import static utils.Swap.swap;

/**
 * 选择排序 外层n-1次循环 每次循环选出后面所有最小的数的位置 与开始的数进行交换
 */
public class Code_02_SelectionSort {
    public static void insertionSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for(int j =i+1;j<arr.length;j++){
                minIndex = arr[j]<arr[minIndex]? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }
}
