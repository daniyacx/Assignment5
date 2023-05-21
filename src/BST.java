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
        root = deleteNode(root, key);
    }
    private Node deleteNode(Node current, K key) {
        if (current == null) {
            return null;
        }
        if (key.compareTo(current.key) < 0) {
            current.left = deleteNode(current.left, key);
        } else if (key.compareTo(current.key) > 0) {
            current.right = deleteNode(current.right, key);
        } else {
            if (current.left == null) {
                size--;
                return current.right;
            } else if (current.right == null) {
                size--;
                return current.left;
            } else {
                Node next = findMin(current.right);
                current.key = next.key;
                current.val = next.val;
                current.right = deleteNode(current.right, next.key);
            }
        }
        return current;
    }
    private Node findMin(Node node) {
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }
    public Iterable<Node> iterator() {
        ArrayList<Node> nodeList = new ArrayList<>();
        inOrderTraversal(nodeList, root);
        return nodeList;
    }

    private void inOrderTraversal(ArrayList<Node> list, Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(list, node.left);
        list.add(node);
        inOrderTraversal(list, node.right);
    }
}