package pers.jz.algorithms.searching;

/**
 * @author Jemmy Zhang
 */
public class AVLTreeNode<T> extends BinaryTreeNode<T> {

    private int height;

    public AVLTreeNode(int height) {
        this.height = height;
    }

    public AVLTreeNode(T data, int height) {
        super(data);
        this.height = height;
    }

    public AVLTreeNode(T data, BinaryTreeNode leftChild, BinaryTreeNode rightChild, int height) {
        super(data, leftChild, rightChild);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
