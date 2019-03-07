package algo;

import java.util.Random;

public class Suggetion {

	private boolean change;
	private double amount;

	public Suggetion(Game game) {
		int x = new Random().nextInt(10);
		if (x < 3) {
			this.change = true;
		} else {
			this.amount = game.getBoxes().stream().filter(box -> !box.getAmount().isUsed()).mapToDouble(box -> {
				String value = box.getAmount().getValue().replaceAll("DT", "").replaceAll(" ", "").trim();
				if (value.equals("Milliard")) {
					return 1000000d;
				}
				if (value.equals("0.1")) {
					return 0.1d;
				}
				value = value.replaceAll("\\.", "");
				return Double.parseDouble(value);
			}).sum();
			this.amount = this.amount / (24 - game.getNumbreBoxopen()) * game.getRound() / 10;
			if (this.amount > 1000) {
				this.amount = (((int) this.amount) / 1000) * 1000;
			}
		}
	}

	public boolean isChange() {
		return change;
	}

	public double getAmount() {
		return amount;
	}

}
