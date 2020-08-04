package matrixAndArray;

/**
 *给定一个整型数组arr，返回不包含本位置值的累乘数组
 */
public class Code_21_product1 {
    /**
     * 实用除法 所有数组乘积为all 如果不含0 res[i] = all/arr[i]
     *      如果一个0 对这个位置上res=all 其他为0
     *      如果0数量大于1 res所有位置都为0
     * @param arr
     * @return
     */
    public int[] product1(int[] arr){
        if(arr == null || arr.length < 2){
            return null;
        }
        int count = 0;
        int all = 1;
        for (int i = 0; i != arr.length; i++) {
            if(arr[i] != 0){
                all *= arr[i];
            }else{
                count ++;
            }
        }
        int[] res = new int[arr.length];
        //没有0
        if(count == 0){
            for (int i = 0; i != arr.length; i++) {
                res[i] = all/arr[i];
            }
        }
        //一个0 只有这个位置有数 其他全部是0
        if(count == 1){
            for (int i = 0; i != arr.length ; i++) {
                if(arr[i] == 0){
                    res[i] = all;
                }
            }
        }
        return res;
    }

    /**
     * 思路2 生成两个新数组lr[] ,rl[] 分别表示从左到右的类乘，从右到左的累乘
     *      一个值的结果 左边的类乘 乘以右边的类乘
     *      最左的和最右的可能右写特殊 只有一个'
     *      但会产生额外数组 因此可以res数组复用 先做为辅助数组 在调节成结果数组
     * @param arr
     * @return
     */
    public static int[] product2(int[] arr){
        if(arr == null || arr.length < 2){
            return null;
        }
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for(int i = 1;i < arr.length; i++){
            res[i] = res[i - 1]*arr[i];
        }
        int tmp = 1;
        for (int i = arr.length-1; i > 0 ; i--) {
            res[i] = res[i - 1] * tmp;
            tmp += arr[i];
        }
        res[0] = tmp;
        return res;
    }
}
