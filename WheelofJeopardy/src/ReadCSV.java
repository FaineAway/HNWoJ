import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV{
	
	public static ArrayList<Question> readCSVCategory(String fileName) {

		BufferedReader fileReader = null;
		ArrayList<Question> questionArray = new ArrayList<Question>();
        try {
        	
        	//Create a new list of student to be filled by CSV file data 

        	
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));
            
            //Read the CSV file header to skip it
            fileReader.readLine();
           
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
            	
                String[] tokens = line.split(",");
                if (tokens.length > 0) {
                	//Create a new student object and fill his  data
                	//System.out.println("question: " + tokens[1]);
                	//int numAnswers = Integer.parseInt(tokens[2]);
                	
                	ArrayList<String> answersArray = new ArrayList<String>();
                	String query = tokens[1];
                	int numAnswers = Integer.parseInt(tokens[2]);
                	
                	//ArrayList<String> answersArray = new ArrayList<String>();
                	for (int j= 0 ; j<numAnswers; j++){
                			answersArray.add(tokens[j+3]);
                	}
                	Question question = new Question(100, query, answersArray);
                	questionArray.add(question);
					//System.out.println("answers: " + answersArray);
				} 
            }
            
        } 
        catch (Exception e) {
        	System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return questionArray;

	}
	
	public static ArrayList<String> readCSVTitles(String fileName) {

		BufferedReader fileReader = null;
		ArrayList<String> categoryArray = new ArrayList<String>();
        try {
        	
        	//Create a new list of student to be filled by CSV file data 
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));
           
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
            	
                String[] tokens = line.split(",");
                if (tokens.length > 0) {
                	//Create a new student object and fill his  data
                	//System.out.println("question: " + tokens[1]);
                	//int numAnswers = Integer.parseInt(tokens[2]);
                	
                	ArrayList<String> answersArray = new ArrayList<String>();
                	String category = tokens[0];
                	            	
                	categoryArray.add(category);
					//System.out.println("answers: " + answersArray);
				} 
            }
            
        } 
        catch (Exception e) {
        	System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return categoryArray;

	}
	
	public static QuestionCategory getCategoryAndQuestions(String fileName) {
		
		ArrayList<Question> questionArray = new ArrayList<Question>();
		questionArray = readCSVCategory(fileName);
		//System.out.println("category: " + questionArray);
		QuestionCategory questionCategory = new QuestionCategory("history");
		for (int i=0; i<5; i++){
			boolean didItWork = questionCategory.AddQuestion(questionArray.get(i));
			//System.out.println("question: " + questionArray.get(i));
		}
		return questionCategory;
	}
}