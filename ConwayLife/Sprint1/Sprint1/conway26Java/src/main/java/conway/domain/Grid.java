package main.java.conway.domain;
import java.util.Arrays;
import java.util.stream.Collectors;
import unibo.basicomm23.utils.CommUtils;

public class Grid implements IGrid{

	private int rows;
	private int cols;
	private ICell[][] grid;
	
	public Grid(int rows, int cols) {
		this.rows=rows;
		this.cols=cols;
		this.grid=new ICell[rows][cols];
		for (int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				this.grid[i][j]=new Cell();
			}
		}
	}
	  
	  @Override
	  public int getRowsNum() {
		  return this.rows;
	  }
	  
	  @Override
	  public int getColsNum() {
		  return this.cols;
	  }

		@Override
		public ICell getCell(int row, int column) {
			return this.grid[row][column];
		}

		@Override
		public void setCellValue(int row, int column, boolean state) {
			this.grid[row][column].setStatus(state);
		}

		@Override
		public boolean getCellValue(int row, int column) {
			return this.grid[row][column].isAlive();
		}
		
		@Override
		public int countNeighbors(int row, int colums) {
			int count = 0;
			
	        for (int i = -1; i <= 1; i++) {
	            for (int j = -1; j <= 1; j++) {
	                
	                if (i == 0 && j == 0) continue;

	                int neighborRow = row + i;
	                int neighborCol = colums + j;

	                if (neighborRow >= 0 && neighborRow < rows && neighborCol >= 0 && neighborCol < cols) {
	                    
	                    if (grid[neighborRow][neighborCol].isAlive()) {
	                        count++;
	                    }
	                }
	            }
	        }
	        return count;
		}
		
		@Override
		  public void reset() {
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						grid[i][j].setStatus(false);
					}
				}
		  }
		
		@Override
		public String toString() {
		    StringBuilder sb = new StringBuilder();

		    for (int i = 0; i < rows; i++) {
		        for (int j = 0; j < cols; j++) {
		            
		            if (grid[i][j].isAlive()) {
		                sb.append("*");
		            } else {
		                sb.append(".");
		            }

		            if (j < cols - 1) {
		                sb.append(" ");
		            }
		        }

		        if (i < rows - 1) {
		            sb.append("\n");
		        }
		    }

		    return sb.toString();
		}
	}