package Graph;

import java.util.ArrayList;
import java.util.List;

public class Queue <T>{

	private List<T> elements;
	
	public Queue(){
		elements = new ArrayList<T>();
	}
	
	public void enqueue(T element){
		elements.add(element);
	}
	
	public T dequeue(){
		T ret = elements.get(0);
		elements.remove(0);
		return ret;
	}
	
	
}
