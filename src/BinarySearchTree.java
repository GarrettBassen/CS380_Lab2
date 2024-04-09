class BinarySearchTree
{
   /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
   /* * * * * * * * * * * * * * * * * * * * * * * NODE CLASS  * * * * * * * * * * * * * * * * * * * * * * * * * * * */
   /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
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
    * TODO IMPLEMENT AND COMMENT
    */
   public void preOrderTraversal()
   {
      //implement me
   }

   /**
    * TODO IMPLEMENT AND COMMENT
    */
   public void inOrderTraversal()
   {
      //implement me
   }

   /**
    * TODO IMPLEMENT AND COMMENT
    */
   public void postOrderTraversal()
   {
      //implement me
   }

   /**
    * Searches through all nodes in tree and returns boolean True or False based on if value was found.
    * @param key Integer value to search for
    * @return Boolean value representing if value was found
    */
   public boolean find(int key)
   {
      // Search for value throughout list
      Node crawler = this.root;
      while (crawler != null)
      {
         // If value is found, return true
         if (key == crawler.value) { return true; }

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
      return false;
   }

   /**
    * TODO IMPLEMENT AND COMMENT
    * @param root
    * @return
    */
   public int getMin(Node root){
      //implement me
      return -1;
   }

   /**
    * TODO IMPLEMENT AND COMMENT
    * @param root
    * @return
    */
   public int getMax(Node root){
      //implement me
      return -1;
   }

   /*
   this method will not compile until getMax
   is implemented
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
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;
   }
}
