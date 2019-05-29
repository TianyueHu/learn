package learn.standard.java.arithmetic.sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] array){
        if(array != null)
            sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end){
        if(start >= 0 && end < array.length && start < end){
            int part = partition(array, start, end);
            if(part != -1){
                sort(array, start, part - 1);
                sort(array, part + 1, end);
            }
        }
    }

    private static int partition(int[] array, int start, int end){

        if(start >= 0 && start < end){
            int keyIndex = start + (int)Math.round(Math.random() * (end - start));
            int key = array[keyIndex];
            int left = start, right = end;
            swap(array, keyIndex, left);
            while(left < right) {

                while (left < right && array[right] >= key) {
                    --right;
                }
                //如果这个循环发生碰撞，那么left位置的值已经放在上一循环的right位置
                array[left] = array[right];
                while (left < right && array[left] <= key) {
                    ++left;
                }
                //如果这个循环发生碰撞，那么right位置的值已经放在上一循环的最后的left位置
                array[right] = array[left];
            }
            array[left] = key;
            return left;
        }
        return -1;
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

        QuickSort.quickSort(array);

        System.out.println(Arrays.toString(array));
        for(int i = 1; i < n; ++i){
            if(array[i] < array[i-1]){
                System.out.println("error");
            }
        }
    }
}
