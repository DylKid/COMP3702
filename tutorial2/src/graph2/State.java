package graph2;

public class State {
	
	private int pathCost;
	private String name;
	
	public State(State state){
		this.pathCost = state.getCost();
		this.name = state.getName();
	}
	
	public State(String name, int pathCost){
		this.name = name;
		this.pathCost = pathCost;
	}
	
	public State(String name){
		this.name = name;
		this.pathCost = Integer.MAX_VALUE;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCost(){
		return pathCost;
	}
	
	public void setPathCost(int cost){
		this.pathCost = cost;
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof State){
			State s1 = (State) other;
			if(s1.getName().equals(this.getName()) && s1.getCost() == this.getCost()){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		int a = 17;
		a += name.hashCode();
		a += pathCost;
		return a;
	}
	
	@Override
	public String toString(){
		return name + " => " + pathCost;
	}
	
	
	
}
