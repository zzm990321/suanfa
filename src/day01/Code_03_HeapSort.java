package day01;

import static utils.Swap.swap;

/**
 * 堆排序
 */
public class Code_03_HeapSort {
    public static void heapSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        //依次把数插进堆中
        for(int i = 0; i < arr.length; i++){
            heapInsert(arr, i);
        }
        int size= arr.length;
        //将最后一个数放到堆顶进行堆的调整
        swap(arr,0,--size);
        while(size > 0){
            heapify(arr, 0, size);
            swap(arr,0,--size);
        }
    }

    /**
     * 插入 数如果比父亲大便交换
     * @param arr
     * @param i
     */
    private static void heapInsert(int[] arr, int i) {
        while(arr[i] > arr[(i-1)/2]){
            swap(arr,i,(i-1)/2);
            i=(i-1)/2;
        }
    }

    /**
     * 进行调整
     * @param arr
     * @param i
     * @param size
     */
    private static void heapify(int[] arr, int i, int size) {
        int left = i * 2 + 1;
        while(left < size){
            //选出子节点中比较大得数
            int largest = left + 1 < size && arr[left+1] > arr[left] ? left+1 : left;
            //与·当前数比较
            largest = arr[largest] > arr[i] ? largest : i;
            if(largest == i){
                break;
            }
            swap(arr,largest,i);
            i = largest;
            left = i * 2 + 1;
        }
    }

}
