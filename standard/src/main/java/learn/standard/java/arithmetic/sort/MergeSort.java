package learn.standard.java.arithmetic.sort;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] array){
        if(array!=null && array.length > 1) {
            int[] copyArray = new int[array.length];
            sort(array, copyArray, 0, array.length - 1);
        }
    }

    public static void merge(int[] array, int[] copyArray, int start, int mid, int end){
        //[start, mid]
        //[mid + 1, end]
        int leftPtr = start, rightPtr = mid + 1;
        int copyPtr = start;
        while(leftPtr <= mid && rightPtr <= end){
            copyArray[copyPtr++] = array[leftPtr] < array[rightPtr] ? array[leftPtr++] : array[rightPtr++];
        }
        while(leftPtr <= mid){
            copyArray[copyPtr++] = array[leftPtr++];
        }
        while(rightPtr <= end){
            copyArray[copyPtr++] = array[rightPtr++];
        }
        for(int i = start; i <= end; ++i){
            array[i] = copyArray[i];
        }
    }

    public static void sort(int[] array, int[] copyArray, int start, int end){
        if(start >= 0 && start < end){
            int mid = (int)((start + end) / 2);
            sort(array, copyArray, start, mid);
            sort(array, copyArray, mid + 1, end);
            merge(array, copyArray, start, mid, end);
        }
    }

    public static void main(String[] args){
        int n = 100;

        int[] array = new int[n];

        for(int i = 0; i < n; ++i){
            array[i] = (int)(Math.random() * 100);
        }
        System.out.println(Arrays.toString(array));

        MergeSort.mergeSort(array);

        System.out.println(Arrays.toString(array));
        for(int i = 1; i < n; ++i){
            if(array[i] < array[i-1]){
                System.out.println("error");
                return;
            }
        }
    }
}
