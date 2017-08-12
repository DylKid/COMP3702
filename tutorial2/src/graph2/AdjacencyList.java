package graph2;

import java.util.HashMap;
import java.util.Map;

public class AdjacencyList {
	
	private Map<String, Map<String, Integer>> adj;
	
	public AdjacencyList(){
		adj = new HashMap<String, Map<String,Integer>>();
	}
	
	public void addNode(String node){
		adj.put(node, new HashMap<String,Integer>());
	}
	
	public void removeNode(String node){
		adj.remove(node);
	}
	
	public Map<String, Integer> get(String node){
		return adj.get(node);
	}
	
	public void addEdge(String node1, String node2, Integer weight) throws Exception{
		Map<String, Integer> node1Map = adj.get(node1);
		if(node1Map!=null){
			node1Map.put(node2, weight);
		} else {
			throw new Exception("node1 does not exist in adj");
		}
	}

}
