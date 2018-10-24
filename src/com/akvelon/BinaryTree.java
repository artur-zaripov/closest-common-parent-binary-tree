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
    
    Node<T> findClosestCommonParentOptimized(Node<T> root, Node<T> firstElement, Node<T> secondElement) {

        if (root == null) return null;

        // if one of elements is root, the answer is root
        if (root == firstElement || root == secondElement) return root;


        // otherwise, answer is either left or right
        Node<T> left = findClosestCommonParentOptimized(root.getLeft(), firstElement, secondElement);
        Node<T> right = findClosestCommonParentOptimized(root.getRight(), firstElement, secondElement);

        // if elements are present in both subtrees, the answer is root
        if (left != null && right != null) return root;

        // if elements are present only in one subtree, the answer is in that subtree
        return left != null ? left : right;
    }
}
