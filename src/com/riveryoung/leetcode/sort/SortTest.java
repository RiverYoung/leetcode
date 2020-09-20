package com.riveryoung.leetcode.sort;

public class SortTest {
    public static void main(String[] args) {

        int[] numBeforeSort = {2,3,1,0,2,5,3};
        Sort sort = new Sort();

        //bubble sort test
        sort.bubbleSort(numBeforeSort);
        System.out.println("\nAfter bubble sort : " );
        printArrAfterSort(numBeforeSort);

        //select sort test
        sort.selectSort(numBeforeSort);
        System.out.println("\nAfter select sort : " );
        printArrAfterSort(numBeforeSort);

        //insert sort test
        sort.insertSort(numBeforeSort);
        System.out.println("\nAfter insert sort : " );
        printArrAfterSort(numBeforeSort);

        //shell sort test
        sort.shellSort(numBeforeSort);
        System.out.println("\nAfter shell sort : " );
        printArrAfterSort(numBeforeSort);

        //quick sort test
        sort.quickSort(numBeforeSort, 0, numBeforeSort.length - 1);
        System.out.println("\nAfter quick sort : " );
        printArrAfterSort(numBeforeSort);

        //merge sort test
        sort.mergeSort(numBeforeSort);
        System.out.println("\nAfter mergeSort sort : " );
        printArrAfterSort(numBeforeSort);
    }

    public static void printArrAfterSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
