package puzzle;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class Puzzle {
	
	public static void main(String args[]){		
		PuzzleNode s4 = new PuzzleNode("_13425786");
		PuzzleNode e4 = new PuzzleNode("12345678_");
		//testBFSDFS(s4,e4);
	//	dfs(s4,e4);
		
		PuzzleNode s5 = new PuzzleNode("1238_4765");
		PuzzleNode e5 = new PuzzleNode("281_43765");
	//	bfs(s2,e2);
	//	dfs(s5,e5);
		
		//Goal state 1
		PuzzleNode s1 = new PuzzleNode("1348627_5");
		PuzzleNode e1 = new PuzzleNode("1238_4765");
		
		//Goal state 2
		PuzzleNode s2 = new PuzzleNode("281_43765");
		PuzzleNode e2 = new PuzzleNode("1238_4765");
		
		//Goal state 3
		PuzzleNode s3 = new PuzzleNode("281463_75");
		PuzzleNode e3 = new PuzzleNode("1238_4765");
		
		System.out.println("Test number 1");
		testBFSDFS(s1,e1);
		System.out.println("----------------");
		
		System.out.println("Test number 2");
		testBFSDFS(s2,e2);
		System.out.println("----------------");
		
		System.out.println("Test number 3");
		testBFSDFS(s3,e3);
		System.out.println("----------------");
	}
	
	public static void testBFSDFS(PuzzleNode start, PuzzleNode end){
		final long dfsStart = System.nanoTime();
		dfs(start,end);
		final long dfsEnd = System.nanoTime();
		long dfsTime = (dfsEnd - dfsStart)/1000;
		
		final long bfsStart = System.nanoTime();
		bfs(start, end);
		final long bfsEnd = System.nanoTime();
		long bfsTime = (bfsEnd - bfsStart)/1000;
		
		System.out.println("DFS took: " + dfsTime + "ms, BFS took: " + bfsTime + "ms");
		
		dfsTime /= 1000;
		bfsTime /= 1000;
		System.out.println("DFS took: " + dfsTime + " seconds, BFS took: " + bfsTime + " seconds");
		
		dfsTime /= 1000;
		bfsTime /= 1000;
		System.out.println("DFS took: " + dfsTime + " minutes, BFS took: " + bfsTime + " minutes");
		
		
	}
	
	public static void bfs(PuzzleNode start, PuzzleNode end){
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
		int counter = 0;
		Stack<PuzzleNode> unvisited = new Stack<PuzzleNode>();
		HashSet<PuzzleNode> visited = new HashSet<PuzzleNode>();
		
		unvisited.add(start);
		while(unvisited.isEmpty() == false){
			counter++;
			
			PuzzleNode current = unvisited.pop();
			
			unvisited.remove(current);
			visited.add(current);

			//if(counter < 100){
			//	System.out.println("counter:" + counter);	
			//	System.out.println(current);
			//}

	
			if(current.equals(end)){
				System.out.println("Finished!");
				return;
			} else {
				
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
		System.out.println("No solution was found");
		
	}
	
}
