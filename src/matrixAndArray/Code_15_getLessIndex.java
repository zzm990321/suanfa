package matrixAndArray;

/**
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等。
 * 写一个函数，只需返回arr中任意一个局部最小出现的位置即可
 */
public class Code_15_getLessIndex {
    /**
     * 用了二分查找的思想 虽然不是有序数组 但只要两侧肯定有想要的内容便可以使用
     * @param arr
     * @return
     */
    public int getLessIndex(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        if(arr.length == 1|| arr[0] < arr[1]){
            return 0;
        }
        if(arr[arr.length - 1] < arr[arr.length - 2]){
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while(left < right){
            mid = (left + right) / 2;

             //说明左面一定出现
            if(arr[mid] > arr[mid - 1]){
                right = mid - 1;
            }else if(arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return left;
    }
}
