package main;
import javax.swing.event.ChangeEvent;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;
import java.awt.*; 
import java.awt.geom.*;

/**
 * The Mancala pits that hold the number of beads each player has
 * @author Andy Wang
 * @version 1.0.0.230414
 */
public class MancalaPit extends JPanel implements ChangeListener {
	private static final int MANCALA_WIDTH = 105;
	private static final int MANCALA_HEIGHT = 230;
	private static final int BEADS_RADIUS = 15;
	private Model<Integer> beadsModel;
	private int mancalaNumber;
	
	/**
	 * Constructor for the MancalaPit
	 * @param model
	 * @param mancalaNumber
	 */
	public MancalaPit(Model<Integer> model, int mancalaNumber) {
		beadsModel = model;
		this.mancalaNumber = mancalaNumber;
		setSize(MANCALA_WIDTH, MANCALA_HEIGHT);
		beadsModel.attach(this);
		
	}
	/**
	 * Paints the mancala with the beads inside
	 *@param g a Graphics object	
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		RoundRectangle2D mancalaPit = new RoundRectangle2D.Double(0, 0, MANCALA_WIDTH, MANCALA_HEIGHT, 75, 75);
		g2.setColor(Color.LIGHT_GRAY);
		g2.fill(mancalaPit);
		int y = 15;
		int x = 15;
		int beadsNum = beadsModel.get(mancalaNumber);
		for(int i = 0; i <	beadsNum; i++) {
			BeadIcon aBead = new BeadIcon(15);
			aBead.paintIcon(this, g, x, y);
			x += aBead.getIconWidth() + 5;
			if (x > MANCALA_WIDTH + 2*BEADS_RADIUS) {
				y += aBead.getIconHeight();
				x = 15;
			}
		}
		
	}

	/**
	 * Gets the mancala number 
	 * @return int value of the mancala number
	 */
	public int getMancalaNumber() {
		return this.mancalaNumber;
	}
	/**
	 * Updates the number of beads in the mancala pit
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		repaint();	
		
	}
}
