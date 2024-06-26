public class Application
{
    /**
     * Main class which tests and demos tree functions.
     */
    public static void main(String[] args)
    {
        // Creates tree
        BinarySearchTree tree  = new BinarySearchTree();

        // TESTING BinarySearchTree.getMin()
        System.out.print("\n~~~~ NEW TEST BLOCK: getMin()\n");
        System.out.print("Attempting to getMin() value in empty tree\n");
        try { tree.getMin(); }
        catch (NullPointerException e)
        {
            System.out.print("NullPointerException caught as intended\n");
        }

        // TESTING BinarySearchTree.getMin()
        System.out.print("\n~~~~ NEW TEST BLOCK: getMax()\n");
        System.out.print("Attempting to getMax() value in empty tree\n");
        try { tree.getMax(); }
        catch (NullPointerException e)
        {
            System.out.print("NullPointerException caught as intended\n");
        }

        // TESTING BinarySearchTree.insert()
        System.out.print("\n~~~~ NEW TEST BLOCK: insert()\n");
        System.out.print("Inserting values [ 24, 80, 18, 9, 90, 22 ]\n");
        tree.insert(24);
        tree.insert(80);
        tree.insert(18);
        tree.insert(9);
        tree.insert(90);
        tree.insert(22);

        // TESTING BinarySearchTree.contains()
        System.out.print("\n~~~~ NEW TEST BLOCK: contains()\n");
        System.out.printf("Found \"123\" within tree: %b\n", tree.contains(123));
        System.out.printf("Found \"24\" within tree: %b\n", tree.contains(24));
        System.out.printf("Found \"9\" within tree: %b\n", tree.contains(9));

        // TESTING BinarySearchTree.getMin()
        System.out.print("\n~~~~ NEW TEST BLOCK: getMin()\n");
        System.out.printf("Smallest node in tree: %d\n", tree.getMin());
        System.out.print("Adding \"2\" to tree\n");
        tree.insert(2);
        System.out.printf("Smallest node in tree: %d\n", tree.getMin());

        // TESTING BinarySearchTree.getMin()
        System.out.print("\n~~~~ NEW TEST BLOCK: getMax()\n");
        System.out.printf("Largest node in tree: %d\n", tree.getMax());
        System.out.print("Adding \"512\" to tree\n");
        tree.insert(512);
        System.out.printf("Largest node in tree: %d\n", tree.getMax());

        // TESTING BinarySearchTree.preOrderTraversal()
        System.out.print("\n~~~~ NEW TEST BLOCK: preOrderTraversal()\n");
        System.out.print("Printing tree in pre-order\n");
        tree.preOrderTraversal();

        // TESTING BinarySearchTree.inOrderTraversal()
        System.out.print("\n~~~~ NEW TEST BLOCK: inOrderTraversal()\n");
        System.out.print("Printing tree in order\n");
        tree.inOrderTraversal();

        // TESTING BinarySearchTree.postOrderTraversal()
        System.out.print("\n~~~~ NEW TEST BLOCK: postOrderTraversal()\n");
        System.out.print("Printing tree in post-order\n");
        tree.postOrderTraversal();
    }
}
