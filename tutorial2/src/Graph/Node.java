package Graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Node implements Comparable<Node> {
	
	private String name;
	private boolean visited;
	private int pathCost;
	private Node parent;
//private Map<Node,Integer> neighbours;
	
	
	public Node(String name){
		this.name = name;
		visited = false;
		pathCost = Integer.MAX_VALUE;
	}
	
	public Node(Node n){
		System.out.println("Creating with " + n.getName());
		this.name = n.getName();
		this.visited = n.isVisited();
		this.pathCost = n.getCost();
		//this.neighbours = new HashMap<Node, Integer>();
		//for(Entry<Node, Integer> entry : n.getNeighbours().entrySet()){
		//	this.neighbours.put(entry.getKey(), entry.getValue());
		//}
	}
	
	public int getCost(){
		return pathCost;
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
	
	/*public void addEdge(Node node2, int weight){
		neighbours.put(node2, weight);
	}
	
	public Map<Node, Integer> getNeighbours(){
		return neighbours;
	}*/
	
	@Override
	public String toString(){
		return String.format("%s => %s", name, pathCost);
	}
	
	public void setPath(int pathCost){
		this.pathCost = pathCost;
	}

	@Override
	public int compareTo(Node n2) {
		if(this.pathCost > n2.pathCost){
			return 1;
		} else if (this.pathCost < n2.pathCost){
			return -1;
		} else {
			return 0;
		}
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof Node){
			Node n1 = (Node) other;
			if(this.getName().equals(n1.getName())){
				return true;
			}
		} 
		return false;
		
	}

}
