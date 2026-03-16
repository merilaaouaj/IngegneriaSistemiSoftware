package main.java.conway.domain;

public class Life implements LifeInterface{        
    // Un riferimento che punta sempre alla griglia che contiene lo stato attuale
    private Grid currentGrid;
    private Grid nextGrid;
    
   public static LifeInterface CreateGameRules() {
	   return new Life(5, 5); 
	   // Dimensioni di default, possono essere 
	   //lette da un file di configurazione o passate come parametri
   }

    // Costruttore che accetta una griglia pre-configurata (utile per i test)
    /*public Life(boolean[][] initialGrid) {
    	int rows = initialGrid.length; 	//getRows()
        int cols = initialGrid[0].length;	//getCols()
        
        // Inizializziamo entrambe le matrici
        this.currentGrid = new Grid(initialGrid); 
        this.nextGrid = new Grid(rows,cols);  
    }*/

    // Costruttore che crea una griglia vuota di dimensioni specifiche
    public Life(int rows, int cols) {
    	this.currentGrid = new Grid(rows, cols);
        this.nextGrid = new Grid(rows, cols); 
    }

    // Calcola la generazione successiva applicando le 4 regole di Conway
    public void nextGeneration() {
    	// Applichiamo le regole leggendo da currentGrid e scrivendo in nextGrid
        for (int r = 0; r < currentGrid.getRowsNum(); r++) {
            for (int c = 0; c < currentGrid.getColsNum(); c++) {
                int neighbors = currentGrid.countNeighbors(r, c);
                boolean isAlive = currentGrid.getCell(r, c).isAlive();
                //apply rules
                if (isAlive) {
                    nextGrid.setCellValue(r, c,(neighbors == 2 || neighbors == 3));
                } else {
                	nextGrid.setCellValue(r, c, (neighbors == 3));
                }
            }
        }

        // --- IL PING-PONG ---
        // Scambiamo i riferimenti: ciò che era 'next' diventa 'current'
        Grid temp = currentGrid;
        currentGrid = nextGrid;
        nextGrid = temp;
        // Nota: non abbiamo creato nuovi oggetti, abbiamo solo spostato i puntatori
    }
    
  
    // Metodi di utilità per i test
    @Override
    public ICell getCell(int r, int c) { 
    	return currentGrid.getCell(r, c); 
    }
    
    @Override
    public void setCell(int r, int c, boolean state) { 
    	currentGrid.setCellValue(r, c,state); 
    }
    
    @Override
    public IGrid getGrid() { 
    	return currentGrid; 
    }

	@Override
	public boolean isAlive(int row, int col) {
		return currentGrid.getCellValue(row, col);
	}
	

	@Override
	public void resetGrids() {
		currentGrid.reset();
		nextGrid.reset();
	}
	
	@Override
	public String gridRep() {
	    // Recuperiamo i riferimenti alla griglia (assumendo che LifeInterface conosca IGrid)
	    int rows = currentGrid.getRowsNum();
	    int cols = currentGrid.getColsNum();
	    StringBuilder sb = new StringBuilder();

	    for (int r = 0; r < rows; r++) {
	        for (int c = 0; c < cols; c++) {
	            // Accediamo alla cella e controlliamo lo stato
	            ICell cell = currentGrid.getCell(r, c);
	            sb.append(cell.isAlive() ? "O " : ". ");
	        }
	        // Aggiungiamo un a capo alla fine di ogni riga, tranne l'ultima
	        if (r < rows - 1) {
	            sb.append("\n");
	        }
	    }
	    
	    return sb.toString();
	}
	
}