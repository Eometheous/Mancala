package main;
import javax.swing.event.ChangeEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;
import java.awt.*; 
import java.awt.geom.*;

/**
 * The Mancala pits that hold the number of beads each player has
 * @author Andy Wang
 * @version 1.0.1.230420
 */
public class MancalaPit extends JPanel implements ChangeListener {
	private static final int MANCALA_WIDTH = 105;
	private static final int MANCALA_HEIGHT = 230;
	private static final int BEADS_RADIUS = 15;
	private Model<Integer> beadsModel;
	private int mancalaNumber;
	private ArrayList<BeadIcon> theBeads;
	
	/**
	 * Constructor for the MancalaPit
	 * @param model
	 * @param mancalaNumber
	 */
	public MancalaPit(Model<Integer> model, int mancalaNumber) {
		beadsModel = model;
		this.mancalaNumber = mancalaNumber;
		setPreferredSize(new Dimension(MANCALA_WIDTH, MANCALA_HEIGHT));
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
		BeadPainter.paintBeads(theBeads,  this,  g,  MANCALA_WIDTH);
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
