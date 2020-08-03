package matrixAndArray;

/**
 * 给定一个长度为N的整型数组arr，其中有N个互不相等的自然数1～N。
 * 请实现arr的排序，但是不要把下标0～N-1位置上的数通过直接赋值的方式替换成1～N
 */
public class Code_11_sort {
    /**
     * 方法一 1 从左到右遍历
     *        2 如果arr[i]== i+1 当前不需要调整
     *        3 ！= 的话 进行跳 跳到他应该在的位置 将原来位置的在进行跳
     * @param arr
     */
    public void sort1(int[] arr){
        int tmp = 0;
        int next = 0;
        for(int i=0; i!= arr.length; i++){
            tmp = arr[i];
            while(arr[i] != i+1 ){
                next = arr[tmp - 1];
                arr[tmp - 1] = tmp;
                tmp = next;
            }

        }
    }

    /**
     * 此时不进行跳 而是不想等则交换 若想等再向下一步
     * @param arr
     */
    public void sort2(int[] arr){
        int tmp = 0;
        for(int i = 0;i != arr.length; i++){
            while(arr[i] != i+1){
                tmp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = tmp;
            }
        }
    }

}
