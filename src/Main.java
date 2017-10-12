
public class Main {

	public static void main(String args[]){
		
		GameEngine engine = GoLFactory.getInstance().getType(0 , 64, 64);	
		
		GameController.getInstance().setEngine(engine);
		
		Window frame = new Window(512, 512, 64, 64);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
