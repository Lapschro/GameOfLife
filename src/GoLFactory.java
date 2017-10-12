
public class GoLFactory {
	static GoLFactory instance;
	
	public static GoLFactory getInstance(){
		if(instance == null)
			instance = new GoLFactory();
		return instance;
	}
	
	public GameEngine getType(int type, int height, int width){
		switch(type){
		case 0:
			return new Conway(height, width);
		case 1:
			return new HighLife(height, width);
		case 2:
			return new DayandNight(height, width);
		case 3:
			return new Seeds(height, width);
		}
		return null;
	}
}
