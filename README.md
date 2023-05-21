# Assignment5
# Binary Search Tree (BST)

A BST is a binary tree where each node has a key and a value, and the keys are stored in a specific order that allows for efficient search, insertion, and deletion operations

## Usage

To use the BST class, follow these steps:

1. Import the necessary package:
```
import java.util.*;
```

2. Create an instance of the BST class, specifying the key and value types:
```
BST<K, V> bst = new BST<>();
```

3. Insert nodes into the BST using the `put()` method:
```
bst.put(key, value);
```
If the key already exists, the associated value will be updated.

4. Retrieve the value associated with a specific key using the `get()` method:
```
V value = bst.get(key);
```
If the key is not found, `null` will be returned.

5. Delete a node with a specific key using the `delete()` method:
```
bst.delete(key);
```

6. Iterate over the nodes of the BST in in-order traversal using the provided iterator:
```
for (BST.Node elem : bst.iterator()) {}
```

## Class Details

### BST Class

The `BST` class is a generic class that represents a binary search tree.

**Constructor:**
- `BST()`: Creates an empty binary search tree.

**Methods:**
- `put(K key, V value)`: Inserts a new node with the specified key and value into the BST. If the key already exists, the value associated with the key is updated.
- `get(K key)`: Retrieves the value associated with the specified key from the BST. If the key is not found, `null` is returned.
- `delete(K key)`: Deletes the node with the given key from the BST.
- `iterator()`: Returns an iterator that iterates over the nodes of the BST in in-order traversal.

### Node Class

The `Node` class is an inner class of the `BST` class and represents a node in the binary search tree.

## Example

```
BST<Integer, String> bst = new BST<>();

bst.put(5, "Bangchan");
bst.put(3, "Changbin");
bst.put(7, "Lee Minho");
bst.put(2, "Felix");
bst.put(4, "Han Jisung");
bst.put(6, "Jeongin");
bst.put(8, "Seungmin");

String value1 = bst.get(5);  // Retrieves the value "Bangchan"
String value2 = bst.get(2);  // Retrieves the value "Felix"
String value3 = bst.get(8);  // Retrieves the value "Seungmin"
String value4 = bst.get(1);  // Retrieves null (key not found)

bst.delete(3);
bst.delete(7);

 for (BST.Node elem : bst.iterator()) {
                System.out.println("key is " + elem.key + " and value is " + elem.val);
            }
```
