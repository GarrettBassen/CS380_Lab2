public class Application
{
    /**
     * Main class which tests and demos tree functions.
     */
    public static void main(String[] args)
    {
        BinarySearchTree tree  = new BinarySearchTree();
        tree.insert(24);
        tree.insert(80);
        tree.insert(18);
        tree.insert(9);
        tree.insert(90);
        tree.insert(22);

        System.out.print("in-order :   ");
        tree.inOrderTraversal();
        System.out.println();
    }
}
