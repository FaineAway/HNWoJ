import java.util.HashMap;
import java.util.Map;

public class QuestionBoard {
	private Map<String, QuestionCategory> question_categories;
	
	public QuestionBoard(HashMap constructed_map)
	{
		this.question_categories = constructed_map;
	}
	
	public Question GetNextQuestion(String category)
	{		
		return question_categories.get(category).PullNextQuestion();
	}
}
