package com.mycompany.app;


import java.util.Objects;
import java.util.Optional;

public class MyLinkedList<T>{

    private Node<T> firstElement;
    private Node<T> lastElement;
    private int size;

    public void add(T value) {
        Node<T> newNode = Node.createNode(value);
        if(firstElement == null){
            this.firstElement = newNode;
            this.lastElement = newNode;
        } else {
            this.lastElement.setNext(newNode);
            this.lastElement = newNode;
        }
        size++;
    }

    public T get(int index) {
        return getNode(index).getValue();
    }

    private Node<T> getNode(int index) {
        Optional<Node<T>> element = Optional.ofNullable(firstElement);
        while(index>0) {
            element = element.orElseThrow(IndexOutOfBoundsException::new).getNext();
            index--;
        }
        return element.orElseThrow(IndexOutOfBoundsException::new);
    }

    public void remove(int index) {
        if(size == 0)
            throw new IndexOutOfBoundsException();
        else if(size == 1){
            firstElement = null;
            firstElement = null;
        } else {
            Node<T> toRemove = getNode(index);
            if(isFirstElement(toRemove)){
                firstElement = firstElement.getNext().orElseThrow(IllegalStateException::new);
            } else {
                Node<T> newLast = getNode(index - 1);
                newLast.setNext(toRemove.getNext().orElse(null));
                this.lastElement = newLast;
            }
        }
        size--;

    }

    private boolean isFirstElement(Node<T> node) {
        return node.equals(firstElement);
    }


    static class Node<T> {
        private T value;
        private Optional<Node<T>> next;

        public Node(T value, Optional<Node<T>> next) {
            this.value = value;
            this.next = next;
        }

        public static <T> Node<T> createNode(T value) {
            return new Node(value, Optional.empty());
        }

        public T getValue() {
            return value;
        }

        public Optional<Node<T>> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = Optional.ofNullable(next);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }
    }
}
