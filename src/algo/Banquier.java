package algo;

public class Banquier {
	
	private Game game;
	
	public Banquier(Game game)
	{
		this.game=game;
	}
	
	public Suggetion process() {
		return new Suggetion(game);
	}

}
