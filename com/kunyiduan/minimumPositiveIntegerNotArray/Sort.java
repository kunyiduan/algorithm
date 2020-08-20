package com.kunyiduan.minimumPositiveIntegerNotArray;

import java.util.Arrays;

/**
 * @author achilles
 * @version 1.0.0
 * @Description 快速排序-单边循环
 * @createTime 2020/08/20 09:39:00
 */
public class Sort {
    private int[] param;

    public Sort(int[] param) {
        this.param = param;
    }

    public void setParam(int[] param) {
        this.param = param;
    }

    private void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }
        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int temp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = temp;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public int[] getResult() {
        quickSort(param, 0, param.length - 1);
        return param;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 3, 2};
        int[] results = new Sort(arr).getResult();
        Arrays.stream(results).forEach(x -> System.out.print(x + " "));
    }
}
