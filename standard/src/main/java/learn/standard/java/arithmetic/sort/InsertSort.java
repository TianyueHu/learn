package learn.standard.java.arithmetic.sort;

import java.util.Arrays;

public class InsertSort {

    public static void insertSort(int[] array){

        if(array != null && array.length > 1){
            for(int i = 0; i < array.length - 1; ++i){
                for(int j = i + 1; j > 0; --j){
                    if(array[j] < array[j - 1]){
                        swap(array, j, j - 1);
                    }
                }
            }
        }
    }
    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static void main(String[] args){
        int n = 100;

        int[] array = new int[n];

        for(int i = 0; i < n; ++i){
            array[i] = (int)(Math.random() * 100);
        }
        System.out.println(Arrays.toString(array));

        InsertSort.insertSort(array);

        System.out.println(Arrays.toString(array));
        for(int i = 1; i < n; ++i){
            if(array[i] < array[i-1]){
                System.out.println("error");
            }
        }
    }
}
