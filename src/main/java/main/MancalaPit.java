package main;
import javax.swing.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * The Mancala pits that hold the number of beads each player has
 * @author Andy Wang
 * @version 1.1.1.230428
 */
public class MancalaPit extends JPanel implements ChangeListener {
	private static final int MANCALA_WIDTH = 105;
	private static final int MANCALA_HEIGHT = 235;
	private static final int BEADS_RADIUS = 15;
	private Model<Integer> beadsModel;
	private int mancalaNumber;
	private ArrayList<BeadIcon> theBeads;
	private Color color;
	private JLabel numOfBeads;
	
	/**
	 * Constructor for the MancalaPit
	 * @author Andy Wang
	 * @param model
	 * @param mancalaNumber
	 */
	public MancalaPit(Model<Integer> model, int mancalaNumber, Color color) {
		beadsModel = model;
		theBeads = new ArrayList<BeadIcon>();
		for(int i = 0; i < model.get(mancalaNumber); i++) {
			theBeads.add(new BeadIcon(BEADS_RADIUS));
		}
		this.mancalaNumber = mancalaNumber;
		setPreferredSize(new Dimension(MANCALA_WIDTH, MANCALA_HEIGHT));
		setSize(MANCALA_WIDTH, MANCALA_HEIGHT);
		beadsModel.attach(this);

		this.color = color;
		
		setLayout(new BorderLayout());
        numOfBeads = new JLabel(Integer.toString(theBeads.size()));
        numOfBeads.setHorizontalAlignment(SwingConstants.CENTER);
        add(numOfBeads, BorderLayout.NORTH);
	}

	/**
	 * Sets the color of the Mancala Pit
	 * @author Jonathan Stewart Thomas
	 * @param color	the color to be used for this pit
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Paints the mancala with the beads inside
	 *@param g a Graphics object	
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		RoundRectangle2D mancalaPit = new RoundRectangle2D.Double(0, 20, MANCALA_WIDTH, MANCALA_HEIGHT, 75, 75);
		g2.setColor(color);
		g2.fill(mancalaPit);
		BeadPainter.paintBeads(theBeads,  this,  g,  MANCALA_WIDTH, 35);
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
		int expectedBeads = beadsModel.get(mancalaNumber);
		int currBeads = theBeads.size();

		for (int i = 0; i < Math.max(expectedBeads, currBeads); i++) {
		    if (i < expectedBeads && i >= currBeads) {
		        theBeads.add(new BeadIcon(BEADS_RADIUS));
		    } else if (i >= expectedBeads && i < currBeads) {
		        theBeads.remove(theBeads.size() - 1);
		    }
		}
		numOfBeads.setText(Integer.toString(theBeads.size()));
		
		getParent().repaint();
		
	}
}
