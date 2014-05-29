
package org.nthroot.sorting;


public class SortBase {


    // slow insertion sort
    // if you want better, override
    public static void sort(Comparable arr[]) {

        for (int i = 1 ; i < arr.length ; i++) {
            int j = i;
            while (j > 0 && lessThan(arr[j], arr[j-1])) {
                exchange(arr, j, j - 1);
                j--;
            }
        }
    }

    public static boolean isSorted(Comparable arr[]) {
        Boolean sorted = true;

        for (int i = 0 ; i < (arr.length - 1) ; i++) {
            if (lessThan(arr[i+i], arr[i])) {
                sorted = false;
                break;
            }
        }

        return sorted;

    }

    public static void printArr(Comparable[] arr) {
        System.out.print("|");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.format("%s|", arr[i].toString()));
        }
        System.out.println();
    }

    protected static boolean lessThan(Comparable x, Comparable y) {
        return (x.compareTo(y) < 0);
    }

    protected static void exchange(Comparable arr[], int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
