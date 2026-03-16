package main.java.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.conway.domain.IGrid;
import main.java.conway.domain.Life;
import main.java.conway.domain.LifeInterface;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
 

public class LifeTest {
private LifeInterface lifeModel;

	@Before
	public void setup() {
		System.out.println("GridTest | setup");	
		lifeModel = new Life(5, 5);
	}

	@After
	public void down() {
		System.out.println("GridTest | down");
	}
	
	@Test
	public void testSetCellAlive() {
	    
	    lifeModel.setCell(2, 3, true);
	
	    assertTrue(lifeModel.isAlive(2, 3));
	}
	
	@Test
	public void testSetCellDead() {
	
	    lifeModel.setCell(1, 1, false);
	
	    assertFalse(lifeModel.isAlive(1, 1));
	}
	
	@Test
	public void testLonelyCellDies() {
	
	    lifeModel.setCell(1, 1, true);
	
	    lifeModel.nextGeneration();
	
	    assertFalse(lifeModel.isAlive(1, 1));
	}
	
	@Test
	public void testBlockStillLife() {
	
		lifeModel.setCell(1,1,true);
		lifeModel.setCell(1,2,true);
		lifeModel.setCell(2,1,true);
		lifeModel.setCell(2,2,true);
	
		lifeModel.nextGeneration();
	
	    assertTrue(lifeModel.isAlive(1,1));
	    assertTrue(lifeModel.isAlive(1,2));
	    assertTrue(lifeModel.isAlive(2,1));
	    assertTrue(lifeModel.isAlive(2,2));
	}
	
	@Test
	public void testReset() {
	
		lifeModel.setCell(2,2,true);
	
		lifeModel.resetGrids();
	
	    assertFalse(lifeModel.isAlive(2,2));
	}
	
	@Test
	public void testGetGrid() {
	
	    IGrid grid = lifeModel.getGrid();
	
	    assertNotNull(grid);
	}

}