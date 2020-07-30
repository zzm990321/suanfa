package sort;

import static utils.Swap.swap;

/**
 * 荷兰国旗 给定一个数 将小于的数放在左面 大于的放右面 思想与快排相同 更为简单
 */
public class Code_08_NetherLandsFlag {
    public static int[] partition(int[] arr, int l, int r, int p){
        int less = l - 1;
        int more = r + 1;
        while(l < more){
            if(arr[l] < p){
                swap(arr,++less,l++);
            }else if(arr[l] > p){
                swap(arr, --more, l);
            }else{
                l++;
            }
        }
        return new int[]{less + 1,more - 1};
    }
}
