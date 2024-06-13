package org.example;

public class SortMain {
    public static void main(String[] args) {
        Integer[] arr = {59,54,80, 27, 41, 61, 90, 55, 37, 25};
        BubbleSort bs = new BubbleSort();
        InsertionSort is = new InsertionSort();
        SelectionSort ss = new SelectionSort();
        QuickSort qs = new QuickSort();

        qs.sort(arr);
        qs.printArr(arr);

        ss.sort(arr);
        ss.printArr(arr);

        bs.sort(arr);
        bs.printArr(arr);


    }
}
