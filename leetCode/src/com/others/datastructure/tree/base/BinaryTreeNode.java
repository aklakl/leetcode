package com.others.datastructure.tree.base;


public class BinaryTreeNode<T> {
	T value;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	BinaryTreeNode(T val) {
		value = val;
	}
}
