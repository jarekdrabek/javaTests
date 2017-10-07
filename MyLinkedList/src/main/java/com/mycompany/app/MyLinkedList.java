package com.mycompany.app;


import java.util.Objects;
import java.util.Optional;

public class MyLinkedList<T>{

    private Optional<Node<T>> firstElement = Optional.empty();
    private Optional<Node<T>> lastElement = Optional.empty();
    private int size;

    public void add(T value) {
        Objects.requireNonNull(value);
        Node<T> newNode = Node.createNode(value);
        if(!firstElement.isPresent()){
            setFirstElement(newNode);
            setLastElement(newNode);
        } else {
            this.lastElement.get().setNext(newNode);
            setLastElement(newNode);
        }
        size++;
    }

    public void setFirstElement(Node<T> firstElement) {
        this.firstElement = Optional.of(firstElement);
    }

    public void setLastElement(Node<T> lastElement) {
        this.lastElement = Optional.of(lastElement);
    }

    public T get(int index) {
        return getNode(index).getValue();
    }

    private Node<T> getNode(int index) {
        Optional<Node<T>> element = firstElement;
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
            firstElement = Optional.empty();
            firstElement = Optional.empty();
        } else {
            Node<T> toRemove = getNode(index);
            if(isFirstElement(toRemove)) {
                setFirstElement(firstElement.get().getNext().get());
            } else if(isLastElement(toRemove)){
                Node<T> oneBeforeRemovedOne = getNode(index - 1);
                oneBeforeRemovedOne.setEmpty();
                setLastElement(oneBeforeRemovedOne);
            } else {
                Node<T> oneBeforeRemovedOne = getNode(index - 1);
                oneBeforeRemovedOne.setNext(toRemove.getNext().get());
            }
        }
        size--;

    }

    private boolean isLastElement(Node<T> node) {
        return Optional.of(node).equals(lastElement);
    }

    private boolean isFirstElement(Node<T> node) {
        return Optional.of(node).equals(firstElement);
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
            this.next = Optional.of(next);
        }

        public void setEmpty() {
            this.next = Optional.empty();
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
