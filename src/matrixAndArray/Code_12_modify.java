package matrixAndArray;

import static utils.Swap.swap;

/**
 * 给定一个长度不小于2的数组arr，实现一个函数调整arr，
 * 要么让所有的偶数下标都是偶数，要么让所有的奇数下标都是奇数
 */
public class Code_12_modify {
    public void modify(int[] arr){
        if(arr == null || arr.length <2){
            return ;
        }
        int even = 0;
        int odd = 1;
        //最后一个数当作end 与前面的比较
        int end = arr.length-1;
        while(even <= end && odd <= end){
            //如果是偶数 交换 偶数加二
            if((arr[end] & 1) == 0){
                swap(arr,end,even);
                even += 2;
            }else{
                //奇数与奇数下标交换
                swap(arr,end,odd);
                odd += 2;
            }
        }
    }
}
