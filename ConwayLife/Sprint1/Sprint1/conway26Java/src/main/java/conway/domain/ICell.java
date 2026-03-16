package main.java.conway.domain;

public interface ICell {
	void setStatus(boolean v); //enità cella ha la capacità di modificare il proprio stato interno a true o false (vivo o morto)
	boolean isAlive();  //entità cella ha la capacità di rispondere a una query per dire se è viva o morta
	void switchCellState(); //entità cella ha la capacità di cambiare stato (da viva a morta e viceversa)
}
