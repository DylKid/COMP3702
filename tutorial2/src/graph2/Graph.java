package graph2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;


public class Graph {
	
	private AdjacencyList adj;
	private int currentCost;
	

	
	public Graph(){
		adj = new AdjacencyList();
	}
	
	public void setup() throws Exception{
		adj.addNode("AEB");
		adj.addNode("UQLake");
		adj.addNode("Bld78");
		adj.addNode("Bld50");
		adj.addNode("Bld51");
		adj.addNode("Wordsmith");
		adj.addNode("Bld42");
		adj.addNode("Bld7");
		
		adj.addEdge("UQLake", "AEB", 50);
		adj.addEdge("UQLake", "Bld78", 70);
		adj.addEdge("AEB", "Bld78", 10);
		adj.addEdge("AEB", "Bld50", 15);
		adj.addEdge("AEB", "Bld51", 15);
		adj.addEdge("Bld78", "Wordsmith", 30);
		adj.addEdge("Bld78", "Bld42", 20);
		adj.addEdge("Bld42", "Bld50", 10);
		adj.addEdge("Bld42", "Bld7", 60);
		adj.addEdge("Bld50", "Bld7", 40);
		adj.addEdge("Bld50", "AEB", 15);
		adj.addEdge("Bld51", "Bld7", 40);
		
		ucs("UQLake", "Bld7");
		
		
	}
	
	public static void main(String args[]){
		Graph g = new Graph();
		try {
			g.setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pathToNode(Node n){
		Node check = n;
		while(n!=null){
			System.out.println(n);
			n = n.getParent();
		}
	}
	
	public int costToNode(Node n){
		int cost = 0;
		while(n!=null){
			cost += n.getState().getCost();
			n = n.getParent();
		}
		return cost;
	}
	
		
	public void ucs(String start, String end){
		Node s = new Node(start, 0);
		//Queue<Node> frontier = new LinkedList<Node>();
		PriorityQueue<Node> frontier = new PriorityQueue<Node>();
		frontier.add(s);
		HashSet<State> explored = new HashSet<State>();
		while(!frontier.isEmpty()){
			Node current = frontier.poll();
			//System.out.println(current);
			
			if(current.getState().getName().equals(end)){
				pathToNode(current);
				return;
			}
			
			explored.add(current.getState());
			
			Map<String, Integer> neighbours = adj.get(current.getState().getName());
			for(Entry<String, Integer> neighbour : neighbours.entrySet()){
				Node child = new Node(neighbour.getKey(), neighbour.getValue(), current);
				child.getState().setPathCost(costToNode(child));
				if(!explored.contains(child.getState())){
					frontier.add(child);
					//pathToNode(child);
				}
			}
			//System.out.println(frontier);
		}
	}
	

	
	
	
	
}
