/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs.cs545.lab03;

import app.Quiz;
import app.ErrorMessage;
import java.io.*;


import javax.servlet.*;
import javax.servlet.http.*;
//import javax.swing.JOptionPane;


/**
 *
 * @author levi
 */
public class Lab03Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* assume goGet is only called on entry to the application.
         * (What about back refreshing page, other ways to return to page?)
         * create a Quiz here, put in session, and call doPost
         */
        Quiz newQuiz = new Quiz();
        HttpSession sess = request.getSession();
        sess.setAttribute("quiz", newQuiz);  //oops  -- violation of REST idempotent principle for Get
        System.out.println("JUST set the quiz in the session.");
        doPost(request, response);
        
    }

    int attCount = 0;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //PrintWriter out = response.getWriter();
        boolean attmpted = false;
        HttpSession sess = request.getSession();
        Quiz sessQuiz = (Quiz) sess.getAttribute("quiz");
   
        //if(request.getParameter("Next") != null) {
            /* REFACTOR should check for null sessQuiz */
            //init error message
            ErrorMessage.mes.setMessage(ErrorMessage.ID.wrong);
            ErrorMessage.mes.hidden(true);

            /* now need to get an input from the user and process it */
            String answer = request.getParameter("txtAnswer");
            System.out.println("Answer is: " + answer);

            boolean error = true;
            request.setAttribute("attimes", attCount);
            /* i.e., if answer is correct then increment the question index and score */
            if ((answer != null) && sessQuiz.isCorrect(answer)) {
                error = false;
                sessQuiz.markAnswerCorrect();
            }
            else {
                if(attCount++ >=3) {
                    //no more attmpt.
                    sessQuiz.nextQuestion();
                    //show no more attmpt
                    attmpted = true;
                    ErrorMessage.mes.hidden(false);
                    request.setAttribute("curAnswer", sessQuiz.getCurrentAnswer());
                    attCount = 0;
                    request.setAttribute("attimes", attCount);
                }
                else {
                    attmpted = false;
                }
            }

            /* NEED TO see if are at end of quiz and go to finish page if so? 
             * refactor:  probably better if have an isFinished method in Quiz to encapsulate the logic. */
            if (sessQuiz.getTotNumQuestions() == sessQuiz.getCurrentQuestionIndex()) {
                System.out.println("have finished quiz");
                RequestDispatcher dispatcher = request.getRequestDispatcher("QuizOverPage.jsp");
                dispatcher.forward(request, response);
            } else {
                /* get a question and print it out */
                String currQuest = sessQuiz.getCurrentQuestion();

                request.setAttribute("Quiz", sessQuiz);
                request.setAttribute("cQuest", currQuest);
                if (error && (answer != null)) {
                    //request.setAttribute("error", "");
                    ErrorMessage.mes.hidden(false);
                    if(!attmpted) {
                        ErrorMessage.mes.setMessage(ErrorMessage.ID.wrong);
                    }
                    else {
                        ErrorMessage.mes.setMessage(ErrorMessage.ID.attempt, sessQuiz.getCurrentAnswer());
                    }
                }
                else {
                    ErrorMessage.mes.setMessage(ErrorMessage.ID.wrong);
                    ErrorMessage.mes.hidden(true);
                    //request.setAttribute("error", "hidden");
                }
                        //set error message
                request.setAttribute("style",ErrorMessage.mes.getHideMessage());
                request.setAttribute("message",ErrorMessage.mes.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("QuizPage.jsp");
                dispatcher.forward(request, response);
                //genQuizPage(sessQuiz, out, currQuest, error, answer);
            }
       // } else if (request.getParameter("hint") != null) {
           // JOptionPane.showMessageDialog(null,sessQuiz.getCUrrentHint());
      //  }
        

        
        
    }

    
    
    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
