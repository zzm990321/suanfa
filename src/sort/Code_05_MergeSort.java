package sort;

/**
 * 归并排序
 */
public class Code_05_MergeSort {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if(l==r){
            return;
        }
        int mid = l + ((r-l) >> 1);
        //递归将每个数组分割成更小的分组
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        //分好后进行合并
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        //用来存放排序好的数组
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        //比较放入数组
        while(p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //还有剩下的
        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        //挪入原数组替代原来数据
        for(i = 0;i < help.length; i++){
            arr[l + i] = help[i];
        }
    }

}
