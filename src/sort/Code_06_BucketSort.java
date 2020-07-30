package sort;

public class Code_06_BucketSort {
    /**
     * 桶排序
     * @param arr
     */
    public static void bucketSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int max = Integer.MIN_VALUE;
        //统计出最大的数是多少用来生成桶
        for(int i = 0; i< arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        int[] bucket = new int[max+1];
        //将数组中的每个数放入桶中
        for(int i = 0;i < arr.length; i++){
            bucket[arr[i]]++;
        }
        int i = 0;
        //将桶中的数字取出来放入数组
        for(int j=0;j<bucket.length;j++){
            while (bucket[j]-- > 0){
                arr[i++] = j;
            }
        }
    }
}
