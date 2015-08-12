import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by hatchjm1 on 6/23/2015.
 */
public class Better {
    private JButton NEWGAMEButton;
    private JLabel WHEELOFJEOPARDYLabel;
    private JButton EXITButton;
    private JPanel GamePanel;
    private JPanel PicturePanel;
    private JLabel Wheel;
    private JButton CategoryAbutton;
    private JButton CategoryBbutton;
    private JButton CategoryCbutton;
    private JButton CategoryDbutton;
    private JButton CategoryEbutton;
    private JButton CategoryFbutton;
    private JLabel A5textbox;
    private JLabel B5textbox;
    private JLabel C5textbox;
    private JLabel D5textbox;
    private JLabel E5textbox;
    private JLabel F5textbox;
    private JLabel A4textbox;
    private JLabel A3textbox;
    private JLabel A2textbox;
    private JLabel A1textbox;
    private JLabel B1textbox;
    private JLabel B2textbox;
    private JLabel B3textbox;
    private JLabel B4textbox;
    private JLabel C1textbox;
    private JLabel C2textbox;
    private JLabel player1Label;
    private JLabel player2Label;
    private JLabel player3Label;
    private JLabel playerAScore;
    private JLabel playerBScore;
    private JButton SPINButton;
    private JLabel C3textbox;
    private JLabel C4textbox;
    private JLabel D1textbox;
    private JLabel D2textbox;
    private JLabel D3textbox;
    private JLabel D4textbox;
    private JLabel E1textbox;
    private JLabel E2textbox;
    private JLabel E3textbox;
    private JLabel E4textbox;
    private JLabel F1textbox;
    private JLabel F2textbox;
    private JLabel F3textbox;
    private JLabel F4textbox;
    private JLabel SpinCountNumber;
    private JLabel SpintCountLabel;
    private JLabel playerCScore;
    private JPanel QuestionAnswerPanel;
    private JPanel PlayerScorePanel;
    private JLabel FreeTurnAvailableLabel;
    private JLabel player1token;
    private JLabel player2token;
    private JLabel player3token;

    private String player_one_name;
    private String player_two_name;
    private String player_three_name;
    private int player_one_score;
    private int player_two_score;
    private int player_three_score;
    private boolean player_one_freeturn;
    private boolean player_two_freeturn;
    private boolean player_three_freeturn;

    public int cat1_index;
    public int cat2_index;
    public int cat3_index;
    public int cat4_index;
    public int cat5_index;
    public int cat6_index;

    public int spin_counter;
    public int current_player;
    public QuestionBoard round_1_question_board;
    public QuestionBoard round_2_question_board;

