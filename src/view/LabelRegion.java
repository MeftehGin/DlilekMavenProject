package view;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelRegion extends JLabel {

	private static String[] REGIONS = { "Ariana", "Beja", "Bizerte", "Ben Arous", "Touzer", "Tatouine", "Tunis",
			"Jendouba", "Zaghouan", "Siliana", "Sousse", "Sidi Bouzid", "Sfax", "Gabes", "Kebili", "Gafsa", "Kasserine",
			"Kairouan", "El kef", "Mednine", "Manouba", "Mahdia", "Monastir", "Nabeul" };
	JLabel label;

	public LabelRegion(int i) {
		label = new JLabel(REGIONS[i]);
		label.setBounds(0, 40, 100, 80);
		label.setHorizontalAlignment(SwingConstants.CENTER);

	}

}
