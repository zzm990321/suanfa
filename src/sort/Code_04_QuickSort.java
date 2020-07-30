package sort;

import static utils.Swap.swap;

/**
 * 快排
 */
public class Code_04_QuickSort {
    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
                return;
            }
        quickSort(arr,0,arr.length-1);
        }

    private static void quickSort(int[] arr, int l, int r) {
        if(l<r){
            //随机一个数变为分界点
            swap(arr,l+(int)(Math.random()*(r-l+1)),r);
            int[] p = partition(arr,l,r);
            //递归将前半段小于的数进行快排
            quickSort(arr,l,p[0]-1);
            //对大于的进行快排
            quickSort(arr,p[1]+1,r);
        }
    }

    /**
     * 此方法将arr[r]设为基准点，将数组分为两个部分，less左面的是已经判断小于基准，more之后的则为大于
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int[] partition(int[] arr, int l, int r) {
        //less指针设为第一个的前一个，使用l进行判断，r指针不变 作为基准点 最后进行交换
        int less = l-1 ;
        int more = r ;
        //两指针没有接触便继续
        while(l<more){
            if(arr[l]<arr[r]){
                //若l指针的数小于基准点 ，less右移，l右移
                swap(arr,++less,l++);
            }else if(arr[l]>arr[r]){
                //若大于 more指针左移，交换在与基准点比较 l不变 此时已变为more上一个数 继续比较即可
                swap(arr,--more,l);
            }else{
                //等于只移动l less不变
                l++;
            }
        }
        //将基准点移动到more指针所在位置
        swap(arr,more,r);
        //返回两个数 第一个指针前的都为小于基准点的数 more之后的都大于基准点 中间的便是想等的
        return new int[]{less+1,more};
    }

}
