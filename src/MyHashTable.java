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

}
