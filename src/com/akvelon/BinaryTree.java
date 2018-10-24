package com.akvelon;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {

    private Node<T> treeRoot;

    BinaryTree(Node<T> treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Node<T> getTreeRoot() {
        return treeRoot;
    }

    List<Node<T>> findPathToElement(T element) {
        return processNode(treeRoot, element, new ArrayList<>());
    }

    private List<Node<T>> processNode(Node<T> node, T element, List<Node<T>> path) {
        if (node == null) {
            return null;
        } else if (node.getElement().equals(element)) {
            return path;
        } else {
            List<Node<T>> newPath = new ArrayList<>(path);
            newPath.add(node);
            List<Node<T>> result = processNode(node.getLeft(), element, newPath);
            if (result == null)
                return processNode(node.getRight(), element, newPath);
            else
                return result;
        }
    }

    T findClosestCommonParent(T firstElement, T secondElement) {
        List<Node<T>> pathToFirst = findPathToElement(firstElement);
        List<Node<T>> pathToSecond = findPathToElement(secondElement);

        if (pathToFirst == null || pathToSecond == null)
            return null;

        int index = 0;
        T commonParent = null;
        while (index < pathToFirst.size() && index < pathToSecond.size() &&
                pathToFirst.get(index).equals(pathToSecond.get(index))) {
            commonParent = pathToFirst.get(index).getElement();
            index++;
        }

        return commonParent;
    }
}
