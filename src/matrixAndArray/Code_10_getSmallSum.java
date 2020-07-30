package matrixAndArray;

/**
 * 数组小和的定义如下：例如，数组s=[1，3，5，2，4，6]，在s[0]的左边小于或等于s[0]的数的和为0；
 * 在s[1]的左边小于或等于s[1]的数的和为1；
 * 在s[2]的左边小于或等于s[2]的数的和为1+3=4；
 * 在s[3]的左边小于或等于s[3]的数的和为1；
 * 在s[4]的左边小于或等于s[4]的数的和为1+3+2=6；
 * 在s[5]的左边小于或等于s[5]的数的和为1+3+5+2+4=15。
 * 所以s的小和为0+1+4+1+6+15=27。给定一个数组s，实现函数返回s的小和。
 */
public class Code_10_getSmallSum {
    /**
     * 本题使用归并排序
     * @param arr
     * @return
     */
    public int getSmallSum(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        return func(arr,0,arr.length-1);
    }
}
