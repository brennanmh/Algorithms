package org.nthroot.structure;

/**
 * Created by brennan on 5/30/14.
 */
public class LinkedList<T> {

    private int size = 10;
    private T[] list;

    private int last = -1;

    public LinkedList() {
        initList(0);
    }

    public LinkedList(int initSize) {
        initList(initSize);
    }


    public void addFirst(T element) {

        // check we've got head room
        if (last > (.75 * size)) {
            growList();
        }

        // adjust everything right
        for (int i = last ; i >= 0 ; i--) {
            list[i+i] = list[i];
        }
        list[0] = element;
    }


    public void addLast(T element) {

        // check we've got head room
        if (last > (.75 * size)) {
            growList();
        }

        list[++last] = element;

    }


    public void addAt(T element, int n) throws ArrayIndexOutOfBoundsException {

        // check it's within the valid range
        // we aren't adding elements way after the current
        // last. This is a LINKED list, after all.
        if (n > last) {
            throw new ArrayIndexOutOfBoundsException(n);
        }

        // check we've got head room
        if (last > (.75 * size)) {
            growList();
        }


    }


    private void initList(int initSize) {
        if (initSize > 0) {
            size = initSize;
        }
        list = (T[]) new Object[size];
    }


    private void growList() {

        size = size * 2;
        T[] newList = (T[]) new Object[size];

        for (int i = 0 ; i <= last ; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }


    private void shrinkList() {

        // one last check
        if (last > (size / 2)) return;

        size = size / 2;
        T[] newList = (T[]) new Object[size];

        for (int i = 0 ; i <= last ; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }



}
