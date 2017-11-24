public class Tester {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(45);
        tree.insert(34);
        tree.insert(3);
        tree.insert(6);
        tree.insert(19);
        tree.insert(32);
        tree.insert(77);
        tree.insert(8);
        tree.insert(80);
        tree.insert(75);
        /*tree.root = new BSTNode<>(1);
        tree.root.left = new BSTNode<>(2);
        tree.root.right = new BSTNode<>(3);
        tree.root.left.left = new BSTNode<>(4);
        tree.root.left.right = new BSTNode<>(5);*/

        //System.out.println("\nInorder traversal of binary tree is ");
        //tree.printInOrder();
        System.out.println("The maximum value of BST is " + tree.findMax());
        System.out.println(tree.contains(3));
    }
}
