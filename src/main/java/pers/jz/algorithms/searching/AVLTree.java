package pers.jz.algorithms.searching;

/**
 * @author Jemmy Zhang
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {


    public BinaryTreeNode<T> insert(AVLTreeNode<T> root, T value) {
        return super.insert(root, value);
    }

    public BinaryTreeNode<T> delete(AVLTreeNode<T> root, T value) {
        return super.delete(root, value);
    }
}
