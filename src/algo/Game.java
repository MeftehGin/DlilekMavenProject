package algo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import view.MainPanel;

public class Game {

	private MainPanel mainPanel;
	private List<Box> boxes = new ArrayList<>();
	private boolean changeTurn;
	private boolean gameOver;
	private boolean banquierTurn;
	private int numbreBoxopen;
	private String gameOverValue;
	private Banquier banquier = new Banquier(this);
	private Thread tBox;
	private Box box;

	private Box newBox;
	private Box oldBox;

	private List<Integer> numeros = new ArrayList<>(24);

	private static int[] NUMERO = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
			24 };

	public Game(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		numbreBoxopen = 0;
		init();

	}

	public void numbre() {
		for (int i = 0; i < NUMERO.length; i++) {
			numeros.add(NUMERO[i]);
		}
		Collections.shuffle(numeros);
	}

	private void init() {
		numbre();
		for (int i = 0; i < 12; i++) {
			boxes.add(new Box(new Amount(VALUES[i], i, 0), numeros.get(i)));
		}
		for (int i = 12; i < 18; i++) {
			boxes.add(new Box(new Amount(VALUES[i], i, 1), numeros.get(i)));
		}
		for (int i = 18; i < 23; i++) {
			boxes.add(new Box(new Amount(VALUES[i], i, 2), numeros.get(i)));
		}
		boxes.add(new Box(new Amount(VALUES[23], 23, 3), numeros.get(23)));
		Collections.shuffle(boxes);
		Random r = new Random();
		boxes.get(r.nextInt(24)).setMine(true);
	}

	public List<Box> getBoxes() {
		return boxes;
	}

	private static final String[] VALUES = "0.1DT,1DT,5DT,10DT,50DT,75DT,100DT,250DT,300DT,500DT,750DT,1000DT,5.000DT,10.000DT,15.000DT,20.000DT,25.000DT,30.000DT,50.000DT,75.000DT,100.000DT,200.000DT,300.000DT,Milliard"
			.split("\\,");

	public boolean remove(int i) {
		if (changeTurn) {

			oldBox = boxes.stream().filter(box -> box.isMine()).findFirst().get();
			newBox = boxes.get(i);

			boxes.set(boxes.indexOf(oldBox), newBox);
			boxes.set(i, oldBox);

			oldBox.setMine(false);
			newBox.setMine(true);

			changeTurn = false;
			return false;

		} else {

			try {
				tBox.interrupt();
			} catch (Exception e) {
				// TODO: handle exception
			}
			this.box = this.boxes.get(i);
			this.box.getAmount().setUsed(true);
			tBox = new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(3000);
						box = null;
						mainPanel.repaint();
					} catch (InterruptedException e) {
					}
				}
			});
			tBox.start();
			numbreBoxopen++;
			if (numbreBoxopen == 23) {
				gameOver = true;
				gameOverValue = boxes.stream().filter(box -> !box.getAmount().isUsed()).findFirst().get().getAmount()
						.getValue();
				return true;
			}

			if (!gameOver && (numbreBoxopen == 6 || numbreBoxopen == 10 || numbreBoxopen == 14 || numbreBoxopen == 17
					|| numbreBoxopen == 20 || numbreBoxopen == 22)) {
				banquierTurn = true;
			}
			return true;
		}
	}

	public Box getBox() {
		return box;
	}

	public String getGameOverValue() {
		return gameOverValue;
	}

	public void checkBanquier() {
		Random r = new Random();

		if (!gameOver && (numbreBoxopen == 6 || numbreBoxopen == 10 || numbreBoxopen == 14 || numbreBoxopen == 17
				|| numbreBoxopen == 20)) {
			Suggetion sugg = banquier.process();

			Thread t1 = new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(15000);
						JOptionPane.getRootFrame().dispose();
					} catch (InterruptedException e) {
					}
				}
			});
			t1.start();

			int prompt = JOptionPane.showOptionDialog(null,
					"Le Banquier vous propose " + (sugg.isChange() ? "un switch" : sugg.getAmount() + "DT") + "?", "?",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					new String[] { "Accepter", "Refuser" }, "Refuser");
			t1.interrupt();

			if (prompt == JOptionPane.OK_OPTION) {
				if (sugg.isChange()) {
					changeTurn = true;

				} else {
					gameOver = true;
					gameOverValue = sugg.getAmount() + "DT";
					boxes.forEach(box -> {
						if (!box.isMine()) {
							box.getAmount().setUsed(true);
						}
					});
				}

			}
		} else if (numbreBoxopen == 22) {
			int x1 = r.nextInt(4);
			for (int i1 = 0; i1 < x1 && !gameOver; i1++) {
				Suggetion sugg = banquier.process();
				Son.phone();
				Thread t1 = new Thread(new Runnable() {
					public void run() {
						try {
							Thread.sleep(15000);
							JOptionPane.getRootFrame().dispose();
						} catch (InterruptedException e) {
						}
					}
				});
				t1.start();
				int prompt = JOptionPane.showOptionDialog(null,
						"Le Banquier vous propose " + (sugg.isChange() ? "un switch" : sugg.getAmount() + "DT") + "?",
						"?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new String[] { "Accepter", "Refuser" }, "Refuser");
				t1.interrupt();
				if (prompt == JOptionPane.OK_OPTION) {
					if (sugg.isChange()) {
						changeTurn = true;
					} else {
						gameOver = true;
						gameOverValue = sugg.getAmount() + "DT";
					}
				}
			}
		}

		banquierTurn = false;

	}

	public boolean isBanquierTurn() {
		return banquierTurn;
	}

	public int getNumbreBoxopen() {
		return numbreBoxopen;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public int getRound() {
		if (numbreBoxopen <= 6)
			return 1;
		if (numbreBoxopen <= 10)
			return 2;
		if (numbreBoxopen <= 14)
			return 3;
		if (numbreBoxopen <= 17)
			return 4;
		return 5;
	}

	public boolean isChangeTurn() {
		return changeTurn;
	}

	public Box getNewBox() {
		return newBox;
	}

	public Box getOldBox() {
		return oldBox;
	}
}
