package matrixAndArray;


import java.util.HashMap;

public class Code_09_getMaxLength {
        /**
         * * 给定一个数组arr，该数组无序，但每个值均为正数，
          * 再给定一个正数k。求arr的所有子数组中所有元素相加和为k的最长子数组长度。
        */
    public int getMaxLength(int[] arr,int k){
        if(arr == null || arr.length == 0 || k<= 0){
            return 0;
        }
        /**
         * 用两个位置标记子数组左右两头 开始都在数组最左边
         */
        int left = 0;
        int right = 0;
        //sum为子数组的和
        int sum = arr[0];
        //len为长度
        int len = 0;
        while(right <arr.length){
            /**
             * 根据sum与k的比较决定指针的移动
             * 如果sum==k 若长度大于len 更新len 令left+1 sum-=left继续判断
             * 若sum<k right+1 sum+=right 判断越界
             * sum>k left+1
             */
            if(sum == k){
                len = Math.max(len,right - left + 1);
                sum -= arr[left++];
            }else if(sum<k){
                right++;
                if(right == arr.length){
                    break;
                }
                sum+=arr[right];
            }else{
                sum -= arr[left++];
            }
        }
        return len;
    }

    /**
     * 元素可以为正可以为负可以为0
     * 思路： 定义s的概念 s（i）代表arr【0，i】的和 所以arr[j,i] = s(i) - s(j-1)
     * @param arr
     * @param k
     * @return
     */
    public int maxLength(int[] arr,int k){
        if(arr == null || arr.length == 0){
            return 0;
        }
        /**
         * 设置hash表 key为累加过程中的出现的sum值 value 为sum出现的最早位置
         * 从左到右遍历 sum = sum+arr[i] 查看map中是否存在 sum - k
         * 如果 sum-k存在 取出对应的value值j 代表第一次出现累加和位置 s[i] =sum s[j] = sum-k
         * arr[j+1..i] 为子数组 大于len就更新len 如果不存在就说明没有
         *
         * 检查当前sum是否在map中 如果不存在 就加入到map中 如果出现过 不添加 因为添加最早出现的位置
         */
        HashMap<Integer,Integer> map = new HashMap<>();
        /**
         * 如果从0位置添加 所有从0开始的数组都没有考虑过 就从-1开始累加
         * 使得任何一个数不加 累加和为0
         */
        map.put(0,-1);
        int len = 0;
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            if(map.containsKey(sum - k)){
                len = Math.max(i-map.get(sum-k),len);
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return len;
    }
}
