
public class Player {
	private int score;
	private String name;
	private boolean has_free_turn;

		
	public Player(String name)
	{
		this.score = 0;
		this.name = name;
	}
	
	public void AddScore(int value_to_add)
	{
		this.score = this.score + value_to_add;
	}
	
	public void Bankrupt()
	{
		this.score = 0;
	}
	
	public void AddFreeTurn()
	{
		this.has_free_turn = true;
	}
	
	public boolean UseFreeTurn()
	{
		if(this.has_free_turn)
		{
			this.has_free_turn = false;
			return true;
		}
		else
			return false;
	}
	
}
