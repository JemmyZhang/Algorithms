package pers.jz.algorithms.searching;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Jemmy Zhang
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

    /**
     * 非递归前序遍历
     *
     * @param root
     */
    public void preOrderWithoutRecursion(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> current = root;
        while (stack.size() > 0 || Objects.nonNull(current)) {
            while (Objects.nonNull(current)) {
                stack.push(current);
                visit(current);
                current = current.getLeftChild();
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.getRightChild();
            }
        }
    }

    /**
     * 非递归中序遍历
     *
     * @param root
     */
    public void inOrderWithoutRecursion(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> current = root;

        while (stack.size() > 0 || Objects.nonNull(current)) {
            while (Objects.nonNull(current)) {
                stack.push(current);
                current = current.getLeftChild();
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                visit(current);
                current = current.getRightChild();
            }
        }
    }

    /**
     * 非递归后序遍历
     *
     * @param root
     */
    public void postOrderWithoutRecursion(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> current = root;
        BinaryTreeNode<T> lastVisit = null;
        while (stack.size() > 0 || Objects.nonNull(current)) {
            while (Objects.nonNull(current)) {
                stack.push(current);
                current = current.getLeftChild();
            }
            if (!stack.isEmpty()) {
                current = stack.peek();
                if (Objects.equals(null, current.getRightChild())
                        || Objects.equals(current.getRightChild(), lastVisit)) {
                    visit(stack.pop());
                    lastVisit = current;
                } else {
                    current = current.getRightChild();
                }
            }
        }
    }

    /**
     * 层次遍历
     *
     * @param root
     */
    public void levelOrder(BinaryTreeNode<T> root) {
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        BinaryTreeNode<T> current = root;
        queue.add(current);
        while (queue.size() != 0) {
            current = queue.poll();
            visit(current);
            if (Objects.nonNull(current.getLeftChild()))
                queue.add(current.getLeftChild());
            if (Objects.nonNull(current.getRightChild()))
                queue.add(current.getRightChild());
        }
    }

    /**
     * 后序遍历求树的高度
     *
     * @param root
     * @return
     */
    public int postOrderGetHeight(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> current = root;
        if (Objects.nonNull(current)) {
            int leftHeight = postOrderGetHeight(root.getLeftChild());
            int rightHeight = postOrderGetHeight(root.getRightChild());
            int maxHeight = leftHeight > rightHeight ? leftHeight : rightHeight;
            return maxHeight + 1;
        }
        return 0;
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
