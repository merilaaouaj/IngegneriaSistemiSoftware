package main.java.conway.domain;

public interface IGrid {
	  public int getRowsNum(); //+ quante righe ha l'entità grid
	  public int getColsNum(); //+ quante colonne ha l'entità grid
	  public void setCellValue(int x, int y, boolean state); //- 
	  public ICell getCell(int x, int y); //+ 
	  public boolean getCellValue(int x, int y); //ritorna valore della cella 
	  public int countNeighbors(int row, int colums); //numero di celle vive adiacenti
	  public void reset(); //- riporta le celle allo stato (morte) 
}
