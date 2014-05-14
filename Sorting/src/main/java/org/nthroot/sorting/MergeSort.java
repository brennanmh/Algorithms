

package org.nthroot.sorting;


public class MergeSort {

  public static void printArr(int[] arr) {
    System.out.print("|");
    for (int i = 0 ; i < arr.length ; i++) {
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
    for (int i = 0 ; i < arr.length / 2 ; i++) {
      larr[i] = arr[i];
    }

    // create right array
    int rarrSize = arr.length / 2;
    if (arr.length % 2 == 1) {
      // handle odd number of elements
      rarrSize = (arr.length / 2) + 1;
    }

    int[] rarr = new int[rarrSize];

    for (int i = 0 ; i < rarrSize ; i++) {
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

    for (int i = 0 ; i < (arr.length-1) ; i++) {
      if (arr[i] > arr[i+1]) {
        isSorted = false;
        break;
      }
    }

    return isSorted;

  }

}
