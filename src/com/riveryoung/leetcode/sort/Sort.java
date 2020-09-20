package com.riveryoung.leetcode.sort;

/**
 *  常见的排序算法：
 *      Bubble sort、Select sort、insert sort、shell sort、Quick sort、Merge Sort
 *
 * @author www.riveryoung.cn
 * @since  2020-9-21 00:44:58
 * */
public class Sort {

    /**
     *  Bubble sort
     **/
    public void bubbleSort(int[] arr) {
        int len = arr.length;
        int temp = 0;
        for (int i = 0; i < len - 1; i++){
            for (int j = 0; j < len - 1 - i; j++){
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     *  Select sort
     * */
    public void selectSort(int[] arr) {
        int len = arr.length;
        int minIndex = 0;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            minIndex = i;
            for (int j = i; j < len; j++) {
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     *  insert sort
     * */
    public void insertSort(int[] arr) {
        int len = arr.length;
        int preIndex = 0;
        int cur = 0;
        for (int i = 1; i < len; i++){
            preIndex = i - 1;
            cur = arr[i];
            while (preIndex >= 0 && cur < arr[preIndex]){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = cur;
        }
    }

    /**
     *  shell sort
     * */
    public void shellSort(int[] arr) {
        int len = arr.length;
        for (int step = len / 2; step > 0; step = step / 2) {
            for (int i = step; i < len; i++) {
                int preIndex = i - step;
                while (preIndex >= 0 && arr[preIndex] > arr[i]) {
                    arr[preIndex + step] = arr[preIndex];
                    preIndex -= step;
                }
                arr[preIndex + step] = arr[i];
            }
        }
    }

    /**
     *  Quick sort
     * */
    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int temp = arr[left];
            int L = left;
            int R = right;
            while (left < right) {
                while (left < right && temp <= arr[right]) {
                    right--;
                }
                if(left < right) {
                    arr[left] = arr[right];
                    left++;
                }
                while (left < right && arr[left] < temp) {
                    left++;
                }
                if (left < right) {
                    arr[right] = arr[left];
                    right--;
                }
            }
            arr[left] = temp;
            quickSort(arr, L, left - 1);
            quickSort(arr, left + 1, R);
        }
    }

    /**
     *   Merge Sort
     * */
    public void mergeSort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1,right,temp);
            MergeArrays(arr, left, mid, right, temp);
        }
    }

    private void MergeArrays(int[] arr, int left, int mid, int right, int[] temp){
        int firstLeft = left;
        int firstRight = mid;
        int secondLeft = mid + 1;
        int secondRight = right;
        int k = 0;
        while(firstLeft <= firstRight && secondLeft <= secondRight){
            if (arr[firstLeft] < arr[secondLeft]){
                temp[k++] = arr[firstLeft++];
            }else{
                temp[k++] = arr[secondLeft++];
            }
        }
        while(firstLeft <= firstRight){
            temp[k++] = arr[firstLeft++];
        }
        while(secondLeft <= secondRight){
            temp[k++] = arr[secondLeft++];
        }
        for (int i = 0; i < k; i++){
            arr[left + i] = temp[i];
        }
    }
}
