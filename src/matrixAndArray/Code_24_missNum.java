package matrixAndArray;

import static utils.Swap.swap;

/**
 * 题组中未出现的最小正整数
 * arr=[-1，2，3，4]。返回1。arr=[1，2，3，4]。返回5
 *
 * 思路 1 两个变量 l表示已经包含的范围 初始为0
 *      r表示目前为止 后续出现最优情况arr可能包含的范围 开始令r=N
 *      2 遍历到l l的数为arr[l]
 *      3 如果arr[l] = l+ 1 l++
 *      4 arr[l] <= l 说明数少了一个 把最后的数放在l上 检查 r-- 重复步骤二
 *      5 如果arr[l] > r  arr最后的放在l上 检查 r-- 重复
 *      6.如果arr[arr[l]-1]==arr[l]。如果步骤4和步骤5没中，说明arr[l]是在[l+1，r]范围上的数，
 *      而且这个数应该放在arr[l]-1位置上。可是此时发现arr[l]-1位置上的数已经是arr[l]，
 *      说明出现了两个 arr[l]，既然在[l+1，r]上出现了重复值，那么[l+1，r]范围上的数又少了一个，
 *      所以与步骤 4和步骤5一样，把arr最后位置的数（arr[r-1]）放在位置l上，下一步检查这个数，然后令r--。重复步骤2。
 *      7.如果步骤4、步骤5和步骤6都没中，说明发现了[l+1，r]范围上的数，并且此时并未发现重复。那么arr[l]应该放到arr[l]-1位置上，所以把l位置上的数和arr[l]-1位置上的数交换，下一步继续遍历l位置上的数。重复步骤2。
 */
public class Code_24_missNum {
    public int missNum(int[] arr){
        int l =0;
        int r = arr.length;
        while(l<r){
            if(arr[l] == l + 1){
                l++;
            }else if(arr[l] <= 1 || arr[l] > r || arr[arr[l] - 1] == arr[l]){
                arr[l] = arr[--r];
            }else{
                swap(arr,l,arr[l] - 1);
            }
        }
        return l+1;
    }
}
