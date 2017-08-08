package puzzle;

import java.util.Arrays;

public class PuzzleNode{

	private char[][] state;
	private boolean visited;
	
	public PuzzleNode(String set){
		visited = false;
		state = new char[3][3];
		int setIndex = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				state[i][j] = set.charAt(setIndex);
				setIndex++;
			}
		}
	}
	
	public boolean isParityEven(){
		String state = this.stringRep();
		int sum = 0;
		for(int i = 0; i < state.length(); i++){
			int iNum = Character.getNumericValue(state.charAt(i));
			if(state.charAt(i) == '_'){
				continue;
			}
			int count = 0;
			for(int j = i; j < state.length(); j++){
				if(state.charAt(j) == '_'){
					continue;
				} else{
					
					int jNum = Character.getNumericValue(state.charAt(j));
					if(iNum > jNum){
						count++;
					}
				}
			}
			sum+= count;
		}
		return (sum % 2 == 0);
	}
	
	public boolean isVisited(){
		return visited;
	}
	
	public void visit(){
		visited = true;
	}
	
	public PuzzleNode(char[][] state){
		this.state = new char[3][3];
		for(int i = 0; i < 3; i++){
			this.state[i] = state[i].clone();
		}
		visited = false;
	}
	
	public int[] findBlank(){
		int[] ret = new int[2];
		for(int i = 0; i < state.length; i++){
			for(int j = 0; j < state[i].length; j++){
				if(state[i][j] == '_'){
					ret[0] = i;
					ret[1] = j;
					return ret; 
				}
			}
		}
		//SHOULD NEVER GET HERE
		return null;
	}
	
	public PuzzleNode left(){
		int[] blankCoords = this.findBlank();
		
		if(blankCoords[1] == 0){
			return null;
		}
		
		int[] leftCoords = blankCoords.clone();
		leftCoords[1]--;	
		return new PuzzleNode(swap(this.getState(), blankCoords, leftCoords));
	}
	
	private char[][] getState(){
		char[][]stateCpy = new char[3][3];
		
		for(int i = 0; i < state.length; i++){
			stateCpy[i] = state[i].clone();
		}
		
		return stateCpy;
	}
	
	public PuzzleNode right(){
		int[] blankCoords = this.findBlank();
		
		if(blankCoords[1] == 2){
			return null;
		}
		
		int[] rightCoords = blankCoords.clone();
		rightCoords[1]++;
		
		return new PuzzleNode(swap(this.getState(), blankCoords, rightCoords));
	}
	
	public PuzzleNode down(){
		int[] blankCoords = this.findBlank();
		
		if(blankCoords[0] == 2){
			return null;
		}
		
		int[] downCoords = blankCoords.clone();
		downCoords[0]++;
		
		return new PuzzleNode(swap(this.getState(), blankCoords, downCoords));
	}
	
	public PuzzleNode up(){
		int[] blankCoords = this.findBlank();
		
		if(blankCoords[0] == 0){
			return null;
		}
		
		int[] upCoords = blankCoords.clone();
		upCoords[0]--;
		
		return new PuzzleNode(swap(this.getState(), blankCoords, upCoords));
	}
	
	public <T> char[][] swap(char[][] state2, int[] aCoord, int[] bCoord){
		int aRow = aCoord[0];
		int aCol = aCoord[1];
		int bRow = bCoord[0];
		int bCol = bCoord[1];
		
		char temp = state2[aRow][aCol];
		state2[aRow][aCol] = state2[bRow][bCol];
		state2[bRow][bCol] = temp;
		
		return state2;
	}
	
	@Override
	public String toString(){
		String ret = "";
		for(int i = 0; i < state.length; i++){
			ret+= Arrays.toString(state[i]);
			ret+="\n";
		}
		return ret;
	}
	
	public String stringRep(){
		String ret = "";
		for(int i = 0; i < state.length; i++){
			for(int j = 0; j < state[i].length; j++){
				ret+= String.valueOf(state[i][j]);
			}
		}
		return ret;
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof PuzzleNode){
			PuzzleNode pz = (PuzzleNode) other;
			char[][] otherState = pz.getState();
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if(otherState[i][j] != this.state[i][j]){
						return false;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	public int hashCode(){
		int a = 17;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(this.state[i][j] != '_'){
					a *= this.state[i][j];
				}
			}
		}
		return a;
	}

}
