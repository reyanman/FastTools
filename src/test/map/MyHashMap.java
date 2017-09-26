package test.map;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K,V> extends AbstractMap<K, V> implements Map<K,V>{

	transient Entry<K,V>[] table;


	@Override
	public V get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		if(key==null){
			return putForNullKey(value);
		}
		
		int hash = hash(key.hashCode());
		int index = indexFor(hash,table.length);
		
		return null;
	}
	
	static int hash(int h) {
		    h ^= (h >>> 20) ^ (h >>> 12);
		    return h ^ (h >>> 7) ^ (h >>> 4);
	}
	
	private int indexFor(int hash,int length){
		return hash & (length-1);
	}
	
	private void addEntry(int index,int hash,K key,V value){
		
		if(table[index] == null){
			Entry<K,V> e = new Entry<K, V>(hash, key, value, null);
		}else{
			
			for(Entry<K,V> e = table[index];e!=null;e=e.next){
				if(hash(e.getKey().hashCode()) == hash){
					e.value = value;
				}
			}
			
		}
	}
	
	private V putForNullKey(V value){
		for(Entry<K, V> e = table[0];e!=null;e=e.next){
			if(e.key == null){
				e.value = value;
				e.recordAccess(this);
				return value;
			}
		}
		return null;
	}



	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}




	
	
	static class Entry<K,V> implements Map.Entry<K,V> {
        final K key;
        V value;
        Entry<K,V> next;
        int hash;

        /**
         * Creates new entry.
         */
        Entry(int h, K k, V v, Entry<K,V> n) {
            value = v;
            next = n;
            key = k;
            hash = h;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry e = (Map.Entry)o;
            Object k1 = getKey();
            Object k2 = e.getKey();
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = getValue();
                Object v2 = e.getValue();
                if (v1 == v2 || (v1 != null && v1.equals(v2)))
                    return true;
            }
            return false;
        }

        public final int hashCode() {
            return (key==null   ? 0 : key.hashCode()) ^
                   (value==null ? 0 : value.hashCode());
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }

        /**
         * This method is invoked whenever the value in an entry is
         * overwritten by an invocation of put(k,v) for a key k that's already
         * in the HashMap.
         */
        void recordAccess(MyHashMap<K,V> m) {
        }

        /**
         * This method is invoked whenever the entry is
         * removed from the table.
         */
        void recordRemoval(HashMap<K,V> m) {
        }
    }






	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
