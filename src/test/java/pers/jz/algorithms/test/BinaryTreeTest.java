package pers.jz.algorithms.test;

import org.junit.Assert;
import org.junit.Test;
import pers.jz.algorithms.searching.BinaryTree;
import pers.jz.algorithms.searching.BinaryTreeNode;

/**
 * @author Jemmy Zhang
 */
public class BinaryTreeTest {

    @Test
    public void preOrderTest() {
        BinaryTree<Integer> tree = generateTree();
        tree.preOrder(tree.getRoot());
        System.out.println("preOrder");
    }

    @Test
    public void inOrderTest(){
        BinaryTree<Integer> tree = generateTree();
        tree.inOrder(tree.getRoot());
        System.out.println("InOrder");
    }

    @Test
    public void postOrderTest(){
        BinaryTree<Integer> tree = generateTree();
        tree.postOrder(tree.getRoot());
        System.out.println("postOrder");
    }

    @Test
    public void postOrderWithoutRecursion(){
        BinaryTree<Integer> tree = generateTree();
        tree.postOrderWithoutRecursion(tree.getRoot());
        System.out.println("postOrderWithoutRecursion");
    }


    public BinaryTree<Integer> generateTree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.setLeftChild(new BinaryTreeNode<>(2));
        root.getLeftChild().setLeftChild(new BinaryTreeNode<>(3));
        root.getLeftChild().getLeftChild().setLeftChild(new BinaryTreeNode<>(4));
        root.getLeftChild().getLeftChild().setRightChild(new BinaryTreeNode<>(5));
        root.getLeftChild().setRightChild(new BinaryTreeNode<>(6));
        root.setRightChild(new BinaryTreeNode<>(7));
        root.getRightChild().setRightChild(new BinaryTreeNode<>(8));
        root.getRightChild().getRightChild().setLeftChild(new BinaryTreeNode<>(9));
        root.getRightChild().getRightChild().setRightChild(new BinaryTreeNode<>(10));
        root.getRightChild().getRightChild().getRightChild().setLeftChild(new BinaryTreeNode<>(11));
        root.getRightChild().getRightChild().getRightChild().getLeftChild().setRightChild(new BinaryTreeNode<>(12));
        BinaryTree<Integer> tree=new BinaryTree<>();
        tree.setRoot(root);
        return tree;
    }
}
