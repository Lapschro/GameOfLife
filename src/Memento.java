
public class Memento {
	
	private final Cell[][] state;
	public Memento(Cell[][] tosave){
		state = tosave;
	}
	
	public Cell[][] getState(){
		return state;
	}
}
