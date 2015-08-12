import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GameDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int player_turn = 1;
		
		// File Parsings
/*		String Category1name = "Cat1";
		String Category2name = "Cat2";
		String Category3name = "Cat3";
		String Category4name = "Cat4";
		String Category5name = "Cat5";
		String Category6name = "Cat6";
		
		String Query1 = "query1";
		String Query2 = "query2";
		String Query3 = "query3";
		String Query4 = "query4";
		String Query5 = "query5";
		
		String Answer1 = "Ans1";
		String Answer2 = "Ans2";
		String Answer3 = "Ans3";
		String Answer4 = "Ans4";
		String Answer5 = "Ans5";
		
		ArrayList<String> answers1 = new ArrayList<String>();
		answers1.add(Answer1);
		ArrayList<String> answers2 = new ArrayList<String>();
		answers2.add(Answer2);
		ArrayList<String> answers3 = new ArrayList<String>();
		answers3.add(Answer3);
		ArrayList<String> answers4 = new ArrayList<String>();
		answers4.add(Answer4);
		ArrayList<String> answers5 = new ArrayList<String>();
		answers5.add(Answer5);
		
		Question question1 = new Question(100, Query1, answers1);
		Question question2 = new Question(100, Query2, answers2);
		Question question3 = new Question(100, Query3, answers3);
		Question question4 = new Question(100, Query4, answers4);
		Question question5 = new Question(100, Query5, answers5);
		
		ArrayList<Question> questions_temp = new ArrayList<Question>();
		
		questions_temp.add(question1);
		questions_temp.add(question2);
		questions_temp.add(question3);
		questions_temp.add(question4);
		questions_temp.add(question5);
		
		QuestionCategory question_cat1 = new QuestionCategory(Category1name);
		QuestionCategory question_cat2 = new QuestionCategory(Category2name);
		QuestionCategory question_cat3 = new QuestionCategory(Category3name);
		QuestionCategory question_cat4 = new QuestionCategory(Category4name);
		QuestionCategory question_cat5 = new QuestionCategory(Category5name);
		QuestionCategory question_cat6 = new QuestionCategory(Category6name);
		
		for(Question item : questions_temp)
		{
			question_cat1.AddQuestion(item);
			question_cat2.AddQuestion(item);
			question_cat3.AddQuestion(item);
			question_cat4.AddQuestion(item);
			question_cat5.AddQuestion(item);
			question_cat6.AddQuestion(item);
		}
		
		HashMap<String, QuestionCategory> q_board = new HashMap<String, QuestionCategory>();
		q_board.put(Category1name, question_cat1);
		q_board.put(Category2name, question_cat2);
		q_board.put(Category3name, question_cat3);
		q_board.put(Category4name, question_cat4);
		q_board.put(Category5name, question_cat5);
		q_board.put(Category6name, question_cat6);
		
		QuestionBoard final_question_board = new QuestionBoard();
		
		// Boom have a populated board... maybe...
*/		
		
    	//parse files
    	ArrayList<String> categoryArray = new ArrayList<String>();
    	ArrayList<Question> questionArray = new ArrayList<Question>();
    	HashMap mapOfQuestionsJeopardy = new HashMap();
    	HashMap mapOfQuestionsDoubleJeopardy = new HashMap();
    	
    	String userDir = System.getProperty("user.dir");
    	String fileName = userDir + "/../ART AND LITERATURE/categories.csv";
		//System.out.println(fileName);
    	categoryArray = ReadCSV.readCSVTitles(fileName);
		//System.out.println(categoryArray);
		
		for (int i=0; i<6; i++){
			String categoryName = categoryArray.get(i);
			QuestionCategory questionCategoryJeopardy = new QuestionCategory(categoryName);
			QuestionCategory questionCategoryDoubleJeopardy = new QuestionCategory(categoryName);
	    	fileName = "C:\\WOJ1\\ART AND LITERATURE\\" + categoryName;
			questionCategoryJeopardy = ReadCSV.getCategoryAndQuestionsJeopardy(fileName);
			questionCategoryDoubleJeopardy = ReadCSV.getCategoryAndQuestionsDoubleJeopardy(fileName);
			//System.out.println("category: " + categoryName);
			
			mapOfQuestionsJeopardy.put(categoryName, questionCategoryJeopardy);
			mapOfQuestionsDoubleJeopardy.put(categoryName, questionCategoryDoubleJeopardy);	
		}
		
		//create question board
		QuestionBoard questionBoardJeopardy = new QuestionBoard(mapOfQuestionsJeopardy);
		QuestionBoard questionBoardDoubleJeopardy = new QuestionBoard(mapOfQuestionsDoubleJeopardy);
    

		
		
		
		String player1_name;
		String player2_name;
		String player3_name;
		
		Scanner scanner = new Scanner(System.in);
		
	    System.out.print("Enter Player 1's Name: ");
	    // get their input as a String
	    player1_name = scanner.next();
	    
	    System.out.print("Enter Player 2's Name: ");
	    // get their input as a String
	    player2_name = scanner.next();
	    
	    System.out.print("Enter Player 3's Name: ");
	    // get their input as a String
	    player3_name = scanner.next();
	    
	    Player player1 = new Player(player1_name);
	    Player player2 = new Player(player2_name);
	    Player player3 = new Player(player3_name);
	    
	    Console console = System.console();
	    
	    
	    while(true)
	    {
	    	Question new_question = questionBoardJeopardy.GetNextQuestion("SCIENCE.csv");
	    	System.out.println();
	    	System.out.println(new_question.toString() + "?: ");
	    	
	    	String playerresponse = scanner.next();
	    	
	    	
	    	if(new_question.CheckAnswer(playerresponse))
	    	{
	    	
	    	}
	    	else
	    	{
	    	
	    	}
	    	
	    	
	    	
	    }
	    
	}
}
