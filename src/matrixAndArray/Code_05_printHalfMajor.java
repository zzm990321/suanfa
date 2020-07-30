package matrixAndArray;

/**
 * 数组 打印其中出现次数大于一半的数
 *
 * 思路 一次在数组中删除两个不同的数 不停删除直到剩下一种
 */
public class Code_05_printHalfMajor {
    public void printHalfMajor(int[] arr){
        int cand = 0;
        int times = 0;
        for(int i = 0;i!=arr.length;i++){
            if(times == 0){
                cand = arr[i];
                times = 1;
            }else if(arr[i] == cand){
                times ++;
            }else{
                times -- ;
            }
        }
        times = 0;
        for(int i =0;i !=arr.length;i++){
            if(arr[i] == cand){
                times ++;
            }
        }
        if(times > arr.length /2){
            System.out.println(cand);
        }else{
            System.out.println("no");
        }
    }
}
