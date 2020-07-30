package sort;

public class Code_07_RadixSort {
    /**
     * 基数排序 设计了两个辅助数组，一个是 count[]，一个是 bucket[]。count 用于记录在某个桶中的最后一个元素的下标，然后再把原数组中的元素计算一下它应该属于哪个“桶”，并修改相应位置的 count 值。直到最大数的最高位也被添加到桶中，或者说，当所有的元素都被被在第 0 个桶中，基数排序就结束了。
     * @param arr
     * 优化思路还有些不懂
     */
    public static void radixSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        radixSort(arr,0,arr.length-1,maxbits(arr));
    }

    /**
     * 求出数组中最大的数的位数
     * @param arr
     * @return
     */
    public static int maxbits(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        int res = 0;
        while(max != 0){
            res++;
            max /=10;
        }
        return res;
    }


    public static void radixSort(int[] arr,int begin,int end, int digit){
        final int radix = 10;
        int i =0,j=0;
        //十个桶子用来存放
        int[] count = new int[radix];
        //与数组个数相同的桶子
        int[] bucket = new int[end-begin+1];
        //循环执行最大数位数的次数
        for(int d =1 ;d<=digit;d++){
            //每次循环将桶里的数字先全部清0
            for(i = 0;i<radix;i++){
                count[i] = 0;
            }
            //根据求出的位数放入count桶子
            for(i = begin; i <= end; i++){
                j=getDigit(arr[i], d);
                count[j]++;
            }
            //将桶中的数字个数转化成各个桶中最后一个数字的下标索引
            for(i = 1; i < radix; i++){
                count[i] = count[i] + count[i-1];
            }

            // 将原数组中的数字分配给辅助数组 bucket
            for(i = end; i >= begin ; i--){
                j = getDigit(arr[i],d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }

            for(i = begin,j = 0;j <= end; i++,j++){
                arr[i] = bucket[j];
            }
        }
    }

    //根据循环次数判断当前位数的数字
    public static int getDigit(int x, int d){
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }
}
