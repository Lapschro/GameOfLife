
public class DayandNight extends GameEngine {

	public DayandNight(int height, int width) {
		super(height, width);
	}


	@Override
	protected boolean shouldKeepAlive(int i, int j) {
		return (cells[i][j].isAlive() && ((numberOfNeighborhoodAliveCells(i, j) == 3) 
				|| numberOfNeighborhoodAliveCells(i, j) == 6
				|| (numberOfNeighborhoodAliveCells(i, j) == 7) 
				|| numberOfNeighborhoodAliveCells(i, j) == 8));
	}
	

	@Override
	protected boolean shouldRevive(int i, int j) {
		return (cells[i][j].isAlive() && ((numberOfNeighborhoodAliveCells(i, j) == 3) 
				|| numberOfNeighborhoodAliveCells(i, j) == 4
				|| (numberOfNeighborhoodAliveCells(i, j) == 6) 
				|| numberOfNeighborhoodAliveCells(i, j) == 7
				|| numberOfNeighborhoodAliveCells(i, j) == 8));
	}

}
