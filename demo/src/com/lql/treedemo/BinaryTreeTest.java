package com.lql.treedemo;


/**
 * 二叉树
 * 中序排序
 */
public class BinaryTreeTest {

    private Node root;

    //添加节点
    public void add(int data){
        if (root == null){
            root = new Node(data);
        }else {
            root.addNode(data);
        }

    }

    public void print(){
        root.printNode();
    }

    private class Node{

        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
        }

        //添加节点
        public void addNode(int data){
            if(this.data>data){
                if(this.left ==null){
                    this.left =new Node(data);
                }else{
                    this.left.addNode(data);
                }
            }else {
                if(this.right == null){
                    this.right = new Node(data);
                }else{
                    this.right.addNode(data);
                }
            }

        }

        //打印节点
        public void printNode(){
            if(this.left !=null){
                this.left.printNode();
            }
            System.out.print(this.data + "->");
            if (this.right != null){
                this.right.printNode();
            }
        }
    }
}
