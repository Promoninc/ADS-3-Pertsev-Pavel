import java.util.Iterator;
import java.util.Stack;

public class MyBST<K extends Comparable<K>, V> {
    private MyNode root;
    private int size;
    private class MyNode {
        public K key;
        public V value;
        private MyNode left, right;

        public MyNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        size++;
        MyNode newNode = new MyNode(key, value);
        if (root == null) {
            root = newNode;
            return;
        }
        MyNode currentNode = root;
        while (true) {
            int cmp = key.compareTo(currentNode.key);
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
        for(Pair<K, V> pair: this.iterator()){
            if(pair.key == key){
                return pair.value;
            }
        }
        return null;
    }
    public void delete(K key){

    }
    public int size(){
        return size;
    }

    public Iterable<Pair<K, V>> iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iterable<Pair<K, V>> {
        private Stack<MyNode> stack = new Stack<>();
        private MyNode currentNode = root;

        @Override
        public Iterator<Pair<K, V>> iterator() {
            return new Iterator<>() {
                @Override
                public boolean hasNext() {
                    return !stack.isEmpty() || currentNode != null;
                }

                @Override
                public Pair<K, V> next() {
                    while (currentNode != null) {
                        stack.push(currentNode);
                        currentNode = currentNode.left;
                    }

                    MyNode node = stack.pop();
                    currentNode = node.right;

                    return new Pair<>(node.key, node.value);
                }
            };
        }
    }
}
