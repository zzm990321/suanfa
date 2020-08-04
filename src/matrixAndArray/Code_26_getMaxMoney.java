package matrixAndArray;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定两个整数W和K，W代表你拥有的初始资金，K代表你最多可以做K个项目。
 * 再给定两个长度为N的正数数组costs[]和profits[]，代表一共有N个项目，
 * costs[i]和profits[i]分别表示第i号项目的启动资金与做完后的利润（注意是利润，如果一个项目启动资金为10，利润为4，代表该项目最终的收入为 14）。
 * 你不能并行只能串行地做项目，并且手里拥有的资金大于或等于某个项目的启动资金时，你才能做这个项目。
 * 该如何选择做项目，能让你最终的收益最大？返回最后能获得的最大资金。
 */
public class Code_26_getMaxMoney {
    /**
     * 项目类
     */
    public class Program {
        public int cost;
        public int profit;

        public Program(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public class CostMinComp implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
            return o1.cost - o2.cost;
        }
    }

    public class ProfitMaxComp implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o2.profit - o1.profit;
        }
    }

    public int getMaxMoney(int W, int K, int[] costs, int[] profits){
        if(W < 1 || K < 0 || costs == null
                ||profits == null || costs.length != profits.length){
            return W;
        }
        //项目花费小根堆
        PriorityQueue<Program> costMinHeap = new PriorityQueue<>(new CostMinComp());
        //项目利润大根堆
        PriorityQueue<Program> profitMaxHeap = new PriorityQueue<>(new ProfitMaxComp());
        //所有项目放进项目花费小根堆
        for(int i = 0;i < costs.length;i++){
            costMinHeap.add(new Program(costs[i],profits[i]));
        }
        //依次做k个项目
        for (int i = 1; i <= K; i++) {
            //当前资金为W 花费小根堆里所有小于等于W的项目都可以考虑
            while(!costMinHeap.isEmpty() && costMinHeap.peek().cost <= W){
                profitMaxHeap.add(costMinHeap.poll());
            }
            //如果当前可加入的为空 无法解锁任何项目
            if(profitMaxHeap.isEmpty()){
                return W;
            }
            //如果可以选最大的
            W += profitMaxHeap.poll().profit;
        }
        return W;
    }
}