    public Better() {
        NEWGAMEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                cat1_index = 1;
                cat2_index = 1;
                cat3_index = 1;
                cat4_index = 1;
                cat5_index = 1;
                cat6_index = 1;

                player_one_freeturn = false;
                player_two_freeturn = false;
                player_three_freeturn = false;

                current_player = 1;
                LoadQuestions();

                player_one_score = 0;
                player_two_score = 0;
                player_three_score = 0;

                player_one_name = JOptionPane.showInputDialog("Please input player 1 name: ");
                player_two_name = JOptionPane.showInputDialog("Please input player 2 name: ");
                player_three_name = JOptionPane.showInputDialog("Please input player 3 name: ");

                player1Label.setText(player_one_name);
                player2Label.setText(player_two_name);
                player3Label.setText(player_three_name);
                playerAScore.setText("" + player_one_score);
                playerBScore.setText("" + player_two_score);
                playerCScore.setText("" + player_three_score);

                CategoryAbutton.setText(round_1_question_board.GetIndexCategoryName(1));
                CategoryBbutton.setText(round_1_question_board.GetIndexCategoryName(2));
                CategoryCbutton.setText(round_1_question_board.GetIndexCategoryName(3));
                CategoryDbutton.setText(round_1_question_board.GetIndexCategoryName(4));
                CategoryEbutton.setText(round_1_question_board.GetIndexCategoryName(5));
                CategoryFbutton.setText(round_1_question_board.GetIndexCategoryName(6));
            }
        });

        SPINButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                Random rand = new Random();
                int max = 12;
                int min = 1;

                int enum_spin = rand.nextInt(max - min + 1) + min;

                String category;
                String query;
                Question question;
                int value;
                String response;

                boolean repeat = false;

                do {


                    switch (enum_spin) {
                        case 1:
                            repeat = false;
                            Wheel.setText(round_1_question_board.GetIndexCategoryName(1));
                            if (cat1_index <= 5) {
                                category = round_1_question_board.GetIndexCategoryName(enum_spin);
                                question = round_1_question_board.GetNextQuestion(category);
                                query = question.toString();
                                value = question.QueryValue();

                                long startTime = System.currentTimeMillis();
                                response = JOptionPane.showInputDialog(null, query + ": ", category, JOptionPane.PLAIN_MESSAGE);
                                long endTime = System.currentTimeMillis();

                                if (endTime-startTime > 15000)
                                {
                                    value = 0;
                                }
                                if (question.CheckAnswer(response)) {
                                    if (current_player == 1)
                                        player_one_score += value;
                                    else if (current_player == 2)
                                        player_two_score += value;
                                    else if (current_player == 3)
                                        player_three_score += value;
                                } else {
                                    if (current_player == 1)
                                        player_one_score -= value;
                                    else if (current_player == 2)
                                        player_two_score -= value;
                                    else if (current_player == 3)
                                        player_three_score -= value;
                                }
                                DisableSquare(enum_spin, cat1_index);
                                cat1_index++;
                            } else {
                                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "No more questions for this category!");
                                current_player--;
                            }
                            break;
                        case 2:
                            repeat = false;
                            Wheel.setText(round_1_question_board.GetIndexCategoryName(2));
                            if (cat2_index <= 5) {
                                category = round_1_question_board.GetIndexCategoryName(enum_spin);
                                question = round_1_question_board.GetNextQuestion(category);
                                query = question.toString();
                                value = question.QueryValue();

                                long startTime = System.currentTimeMillis();
                                response = JOptionPane.showInputDialog(null, query + ": ", category, JOptionPane.PLAIN_MESSAGE);
                                long endTime = System.currentTimeMillis();

                                if (endTime-startTime > 15000)
                                {
                                    value = 0;
                                }

                                if (question.CheckAnswer(response)) {
                                    if (current_player == 1)
                                        player_one_score += value;
                                    else if (current_player == 2)
                                        player_two_score += value;
                                    else if (current_player == 3)
                                        player_three_score += value;
                                } else {
                                    if (current_player == 1)
                                        player_one_score -= value;
                                    else if (current_player == 2)
                                        player_two_score -= value;
                                    else if (current_player == 3)
                                        player_three_score -= value;
                                }
                                DisableSquare(enum_spin, cat2_index);
                                cat2_index++;
                            } else {
                                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "No more questions for this category!");
                                current_player--;
                            }
                            break;
                        case 3:
                            repeat = false;
                            Wheel.setText(round_1_question_board.GetIndexCategoryName(3));
                            if (cat3_index <= 5) {
                                category = round_1_question_board.GetIndexCategoryName(enum_spin);
                                question = round_1_question_board.GetNextQuestion(category);
                                query = question.toString();
                                value = question.QueryValue();

                                long startTime = System.currentTimeMillis();
                                response = JOptionPane.showInputDialog(null, query + ": ", category, JOptionPane.PLAIN_MESSAGE);
                                long endTime = System.currentTimeMillis();

                                if (endTime-startTime > 15000)
                                {
                                    value = 0;
                                }
                                if (question.CheckAnswer(response)) {
                                    if (current_player == 1)
                                        player_one_score += value;
                                    else if (current_player == 2)
                                        player_two_score += value;
                                    else if (current_player == 3)
                                        player_three_score += value;
                                } else {
                                    if (current_player == 1)
                                        player_one_score -= value;
                                    else if (current_player == 2)
                                        player_two_score -= value;
                                    else if (current_player == 3)
                                        player_three_score -= value;
                                }
                                DisableSquare(enum_spin, cat3_index);
                                cat3_index++;
                            } else {
                                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "No more questions for this category!");
                                current_player--;
                            }
                            break;
                        case 4:
                            repeat = false;
                            Wheel.setText(round_1_question_board.GetIndexCategoryName(4));
                            if (cat4_index <= 5) {
                                category = round_1_question_board.GetIndexCategoryName(enum_spin);
                                question = round_1_question_board.GetNextQuestion(category);
                                query = question.toString();
                                value = question.QueryValue();

                                long startTime = System.currentTimeMillis();
                                response = JOptionPane.showInputDialog(null, query + ": ", category, JOptionPane.PLAIN_MESSAGE);
                                long endTime = System.currentTimeMillis();

                                if (endTime-startTime > 15000)
                                {
                                    value = 0;
                                }
                                if (question.CheckAnswer(response)) {
                                    if (current_player == 1)
                                        player_one_score += value;
                                    else if (current_player == 2)
                                        player_two_score += value;
                                    else if (current_player == 3)
                                        player_three_score += value;
                                } else {
                                    if (current_player == 1)
                                        player_one_score -= value;
                                    else if (current_player == 2)
                                        player_two_score -= value;
                                    else if (current_player == 3)
                                        player_three_score -= value;
                                }
                                DisableSquare(enum_spin, cat4_index);
                                cat4_index++;
                            } else {
                                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "No more questions for this category!");
                                current_player--;
                            }
                            break;
                        case 5:
                            repeat = false;
                            Wheel.setText(round_1_question_board.GetIndexCategoryName(5));
                            if (cat5_index <= 5) {
                                category = round_1_question_board.GetIndexCategoryName(enum_spin);
                                question = round_1_question_board.GetNextQuestion(category);
                                query = question.toString();
                                value = question.QueryValue();

                                long startTime = System.currentTimeMillis();
                                response = JOptionPane.showInputDialog(null, query + ": ", category, JOptionPane.PLAIN_MESSAGE);
                                long endTime = System.currentTimeMillis();

                                if (endTime-startTime > 15000)
                                {
                                    value = 0;
                                }
                                if (question.CheckAnswer(response)) {
                                    if (current_player == 1)
                                        player_one_score += value;
                                    else if (current_player == 2)
                                        player_two_score += value;
                                    else if (current_player == 3)
                                        player_three_score += value;
                                } else {
                                    if (current_player == 1)
                                        player_one_score -= value;
                                    else if (current_player == 2)
                                        player_two_score -= value;
                                    else if (current_player == 3)
                                        player_three_score -= value;
                                }
                                DisableSquare(enum_spin, cat5_index);
                                cat5_index++;
                            } else {
                                JOptionPane.showMessageDialog(null, "No more questions for this category!");
                                current_player--;
                            }
                            break;
                        case 6:
                            repeat = false;
                            Wheel.setText(round_1_question_board.GetIndexCategoryName(6));
                            if (cat6_index <= 5) {
                                category = round_1_question_board.GetIndexCategoryName(enum_spin);
                                question = round_1_question_board.GetNextQuestion(category);
                                query = question.toString();
                                value = question.QueryValue();

                                long startTime = System.currentTimeMillis();
                                response = JOptionPane.showInputDialog(null, query + ": ", category, JOptionPane.PLAIN_MESSAGE);
                                long endTime = System.currentTimeMillis();

                                if (endTime-startTime > 15000)
                                {
                                    value = 0;
                                }
                                if (question.CheckAnswer(response)) {
                                    if (current_player == 1)
                                        player_one_score += value;
                                    else if (current_player == 2)
                                        player_two_score += value;
                                    else if (current_player == 3)
                                        player_three_score += value;
                                } else {
                                    if (current_player == 1)
                                        player_one_score -= value;
                                    else if (current_player == 2)
                                        player_two_score -= value;
                                    else if (current_player == 3)
                                        player_three_score -= value;
                                }
                                DisableSquare(enum_spin, cat6_index);
                                cat6_index++;
                            } else {
                                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "No more questions for this category!");
                                current_player--;
                            }
                            break;
                        // Bankrupt
                        case 7:
                            repeat = false;
                            Wheel.setText("Bankrupt!");
                            if (current_player == 1) {
                                if (player_one_score > 0)
                                    player_one_score = 0;
                            }
                            if (current_player == 2) {
                                if (player_two_score > 0)
                                    player_two_score = 0;
                            }
                            if (current_player == 3) {
                                if (player_three_score > 0)
                                    player_three_score = 0;
                            }
                            break;
                        // Lose Turn
                        case 8:
                            repeat = false;
                            Wheel.setText("LoseTurn!");

                            break;
                        // SpinAgain
                        case 9:
                            repeat = false;
                            Wheel.setText("SpinAgain!");
                            current_player--;
                            break;
                        // Opponent's Choice
                        case 10:
                            repeat = true;
                            Wheel.setText("Opponent's Choice!");
                            response = JOptionPane.showInputDialog(null, "Enter category of choice: ", "Opponent Choose a Category!", JOptionPane.PLAIN_MESSAGE);
                            enum_spin = Integer.parseInt(response);
                            break;
                        // Player's Choice
                        case 11:
                            repeat = true;
                            Wheel.setText("Your Choice!");
                            response = JOptionPane.showInputDialog(null, "Enter category of choice: ", "Your Choose a Category!", JOptionPane.PLAIN_MESSAGE);
                            enum_spin = Integer.parseInt(response);
                            break;
                        // Free Turn
                        case 12:
                            repeat = false;
                            Wheel.setText("FreeTurn!");
                            if (current_player == 1)
                                player_one_freeturn = true;
                            if (current_player == 2)
                                player_two_freeturn = true;
                            if (current_player == 3)
                                player_three_freeturn = true;
                            break;
                    }

                }while(repeat);


                if(current_player == 1 && player_one_freeturn){
                    int n = JOptionPane.showConfirmDialog(
                            null,
                            "Player 1 use free turn?",
                            "FreeTurn!",
                            JOptionPane.YES_NO_OPTION);
                    if(n == JOptionPane.YES_OPTION)
                        current_player--;
                }

                if(current_player == 2 && player_two_freeturn){
                    int n = JOptionPane.showConfirmDialog(
                            null,
                            "Player 2 use free turn?",
                            "FreeTurn!",
                            JOptionPane.YES_NO_OPTION);
                    if(n == JOptionPane.YES_OPTION)
                        current_player--;
                }

                if(current_player == 3 && player_three_freeturn){
                    int n = JOptionPane.showConfirmDialog(
                            null,
                            "Player 3 use free turn?",
                            "FreeTurn!",
                            JOptionPane.YES_NO_OPTION);
                    if(n == JOptionPane.YES_OPTION)
                        current_player--;
                }


                current_player++;
                if (current_player == 4)
                    current_player = 1;

                spin_counter++;
                SpinCountNumber.setText("" + spin_counter);

                playerAScore.setText("" + player_one_score);
                playerBScore.setText("" + player_two_score);
                playerCScore.setText("" + player_three_score);

            }
        });
    }

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("WheelOfJeopardy!");
        frame.setContentPane(new Better().GamePanel);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void DisableSquare(int i, int j)
    {
        if(i == 1)
        {
            if(j == 1)
                A1textbox.setEnabled(false);
            else if(j == 2)
                A2textbox.setEnabled(false);
            else if(j == 3)
                A3textbox.setEnabled(false);
            else if(j == 4)
                A4textbox.setEnabled(false);
            else if(j == 5)
                A5textbox.setEnabled(false);
        }
        else if(i == 2)
        {
            if(j == 1)
                B1textbox.setEnabled(false);
            else if(j == 2)
                B2textbox.setEnabled(false);
            else if(j == 3)
                B3textbox.setEnabled(false);
            else if(j == 4)
                B4textbox.setEnabled(false);
            else if(j == 5)
                B5textbox.setEnabled(false);
        }
        else if(i == 3)
        {
            if(j == 1)
                C1textbox.setEnabled(false);
            else if(j == 2)
                C2textbox.setEnabled(false);
            else if(j == 3)
                C3textbox.setEnabled(false);
            else if(j == 4)
                C4textbox.setEnabled(false);
            else if(j == 5)
                C5textbox.setEnabled(false);
        }
        else if(i == 4)
        {
            if(j == 1)
                D1textbox.setEnabled(false);
            else if(j == 2)
                D2textbox.setEnabled(false);
            else if(j == 3)
                D3textbox.setEnabled(false);
            else if(j == 4)
                D4textbox.setEnabled(false);
            else if(j == 5)
                D5textbox.setEnabled(false);
        }
        else if(i == 5)
        {
            if(j == 1)
                E1textbox.setEnabled(false);
            else if(j == 2)
                E2textbox.setEnabled(false);
            else if(j == 3)
                E3textbox.setEnabled(false);
            else if(j == 4)
                E4textbox.setEnabled(false);
            else if(j == 5)
                E5textbox.setEnabled(false);
        }
        else if(i == 6)
        {
            if(j == 1)
                F1textbox.setEnabled(false);
            else if(j == 2)
                F2textbox.setEnabled(false);
            else if(j == 3)
                F3textbox.setEnabled(false);
            else if(j == 4)
                F4textbox.setEnabled(false);
            else if(j == 5)
                F5textbox.setEnabled(false);
        }
    }

    public void LoadQuestions()
    {
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
            String categoryNamecsv = categoryArray.get(i);
            String categoryName = categoryNamecsv.substring(0, categoryNamecsv.length() - 4);
            QuestionCategory questionCategoryJeopardy = new QuestionCategory(categoryName);
            QuestionCategory questionCategoryDoubleJeopardy = new QuestionCategory(categoryName);
            fileName = userDir + "/../ART AND LITERATURE/" + categoryNamecsv;
            questionCategoryJeopardy = ReadCSV.getCategoryAndQuestionsJeopardy(fileName);
            questionCategoryDoubleJeopardy = ReadCSV.getCategoryAndQuestionsDoubleJeopardy(fileName);
            //System.out.println("category: " + categoryName);

            mapOfQuestionsJeopardy.put(categoryName, questionCategoryJeopardy);
            mapOfQuestionsDoubleJeopardy.put(categoryName, questionCategoryDoubleJeopardy);
        }

        //create question board
        round_1_question_board = new QuestionBoard(mapOfQuestionsJeopardy);
        round_2_question_board = new QuestionBoard(mapOfQuestionsDoubleJeopardy);
        /*String Category1name = "Cat1";
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

        Question question1 = new Question(200, Query1, answers1);
        Question question2 = new Question(400, Query2, answers2);
        Question question3 = new Question(600, Query3, answers3);
        Question question4 = new Question(800, Query4, answers4);
        Question question5 = new Question(1000, Query5, answers5);

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

        round_1_question_board = new QuestionBoard(q_board);*/
    }
}
