package matrixAndArray;

import static utils.Swap.swap;

/**
 * 找到一个数组中最小的k个数
 * 若长度为N 找k个
 * 可以排序后找 复杂度为NlogN
 * 本题用堆排序 NlogK
 */
public class Code_03_getMinKNumsByHeap {
    public int[] getMinKNumsByHeap(int[] arr, int k){
        if(k < 1 || k > arr.length){
            return arr;
        }
        //建立大小为K的大顶堆
        int[] kHeap = new int[k];
        //先插入i个数建立堆
        for(int i = 0;i != k; i++){
            heapInsert(kHeap, arr[i], i);
        }
        //将剩下的数插入并进行堆的调整
        for(int i = k; i != arr.length; i++){
            //如果有比大顶堆中最大的数小的数便放入堆中
            if(arr[i] < kHeap[0]){
                kHeap[0] = arr[i];
                heapify(kHeap, 0 , k);
            }
        }
        return kHeap;
    }

    //插入数时进行调整
    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        //判断是否还有下一层
        while(left < heapSize){
            //找出子节点是否有更大的数有则进行交换
            if(arr[left] > arr[index]){
                largest = left;
            }
            if(right < heapSize && arr[right] > arr[largest]){
                largest = right;
            }
            if(largest != index){
                swap(arr,largest,index);
            }else{
                 break;
            }
            index = largest;
            left = index * 2 +1;
            right = index * 2 +2;
        }
    }

    //建立大顶堆 保证最上面的数是最大的
    private void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while(index != 0){
            int parent = (index - 1) /2;
            if(arr[parent] < arr[index]){
                swap(arr,parent,index);
                index = parent;
            }else{
                break;
            }
        }
    }
}
