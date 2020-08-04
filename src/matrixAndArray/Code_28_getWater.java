package matrixAndArray;

/**
 * 容器装水
 */
public class Code_28_getWater {
    public int getWater1(int[] arr){
        if(arr == null || arr.length < 3){
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length-1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for(int l = 0;l < i;l++){
                leftMax = Math.max(arr[l],leftMax);
            }
            for(int r = i + 1; r < arr.length; r++){
                rightMax = Math.max(arr[r],rightMax);
            }
            res += Math.max(Math.min(leftMax,rightMax)-arr[i],0);
        }
        return res;
    }
}
