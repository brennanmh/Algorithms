package org.nthroot.util;

/**
 * Created by brennan on 4/22/14.
 */
public class LLStack <Item> {

    private Node top = null;
    private int numItems = 0;

    private class Node {
        Item item;
        Node next;
    }

    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = top;
        top = node;
        numItems++;
    }

    public Item pop() {
        if (top == null) {
            // TODO: change to StackUnderflowException
            return null;
        }

        // pop top node
        Node node = top;
        top = node.next;
        numItems--;

        // pull the item
        Item item = node.item;
        // deref the item - avoid leaking
        node.item = null;
        node.next = null;

        return item;
    }

    public int getNumItems() {
        return numItems;
    }

}
