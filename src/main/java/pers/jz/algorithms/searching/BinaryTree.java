package pers.jz.algorithms.searching;

import java.util.Objects;
import java.util.Stack;

/**
 * @author Jemmy Zhang on 2018/7/15.
 */
public class BinaryTree<T> {

    private BinaryTreeNode<T> root;

    public boolean isEmpty() {
        return Objects.isNull(root);
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public void preOrder(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> currentNode = root;
        if (currentNode != null) {
            visit(currentNode);
            preOrder(currentNode.getLeftChild());
            preOrder(currentNode.getRightChild());
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inOrder(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> currentNode = root;
        if (currentNode != null) {
            inOrder(currentNode.getLeftChild());
            visit(currentNode);
            inOrder(currentNode.getRightChild());
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void postOrder(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> currentNode = root;
        if (currentNode != null) {
            postOrder(currentNode.getLeftChild());
            postOrder(currentNode.getRightChild());
            visit(currentNode);
        }
    }

    public void preOrderWithoutRecursion(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        visit(root);
        stack.push(root);
        BinaryTreeNode<T> current = root;
        while (stack.size() > 0) {
            BinaryTreeNode<T> currentLeftChild = current.getLeftChild();
            while (Objects.nonNull(currentLeftChild)) {
                visit(currentLeftChild);
                stack.push(currentLeftChild);
                current = currentLeftChild;
            }

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
