package Graph;

import java.util.Comparator;

public class Node implements Comparator<Object> {
	private String name;
	private boolean visited;
	
	
	public Node(String name){
		this.name = name;
		visited = false;
	}
	
	public void visit(){
		visited = true;
	}
	
	public boolean isVisited(){
		return visited;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public String toString(){
		return name;
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		Node n0 = (Node) arg0;
		Node n1 = (Node) arg1;
		if(n0.getName().equals(n1.getName())){
			return 0;
		}
		else {
			return -1;
		}
	}

}
