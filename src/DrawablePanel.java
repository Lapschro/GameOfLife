
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawablePanel extends JPanel{
	int ncellw;
	int ncellh;
	int cellw;
	int cellh;

	private boolean GETMOUSEPOS;
	private boolean TOADD, TOREMOVE;
	private boolean automatic;
	
	
	public int getCellw(){return cellw;}
	public int getCellh(){return cellh;}

	public void setGMP(boolean a){
		GETMOUSEPOS = a;
	}
	public void setTA(boolean a){
		TOADD =a;
	}
	public void setTR(boolean a){
		TOREMOVE = a;
	}
	
	public boolean getGMP(){
		return GETMOUSEPOS;
	}
	public boolean getTA(){
		return TOADD;
	}
	public boolean getTR(){
		return TOREMOVE;
	}
	
	public void setAuto(boolean a){
		automatic = a;
	}
	
	public boolean getAuto(){
		return automatic;
	}
	
    public DrawablePanel(int w, int h, int cw, int ch) {
		super();
		ncellw = w;
		ncellh = h;
		cellw = cw;
		cellh = ch;
		automatic = false;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(GETMOUSEPOS){
					if(TOADD){
						GameController.getInstance().makeCellAlive(arg0.getX()/cellw, arg0.getY()/cellh);
					}else if (TOREMOVE){
						GameController.getInstance().killCell(arg0.getX()/cellw, arg0.getY()/cellh);
					}
				     //GETMOUSEPOS = false;
				     //TOADD = false;
				     //TOREMOVE = false;
				     repaint();
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				if(GETMOUSEPOS){
					if(TOADD){
						GameController.getInstance().makeCellAlive(e.getX()/cellw, e.getY()/cellh);
					}else if (TOREMOVE){
						GameController.getInstance().killCell(e.getX()/cellw, e.getY()/cellh);
					}
				     //GETMOUSEPOS = false;
				     //TOADD = false;
				     //TOREMOVE = false;
				     repaint();
				}
				
			}
		});
		
		setBackground(Color.DARK_GRAY);
		setBorder(null);
		setLayout(null);
		
		Timer t = new Timer(33, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(automatic){
					GameController.getInstance().nextGeneration();
					repaint();
				}
			}
		});
		t.start();
	}
    
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D aux = (Graphics2D)g;
		aux.setColor(new Color(255, 255, 255));
		for(int i = 0; i < ncellw; i++){
			for(int j = 0; j < ncellh; j++){
				if(GameController.getInstance().getEngine().isCellAlive(i, j)){
					aux.drawRect(i*cellw, j*cellh, cellw, cellh);
					aux.fillRect(i*cellw, j*cellh, cellw, cellh);
				}
			}
		}
	}
}
