package pers.jz.algorithms.searching;

/**
 * @author Jemmy Zhang
 */
public class AVLTreeNode extends BinaryTreeNode{

    private int height;

    public AVLTreeNode(int height) {
        this.height = height;
    }

    public AVLTreeNode(Object data, int height) {
        super(data);
        this.height = height;
    }

    public AVLTreeNode(Object data, BinaryTreeNode leftChild, BinaryTreeNode rightChild, int height) {
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
