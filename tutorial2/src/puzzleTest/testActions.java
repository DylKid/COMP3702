package puzzleTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import puzzle.PuzzleNode;

public class testActions {
	
	@Test
	public void testLeft(){
		PuzzleNode pz1 = new PuzzleNode("7245_6831");
		
		assertEquals(pz1.left().stringRep(), "724_56831");
		
		assertEquals(pz1.left().left(), null);
		
		
		PuzzleNode pz2 = new PuzzleNode("_72456831");
		assertEquals(pz2.left(), null);
		
		PuzzleNode pz3 = new PuzzleNode("72456831_");
		assertEquals(pz3.left().stringRep(), "7245683_1");
		assertEquals(pz3.left().left().stringRep(), "724568_31");
		assertEquals(pz3.left().left().left(), null);
	}
	
	@Test
	public void testRight(){
		PuzzleNode pz1 = new PuzzleNode("7245_6831");
		
		assertEquals(pz1.right().stringRep(), "72456_831");
		assertEquals(pz1.right().right().stringRep(), "72456_831");
		
		PuzzleNode pz2 = new PuzzleNode("_24756831");
		assertEquals(pz2.right().stringRep(), "2_4756831");
		assertEquals(pz2.right().right().stringRep(), "24_756831");
		assertEquals(pz2.right().right().right().stringRep(), "24_756831");
	}
	
	@Test
	public void testUp(){
		PuzzleNode pz1 = new PuzzleNode("7245_6831");
		
		assertEquals(pz1.up().stringRep(), "7_4526831");
		assertEquals(pz1.up().up().stringRep(), "7_4526831");
		
		PuzzleNode pz2 = new PuzzleNode("724536_81");
		
		assertEquals(pz2.up().stringRep(), "724_36581");
		assertEquals(pz2.up().up().stringRep(), "_24736581");
		assertEquals(pz2.up().up().up().stringRep(), "_24736581");
	}
	
	@Test
	public void testDown(){
		PuzzleNode pz1 = new PuzzleNode("7245_6831");
		
		assertEquals(pz1.down().stringRep(), "7245368_1");
		assertEquals(pz1.down().stringRep(), "7245368_1");
		
		PuzzleNode pz2 = new PuzzleNode("_24736581");
		assertEquals(pz2.down().stringRep(), "724_36581");
		assertEquals(pz2.down().down().stringRep(), "724536_81");
		assertEquals(pz2.down().down().down().stringRep(), "724536_81");
	}
	
}
