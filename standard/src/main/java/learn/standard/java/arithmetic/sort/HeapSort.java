package learn.standard.java.arithmetic.sort;

import java.util.Arrays;

public class HeapSort {


    public static void heapSort(int[] array){
        if(array != null && array.length > 1){
            int len  = array.length;
            int[] heap = Arrays.copyOf(array, len);

            for(int i = len / 2 - 1; i >= 0; --i){
                pushDown(heap, i, len - 1);
            }

            for(int i = 0; i < len; ++i){
                array[i] = heap[0];
                heap[0] = heap[len - 1 - i];
                pushDown(heap, 0, len - 2 - i);
            }

        }
    }

    private static void pushDown(int[] array, int root, int maxLeaf){
        int index = root;
        while(index * 2 + 1 <= maxLeaf){
            //0代表不换，1代表和左孩子换，2代表和右孩子换
            int changeStatus = 0;

            if(array[index * 2 + 1] < array[index]){
                changeStatus = 1;
            }
            if(index * 2 + 2 <= maxLeaf){
                changeStatus = (changeStatus == 1
                        ? (array[index * 2 + 2] < array[index * 2 + 1] ? 2 : 1 )
                        : (array[index * 2 + 2] < array[index] ? 2 : 0));

            }
            if(changeStatus == 1){
                swap(array, index,index * 2 + 1);
                index = index * 2 + 1;
            }
            else if(changeStatus == 2){
                swap(array, index, index * 2 + 2);
                index = index * 2 + 2;
            }
            else{
                break;
            }
        }
    }

    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static void main(String[] args){
        int n = 1000;

        int[] array = new int[n];

        for(int i = 0; i < n; ++i){
            array[i] = (int)(Math.random() * 100);
        }
        System.out.println(Arrays.toString(array));

        HeapSort.heapSort(array);

        System.out.println(Arrays.toString(array));
        for(int i = 1; i < n; ++i){
            if(array[i] < array[i-1]){
                System.out.println("error");
                break;
            }
        }
    }

}
