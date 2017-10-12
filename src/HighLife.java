
public class HighLife extends GameEngine {

	public HighLife(int height, int width) {
		super(height, width);
	}

	@Override
	protected boolean shouldKeepAlive(int i, int j) {
		return (cells[i][j].isAlive() 
				&& ((numberOfNeighborhoodAliveCells(i, j) == 3) 
				|| numberOfNeighborhoodAliveCells(i, j) == 2));
	}

	@Override
	protected boolean shouldRevive(int i, int j) {
		return (!cells[i][j].isAlive() 
				&& (numberOfNeighborhoodAliveCells(i, j) == 6 
				|| numberOfNeighborhoodAliveCells(i, j) == 3));
	}

}
