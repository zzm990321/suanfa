package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出一个数组中不包含另一个数组的所有数
 */
public class Code_10_GetAllNotInclued {
    public static List<Integer> GetAllNotIncluded(int[] A,int[] B){
        List<Integer> res = new ArrayList<>();
        //对B中的所有数做循环 利用二分法判断是否在另一个数组中 要求被判断数组为排好序的
        for(int i = 0; i < B.length; i++ ){
            int l = 0;
            int r = A.length - 1;
            boolean contains = false;
            while(l <= r){
                int mid =l + ((r - 1) >>1);
                if(A[mid] == B[i]){
                    contains = true;
                    break;
                }
                if(A[mid] > B[i]){
                    r = mid -1;
                }else{
                    l = mid + 1;
                }
            }
            if(!contains){
                res.add(B[i]);
            }
        }
        return res;
    }
}
