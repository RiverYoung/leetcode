package com.riveryoung.leetcode.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTree {

    /**
     *  按层序遍历构建二叉树
     * */
    public static final TreeNode constructByLevelOrder(Integer[] root) {
        int len = root.length;
        if(len == 0) {
            return null;
        }
        TreeNode result = new TreeNode(root[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(result);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (i < len && root[i] != null){
                TreeNode node = new TreeNode(root[i]);
                cur.left = node;
                queue.add(cur.left);
            }
            i++;
            if (i < len && root[i] != null){
                TreeNode node = new TreeNode(root[i]);
                cur.right = node;
                queue.add(cur.right);
            }
            i++;
        }

        return result;
    }
    /**
     * 缓存中序遍历数组每个值对应的索引
     */
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        for (int i = 0; i < in.length; i++){
            indexForInOrders.put(in[i], i);
        }

        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int [] pre, int preL, int preR, int inL){
        if (preL > preR){
            return null;
        }

        TreeNode root = new TreeNode(pre[preL]);

        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;

        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}


