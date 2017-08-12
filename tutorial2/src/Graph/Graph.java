package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {
	
	public static void main(String args[]){
		Graph g = new Graph();
		
		Node UQLake = new Node("UQLake");
		Node Bld78 = new Node("Bld78");
		Node AEB = new Node("AEB");
		Node Wordsmith = new Node("Wordsmith");
		Node Bld50 = new Node("Bld50");
		Node Bld42 = new Node("Bld42");
		Node Bld51 = new Node("Bld51");
		Node Bld7 = new Node("Bld7");
		
		
		g.addNode(UQLake);
		g.addNode(Bld78);
		g.addNode(AEB);
		
		g.addEdge(UQLake, Bld78, 70);
		g.addEdge(UQLake, AEB,50);
		
		g.addNode(Wordsmith);
		
		g.addEdge(Bld78, Wordsmith, 30);
		
		g.addNode(Bld50);
		
		g.addEdge(AEB, Bld50, 15);
		
		g.addEdge(Bld50, AEB, 15);
		g.addEdge(Bld50, Bld7, 40);
		
		g.addNode(Bld42);
		
		g.addEdge(Bld78, Bld42, 20);
		
		g.addNode(Bld51);
		
		g.addEdge(AEB, Bld51, 15);
		g.addEdge(AEB, Bld78, 10);
		
		g.addNode(Bld7);
		
		g.addEdge(Bld42, Bld7, 60);
		g.addEdge(Bld50, Bld7, 40);
		g.addEdge(Bld51, Bld7, 40);
		
		
		System.out.println(g);
		g.ucs(UQLake, Bld7);
	}
	
	private Map<Node, Map<Node, Integer>> adjacencyMap;
	
	public Graph(){
		adjacencyMap = new HashMap<Node, Map<Node, Integer>>();
	}
	
	public void addNode(Node node){
		adjacencyMap.put(node, new HashMap<Node,Integer>());
	}
	
	public void addEdge(Node node1, Node node2, int weight){
	//	if(adjacencyMap.get(node1)!=null){
			adjacencyMap.get(node1).put(node2, weight);
	//	} else {
	//		System.out.println("Add failed");
	//	}
	}
	
	public void ucs(Node start, Node goal){
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		start.visit();
		start.setPath(0);
		pq.add(start);
		while(!pq.isEmpty()){
			Node current = pq.poll();
			
			System.out.println(current);
			current.visit();
			
			if(current.equals(goal)){
				return;
			}
			
			Map<Node, Integer> neighbours = this.getNeighbours(current);
			
			for(Entry<Node, Integer> neighbour : neighbours.entrySet()){
				if(!neighbour.getKey().isVisited()){
					neighbour.getKey().setPath(neighbour.getValue());
					//Node n = new Node(neighbour.getKey());
					//this.addNode(n);
					//System.out.println("n:" + n);
					//Map<Node, Integer> neighbourNeighbours = this.getNeighbours(neighbour.getKey());
					//for(Entry<Node, Integer> neighbourNeighbour : neighbourNeighbours.entrySet()){
					//	this.addEdge(n, neighbour.getKey(), neighbour.getValue());
					//}
					pq.add(neighbour.getKey());
				}
			}
			System.out.println(neighbours);
			System.out.println(pq);
			
		}
	}
	

	
	public void bfs(Node start, Node goal){
		Queue<Node> queue = new LinkedList<Node>();
		start.visit();
		queue.add(start);
		while(!queue.isEmpty()){
			Node current = queue.poll();
			
			System.out.println(current);
			
			current.visit();
			if(current.equals(goal)){
				return;
			}
			Map<Node, Integer> neighbours = this.getNeighbours(current);
			for(Entry<Node, Integer> neighbour : neighbours.entrySet()){
				queue.add(neighbour.getKey());
			}
		}
		
	}
	
	public void dfs(Node start, Node goal){
		Stack<Node> s = new Stack<Node>();
		start.visit();
		s.push(start);
		while(true){
			if(s.isEmpty()){
				return;
			}
			Node t = s.pop();
			t.visit();
			if(t.equals(goal)){
				return;
			}
			Map<Node, Integer> neighbours = this.getNeighbours(t);
			for(Entry<Node,Integer> neighbour : neighbours.entrySet()){
				s.push(neighbour.getKey());
			}
			System.out.println("current node:" + t);
			System.out.println("current stack:" + s);
		}	
	}
	
	public Map<Node, Integer> getNeighbours(Node node){
		Map<Node, Integer> neighbours = adjacencyMap.get(node);
		if(neighbours !=null){
			return neighbours;
		}
		else return new HashMap<Node,Integer>();
	}
	
	public void dfs_recursive(String node, String finish){
		
	}
	
	@Override
	public String toString(){
		String result = "";
		//StringBuilder sb = new StringBuilder("");
		for(Entry<Node, Map<Node, Integer>>  entry : adjacencyMap.entrySet()){
			result += String.format("%s: ", entry.getKey());
			for(Entry<Node, Integer> neighbour : entry.getValue().entrySet()){
				result += String.format("%s = %s, ", neighbour.getKey(), neighbour.getValue().toString());
			}
			result += "\n";
		}
		return result;
	}

}
