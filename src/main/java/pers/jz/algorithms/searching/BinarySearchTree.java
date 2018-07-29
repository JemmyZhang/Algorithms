package pers.jz.algorithms.searching;

import java.util.NoSuchElementException;
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

    public BinaryTreeNode<T> findMin(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> current = root;
        if (Objects.isNull(current))
            return null;
        if (Objects.isNull(current.getLeftChild())) {
            return current;
        }
        return findMin(current.getLeftChild());
    }

    public BinaryTreeNode<T> findMax(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> current = root;
        if (Objects.isNull(current)) {
            return null;
        }
        while (Objects.nonNull(current.getRightChild())) {
            current = current.getRightChild();
        }
        return current;
    }

    public BinaryTreeNode<T> insert(BinaryTreeNode<T> root, T value) {
        BinaryTreeNode<T> current = root;
        if (Objects.isNull(value)) {
            throw new NullPointerException();
        }
        if (Objects.isNull(current)) {
            BinaryTreeNode<T> node = new BinaryTreeNode<T>();
            node.setData(value);
            current = node;
        } else if (value.compareTo(current.getData()) > 0) {
            current.setRightChild(insert(root.getRightChild(), value));
        } else if (value.compareTo(current.getData()) < 0) {
            current.setLeftChild(insert(current.getLeftChild(), value));
        }
        return current;
    }

    public BinaryTreeNode<T> delete(BinaryTreeNode<T> root, T value) {
        BinaryTreeNode<T> current = root;
        if (Objects.isNull(value)) {
            throw new NullPointerException();
        }
        if (Objects.isNull(current)) {
            throw new NoSuchElementException();
        }
        if (value.compareTo(current.getData()) < 0) {
            current.setLeftChild(delete(current.getLeftChild(), value));
        } else if (value.compareTo(current.getData()) > 0) {
            current.setRightChild(delete(current.getRightChild(), value));
        } else {
            if (Objects.isNull(current.getRightChild())) {
                current = current.getLeftChild();
            } else if (Objects.isNull(current.getLeftChild())) {
                current = current.getRightChild();
            } else {
                BinaryTreeNode<T> min = findMin(current.getRightChild());
                current.setData(min.getData());
                current.setRightChild(delete(current.getRightChild(), min.getData()));
            }
        }
        return current;
    }
}
