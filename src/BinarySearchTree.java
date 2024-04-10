class BinarySearchTree
{
   /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
   /* * * * * * * * * * * * * * * * * * * * * * * NODE CLASS  * * * * * * * * * * * * * * * * * * * * * * * * * * * */
   /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

   /**
    * Node class contains a value as well as a left and right node. The tree is made of node objects.
    */
   static class Node
   {
      protected Node left, right;
      protected int value;

      public Node(int value)
      {
         this.value = value;
         this.left = null;
         this.right = null;
      }
   }


   /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
   /* * * * * * * * * * * * * * * * * * * START OF TREE CLASS * * * * * * * * * * * * * * * * * * * * * * * * * * * */
   /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
   protected Node root;

   /**
    * Inserts given value in correct place within tree object. Objects less than the current node, traverse left.
    * Objects greater than the current node traverse right. Once a null node is found, the value is assigned.
    * @param value Integer value to insert
    */
   public void insert(int value)
   {
      // Assign head if tree is empty
      if (this.root == null)
      {
         this.root = new Node(value);
         return;
      }

      // Traverse tree to find spot to insert value
      Node crawler = this.root;
      while (true)
      {
         // Value is less than current node
         if (value < crawler.value)
         {
            // Assign value if left node is null; else, go left and continue search
            if (crawler.left == null)
            {
               crawler.left = new Node(value);
               return;
            }

            crawler = crawler.left;
         }
         // Value is greater than or equal to current node
         else
         {
            // Assign value if left node is null; else, go left and continue search
            if (crawler.right == null)
            {
               crawler.right = new Node(value);
               return;
            }

            crawler = crawler.right;
         }
      }
   }

   /**
    * Prints bracket-encased tree values in space-separated pre-order value.
    */
   public void preOrderTraversal()
   {
      System.out.print("[");
      recursivePreOrder(this.root);
      System.out.print(" ]\n");
   }

   /**
    * Prints bracket-encased tree values in space-separated ordered value.
    */
   public void inOrderTraversal()
   {
      System.out.print("[");
      recursiveInOrder(this.root);
      System.out.print(" ]\n");
   }

   /**
    * Prints bracket-encased tree values in space-separated post-order value.
    */
   public void postOrderTraversal()
   {
      System.out.print("[");
      recursivePostOrder(this.root);
      System.out.print(" ]\n");
   }

   /**
    * Searches tree for value and returns true if value is found; else, returns false.
    * @param key Integer value to search for
    * @return True if value is found in tree; otherwise, false
    */
   public boolean contains(int key)
   {
      return getNode(key) != null;
   }

   /**
    * Searches through all nodes in tree and returns Node reference if value was found or null.
    * @param key Integer value to search for
    * @return Node reference or null
    */
   public Node getNode(int key)
   {
      // Search for value throughout list
      Node crawler = this.root;
      while (crawler != null)
      {
         // If value is found, return Node
         if (key == crawler.value) { return crawler; }

         // If value is less than current node, traverse left
         else if (key < crawler.value)
         {
            crawler = crawler.left;
         }
         // If value is greater than current node, traverse right
         else
         {
            crawler = crawler.right;
         }
      }

      // Value was not found; return false.
      return null;
   }

   /**
    * Finds and returns smallest Integer value within tree or throws NullPointerException if tree has no values.
    * @return Integer smallest value
    * @throws NullPointerException Throws if tree has no values
    */
   public int getMin() throws NullPointerException
   {
      // Traverse left until null node is found which means the smallest node is found.
      Node crawler = this.root;
      while (crawler != null)
      {
         if (crawler.left == null)
         {
            return crawler.value;
         }
         crawler = crawler.left;
      }
      // Throws exception if tree is empty
      throw new NullPointerException();
   }

   /**
    * Finds and returns largest Integer value within tree or throws NullPointerException if tree has no values.
    * @return Integer largest value
    * @throws NullPointerException Throws if tree has no values
    */
   public int getMax() throws NullPointerException
   {
      // Traverse right until null node is found which means the largest node is found.
      Node crawler = this.root;
      while (crawler != null)
      {
         if (crawler.right == null)
         {
            return crawler.value;
         }
         crawler = crawler.right;
      }
      // Throws exception if tree is empty
      throw new NullPointerException();
   }

   /*
   this method will not compile until getMax
   is implemented TODO EXAMINE
   */
   public Node delete(Node root, int key)
   {
      if(root == null)
      {
         return root;
      }
      else if(key < root.value)
      {
         root.left = delete(root.left, key);
      }
      else if(key > root.value)
      {
         root.right = delete(root.right, key);
      }
      else
      {
         //node has been found
         if(root.left == null && root.right == null)
         {
            //case #1: leaf node
            root = null;
         }
         else if(root.right == null)
         {
            //case #2 : only left child
            root = root.left;
         }
         else if(root.left == null)
         {
            //case #2 : only right child
            root = root.right;
         }
         else
         {
            //case #3 : 2 children
            root.value = getMax();
            root.left = delete(root.left, root.value);
         }
      }
      return root;
   }


   /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
   /* * * * * * * * * * * * * * * * * * * * HELPER FUNCTIONS  * * * * * * * * * * * * * * * * * * * * * * * * * * * */
   /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
   /**
    * Recursively travels through tree and prints nodes in pre-order.
    * @param root Node root of the tree to traverse
    */
   private void recursivePreOrder(Node root)
   {
      if (root == null) { return; }

      // Traverse left and right, printing in pre-order
      System.out.printf(" %d", root.value);
      recursiveInOrder(root.left);
      recursiveInOrder(root.right);
   }

   /**
    * Recursively travels through tree and prints nodes in order.
    * @param root Node root of the tree to traverse
    */
   private void recursiveInOrder(Node root)
   {
      if (root == null) { return; }

      // Traverse left and right, printing in order
      recursiveInOrder(root.left);
      System.out.printf(" %d", root.value);
      recursiveInOrder(root.right);
   }

   /**
    * Recursively travels through tree and prints nodes in post-order.
    * @param root Node root of the tree to traverse
    */
   private void recursivePostOrder(Node root)
   {
      if (root == null) { return; }

      // Traverse left and right, printing in post-order
      recursivePostOrder(root.left);
      recursivePostOrder(root.right);
      System.out.printf(" %d", root.value);
   }
}
