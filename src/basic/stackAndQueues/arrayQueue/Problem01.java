package basic.stackAndQueues.arrayQueue;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历
 */
public class Problem01 {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }

        ArrayQueue<Pair<TreeNode,Integer>> queue = new ArrayQueue<>();
        queue.enqueue(new Pair<TreeNode,Integer>(root,0));

        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> front = queue.dequeue();
            TreeNode node = front.getKey();
            int level = front.getValue();

            if (level == res.size()) {
                res.add(new ArrayList<Integer>());
            }
            assert level < res.size();

            res.get(level).add(node.val);
            if (node.left != null) {
                queue.enqueue(new Pair<TreeNode, Integer>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.enqueue(new Pair<TreeNode, Integer>(node.right, level + 1));
            }
        }
            return res;
        }
    }

