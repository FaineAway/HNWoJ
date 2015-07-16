import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class QuestionCategory {
	//private int index;
	private String category;
	private Queue<Question> question_pool;
	
	public QuestionCategory(String category, ArrayList<Question> questions)
	{
		//this.index = 0;
		this.category = category;
		this.question_pool = new LinkedList<Question>();
	}
	
	public boolean AddQuestion(Question question_to_add)
	{
		if(question_pool.size() < 5)
		{
			question_pool.add(question_to_add);
			return true;
		}
		else 
			return false;
	}
	
	public Question PullNextQuestion()
	{
		return question_pool.poll();
	}
	
	public String QueryCategory()
	{
		return this.category;
	}
}
