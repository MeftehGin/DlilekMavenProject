package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import algo.Box;

public class DisplayPanel extends JPanel {

	private MainPanel mainPanel;

	public DisplayPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		setBackground(Color.RED);
		setOpaque(true);

	}

	@Override
	public void paintComponent(Graphics g) {
		List<Box> boxes = this.mainPanel.getGame().getBoxes();
		for (Box box : boxes) {
			int positionX = box.getAmount().getIndex() < 12 ? 0
					: box.getAmount().isUsed() ? this.getWidth() - 10 : this.getWidth() - 100;
			int positionY = 10 + ((box.getAmount().getIndex() % 12) * 35);
			int sizeX = box.getAmount().isUsed() ? 10 : 100;
			int sizeY = 30;

			g.setColor(SHADOWS[box.getAmount().getGroup()]);
			g.fillRect(positionX + (box.getAmount().getIndex() < 12 ? 0 : -2), positionY, sizeX + 2, sizeY + 2);

			g.setColor(COLORS[box.getAmount().getGroup()]);
			g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC | Font.CENTER_BASELINE, 16));
			g.fill3DRect(positionX, positionY, sizeX, sizeY, true);
			g.fillRect(positionX, positionY, sizeX, sizeY);
			if (!box.getAmount().isUsed()) {
				g.setColor(Color.WHITE);
				g.drawString(box.getAmount().getValue(), positionX + (box.getAmount().getIndex() < 12 ? 30 : 10),
						positionY + 20);
			}
		}
		Box box = this.mainPanel.getGame().getBox();
		if (box != null) {
			int positionX = this.getWidth() / 2 - 50;
			int positionY = this.getHeight() / 2 - 20;
			int sizeX = 100;
			int sizeY = 40;

			g.setColor(SHADOWS[box.getAmount().getGroup()]);
			g.fillRect(positionX + (box.getAmount().getIndex() < 12 ? 0 : -2), positionY, sizeX + 2, sizeY + 2);

			g.setColor(COLORS[box.getAmount().getGroup()]);
			g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC | Font.CENTER_BASELINE, 16));
			g.fill3DRect(positionX, positionY, sizeX, sizeY, true);
			g.fillRect(positionX, positionY, sizeX, sizeY);
			g.setColor(Color.WHITE);
			g.drawString(box.getAmount().getValue(), positionX + (box.getAmount().getIndex() < 12 ? 30 : 10),
					positionY + 20);
			super.paintComponents(g);
		}
		if (mainPanel.getGame().isGameOver()) {
			int positionX = this.getWidth() / 2 - 50;
			int positionY = this.getHeight() / 2 - 20;
			int sizeX = 100;
			int sizeY = 40;

			g.setColor(SHADOWS[3]);
			g.fillRect(positionX - 2, positionY, sizeX + 2, sizeY + 2);

			g.setColor(COLORS[3]);
			g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC | Font.CENTER_BASELINE, 16));
			g.fill3DRect(positionX, positionY, sizeX, sizeY, true);
			g.fillRect(positionX, positionY, sizeX, sizeY);
			g.setColor(Color.WHITE);
			g.drawString(mainPanel.getGame().getGameOverValue(), positionX + 20, positionY + 20);
			super.paintComponents(g);
		}
	}

	private final Color[] COLORS = { new Color(17, 77, 150), new Color(232, 182, 145), new Color(167, 0, 0),
			new Color(163, 148, 60) };
	private final Color[] SHADOWS = { new Color(0, 13, 60), new Color(186, 86, 37), new Color(99, 0, 4),
			new Color(104, 73, 9) };

}
