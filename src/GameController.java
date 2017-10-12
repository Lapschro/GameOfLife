
import java.security.InvalidParameterException;

/**
 * Classe que atua como um controlador do 
 * padrao MVC, separando os componentes da 
 * camada de apresentacao e model. 
 * 
 * @author rbonifacio
 */
public class GameController {

	private GameEngine engine;
	private Statistics statistics;
	static private GameController instance;
	
	
	public static GameController getInstance(){
		if(instance == null){
			instance = new GameController();
		}
		return instance;
	}
	
	private GameController(){}
	
	public GameEngine getEngine() {
		return engine;
	}
	
	public void setEngine(GameEngine engine) {
		this.engine = engine;
	}
	

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	public void halt() {
		statistics.display();
		System.exit(0);
	}
	
	public void makeCellAlive(int i, int j) {
		try {
			engine.makeCellAlive(i, j);
		}
		catch(InvalidParameterException e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void killCell(int i, int j) {
		try {
			engine.killCell(i, j);
		}
		catch(InvalidParameterException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void nextGeneration() {
		engine.nextGeneration();
	}
	
}
