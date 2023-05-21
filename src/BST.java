
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
    }
    public void delete(K key) {
    }
}