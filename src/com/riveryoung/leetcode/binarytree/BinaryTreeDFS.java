package com.riveryoung.leetcode.binarytree;

import java.util.Stack;

public class BinaryTreeDFS {

    /**
     *  前序遍历：先根节点，再左子树，最后右子树（递归）
     * */
    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     *  前序遍历：先根节点，再左子树，最后右子树（使用栈）
     * */
    public void preOrderTraversal_stack(TreeNode root) {
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.pop();
                cur = temp.right;
            }
        }
    }

    /**
     *  中序遍历：先左子树，再根节点，最后右子树（递归）
     * */
    public void inOrderTraversal(TreeNode root) {
        if (root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    /**
     *  中序遍历：先左子树，再根节点，最后右子树（使用栈）
     * */
    public void inOrderTraversal_stack(TreeNode root) {
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.pop();
                System.out.print(temp.val + " ");
                cur = temp.right;
            }
        }
    }

    /**
     *  后序遍历：先左子树，再右子树，最后根节点（递归）
     * */
    public void postOrderTraversal(TreeNode root) {
        if (root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    /**
     *  后序遍历：先左子树，再右子树，最后根节点（使用栈）
     * */
    public void postOrderTraversal_stack(TreeNode root) {
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        TreeNode prev = null;
        while (!stack.isEmpty()){
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (prev != null && (prev == cur.left || prev == cur.right))){
                System.out.print(cur.val + " ");
                stack.pop();
                prev = cur;
            }else{
                if (cur.right != null){
                    stack.push(cur.right);
                }
                if (cur.left != null){
                    stack.push(cur.left);
                }
            }
        }
    }

    /**
     *  剑指 Offer 27. 二叉树的镜像
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * 例如输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * 示例 1：
     *
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     *
     * */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode res = new TreeNode(root.val);
        res.left = mirrorTree(root.right);
        res.right = mirrorTree(root.left);
        return res;
    }

    /**
     *  剑指 Offer 27. 二叉树的镜像（使用栈）
     * */
    public TreeNode mirrorTree_stack(TreeNode root){
        if (root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur.left != null){
                stack.push(cur.left);
            }
            if (cur.right != null){
                stack.push(cur.right);
            }
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
        }
        return root;
    }

    /**
     *  剑指 Offer 28. 对称的二叉树
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     *
     * 示例 2：
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     * */
    public boolean isSymmetric(TreeNode root) {
        TreeNode mirrorTree = mirrorTree(root);
        return isSameTree(root, mirrorTree);
    }

    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null){
            return true;
        }else if ((t1 != null && t2 == null) || (t1 == null && t2 != null)){
            return false;
        }else{
            if (t1.val == t2.val){
                return (isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right));
            }else{
                return false;
            }
        }
    }

    /**
     *  剑指 Offer 28. 对称的二叉树（递归）
     * */
    public boolean isSymmetricRecursive(TreeNode root){
        return isMirrored(root, root);
    }
    public boolean isMirrored(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null){
            return true;
        }
        else if ((t1 != null && t2 == null) || (t1 == null && t2 != null)){
            return false;
        }
        else{
            if (t1.val == t2.val){
                return (isMirrored(t1.left, t2.right) && isMirrored(t1.right, t2.left));
            }else{
                return false;
            }
        }
    }

    /**
     * 剑指 Offer 55 - I. 二叉树的深度
     * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     * */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 剑指 Offer 54. 二叉搜索树的第 k 大节点
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     *
     * 示例 1:
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 4
     *
     * 示例 2:
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 4
     *
     * 限制：
     *
     * 1 ≤ k ≤ 二叉搜索树元素个数
     * */
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        int i = 0;
        while (i < k && (cur != null || !stack.isEmpty())){
            if (cur != null){
                stack.push(cur);
                cur = cur.right;
            }else{
                i++;
                TreeNode temp = stack.pop();
                if (i == k){
                    return temp.val;
                }
                cur = temp.left;
            }
        }
        return -1;
    }

    /**
    *617. 合并二叉树
    * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
    *
    * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
    *
    * 示例 1:
    *
    * 输入:
    * 	Tree 1                     Tree 2
    *           1                         2
    *          / \                       / \
    *         3   2                     1   3
    *        /                           \   \
    *       5                             4   7
    * 输出:
    * 合并后的树:
    * 	     3
    * 	    / \
    * 	   4   5
    * 	  / \   \
    * 	 5   4   7
    * 注意: 合并必须从两个树的根节点开始。
    * */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        TreeNode temp = new TreeNode(t1.val + t2.val);
        temp.left = mergeTrees(t1.left, t2.left);
        temp.right = mergeTrees(t1.right, t2.right);
        return temp;
    }
}
