package com.whg.dataStructure;

import java.util.EmptyStackException;

public interface IStack<E> extends IList<E>{

	default E push(E e){
		add(e);
		return e;
	}
	
	default E pop(){
		E e = peek();
		remove(e);
		return e;
	}
	
	default E peek(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return get(size()-1);
	}
	
}
