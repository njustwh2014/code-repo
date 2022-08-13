package com.code.wh.leetcode.question.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description:leetcode 34 二叉树中和为某一值的路径 https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @author: 王欢
 * @create: 2022/07/03 17:21
 **/
public class BinaryTreeTargetSumPathLc34 {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        // 参数校验
        if (null == root) {
            return resultList;
        }
        // 深度优先 当查询到叶子节点时计算当前路径和
        dfs(root, target, new ArrayList<>(), resultList);
        return resultList.stream().filter(Objects::nonNull).filter(list -> list.size() > 0).collect(Collectors.toList());
    }

    // 深度优先解法
    private static void dfs(TreeNode curNode, int target, List<Integer> curParentPath, List<List<Integer>> resultList) {
        if (null == curNode) {
            return;
        }
        curParentPath.add(curNode.val);
        target -= curNode.val;
        // 判断是否是叶子节点
        if (null == curNode.left && null == curNode.right) {
            // 遇到叶子节点, 计算curPath和
            if (0 == target) {
                resultList.add(cloneList(curParentPath));
            }
        } else {
            dfs(curNode.left, target, curParentPath, resultList);
            dfs(curNode.right, target, curParentPath, resultList);
        }
        curParentPath.remove(curParentPath.size() - 1);
    }

    private static List<Integer> cloneList(List<Integer> list) {
        if (list == null) {
            return null;
        }
        return new ArrayList<>(list);
    }

    private static int computeSum(List<Integer> curPath) {
        if (null == curPath) {
            return 0;
        }
        int sum = 0;
        for (Integer i : curPath) {
            sum += i;
        }
        return sum;
    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
