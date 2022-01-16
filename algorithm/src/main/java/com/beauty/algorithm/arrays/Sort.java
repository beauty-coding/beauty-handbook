package com.beauty.algorithm.arrays;


/**
 * description 排序算法
 *
 * @author yufengwen
 * @date 2022/1/11 6:38 下午
 */
public class Sort {

    public static void main(String[] args) {
        final int[] array = {10, 2, 4, 23, 6};
        sort(array);

        for (int i : array) {
            System.out.println(i);
        }
    }


    public static void sort(int[] array) {

        int length;
        if (array == null || (length = array.length) < 2) {
            return;
        }

        quickSort(array, 0, length - 1);


    }


    /**
     * 快速排序
     * @param array 数组
     * @param left 左边界
     * @param right 右边界
     */
    public static void quickSort(int[] array, int left, int right) {

        // 如果 全部排完 直接返回
        if (left > right) {
            return;
        }

        // 设定 指定值
        int basic = array[left];

        int i = left;
        int j = right;

        // 遍历未结束
        while (i < j) {

            // 找到右侧 比 标准位 小的位置
            while (array[j] >= basic && i < j) {
                j--;
            }
            // 找到右侧 比 标准位 大的位置
            while (array[i] <= basic && i < j) {
                i++;
            }

            // 将 右侧小于basic的值 和 左侧的 大于basic 的值 交换位置
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // 将基准位 放到中间
        array[left] = array[i];
        array[i] = basic;

        // 分治 分别 排序 基准位 两侧的 数据

        quickSort(array, left, i - 1);

        quickSort(array, i + 1, right);


    }


}
