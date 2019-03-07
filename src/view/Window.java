package view;

import javax.swing.JFrame;

public class Window extends JFrame {

	public Window() {
		super("Dlilek Mlak");
		init();
	}

	private void init() {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setContentPane(new MainPanel());
		this.setVisible(true);
	}

}
