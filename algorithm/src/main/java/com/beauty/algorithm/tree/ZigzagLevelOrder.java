package com.beauty.algorithm.tree;

import com.beauty.algorithm.base.TreeNode;

import java.util.*;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/21 15:22
 * @since v0.1.0.0
 */
public class ZigzagLevelOrder {


    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()){

            Deque<Integer> levelList = new LinkedList<>();
            final boolean b = level % 2 == 0;

            for (int i = 0; i < queue.size(); i++) {
                final TreeNode node = queue.poll();

                final int val = node.getVal();
                if (b){
                    levelList.addFirst(val);

                }else {
                    levelList.addLast(val);
                }

                if (node.getLeft()!=null){
                    queue.offer(node.getLeft());
                }
                if (node.getRight()!=null){
                    queue.offer(node.getRight());
                }

            }
            result.add(new ArrayList<>(levelList));

            level++;

        }

        return result;


    }
}
