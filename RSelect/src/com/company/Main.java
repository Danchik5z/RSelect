package com.company;

import java.util.Scanner;

public class Main {

    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        int[] in = {-12, 32, 23, 2, 0, 67 ,123, -121, 4, -3, -1};
        System.out.println("Исходный массив");
            for (int i = 0; i < in.length; i++) {
                System.out.print(in[i] + " ");
            }
        Scanner zxc = new Scanner(System.in);
        System.out.print(ANSI_GREEN +"\nВведите n-й по порядку элемент массива:");
        int n = zxc.nextInt();
            in[n - 1] = RandSelect(in, 0, 10, n - 1);
            System.out.print(n +"-й элемент массива: " + in[n - 1]);

    }
    public static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int sIndex = left;
        for (int i = left; i <= right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, sIndex, i);
                sIndex++;
            }
        }
        swap(arr, right, sIndex);
        return sIndex;
    }

    public static void swap(int[] arr, int leftI, int rightI) {
        int temp = arr[leftI];
        arr[leftI] = arr[rightI];
        arr[rightI] = temp;
    }

    public static int TakeRandElement(int left, int right) {
        right -= left;
        return (int) (Math.random() * ++right) + left;
    }
    public static int RandSelect(int[] arr, int left, int right, int k) {
        int pindex = TakeRandElement(left, right);
        pindex = partition(arr, left, right, pindex);
        if (k == pindex) return arr[pindex];
        else if (k > pindex) return RandSelect(arr, pindex + 1, right, k);
        else return RandSelect(arr, left, pindex - 1, k);
    }
}
