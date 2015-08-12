import java.util.ArrayList;

public class Question {
	private int value;
	private String query;
	private ArrayList<String> answer_bank;
	
	public Question(int value, String query, ArrayList<String> answer_bank)
	{
		this.value = value;
		this.query = query;
		this.answer_bank = answer_bank;
	}
	
	public boolean CheckAnswer(String response)
	{
		int success = 0;
		for(String temp : this.answer_bank)
		{
			if(temp.equals(response))
				success = success + 1;
		}
		if(success > 0)
			return true;
		else
			return false;
	}
	
	@Override public String toString() {
			return query;
	  }
	
	public int QueryValue()
	{
		return this.value;
	}	
}
