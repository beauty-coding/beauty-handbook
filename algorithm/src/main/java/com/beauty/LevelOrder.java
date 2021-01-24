package com.beauty;

import com.beauty.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/21 14:52
 * @since v0.1.0.0
 */
public class LevelOrder {

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public List<List<Integer>> bfs(TreeNode root) {

        if (root == null){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            List<Integer> level = new ArrayList<>();
            // 首先获取 当前队列的 长度  此时 只存放 当前层数据
            final int size = queue.size();
            for (int i = 0; i < size; i++) {

                final TreeNode node = queue.poll();
                level.add(node.getVal());

                // 此时加入队列的数据  已经超出了此 size 下一个循环
                if (node.getLeft() != null) {

                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null){
                    queue.offer(node.getRight());
                }
            }

            result.add(level);



        }


        return result;

    }
}
