package com.riveryoung.leetcode.binarytree;

import java.util.*;

public class BinaryTreeBFSTest extends BinaryTreeTest{
    public static void main(String[] args){

        Integer[] iRoot = {3,9,20,null,null,15,7};
        TreeNode tRoot = BinaryTree.constructByLevelOrder(iRoot);

        //剑指 Offer 32 - I. 从上到下打印二叉树
        BinaryTreeBFS binaryTreeBFS = new BinaryTreeBFS();
        int[] result = binaryTreeBFS.levelOrder(tRoot);
        printBinaryTreeResult(result);

        //剑指 Offer 32 - II. 从上到下打印二叉树 II
        List<List<Integer>> listLevelOrderByLevel = binaryTreeBFS.levelOrderByLine(tRoot);
        printBinaryTreeResultE(listLevelOrderByLevel);

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

        //剑指 Offer 55 - I. 二叉树的深度
        int depth = binaryTreeBFS.maxDepth(tRoot);
        System.out.println("depth = " + depth);
    }
}


