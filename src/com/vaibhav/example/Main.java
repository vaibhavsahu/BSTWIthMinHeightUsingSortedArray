package com.vaibhav.example;

public class Main {

    public static void main(String[] args) {
	    int [] sortedArray = {1,2,7,8,11,13,15};
	    Node root = makeBSTArray(sortedArray, 0, sortedArray.length-1, null);
	    printTree(root);
    }

    private static void printTree(Node root) {
        if(root == null){
            return;
        }
        System.out.println(root.getData());
        printTree(root.getLeftChild());
        printTree(root.getRightChild());
    }

    private static Node makeBSTArray(int[] sortedArray, int start, int end, Node root1) {
        //base case: if start and end are same, return
            if(start == end){ //leaf node
                Node node = new Node(sortedArray[start]);
                return node;
            }
            int middle = (start+end)/2;
            root1 = new Node(sortedArray[middle]);

            root1.setLeftChild(makeBSTArray(sortedArray, start, middle-1, root1.getLeftChild()));

            root1.setRightChild(makeBSTArray(sortedArray, middle+1, end, root1.getRightChild()));

        return root1;
    }
}
