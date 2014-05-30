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
        addAt(element, 0);
    }


    public void addLast(T element) {

        // check we've got head room
        if (last > (.75 * size) || (last >= (size - 1))) {
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
        if (last > (.75 * size) || (last >= (size - 1))) {
            growList();
        }

        for (int i = last ; i >= n ; i--) {
            list[i+1] = list[i];
        }
        list[n] = element;
        last++;

    }


    public T getLast() throws  ArrayIndexOutOfBoundsException {
        if (last == -1 ) throw new ArrayIndexOutOfBoundsException("List Empty");

        return list[last];
    }

    public T getFirst() throws  ArrayIndexOutOfBoundsException {
        if (last == -1) throw new ArrayIndexOutOfBoundsException("List Empty");

        return list[0];
    }

    public T getAt(int n) {
        if (n > last) throw new ArrayIndexOutOfBoundsException(n);

        return list[n];
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
