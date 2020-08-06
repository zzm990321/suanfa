package stackAndQueue;


import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量
 */
public class Code_09_getNum {
    /**
     * 1 生成两个双端队列 qmax qmin  两个整型变量i和j 表示子数组范围
     * arr[i,j] 生成整型变量res表示满足条件的子数组数量
     * 2 j向右移动 不断更新双端队列  当不满足的时候 说明前面的都满足
     *          res+=j-i
     * 3 i向右移动一个 然后重复2
     * @param arr
     * @param num
     * @return
     */
    public static int getNum(int[] arr, int num){
        if(arr == null || arr.length == 0 || num < 0){
            return 0;
        }
        //生成两个双端队列 一个表示当前最大值 一个表示最小值
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while(i < arr.length){
            while(j < arr.length){
                //队列中的数也不能超出j的范围
                if(qmin.isEmpty() || qmin.peekLast() != j){
                    //小的将会挤出比他大的
                    while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
                        qmin.pollLast();
                    }
                    qmin.addLast(j);
                    //大的将会挤出小的
                    while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                        qmax.pollLast();
                    }
                    qmax.addLast(j);
                }
                //此时不满足条件了 i需要向右移动 因为原来的肯定都不满足了
                if(arr[qmax.getFirst()] - arr[qmin.getFirst()] > num){
                    break;
                }
                j++;
            }
            //满足条件的加进去
            res += j - i;
            //将被淘汰的数去除
            if(qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            if(qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            i++;
        }
        return res;
    }
}
