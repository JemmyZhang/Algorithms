package pers.jz.algorithms.searching;

import java.util.Objects;

/**
 * @author Jemmy Zhang
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public BinaryTreeNode<T> find(BinaryTreeNode<T> root, T key) {
        BinaryTreeNode<T> current = root;
        if (Objects.isNull(current) || Objects.isNull(key)) {
            return null;
        }
        if (Objects.equals(current.getData(), key)) {
            return current;
        } else if (key.compareTo(current.getData()) < 0) {
            return find(current.getLeftChild(), key);
        } else {
            return find(current.getRightChild(), key);
        }
    }

    public BinaryTreeNode<T> findWithOutRecursion(BinaryTreeNode<T> root, T key) {
        BinaryTreeNode<T> current = root;
        if (Objects.isNull(key)) {
            return null;
        }
        while (Objects.nonNull(current)) {
            if (Objects.equals(current.getData(), key)) {
                return current;
            } else if (key.compareTo(current.getData()) < 0) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return null;
    }
}
