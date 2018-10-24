package com.akvelon;

class Node<T> {
    private Node left;
    private Node right;
    private T element;

    Node(T element) {
        right = null;
        left = null;
        this.element = element;
    }


    Node(Node left, Node right, T element) {
        this.left = left;
        this.right = right;
        this.element = element;
    }

    Node getLeft() {
        return left;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    Node getRight() {
        return right;
    }

    void setRight(Node right) {
        this.right = right;
    }

    T getElement() {
        return element;
    }
}
