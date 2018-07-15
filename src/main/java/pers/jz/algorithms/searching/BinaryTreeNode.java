package pers.jz.algorithms.searching;

import java.util.Objects;

/**
 * @author Jemmy Zhang on 2018/7/15.
 */
public class BinaryTreeNode<T> {
    private T data;
    private BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        this.data = data;
        if (Objects.nonNull(leftChild)) {
            this.leftChild = leftChild;
            this.leftChild.setParent(this);
        }

        if (Objects.nonNull(rightChild)) {
            this.rightChild = rightChild;
            this.rightChild.setParent(this);
        }

    }

    public boolean isLeaf() {
        return Objects.isNull(leftChild) && Objects.isNull(rightChild);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode<T> parent) {
        this.parent = parent;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
        this.leftChild.setParent(this);
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
        this.rightChild.setParent(this);
    }
}
