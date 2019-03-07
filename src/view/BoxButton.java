package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import algo.Box;
import algo.Game;
import algo.Son;

public class BoxButton extends JPanel {

	private Box box;
	private JButton button;
	private Game game;
	private MainPanel mainPanel;
	private Timer t;
	private Timer t1;
	private JLabel label;

	private int i;

	public BoxButton(int i, MainPanel mainPanel, Game game) {
		this.i = i;
		this.mainPanel = mainPanel;
		this.game = game;
		refresh();
	}

	private static String[] REGIONS = { "Ariana", "Beja", "Bizerte", "Ben Arous", "Touzer", "Tatouine", "Tunis",
			"Jendouba", "Zaghouan", "Siliana", "Sousse", "Sidi Bouzid", "Sfax", "Gabes", "Kebili", "Gafsa", "Kasserine",
			"Kairouan", "El kef", "Mednine", "Manouba", "Mahdia", "Monastir", "Nabeul" };

	public void refresh() {
		this.button = new JButton("" + (game.getBoxes().get(i).getNumberBox())) {
			@Override
			public boolean isEnabled() {
				try {
					return !game.isGameOver() && !game.isBanquierTurn() && !game.getBoxes().get(i).getAmount().isUsed();
				} catch (Exception e) {
					return false;
				}

			}
		};
		if (game != null) {
			this.box = game.getBoxes().get(i);
			this.setBounds(10 + (i % 5) * 105, 10 + (i / 5) * 85, 100, 40);
			if (i >= 20) {

				this.setBounds(65 + (i % 5) * 105, 10 + (i / 5) * 85, 100, 40);
			}
			if (box.isMine()) {
				this.setBounds(200, 450, 100, 40);
				button.setEnabled(false);
			}
			this.button.setBounds(0, 0, 100, 40);

			this.setLayout(null);
			this.button.addActionListener(action -> {
				// box.getAmount().setUsed(true);
				if (!game.isBanquierTurn() && !game.getBoxes().get(i).getAmount().isUsed()) {
					if (game.remove(i)) {
						Son.open();
						t1 = new Timer(1050, actionTimer -> {
							button.setEnabled(false);
							mainPanel.repaint();

							if (this.game.getBoxes().get(i).getAmount().getGroup() == 0) {
								Son.group1();
							} else if (this.game.getBoxes().get(i).getAmount().getGroup() == 1) {
								Son.group2();
							} else if (this.game.getBoxes().get(i).getAmount().getGroup() == 2) {

								Son.group3();

							} else {
								Son.group4();
							}

							if (game.isBanquierTurn()) {
								t = new Timer(4000, actionTimerA -> {
									Son.phone();
									game.checkBanquier();
									t.stop();
									mainPanel.repaint();
								});
								t.start();
							}
							t1.stop();
						});
						t1.start();

					} else {
						button.setEnabled(false);
						mainPanel.repaint();
					}

				}

			});
			this.add(button);
		}

	}

	public int getI() {
		return i;
	}

	public Box getBox() {
		return box;
	}

}
