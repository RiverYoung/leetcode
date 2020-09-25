package com.riveryoung.leetcode.binarytree;

public class BinaryTreeDFSTest extends BinaryTreeTest{
    public static void main(String[] args){

        Integer[] iRoot = {3,9,20,null,null,15,7};
        TreeNode tRoot = BinaryTree.constructByLevelOrder(iRoot);
        Integer[] iRoot2 = {1,2,2,null,3,null,3};
        TreeNode tRoot2 = BinaryTree.constructByLevelOrder(iRoot2);
        Integer[] iRootBinarySearch = {3,1,4,null,2}; //二叉搜索树
        TreeNode tRootBinarySearch = BinaryTree.constructByLevelOrder(iRootBinarySearch);

        BinaryTreeBFS binaryTreeBFS = new BinaryTreeBFS();
        BinaryTreeDFS binaryTreeDFS = new BinaryTreeDFS();

        //前序遍历_使用递归
        binaryTreeDFS.preOrderTraversal(tRoot);
        System.out.println();

        //前序遍历_使用栈
        binaryTreeDFS.preOrderTraversal_stack(tRoot);
        System.out.println();

        //中序遍历_使用递归
        binaryTreeDFS.inOrderTraversal(tRoot);
        System.out.println();

        //中序遍历_使用栈
        binaryTreeDFS.inOrderTraversal_stack(tRoot);
        System.out.println();

        //后序遍历_使用递归
        binaryTreeDFS.postOrderTraversal(tRoot);
        System.out.println();

        //后序遍历_使用栈
        binaryTreeDFS.postOrderTraversal_stack(tRoot);
        System.out.println();

        //剑指 Offer 27. 二叉树的镜像
        TreeNode tRootMirror = binaryTreeDFS.mirrorTree(tRoot);
        printBinaryTreeResult(binaryTreeBFS.levelOrder(tRootMirror));

        //剑指 Offer 27. 二叉树的镜像（使用栈）
        TreeNode tRootMirrorStack = binaryTreeDFS.mirrorTree_stack(tRoot);
        printBinaryTreeResult(binaryTreeBFS.levelOrder(tRootMirrorStack));

        //剑指 Offer 28. 对称的二叉树
        boolean bIsSymmetric = binaryTreeDFS.isSymmetric(tRoot2);
        System.out.println("bIsSymmetric = " + bIsSymmetric);

        boolean bIsSymmetricRecursive = binaryTreeDFS.isSymmetricRecursive(tRoot2);
        System.out.println("bIsSymmetricRecursive = " + bIsSymmetricRecursive);

        //剑指 Offer 55 - I. 二叉树的深度
        int depth = binaryTreeDFS.maxDepth(tRoot2);
        System.out.println("depth = " + depth);

        //剑指 Offer 54. 二叉搜索树的第 k 大节点
        int kthLargest = binaryTreeDFS.kthLargest(tRootBinarySearch, 4);
        System.out.println("kthLargest = " + kthLargest);

        TreeNode tMergeTree = binaryTreeDFS.mergeTrees(tRoot2, tRootBinarySearch);
        printBinaryTreeResult(binaryTreeBFS.levelOrder(tMergeTree));
    }
}
