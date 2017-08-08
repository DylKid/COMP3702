package puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Puzzle {
	
	public static void main(String args[]){		
		PuzzleNode s4 = new PuzzleNode("_13425786");
		PuzzleNode e4 = new PuzzleNode("12345678_");
		//testBFSDFS(s4,e4);
		//dfs(s4,e4);
		
		PuzzleNode s5 = new PuzzleNode("1238_4765");
		PuzzleNode e5 = new PuzzleNode("281_43765");
		//bfs(s2,e2);
		dfs(s5,e5);
		
		//Goal state 1
		PuzzleNode s1 = new PuzzleNode("1348627_5");
		PuzzleNode e1 = new PuzzleNode("1238_4765");
		//dfs(s1,e1);
		
		//Goal state 2
		PuzzleNode s2 = new PuzzleNode("281_43765");
		PuzzleNode e2 = new PuzzleNode("1238_4765");
		//dfs(s2,e2);
		
		//Goal state 3
		PuzzleNode s3 = new PuzzleNode("281463_75");
		PuzzleNode e3 = new PuzzleNode("1238_4765");
		//dfs(s3,e3);
		
		/*System.out.println("Test number 1");
		testBFSDFS(s1,e1);
		System.out.println("----------------");
		
		System.out.println("Test number 2");
		testBFSDFS(s2,e2);
		System.out.println("----------------");
		
		System.out.println("Test number 3");
		testBFSDFS(s3,e3);
		System.out.println("----------------");*/
	}
	
	public static boolean isDoable(PuzzleNode start, PuzzleNode end){
		if(start.isParityEven() == end.isParityEven()){
			return true;
		} else {
			return false;
		}
	}
	
	public static void testBFSDFS(PuzzleNode start, PuzzleNode end){
		final long dfsStart = System.nanoTime();
		dfs(start,end);
		final long dfsEnd = System.nanoTime();
		long dfsTime = (dfsEnd - dfsStart)/1000000;
		
		final long bfsStart = System.nanoTime();
		bfs(start, end);
		final long bfsEnd = System.nanoTime();
		long bfsTime = (bfsEnd - bfsStart)/1000000;
		
		System.out.println("DFS took: " + dfsTime + "ms, BFS took: " + bfsTime + "ms");
		
		dfsTime /= 1000;
		bfsTime /= 1000;
		System.out.println("DFS took: " + dfsTime + " seconds, BFS took: " + bfsTime + " seconds");
		
		dfsTime /= 60;
		bfsTime /= 60;
		System.out.println("DFS took: " + dfsTime + " minutes, BFS took: " + bfsTime + " minutes");
	}
	
	public static void bfs(PuzzleNode start, PuzzleNode end){
		
		if(isDoable(start, end) == false){
			System.out.println("Not possible, parities are not equal");
			return; 
		}
		
		int counter = 0;
		Queue<PuzzleNode> unvisited = new LinkedList<PuzzleNode>();
		HashSet<PuzzleNode> visited = new HashSet<PuzzleNode>();
		
		unvisited.add(start);
		while(unvisited.isEmpty() == false){
			counter++;
			
			PuzzleNode current = unvisited.remove();
			
			/*if(counter % 100 == 0){
				System.out.println("Counter:"  + counter);
				System.out.println(current);
			}*/
			
			visited.add(current);
			
			if(current.equals(end)){
				//System.out.println("Counter:"  + counter);
				//System.out.println(current);
				//System.out.println("Finished!");
				System.out.println("BFS count:" + counter);
				return;
			}

			PuzzleNode temp;
			
			temp = current.left();
			if(temp!=null && visited.add(temp)){
				unvisited.add(temp);
			}
			temp = current.right();
			if(temp!=null && visited.add(temp)){
				unvisited.add(temp);
			}
			temp = current.up();
			if(temp!=null && visited.add(temp)){
				unvisited.add(temp);
			}
			temp = current.down();
			if(temp!=null && visited.add(temp)){
				unvisited.add(temp);
			}
		}
		
	}
	
	public static void dfs(PuzzleNode start, PuzzleNode end){
		//check if it's doable using the parity check
		if(isDoable(start, end) == false){
			System.out.println("Not possible, as the parities of the start and end node are not equal");
			return;
		}
		
		int counter = 0;
		Stack<PuzzleNode> unvisited = new Stack<PuzzleNode>();
		HashMap<PuzzleNode, PuzzleNode> parentMap = new HashMap<PuzzleNode, PuzzleNode>();
		
		//set the initial vertex as the root of the search tree
		parentMap.put(start, null);
		//push the initial vertex to the stack
		unvisited.add(start);
		
		while(unvisited.isEmpty() == false){
			counter++;
			
			//current = front of the stack, also, remove t from the stack
			PuzzleNode current = unvisited.pop();

			if(counter % 1000  == 0){
				System.out.println("counter:" + counter);	
				System.out.println(current);
			}

			//if current is the goal, then return 
			if(current.equals(end)){
				System.out.println(current);
				System.out.println("Finished!");
				System.out.println("DFS Count:" + counter);
				return;
				
			} else {
				//For each successor (left, right, up, and down)
				PuzzleNode temp;
				
				temp = current.left();				
				//if the node is possible (i.e. not null), and 
				//it is not in the path to the current node 
				if(temp!=null && !parentMap.containsValue(temp)){
					//push it to the stack
					unvisited.push(temp);
					//put temp as a child of current in the search tree 
					parentMap.put(temp, current);
				}
				
				//do the same for right up and down 
				temp = current.right();
				if(temp!=null && !parentMap.containsValue(temp)){
					unvisited.push(temp);
					parentMap.put(temp, current);
				}
				
				temp = current.up();
				if(temp!=null && !parentMap.containsValue(temp)){
					unvisited.push(temp);
					parentMap.put(temp, current);
				}
				
				temp = current.down();
				if(temp!=null && !parentMap.containsValue(temp)){
					unvisited.push(temp);
					parentMap.put(temp, current);
				}
			}
		}
		System.out.println("No solution was found");
	}
	
}
