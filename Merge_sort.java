/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package merge_sort;
 import java.util.Arrays;

public class Merge_sort {
    public static void main(String[] args) {
        int[] arr = {14, 7, 3, 12}; // Initial array
        System.out.println("Original array: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1); // Call merge sort

        System.out.println("Sorted array: " + Arrays.toString(arr)); // Print sorted array
    }
    // Merge Sort function (recursive)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) { // Base condition
            int mid = left + (right - left) / 2; // Find the middle index

            // Recursively divide the array into two halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves
            merge(arr, left, mid, right);
        }
    }
    // Merge function to combine two sorted halves
    public static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of left and right subarrays
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // Create temporary arrays
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        // Copy data to temporary arrays
        for (int i = 0; i < leftSize; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // Merge the two arrays back into the original array
        int i = 0, j = 0, k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArr[]
        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArr[]
        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
