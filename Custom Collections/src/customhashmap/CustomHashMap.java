package customhashmap;

public class CustomHashMap<K, V>{
    
	private HashData<K,V>[] table;
    private int capacity = 16;
    private int size = 0;

    @SuppressWarnings("unchecked")
	public CustomHashMap() {
        table = new HashData[capacity];
    }
    @SuppressWarnings("unchecked")
	public CustomHashMap(int capacity) {
        this.capacity = capacity;
        table = new HashData[capacity];
    }

    private int index(K key){
        if(key == null)
            return 0;
        return Math.abs(key.hashCode() % capacity);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void put(K key,V value){
        int index = index(key);
        HashData newData = new HashData(key,value,null);
        if(table[index] == null){
            table[index] = newData;
            size++;
        }
        else{
            HashData<K,V> prev = null;
            HashData<K,V> cur = table[index];
            while(cur != null){
                if(cur.getKey().equals(key)){
                    cur.setValue(value);
                    size++;
                    break;
                }
                prev = cur;
                cur = cur.getNext();
            }
            if(prev != null){
                prev.setNext(newData);
                size++;
            }
        }
    }
    
    public V get(K key) {
        int index = index(key);
        V value = null;
        HashData<K,V> entry = table[index];
        while(entry != null ){
            if(entry.getKey().equals(key)){
                value = entry.getValue();
                break;
            }
            entry = entry.getNext();
        }
        return value;
    }
    
    public int size() {
    	return size;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes", "null" })
	public void remove(K key) {
        int index = index(key);
        HashData prev = null;
        HashData entry = table[index];
        while(entry != null){
            if(entry.getKey().equals(key)) {
                if(prev != null) {
                    entry = entry.getNext();
                    table[index] = entry;
                    return;
                }
                else {
                    prev.setNext(entry.getNext());
                    return;
                }
            }
            else{
                System.out.println("Key not found");
            }
            prev = entry;
            entry = entry.getNext();
        }

    }

}

