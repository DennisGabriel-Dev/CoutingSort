package couting_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 7, 4, 7, 1, 2, 3};
        arr = countingSort(arr);
        System.out.println("Array ordenado: " + Arrays.toString(arr));
    }


    public static int[] countingSort(int[] array) {
        int A[] = array;
        int k = Arrays.stream(A).max().getAsInt();
     
        int C[] = new int[k];
        int B[] = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            C[A[i] - 1] += 1;
        }

        for (int i = 1; i < C.length; i++) {
            C[i] += C[i - 1];
        }

        for (int i = A.length - 1; i >= 0; i--) {
            B[C[A[i] - 1] - 1] = A[i];
            C[A[i] - 1]-= 1;
        }



        return B;
    }
}