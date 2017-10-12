
import java.util.ArrayList;

public class Caretaker {
	private ArrayList<Memento> estados = new ArrayList<Memento>();
	private static Caretaker instance;
	
	public static Caretaker getInstance(){
		if(instance == null){
			instance = new Caretaker();
		}
		return instance;
	}
	
	public void add(Memento m){
		if(estados.size() > 24){
		    estados.remove(0);
		}
		estados.add(m);
	}
	
	public void reset(){
		estados.clear();
	}
	
	public Memento get(boolean back){
		Memento ret;
		if(back){
			if(estados.size() > 0){
				ret = estados.get(estados.size() - 1);
				estados.remove(estados.size() - 1);
			}else
				ret = estados.get(0);
		}else{
			if(estados.size() > 0){
				ret = estados.get(estados.size() - 1);
			}else
				ret = estados.get(0);
		}
		return ret;
	}
	
	public int getnEstados(){return estados.size();}
	
}
