
public class Seeds extends GameEngine {

	public Seeds(int height, int width) {
		super(height, width);
	}

	@Override
	protected boolean shouldKeepAlive(int i, int j) {
		return false;
	}

	@Override
	protected boolean shouldRevive(int i, int j) {
		return (!cells[i][j].isAlive() && (numberOfNeighborhoodAliveCells(i, j) == 2));
	}

}
