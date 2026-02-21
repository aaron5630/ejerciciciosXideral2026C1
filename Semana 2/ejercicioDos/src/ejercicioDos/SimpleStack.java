package ejercicioDos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleStack<T> implements Iterable<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    // PUSH
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }

    // POP
    public T pop() {
        if (top == null) {
            throw new NoSuchElementException("Stack is empty");
        }

        T value = top.data;
        top = top.next;
        return value;
    }

    // ITERATOR
    private class StackIterator implements Iterator<T> {

        private Node<T> current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T value = current.data;
            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
}
