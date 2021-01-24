package com.beauty.algorithm.tree;

import java.util.*;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2020/12/14 9:13
 * @since v0.1.0.0
 */

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        return dfs(root);

    }
    private List<List<Integer>> dfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // 边缘判断
        if (root == null) {
            return result;
        }

        int level = 1;
        Map<Integer,List<Integer>> cache = new HashMap<Integer,List<Integer>>();


        dfsTree(root,cache,level);

        for (Integer integer : cache.keySet()) {
            result.add(cache.get(integer));
        }


        return result;
    }

    private void dfsTree(TreeNode node,Map<Integer,List<Integer>> cache,int level){
        if (node == null) {
            return;
        }
        List<Integer> list;
        if (cache.containsKey(level)) {
            list = cache.get(level);
        } else {
            list = new ArrayList<>();
        }
        list.add(node.val);
        cache.put(level,list);
        ++level;

        dfsTree(node.left,cache,level);
        dfsTree(node.right,cache,level);

    }


    private List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // 边缘判断
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        while (!queue.isEmpty()){
            ArrayList<Integer> levelList = new ArrayList<>();
            final int size = queue.size();
            for (int i = 1; i <= size; i++) {
                final TreeNode node = queue.poll();
                assert node != null;
                levelList.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }

                if (node.right!=null){
                    queue.offer(node.right);
                }

            }
            result.add(levelList);

        }

        return result;
    }

    static List<List<Integer>> sPrint(TreeNode root){
        if (root == null){
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();

        Stack<TreeNode> stack0 = new Stack<TreeNode>();

        Stack<TreeNode> stack1 = new Stack<TreeNode>();

        stack1.push(root);

        int floor = 1;

        while (!stack1.isEmpty()||!stack0.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            if (floor%2==0&&!stack0.isEmpty()) {
                final int size = stack0.size();
                final TreeNode pop = stack0.pop();
                for (int i = 1; i <= size; i++) {

                    level.add(pop.val);

                    if (pop.left!=null){
                        stack1.push(pop.left);
                    }
                    if (pop.right!=null){
                        stack1.push(pop.right);
                    }
                }
            }
            if (floor%2==1&&!stack1.isEmpty()) {
                final int size = stack1.size();
                final TreeNode pop = stack1.pop();
                for (int i = 1; i <= size; i++) {
                    level.add(pop.val);

                    if (pop.right!=null){
                        stack0.push(pop.right);
                    }
                    if (pop.left!=null){
                        stack0.push(pop.left);
                    }
                }
            }
            floor++;
            result.add(level);
        }

        return result;

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(5);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(7);
        node.right.left = new TreeNode(8);
        node.right.right = new TreeNode(15);
        node.right.left.right = new TreeNode(9);
        node.right.right.right = new TreeNode(16);
        node.left.left.left = new TreeNode(3);
        node.left.left.right = new TreeNode(6);
//        sPrint(node).forEach(System.out::println);

        System.out.println(new LevelOrder().levelOrder(node).toString());

    }


}
