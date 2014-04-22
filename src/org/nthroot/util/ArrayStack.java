package org.nthroot.util;


public class ArrayStack<Item> {
    private Item[] theStack;
    private static int defaultSize = 1;
    private int numItems = 0;

    public ArrayStack(int initSize) {
        theStack = initStack(initSize);
    }

    public ArrayStack() {
        theStack = initStack(defaultSize);
    }

    public void push(Item item) {
        // first item special case
        if (numItems == 0) {
            theStack[0] = item;
            numItems++;
            return;
        }

        if (numItems > (theStack.length / 2)) {
            growStack();
        }

        theStack[numItems++] = item;
    }

    public Item pop() {
        if (numItems == 0) {
            // TODO: convert this to a StackUnderflowException later
            return null;
        }

        Item theTopItem = theStack[--numItems];

        if (numItems < (theStack.length / 2)) shrinkStack();

        return theTopItem;

    }

    public int getNumItems() {
        return numItems;
    }

    @SuppressWarnings("unchecked")
    private Item[] initStack(int initSize) {
        return ((Item[]) new Object[initSize]);
    }

    private void growStack() {
        // just make sure we are not here unecessarily
        if ((theStack.length / 2) > numItems) return; // no need to grow yet, bail

        Item[] newStack = initStack(theStack.length * 2);


        for (int i = 0 ; i < numItems ; i++) {
            newStack[i] = theStack[i];
        }

        theStack = newStack;

    }

    private void shrinkStack() {
        // just make sure we are not here stupidly
        if ((theStack.length / 2) < numItems) return; // if we shrink we won't have enough space, bail

        Item[] newStack = initStack(theStack.length / 2);

        for (int i = 0 ; i < numItems ; i++) {
            newStack[i] = theStack[i];
        }

        theStack = newStack;
    }

}
