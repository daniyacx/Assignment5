import java.util.*;
public class BST<K extends Comparable<K>,V> {
    private Node root;
    private int size = 1;
    public class Node {
        public K key;
        public V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    /**
     @put() inserts a new node with the specified key and value into the binary search tree
     if the key already exists, the value associated with the key is updated
     @param key   the key of the node to be inserted
     @param value the value associated with the key
     */
    public void put(K key, V value) {
        root = insertNode(root, key, value);
    }
    /**
     @insertNode recursive helper method to insert a node into the binary search tree
     @param currentNode the current node being examined
     @param key         the key of the node to be inserted
     @param value       the value associated with the key
     @return the modified current node after insertion
     */
    // recursive helper method to insert a node into the bst
    private Node insertNode(Node currentNode, K key, V value) {
        if (currentNode == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(currentNode.key) < 0) {
            currentNode.left = insertNode(currentNode.left, key, value); // traverse to the left subtree
        } else {
            currentNode.right = insertNode(currentNode.right, key, value); // traverse to the right subtree
        }
        return currentNode;
    }
    /**
     @get() retrieves the value associated with the specified key from the binary search tree
     if the key is not found, null is returned
     @param key the key to search for
     @return the value associated with the key, or null if the key is not found
     */
    public V get(K key) {
        Node foundNode = searchNode(root, key);
        if (foundNode == null) {
            return null; // key not found, return null
        } else {
            return foundNode.val; // return the value associated with the key
        }
    }
    // recursive helper method to search for a node with the given key in the bst
    private Node searchNode(Node current, K key) {
        if (current == null || key.equals(current.key)) {
            return current; // key found or reached a null node, return the current node
        }
        if (key.compareTo(current.key) < 0) {
            return searchNode(current.left, key); // traverse to the left subtree
        } else {
            return searchNode(current.right, key); // traverse to the right subtree
        }
    }
    public void delete(K key) {
        root = deleteNode(root, key);
    }
    // recursive helper method to delete a node with the given key from the bst
    private Node deleteNode(Node current, K key) {
        if (current == null) {
            return null; // key not found, return null
        }
        if (key.compareTo(current.key) < 0) {
            current.left = deleteNode(current.left, key); // traverse to the left subtree
        } else if (key.compareTo(current.key) > 0) {
            current.right = deleteNode(current.right, key); // traverse to the right subtree
        } else {
            // found the node to delete
            if (current.left == null) {
                size--;
                return current.right; // replace the node with its right child
            } else if (current.right == null) {
                size--;
                return current.left; // replace the node with its left child
            } else {
                // node has both left and right children
                Node next = findMin(current.right); // find the minimum node in the right subtree
                current.key = next.key; // replace the current node with the minimum node
                current.val = next.val;
                current.right = deleteNode(current.right, next.key); // delete the minimum node from the right subtree
            }
        }
        return current;
    }
    // helper method to find the minimum node in a given subtree
    private Node findMin(Node node) {
        if (node.left == null) {
            return node; // minimum node found
        }
        return findMin(node.left); // recursively search for the minimum node in the left subtree
    }
    /**
     * returns an iterator that iterates over the nodes of the binary search tree in in-order traversal
     * @return an iterator over the nodes of the binary search tree
     */
    public Iterable<Node> iterator() {
        ArrayList<Node> nodeList = new ArrayList<>();
        inOrderTraversal(nodeList, root);
        return nodeList;
    }
    // helper method to perform in-order traversal of the bst and populate the list
    private void inOrderTraversal(ArrayList<Node> list, Node node) {
        if (node == null) {
            return; // base case: reached a null node, return
        }

        inOrderTraversal(list, node.left); // recursively traverse the left subtree
        list.add(node); // add the current node to the list
        inOrderTraversal(list, node.right); // recursively traverse the right subtree
    }
}