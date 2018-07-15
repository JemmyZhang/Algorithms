package pers.jz.algorithms.searching;

import jdk.nashorn.internal.ir.BinaryNode;

import java.util.Objects;

/**
 * @author Jemmy Zhang on 2018/7/15.
 */
public class BinaryTree<T> {

    private BinaryTreeNode<T> root;

    public boolean isEmpty() {
        return Objects.isNull(root);
    }

    public BinaryTreeNode<T> parentNode(BinaryTreeNode<T> currentNode) {
        return currentNode.getParent();
    }

    /**
     * 返回左兄弟结点
     *
     * @param currentNode
     * @return
     */
    public BinaryTreeNode<T> leftSibling(BinaryTreeNode<T> currentNode) {
        return currentNode.getParent().getLeftChild();
    }

    /**
     * 返回右兄弟结点
     *
     * @param currentNode
     * @return
     */
    public BinaryTreeNode<T> rightSibling(BinaryTreeNode<T> currentNode) {
        return currentNode.getParent().getRightChild();
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public void PreOrder(BinaryTreeNode<T> root) {
        if (root != null) {
            visit(root);
            PreOrder(root.getLeftChild());
            PreOrder(root.getRightChild());
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void InOrder(BinaryTreeNode<T> root) {
        if (root != null) {
            PreOrder(root.getLeftChild());
            visit(root);
            PreOrder(root.getRightChild());
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void PostOrder(BinaryTreeNode<T> root) {
        if (root != null) {
            PostOrder(root.getLeftChild());
            PostOrder(root.getRightChild());
            visit(root);
        }
    }

    //层次遍历
    public void levelOrder(BinaryTreeNode<T> root) {

    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    private void visit(BinaryTreeNode<T> root) {
        System.out.println(root.getData());
    }
    
}
