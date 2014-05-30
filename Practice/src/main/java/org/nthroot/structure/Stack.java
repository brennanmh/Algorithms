package org.nthroot.structure;

import java.lang.reflect.Array;

/**
 * Created by brennan on 5/30/14.
 */
public class Stack<T> {

    private int top = 0;
    private int size = 10;
    private T[] stack;

    public Stack() {
        initStack(0);
    }


    public Stack(int initSize) {
        initStack(initSize);
    }


    public void push(T newElement) {
        if (top > (.75 * size)) {
            growStack();
        }

        stack[++top] = newElement;
    }


    public T pop() {

        T element = stack[top--];

        if (top < (.25 * size)) {
            shrinkStack();
        }

        return element;
    }


    public String toString() {
        String outstr = "";
        for (int i = top ; i >= 0 ; i--) {
            outstr += String.format("%s\n", stack[i].toString());
        }

        return outstr;
    }


    public void printString() {
        String outstr = toString();
        System.out.println(outstr);
    }


    private void initStack(int initSize) {
        top = -1;
        if (initSize > 0) {
            size = initSize;
        }
        stack = (T[]) new Object[size];
    }


    private void shrinkStack() {

        size = size / 2;

        T[] newStack = (T[]) new Object[size];

        for (int i = 0 ; i <= top ; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }


    private void growStack() {

        size = size * 2;

        T[] newStack = (T[]) new Object[size];

        for (int i = 0 ; i <= top ; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;

    }


}
