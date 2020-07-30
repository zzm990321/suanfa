package sort;




import static utils.Swap.swap;

public class Code_01_InsertionSort {
    /**
     * 插入排序
     * 通过将数字插入到已经排好序的数组中
     * 首先只有一个 进行插入 从第一个循环选中的数向前比较 若不是适合的位置则进行调整 否则直接开始下一次循环 直到全部有序
     * @param arr
     */
    public static void insertionSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        for(int i =0;i<arr.length;i++){
            //从最后一个数与前面的数进行比较，若小的便进行交换一直向前插入直到不满足条件或者没有数字便开始下一次插入
            for(int j=i-1;j>=0&&arr[j]>arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }
    }
}
