package matrixAndArray;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 数组 打印其中出现次数大于一半的数
 *进阶问题 判断是否出现 N/k以上的数
 *  可用hashMap循环判断每一个出现的次数 但空间复杂度不满足要求
 *  因此可以一次在数组中删除两个不同的数 不停删除直到剩下一种
 */
public class Code_05_printHalfMajor {
    public void printHalfMajor(int[] arr){
        int cand = 0;
        int times = 0;
        /**
         * 解题的关键 cand叫作候选 times叫次数
         * times=0 此时没有候选 选现在的数当作候选 times变为 1
         * times！=0 时，若相等 times加一 不相等减一说明抵消了一个 有两个不同的数
         */
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
        /**
         * 可能序列为 1 2 3 没有出现一半以上的 但由于最后一个剩下来 因此进行判断
         */
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

    /**
     * 进阶的做法 遍历到arr[i]看是否与某个候选相同 如果相同就将候选的点数加一
     *  若不同 看候选是否满了 不满就作为一个新候选
     *          满了 把所有点数全部减一 若某点数为0则删除为0的候选
     * @param arr
     * @param k
     */
    public void printKMajor(int[] arr,int k){
        if(k<2){
            System.out.println("the value of k is invalid");
            return;
        }
        HashMap<Integer,Integer> cands = new HashMap<>();
        for(int i = 0; i !=arr.length; i++){
            if(cands.containsKey(arr[i])){
                cands.put(arr[i], cands.get(arr[i]) + 1);
            }else{
                if (cands.size() == k - 1){
                    allCandsMinusOne(cands);
                }else{
                    cands.put(arr[i], 1);
                }
            }
        }
        HashMap<Integer, Integer> reals = getReals(arr, cands);
        boolean hasPrint = false;
        for(Map.Entry<Integer,Integer> set : cands.entrySet()){
            Integer key = set.getKey();
            if(reals.get(key) > arr.length /k){
                hasPrint = true;
                System.out.println(key+" ");
            }
        }
        System.out.println(hasPrint?"":"no");
    }


    private void allCandsMinusOne(HashMap<Integer, Integer> map) {
        List<Integer> removeList = new LinkedList<>();
        for(Map.Entry<Integer, Integer> set : map.entrySet()){
            Integer key = set.getKey();
            Integer value = set.getValue();
            if(value == 1){
                removeList.add(key);
            }
            map.put(key,value - 1);
        }
        for(Integer removeKey : removeList){
            map.remove(removeKey);
        }
    }

    private HashMap<Integer, Integer> getReals(int[] arr, HashMap<Integer, Integer> cands) {
    HashMap<Integer,Integer> reals = new HashMap<>();
    for(int i =0;i != arr.length; i++){
        int curNum = arr[i];
        if(cands.containsKey(curNum)){
            if(reals.containsKey(curNum)){
                reals.put(curNum,reals.get(curNum) + 1);
            }else{
                reals.put(curNum,1);
            }
        }
    }
    return reals;
    }

}
