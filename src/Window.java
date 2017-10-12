
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame {

	private DrawablePanel contentPane;
	String name = "Game Of Life";
	String nameofrule;
	
	
	public Window(int w, int h, final int celw, final int celh) {
		setLocationRelativeTo(null);
		setResizable(false);
		
		setTitle("Game Of Life");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 630, 492);
		
		contentPane = new DrawablePanel(celw, celh, w/celw, h/celh);		
		
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(506, 0, 117, 462);
		contentPane.add(panel);
		
		JButton AdicionarCel = new JButton("Adicionar");
		panel.add(AdicionarCel);
		
		JButton remCel = new JButton("Remover");
		panel.add(remCel);
		
		JButton antB = new JButton("<-");
		panel.add(antB);
		antB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameController.getInstance().getEngine().returnToLastState();
				contentPane.repaint();
			}
		}
		);
		
		JButton proxB = new JButton("->");
		panel.add(proxB);
		
		JButton btnConway = new JButton("Conway");
		panel.add(btnConway);
		
		JButton btnHiglife = new JButton("HighLife");
		panel.add(btnHiglife);
		
		JButton btnDayNNight = new JButton("Day n Night");
		panel.add(btnDayNNight);
		
		JButton btnSeeds = new JButton("Seeds");
		panel.add(btnSeeds);
		
		JButton btnAuto = new JButton("Auto");
		panel.add(btnAuto);
		
		btnConway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Caretaker.getInstance().add(GameController.getInstance().getEngine().SaveToMemento());
				GameController.getInstance().setEngine(GoLFactory.getInstance().getType(0, celh,celw));
				GameController.getInstance().getEngine().returnToLastState();
				nameofrule = " Conway";
				setTitle(name+nameofrule+" Auto: "+contentPane.getAuto() + ((contentPane.getTA())?" Adding Cells":" Removing Cells"));
				contentPane.repaint();
			}
		});
		
		btnSeeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Caretaker.getInstance().add(GameController.getInstance().getEngine().SaveToMemento());
				GameController.getInstance().setEngine(GoLFactory.getInstance().getType(3, celh,celw));
				GameController.getInstance().getEngine().returnToLastState();
				nameofrule = " Seeds";
				setTitle(name+nameofrule+" Auto: "+contentPane.getAuto() + ((contentPane.getTA())?" Adding Cells":" Removing Cells"));
				contentPane.repaint();
			}
		});
		
		btnAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setAuto(!contentPane.getAuto());
				setTitle(name+nameofrule+" Auto: "+contentPane.getAuto() + ((contentPane.getTA())?" Adding Cells":" Removing Cells"));
			}
		});
		
		btnHiglife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Caretaker.getInstance().add(GameController.getInstance().getEngine().SaveToMemento());
				GameController.getInstance().setEngine(GoLFactory.getInstance().getType(1, celh,celw));
				GameController.getInstance().getEngine().returnToLastState();
				nameofrule = " HighLife";
				setTitle(name+nameofrule+" Auto: "+contentPane.getAuto() + ((contentPane.getTA())?" Adding Cells":" Removing Cells"));
				contentPane.repaint();
			}
		});
		
		btnDayNNight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Caretaker.getInstance().add(GameController.getInstance().getEngine().SaveToMemento());
				GameController.getInstance().setEngine(GoLFactory.getInstance().getType(2, celh,celw));
				GameController.getInstance().getEngine().returnToLastState();
				nameofrule = " Day n Night";
				setTitle(name+nameofrule+" Auto: "+contentPane.getAuto() + ((contentPane.getTA())?" Adding Cells":" Removing Cells"));
				contentPane.repaint();
			}
		});
		
		
		
		proxB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameController.getInstance().nextGeneration();
				contentPane.repaint();
			}
		});
		
		
		remCel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setGMP(true);
			     contentPane.setTA(false);
			     contentPane.setTR(true);
			     setTitle(name+nameofrule+" Auto: "+contentPane.getAuto() + ((contentPane.getTA())?" Adding Cells":" Removing Cells"));
			}
		});
		AdicionarCel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setGMP(true);
			     contentPane.setTA(true);
			     contentPane.setTR(false);
			     setTitle(name+nameofrule+" Auto: "+contentPane.getAuto() + ((contentPane.getTA())?" Adding Cells":" Removing Cells"));
			}
		});
		
		contentPane.setFocusable(true);
		
	}
}
