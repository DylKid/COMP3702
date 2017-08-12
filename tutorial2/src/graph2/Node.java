package graph2;

import java.util.Comparator;

public class Node implements Comparable<Node>{
	
	private State state;
	private Node parent;
	
	public Node(State state){
		this.state = new State(state);
		parent = null;
	}
	
	
	
	public Node(String name, int pathCost){
		this.state = new State(name, pathCost);
		parent = null;
	}
	
	public Node(String name, int pathCost, Node parent){
		this.state = new State(name, pathCost);
		this.parent = parent;
	}
	
	public void setParent(Node parent){
		this.parent = parent;
	}
	
	public Node getParent(){
		return parent;
	}
	
	public State getState(){
		return state;
	}
	
	@Override
	public String toString(){
		return state.toString();
	}



	@Override
	public int compareTo(Node o1) {
		State s1 = o1.getState();
		State s2 = this.getState();
		
		if(s1.getCost() > s2.getCost()){
			return -1;
		} else if(s1.getCost() < s2.getCost()){
			return 1;
		}
		return 0;
	}

}
