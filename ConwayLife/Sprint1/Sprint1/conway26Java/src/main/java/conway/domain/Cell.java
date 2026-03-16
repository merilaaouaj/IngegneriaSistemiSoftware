package main.java.conway.domain;

public class Cell implements ICell{
	 //rappresentazione concreta di una cella
	private boolean value;
	
	public Cell() {
		this.value = false; //assumo ogni cella creata inizialmente sia morta
	}

	public Cell(boolean b) {
		this.value = b;  //nel caso per specificare stato in cui nasce una cella
	}

	@Override
	public boolean isAlive() {
		return value;
	}

	@Override
	public void setStatus(boolean status) {
		value = status;
	}

	@Override
	public void switchCellState() {
		value = !value;				
	}

}