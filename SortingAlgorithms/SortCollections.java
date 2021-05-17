package DSA.SortingAlgorithms;

import java.util.Arrays;

public class SortCollections {
    void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void insertionSort(int[] A){
        for (int i = 1; i < A.length; i++) {
            int key = A[i];
            int j = i - 1;
            while (j >= 0 && key < A[j]){
                A[j + 1] = A[j];
                --j;
            }
            A[j + 1] = key;
        }
    }

    public void selectionSort(int[] A){
        for (int i = 0; i < A.length; i++) {
            int min_i = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[min_i] > A[j])
                    min_i = j;
            }
            int temp = A[i];
            A[i] = A[min_i];
            A[min_i] = temp;
        }
    }

    public void bubbleSort(int a[]){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    private void merge(int[] a, int l, int m, int r){
        int L[] = new int[m - l + 1];
        int R[] = new int[r - m];

        for (int i = 0; i < L.length; i++)
            L[i] = a[l + i];

        for (int i = 0; i < R.length; i++)
            R[i] = a[m + 1 + i];

        int i = 0, j = 0, k = l;
        while (i < L.length && j < R.length){
            if (L[i] <= R[j])
                a[k++] = L[i++];
            else
                a[k++] = R[j++];
        }
        while (i < L.length){
            a[k++] = L[i++];
        }
        while (j < R.length){
            a[k++] = R[j++];
        }
    }

    public void mergeSort(int[] a){
        mergeSort(a, 0, a.length - 1);
    }

    public void mergeSort(int[] a, int l, int r){
        if (l < r){
            int m = (l + r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);

            merge(a, l, m, r);
        }
    }

    void quickSort(int[] a){
        quickSort(a, 0, a.length - 1);
    }
    void quickSort(int[] a, int l, int r){
        if (l < r){
            int pi = partition(a, l, r);
            quickSort(a, l, pi - 1);
            quickSort(a, pi + 1, r);
        }
    }
    int partition(int[] a, int l, int r){
        int pivot = a[r]; // pivot = the right most element index
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (a[j] <= pivot){
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[r];
        a[r] = temp;

        return i + 1;
    }

    void countingSort(int array[], int place) {
        int size = array.length;
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;

        // Calculate cumulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }

        for (int i = 0; i < size; i++)
            array[i] = output[i];
    }

    int getMax(int[] a){
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }

    void radixSort(int[] a){
        int max = getMax(a);
        for (int i = 1; max / i > 0; i *= 10) {
            countingSort(a, i);
        }
    }

    void heapify(int[] a, int n, int i){
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && a[l] > a[largest])
            largest = l;
        if (r < n && a[r] > a[largest])
            largest = r;

        if (largest != i){
            swap(a, i, largest);
            heapify(a, n, largest);
        }
    }

    void heapSortArray(int[] a){
        for (int i = a.length / 2 - 1; i >= 0; i--)
            heapify(a, a.length, i);

        for (int i = a.length - 1; i >= 0; i--){
            swap(a, 0, i);
            heapify(a, i, 0);
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{7,5,4,4,3,1};
        new SortCollections().heapSortArray(a);
        System.out.println(Arrays.toString(a));
    }
}
