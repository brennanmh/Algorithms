

package org.nthroot.sorting;


public class QuickSort extends SortBase
{
    // satisfy the interface
    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length);
    }

    private static void sort(Comparable[] a, int lo, int hi) {

        if (hi <= lo) return;

        int lt = lo;
        int i = lo + 1;
        int gt = hi;

        Comparable c = a[lo];

        while (i <= gt) {

            int cmp = a[i].compareTo(c);
            if (cmp < 0)
                exchange(a, lt++, i++);
            else if (cmp > 0)
                exchange(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

}
