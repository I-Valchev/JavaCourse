import java.util.HashMap;


public class MyHashMap<K, V> extends HashMap<K,V>{
	/**
	 * @author Ivo Valchev
	 */
	private static final long serialVersionUID = 1L;
	private boolean allowNullKeys, allowNullValues = false;
	
	MyHashMap(boolean allowNullKeys, boolean allowNullValues){
		this.allowNullKeys = allowNullKeys;
		this.allowNullValues = allowNullValues;
	}
	
	MyHashMap(){}
	
	@Override
	public V put(K key, V value){
		
		if(!allowNullKeys && key == null){
			try {
				throw new IllegalHashKeyException();
			} catch (IllegalHashKeyException e) {
				e.printStackTrace();
			}
		}
		
		if(!allowNullValues && value == null){
			try {
				throw new IllegalHashValueException();
			} catch (IllegalHashValueException e) {
				e.printStackTrace();
			}
		}
		
		return super.put(key, value);
	}
	
	@Override
	public V get(Object key){
		if(!allowNullKeys && key == null){
			try {
				throw new IllegalHashKeyException();
			} catch (IllegalHashKeyException e) {
				e.printStackTrace();
			}
		}
		
		return super.get(key);
	}
	
	public static void main(String [] args){
		MyHashMap<String, Integer> myHash = new MyHashMap<String, Integer>();
		myHash.put("Abv", 123);
		myHash.put(null, 547);
	}
}
