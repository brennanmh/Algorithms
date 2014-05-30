
package org.nthroot.sorting;


public class MergeSort extends SortBase {


    /////////////////////////////////////////
    //
    // int array sort
    //
    /////////////////////////////////////////
    public static void printArr(int[] arr) {
        System.out.print("|");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.format("%d|", arr[i]));
        }
        System.out.println();
    }

    // with int arrays
    public static int[] sort(int[] arr) {

        //    System.out.println("Sorting");

        if (arr.length <= 1) {
            return arr;
        }

        // create left array
        int larrSize = arr.length / 2;
        int[] larr = new int[larrSize];
        for (int i = 0; i < arr.length / 2; i++) {
            larr[i] = arr[i];
        }

        // create right array
        int rarrSize = larrSize;
        if (arr.length % 2 == 1) {
            // handle odd number of elements
            rarrSize++;
        }

        int[] rarr = new int[rarrSize];

        for (int i = 0; i < rarrSize; i++) {
            rarr[i] = arr[larrSize + i];
        }


        int[] nlarr = sort(larr);
        int[] nrarr = sort(rarr);

        int[] result = merge(nlarr, nrarr);

        return result;

    }

    public static int[] merge(int[] larr, int[] rarr) {

    /*
    System.out.println("Merging");
    System.out.print("Left:  ");
    printArr(larr);
    System.out.print("Right: ");
    printArr(rarr);
    */

        int[] result = new int[larr.length + rarr.length];

        int l = 0;
        int r = 0;
        int i = 0;

        while (l < larr.length || r < rarr.length) {
            if (l < larr.length && r < rarr.length) {
                // both have remaining elements
                if (larr[l] <= rarr[r]) {
                    // choose left
                    result[i] = larr[l];
                    l++;
                } else {
                    // choose right
                    result[i] = rarr[r];
                    r++;
                }
            } else if (l < larr.length) {
                // choose left
                result[i] = larr[l];
                l++;
            } else if (r < rarr.length) {
                // choose right
                result[i] = rarr[r];
                r++;
            }
            i++;
        }

    /*
    System.out.print("Result: ");
    printArr(result);
    */

        return result;

    }


    public static boolean isSorted(int[] arr) {

        boolean isSorted = true;

        for (int i = 0; i < (arr.length - 1); i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }

        return isSorted;

    }


    ///////////////////////////////////////////////
    //
    // Comparable array sort
    //
    ///////////////////////////////////////////////
    /*
    public static Comparable[] sort(Comparable[] arr) {

        // exit condition
        if (arr.length <= 1) {
            return arr;
        }

        int lsize = arr.length / 2;
        int rsize = lsize;
        if (arr.length % 2 == 1) {
            // we're odd, give the extra to the right
            rsize++;
        }

        Comparable[] larr = new Comparable[lsize];
        for (int i = 0 ; i < lsize ; i++) {
            larr[i] = arr[i];
        }

        Comparable[] rarr = new Comparable[rsize];
        for (int i = 0 ; i < rsize ; i++) {
            rarr[i] = arr[lsize + i];
        }

        larr = sort(larr);
        rarr = sort(rarr);

        return(merge(larr, rarr));

    }

    public static Comparable[] merge(Comparable[] larr, Comparable[] rarr) {

        Comparable[] result = new Comparable[larr.length + rarr.length];

        int l = 0;
        int r = 0;
        int i = 0;

        while (l < larr.length || r < rarr.length) {
            if (l < larr.length && r < rarr.length) {
                // both have remaining entries
                if (larr[l].compareTo(rarr[r]) <= 0) {
                    // take left
                    result[i++] = larr[l++];
                } else {
                    // take right
                    result[i++] = rarr[r++];
                }
            } else if (l < larr.length) {
                // take left
                result[i++] = larr[l++];
            } else if (r < rarr.length) {
                // take right
                result[i++] = rarr[r++];
            }
        }

        return result;

    }
    */

}

// vim: set ft=java:ts=4:sw=4:expandtab:
