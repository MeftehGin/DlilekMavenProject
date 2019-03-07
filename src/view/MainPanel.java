package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import algo.Game;

public class MainPanel extends JPanel {

	private Game game;
	private BoxesPanel boxesPanel;
	private DisplayPanel dispalyPanel;

	private static String[] REGIONS = { "Ariana", "Beja", "Bizerte", "Ben Arous", "Touzer", "Tatouine", "Tunis",
			"Jendouba", "Zaghouan", "Siliana", "Sousse", "Sidi Bouzid", "Sfax", "Gabes", "Kebili", "Gafsa", "Kasserine",
			"Kairouan", "El kef", "Mednine", "Manouba", "Mahdia", "Monastir", "Nabeul" };

	public MainPanel() {
		init();
	}

	public void addLabel() {
		for (int i = 0; i < 24; i++) {
			if (game.getBoxes().get(i).isMine()) {
				JLabel label = new JLabel(REGIONS[i]);
				label.setBounds(200, 450, 100, 120);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				this.add(label);
			}

			else if (i < 20) {
				JLabel label = new JLabel(REGIONS[i]);
				label.setBounds(10 + (i % 5) * 105, 10 + (i / 5) * 85, 100, 120);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				this.add(label);
			} else if (i >= 20) {
				JLabel label = new JLabel(REGIONS[i]);
				label.setBounds(65 + (i % 5) * 105, 10 + (i / 5) * 85, 105, 120);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				this.add(label);
			}
		}
	}

	private void init() {
		this.game = new Game(this);
		this.boxesPanel = new BoxesPanel(this, game);
		this.dispalyPanel = new DisplayPanel(this);

		JSplitPane jsp = new JSplitPane();
		jsp.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		jsp.setDividerLocation(550);
		jsp.setRightComponent(dispalyPanel);
		jsp.setLeftComponent(boxesPanel);
		this.addLabel();
		this.setLayout(new BorderLayout());
		this.add(jsp);

	}

	public Game getGame() {
		return game;
	}

	public BoxesPanel getBoxesPanel() {
		return boxesPanel;
	}

	public DisplayPanel getDispalyPanel() {
		return dispalyPanel;
	}

}
