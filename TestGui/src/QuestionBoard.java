import java.util.HashMap;
import java.util.Map;

public class QuestionBoard {
	public Map<String, QuestionCategory> question_categories;
	
	public QuestionBoard(HashMap constructed_map)
	{
		this.question_categories = constructed_map;
	}
	
	public Question GetNextQuestion(String category)
	{		
		return question_categories.get(category).PullNextQuestion();
	}

	public String GetIndexCategoryName(int index)
	{
		int indexcounter = 1;
		for (QuestionCategory item : question_categories.values())
		{
			if(indexcounter == index)
			{
				return item.QueryCategory();
			}
			indexcounter++;
		}
		return "HAHAHAH";
	}
}
