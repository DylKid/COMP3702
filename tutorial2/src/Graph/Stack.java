package Graph;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	
	private List<T> elements;
	
	public Stack(){
		elements = new ArrayList<>();
	}
	
	public void push(T e){
		elements.add(0, e);
	}
	
	public T pop(){
		T ret = elements.remove(0);
		return ret;
	}
	
	public T peek(){
		return elements.get(0);
	}
	
	@Override
	public String toString(){
		String ret = "";
		for(T element : elements){
			ret += element.toString() + ",";
		}
		return ret;
	}
	
	public boolean isEmpty(){
		if(elements.size() == 0){
			return true;
		} else {
			return false;
		}
	}

}
