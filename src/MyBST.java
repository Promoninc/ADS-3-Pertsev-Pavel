import java.util.Iterator;
import java.util.Stack;

public class MyBST<K extends Comparable<K>, V> {
    public class MyNode<K extends Comparable<K>, V> {
        private K key;
        private V value;
        public MyNode left, right;

        public V getValue(){
            return value;
        }

        public K getKey(){
            return key;
        }

        public MyNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private MyNode root;
    private int size;

    public void put(K key, V value) {
        size++;
        MyNode newNode = new MyNode(key, value);
        if (root == null) {
            root = newNode;
            return;
        }
        MyNode currentNode = root;
        while (true) {
            int cmp = key.compareTo((K) currentNode.getKey());
            if (cmp < 0) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                }
                currentNode = currentNode.left;
            }
            else if (cmp > 0) {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                }
                currentNode = currentNode.right;
            }
            else {
                currentNode.value = value;
                break;
            }
        }
    }
    public V get(K key){
        for(var elem: this.iterator()){
            if(elem.getKey() == key){
                return elem.getValue();
            }
        }
        return null;
    }

    public void delete(K key){
        MyNode current = root;
        MyNode parent = null;
        while (current != null){
            int cmp = key.compareTo((K) current.getKey());
            if(cmp < 0){
                parent = current;
                current = current.left;
            }
            else if(cmp > 0){
                parent = current;
                current = current.right;
            }
            else{
                if(current.right == null) {
                    if(parent == null) {
                        root = current.left;
                    }
                    else if(parent.left == current) {
                        parent.left = current.left;
                    }
                    else{
                        parent.right = current.left;
                    }
                }
                else{
                    MyNode minRight = findMin(current.right);
                    current.key = minRight.getKey();
                    current.value = minRight.getValue();
                    current.right = deleteMin(current.right);
                }
                break;
            }
        }
        size--;
    }

    private MyNode findMin(MyNode currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }
    private MyNode deleteMin(MyNode currentNode) {
        if (currentNode.left == null) {
            return currentNode.right;
        }
        currentNode.left = deleteMin(currentNode.left);
        return currentNode;
    }
    public int size(){
        return size;
    }

    public Iterable<MyNode<K, V>> iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iterable<MyNode<K, V>> {
        private Stack<MyNode> stack = new Stack<>();
        private MyNode currentNode = root;

        @Override
        public Iterator<MyNode<K, V>> iterator() {
            return new Iterator<>() {
                @Override
                public boolean hasNext() {
                    return !stack.isEmpty() || currentNode != null;
                }

                @Override
                public MyNode next() {
                    while (currentNode != null) {
                        stack.push(currentNode);
                        currentNode = currentNode.left;
                    }

                    MyNode node = stack.pop();
                    currentNode = node.right;

                    return node;
                }
            };
        }
    }
}
