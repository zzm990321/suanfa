package matrixAndArray;

import static utils.Swap.swap;

/**
 * 给定一个有序数组arr，调整arr使得这个数组的左半部分没有重复元素且升序，
 * 而不用保证右部分是否有序。
 */
public class Code_22_leftUnique {
    public void leftUnique(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //u的含义 前面的元素都无重复元素且有序 A区域
        int u = 0;
        //i的含义 arr[u+1,i] 上不保证没有重复元素且升序
        int i = 1;
        /**
         * 因为是有序 如果arr[i] != arr[u]当前数就放在A区域 交换arr[u+1] 和 arr[i]
         * u++,如果相等说明已经加入 不用添加 i++就好
         */
        while (i != arr.length){
            if (arr[i++] != arr[u]){
                swap(arr, ++u, i - 1);
            }
        }
    }

    /**
     * 给定一个数组arr，其中只可能含有0、1、2三个值，请实现arr的排序。
     * @param arr
     */
    public void sort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //left左面都是0
        int left = -1;
        int index = 0;
        int right = arr.length;
        while(index < right){
            if(arr[index] == 0){
                swap(arr, ++left, index++);
            }else if(arr[index] == 2){
                swap(arr, index, --right);
            }else{
                index++;
            }
        }
    }
}
