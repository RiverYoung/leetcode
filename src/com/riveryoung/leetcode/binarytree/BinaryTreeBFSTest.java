package com.riveryoung.leetcode.binarytree;

import java.util.*;

public class BinaryTreeBFSTest {
    public static void main(String[] args){

        Integer[] iRoot = {3,9,20,null,null,15,7};
        TreeNode tRoot = BinaryTree.constructByLevelOrder(iRoot);

        //剑指 Offer 32 - I. 从上到下打印二叉树
        BinaryTreeBFS binaryTreeBFS = new BinaryTreeBFS();
        int[] result = binaryTreeBFS.levelOrder(tRoot);
        printBinaryTreeResult(result);

        //leetcode 199. 二叉树的右视图
        List<Integer> list = binaryTreeBFS.rightSideView(tRoot);
        printBinaryTreeResult(list);

        //leetcode 637. 二叉树的层平均值
        List<Double> listAverageOfLevers = binaryTreeBFS.averageOfLevels(tRoot);
        printBinaryTreeResultD(listAverageOfLevers);

        //leetcode 515. 在每个树行中找最大值
        List<Integer> listLargeValues = binaryTreeBFS.largestValues(tRoot);
        printBinaryTreeResult(listLargeValues);

        //leetcode 103. 二叉树的锯齿形层次遍历
        List<List<Integer>> listZigZagLevelOrder = binaryTreeBFS.zigzagLevelOrderB(tRoot);
        printBinaryTreeResultE(listZigZagLevelOrder);
    }

    private static void printBinaryTreeResult(int[] result){
        System.out.println("");
        System.out.print("[ ");
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println("]");
    }

    private static void printBinaryTreeResult(Double[] result){
        System.out.println("");
        System.out.print("[ ");
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println("]");
    }

    private static void printBinaryTreeResult(List<Integer> list){
        //转化List 为 int[]
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        printBinaryTreeResult(res);
    }

    private static void printBinaryTreeResultD(List<Double> list){
        //转化List 为 int[]
        Double[] res = new Double[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i).doubleValue();
        }
        printBinaryTreeResult(res);
    }

    private static void printBinaryTreeResultE(List<List<Integer>> list) {
        System.out.print("[");
        int len = list.size();
        for (int i = 0; i < len; i++){
            printBinaryTreeResult(list.get(i));
        }
        System.out.println("]");
    }
}

class BinaryTreeBFS{

    /**
     *  关键点： 层序遍历二叉树
     *  剑指 Offer 32 - I. 从上到下打印二叉树
     *  从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     *
     *  例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 返回：
     * [3,9,20,15,7]
     *
     * */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }

        //转化List 为 int[]
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     *  leetcode 199. 二叉树的右视图
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * 示例:
     *
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     * 解释:
     *
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     * */
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int iSize = queue.size();
            for (int i = 0; i < iSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
                if (i == iSize - 1){
                    list.add(cur.val);
                }
            }
        }
        return list;
    }

    /**
     * leetcode 637. 二叉树的层平均值
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     *
     *
     *
     * 示例 1：
     *
     * 输入：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 输出：[3, 14.5, 11]
     * 解释：
     * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
     *
     *
     * 提示：
     *
     * 节点值的范围在32位有符号整数范围内。
     * */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<Double>();
        if (root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            int iSize = queue.size();
            Double iSum = 0.0;
            for (int i = 0; i < iSize; i++){
                TreeNode cur = queue.poll();
                iSum += cur.val;
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
            list.add(iSum / iSize);
        }
        return list;
    }

    /**
     * leetcode 515. 在每个树行中找最大值
     * 您需要在二叉树的每一行中找到最大的值。
     *
     * 示例：
     *
     * 输入:
     *           1
     *          / \
     *         3   2
     *        / \   \
     *       5   3   9
     *
     * 输出: [1, 3, 9]
     * */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int iSize = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < iSize; i++){
                TreeNode cur = queue.poll();
                if (i == 0){
                    max = cur.val;
                }else{
                    max = Math.max(max, cur.val);
                }
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
            result.add(max);
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> oddList = new ArrayList<Integer>();
        List<Integer> evenList = new ArrayList<Integer>();
        Stack<Integer> evenStack = new Stack<Integer>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            oddList.clear();
            evenList.clear();
            evenStack.clear();
            int iSize = queue.size();
            level++;
            boolean bIsOddLevel = (level & 1) == 1;
            for (int i = 0; i < iSize; i++){
                TreeNode cur = queue.poll();
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
                if (bIsOddLevel){
                    oddList.add(Integer.valueOf(cur.val));
                }else{
                    evenStack.push(Integer.valueOf(cur.val));
                }
            }
            if (bIsOddLevel){
                result.add(oddList);
            }else{
                int iStackSize = evenStack.size();
                for (int i = 0; i < iStackSize; i++){
                    evenList.add(evenStack.pop());
                }
                result.add(evenList);
            }
        }
        return result;
    }

    /**
     * leetcode 103. 二叉树的锯齿形层次遍历
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层次遍历如下：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     * */
    public List<List<Integer>> zigzagLevelOrderB(TreeNode root) {
        if (root == null){
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            LinkedList<Integer> levelList = new LinkedList<Integer>();
            int iSize = queue.size();
            level++;
            boolean bIsOddLevel = (level & 1) == 1;
            for (int i = 0; i < iSize; i++){
                TreeNode cur = queue.poll();
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
                if (bIsOddLevel){
                    levelList.addLast(Integer.valueOf(cur.val));
                }else{
                    levelList.addFirst(Integer.valueOf(cur.val));
                }
            }
            result.add(levelList);
        }
        return result;
    }
}
