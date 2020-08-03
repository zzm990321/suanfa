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
     *
     * @param arr
     * @return
     */
    public int getSmallSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return func(arr, 0, arr.length - 1);
    }

    public int func(int[] s, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        //递归调用归并并求出其中的小和相加
        return func(s, l, mid) + func(s, mid + 1, r) + merge(s, l, mid, r);
    }

    public int merge(int[] s, int left, int mid, int right) {
        //h是排序后的数组
        int[] h = new int[right - left + 1];
        int h1 = 0;
        int i = left;
        int j = mid + 1;
        int smallSum = 0;
        while (i <= mid && j <= right) {
            if (s[i] <= s[j]) {
                //小和相加
                smallSum += s[i] * (right - j + 1);
                h[h1++] = s[i++];
            } else {
                h[h1++] = s[j++];
            }
        }
        //将剩下数组放进去
        for (; (j < right + 1) || (i < mid + 1); j++, i++) {
            h[h1++] = i > mid ? s[j] : s[i];
        }
        //排序好的数组放回去
        for (int k = 0; k != h.length; k++) {
            s[left++] = h[k];
        }
        return smallSum;

    }
}
