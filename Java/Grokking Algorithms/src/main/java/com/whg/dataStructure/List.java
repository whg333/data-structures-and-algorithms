package com.whg.dataStructure;

public interface List<E> extends Collection<E> {
	
	default boolean add(E e) {
		add(size(), e);
		return true;
	}

	void add(int index, E e);
	
	default boolean remove(E e) {
		return remove(indexOf(e)) != null;
	}
	
	E remove(int index);
	
	default boolean has(E e) {
		return indexOf(e) >= 0;
	}
	
	default int indexOf(E e){
		if(e == null || isEmpty()){
			return -1;
		}
		int size = size();
		for(int i=0;i<size;i++){
			if(e.equals(get(i))){
				return i;
			}
		}
		return -1;
	}
	
	default int lastIndexOf(E e){
		if(e == null || isEmpty()){
			return -1;
		}
		int lastIndex = size()-1;
		for(int i=lastIndex;i>=0;i--){
			if(e.equals(get(i))){
				return i;
			}
		}
		return -1;
	}
	
	E get(int index);
	
	E set(int index, E e);
	
}
