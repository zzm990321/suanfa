package matrixAndArray;

/**
 * 给定排序数组arr和整数k，不重复打印arr中所有相加和为k的不降序二元组
 */
public class Code_08_printUniquePair {
    /**
     * 双指针进行判断 ·
     * 比较arr[left]+arr[right]的值（sum）与k的大小：●
     * 如果sum等于k，打印“arr[left]，arr[right]”，则left++，right--。●
     * 如果sum大于k，right--。● 如果sum小于k，left++。
     * 如果left＜right，则一直重复
     */
    public void printUniquePair(int[] arr,int k) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < k) {
                left++;
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                if (left == 0 || arr[left - 1] != arr[left]) {
                    System.out.println(arr[left] + "," + arr[right]);
                }
                left++;
                right--;
            }
        }
    }
    /**
     * 进阶问题 三元组 选定一个数进行for循环从前到后 剩下两个数按上面的方法
     */
    public void printUniqueTriad(int[] arr,int k){
        if(arr == null || arr.length < 3){
            return;
        }
        for(int i = 0; i < arr.length - 2; i++){
            if(i == 0|| arr[i] != arr[i-1]){
                printRest(arr,i,i+1,arr.length-1,k-arr[i]);
            }
        }
    }
    public void printRest(int[] arr,int f,int l , int r, int k){
        while(l < r){
            if(arr[l] + arr[r] < k){
                l++;
            }else if(arr[l] + arr[r] > k){
                r--;
            }else{
                if(l == f+1 || arr[l-1] != arr[l]){
                    System.out.println(arr[f] + ","+arr[l]+","+arr[r]);
                }
                l++;
                r--;
            }
        }
    }
}
