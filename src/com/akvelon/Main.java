package com.akvelon;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(
                new Node<>(
                        new Node<>(
                                new Node<>(4),
                                new Node<>(5),
                                2
                        ),
                        new Node<>(
                                new Node<>(6),
                                new Node<>(7),
                                3
                        ),
                        1
                )
        );

        System.out.println(tree.findClosestCommonParent(4, 5));
        System.out.println(tree.findClosestCommonParent(6, 7));
        System.out.println(tree.findClosestCommonParent(4, 7));
        System.out.println(tree.findClosestCommonParent(4, 70));

    }
}
