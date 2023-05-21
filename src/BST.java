
public class BST<K extends Comparable<K>,V> {
    private Node root;
    private int size = 1;
    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V value) {
        root = insertNode(root, key, value);
    }
    private Node insertNode(Node currentNode, K key, V value) {
        if (currentNode == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(currentNode.key) < 0) {
            currentNode.left = insertNode(currentNode.left, key, value);
        } else {
            currentNode.right = insertNode(currentNode.right, key, value);
        }
        return currentNode;
    }
    public V get(K key) {
        Node foundNode = searchNode(root, key);
        if (foundNode == null) {
            return null;
        } else {
            return foundNode.val;
        }
    }
    private Node searchNode(Node current, K key) {
        if (current == null || key.equals(current.key)) {
            return current;
        }
        if (key.compareTo(current.key) < 0) {
            return searchNode(current.left, key);
        } else {
            return searchNode(current.right, key);
        }
    }
    public void delete(K key) {
    }
}