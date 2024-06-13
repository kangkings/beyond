package org.example;

public class BubbleSort implements Sort {
    @Override
    public void sort(Integer[] arr) {
        Integer tmp = null;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]){
                    tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    @Override
    public void printArr(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
