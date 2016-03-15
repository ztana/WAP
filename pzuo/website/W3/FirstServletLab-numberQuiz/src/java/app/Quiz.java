/*
 * Quiz has a set of questions that can be presented to a person.
 * it also tracks the number of correct responses.
 * also tracks where in the quiz the person is at.
 */

package app;

import java.util.ArrayList;

/**
 *
 * @author levi
 */
public class Quiz {
    private ArrayList<Question> questions = new ArrayList<Question>();
    private int numCorrect = 0;
    /* 0 based index for the current question */
    private int currentQuestionIndex = 0;  
    
    /**
     * 
     */
    public int getTotNumQuestions() {
        return questions.size();
    }
    /**
     * Create a new Quiz with questions
     */
    public Quiz() {
        questions.add(new Question("[3 1 4 1 5]", "9","PI"));
        questions.add(new Question("[1 1 2 3 5]", "8","Fibonacci"));
        questions.add(new Question("[1, 4, 9, 16, 25]", "36","self multiply"));
        questions.add(new Question("[2, 3, 5, 7, 11]", "13","Prime"));
        questions.add(new Question("[1 2 4 8 16]", "32","n * 2"));
    }
    
    /**
     * return true or false if answer is correct or false for current question
     * @param ans
     * @return
     */
    public boolean isCorrect(String ans) {
        if (ans.equals(questions.get(currentQuestionIndex).getAnswer())) {
            return true;
        }
        else {
            return false;
        }
        
    }    
    
    /**
     * increment the currentQuestion index 
     * and also increment the score (should be called if
     * answer is correct.
     */
    public void markAnswerCorrect() { //String ans) {
        //if (isCorrect(ans)) {
            nextQuestion();
            numCorrect++;
        //}
        
    }
    
    public void nextQuestion() {
        currentQuestionIndex++;
    }

    /**
     * getter
     * @return
     */
    public int getNumCorrect() {
        return this.numCorrect;
    }

    /**
     * getter
     */ 
    public int getCurrentQuestionIndex() {
        return this.currentQuestionIndex;
    }
    
    /**
     * return the text for the current question
     */
    public String getCurrentQuestion(){
        return questions.get(currentQuestionIndex).getQuestion();
    }
    
    public String getCurrentAnswer() {
        return questions.get(currentQuestionIndex).getAnswer();
    }

    public String getCUrrentHint() {
        return questions.get(currentQuestionIndex).gethint();
    }
}
