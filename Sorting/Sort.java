package Sorting;

public class Sort {
    public static void main(String[] arg) {
        int[] array = new int[] { 2, 5, 4, 1, 3, 8, 6, 7 };

        bubbleSort(array);
        selectionSort(array);
        insertionSort(array);

        quickSort(array, 0, array.length - 1);
        mergeSort(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void swap(int[] arr, int a, int b) {
        if (a != b) {
            arr[a] = arr[a] ^ arr[b];
            arr[b] = arr[a] ^ arr[b];
            arr[a] = arr[a] ^ arr[b];
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j])
                    swap(arr, j - 1, j);
            }
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            }
            if (minIdx != i)
                swap(arr, i, minIdx);
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]) {
                swap(arr, j-1, j);
                j--;
            }
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (end <= start) return; //base case;

        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++){
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, end);
        return i;
    }

    private static void mergeSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) return;

        int middle = length / 2;
        int[] leftArr = new int[middle];
        int[] rightArr = new int[length - middle];

        int j = 0;
        for (int i = 0; i < length; i++) {
            if (i < middle) 
                leftArr[i] = arr[i];
            else 
                rightArr[j++] = arr[i];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(leftArr, rightArr, arr);
    }

    private static void merge(int[] left, int[] right, int[] arr) {
        int leftSize = left.length;
        int rightSize = right.length;

        int i = 0, l = 0, r = 0;
        while (l < leftSize && r < rightSize) {
            if (left[l] <= right[r])
                arr[i++] = left[l++];
            else 
                arr[i++] = right[r++];
        }

        while (l < leftSize) {
            arr[i++] = left[l++];
        }

        while (r < rightSize) {
            arr[i++] = right[r++];
        }
    }
}
