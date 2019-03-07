package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import algo.Game;

public class BoxesPanel extends JPanel {

	private MainPanel mainPanel;
	private Game game;
	private BoxButton boxButton;
	
		
	private static String[] REGIONS = { "Ariana", "Beja", "Bizerte", "Ben Arous", "Touzer", "Tatouine", "Tunis",
			"Jendouba", "Zaghouan", "Siliana", "Sousse", "Sidi Bouzid", "Sfax", "Gabes", "Kebili", "Gafsa", "Kasserine",
			"Kairouan", "El kef", "Mednine", "Manouba", "Mahdia", "Monastir", "Nabeul" };
	
	
	
	public BoxesPanel(MainPanel mainPanel,Game game) {
		setLayout(null);
		//setBackground(Color.WHITE);
		this.mainPanel=mainPanel;
		this.game=game;
		refresh();
	}
	
	

	private void refresh() {
		this.removeAll();
		for (int i = 0; i < 24; i++) {
			this.add(boxButton = new BoxButton(i,mainPanel, game));
			
			if(game.isChangeTurn() && boxButton.getBox().equals(game.getOldBox()))
			{
					//boxButton.setBounds(boxButton);
			}
						
		}
		
				
					
	}
	
		
	@Override
	public void paint(Graphics arg0) {
		this.refresh();
		super.paint(arg0);
	}
	
	public BoxButton getBoxButton() {
		return boxButton;
	}
	
	
}
