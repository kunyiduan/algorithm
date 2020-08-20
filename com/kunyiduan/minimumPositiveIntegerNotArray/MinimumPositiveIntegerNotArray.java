package com.kunyiduan.minimumPositiveIntegerNotArray;

public class MinimumPositiveIntegerNotArray {

    private int getMinimumPositiveInteger(int[] arr) {
        if (arr[0] <= 0 || (arr[0] > 0 && arr[0] != 1)) {
            return 1;
        } else {
            int position = getPosition(arr);
            if (position == -1) {
                return arr[arr.length - 1] + 1;
            } else {
                return arr[position] + 1;
            }
        }
    }

    private int getPosition(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (!(arr[i] - arr[i - 1] == 0 || arr[i] - arr[i - 1] == 1)) {
                return i - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 3};
        int[] results = new Sort(arr).getResult();
        int minimumPositiveInteger = new MinimumPositiveIntegerNotArray().getMinimumPositiveInteger(results);
        System.out.println(minimumPositiveInteger);
    }
}
