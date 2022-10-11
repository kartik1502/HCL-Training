package customhashmap;

public class HashData<K, V> {
    private K key;
    private V value;
    private HashData<K,V> next;
    public HashData(K key, V value, HashData<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public HashData<K, V> getNext() {
        return next;
    }
    public void setNext(HashData<K, V> next) {
        this.next = next;
    }
}