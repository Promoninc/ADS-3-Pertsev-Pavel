public class MyHashTable<K, V> {
    private class MyHashNode<K, V>{
        private K key;
        private V value;
        private MyHashNode<K, V> next;
        MyHashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    private MyHashNode<K, V>[] buckets;
    private int capacity = 11;
    private int size;
    public MyHashTable(){
        buckets = new MyHashNode[capacity];
        size = 0;
    }
    public MyHashTable(int capacity){
        this.capacity = capacity;
        buckets = new MyHashNode[capacity];
        size = 0;
    }
    private int hash(K key){

        return (key.hashCode() & 0x7fffffff) % capacity;
    }
    public void put(K key, V value){
        int index = hash(key);
        MyHashNode<K, V> newNode = new MyHashNode<>(key, value);
        if (buckets[index] == null){
            buckets[index] = newNode;
        }
        else{
            newNode.next = buckets[index];
            buckets[index] = newNode;
        }
        size++;
    }
    public V get(K key){
        int index = hash(key);
        MyHashNode<K, V> node = buckets[index];
        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    public V remove(K key){
        int index = hash(key);
        MyHashNode<K, V> prevNode = null;
        MyHashNode<K, V> node = buckets[index];
        while(node != null){
            if(node.key.equals(key)){
                if(prevNode == null){
                    buckets[index] = node.next;
                }
                else{
                    prevNode.next = node.next;
                }
                size--;
                return node.value;
            }
            prevNode = node;
            node = node.next;
        }
        return null;
    }
    public boolean contains(V value){
        return getKey(value) != null;
    }
    public K getKey(V value){
        for(int i = 0; i < capacity; i++){
            MyHashNode<K,V> node = buckets[i];
            while(node != null){
                if(node.value.equals(value)){
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }
}
