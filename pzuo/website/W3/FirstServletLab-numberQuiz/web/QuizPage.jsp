<%-- 
    Document   : QuizPage
    Created on : Mar 11, 2016, 10:52:53 AM
    Author     : 984881
--%>

<%@page import="app.Quiz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NumberQuiz</title>
    </head>
    <body>
        <form method='post'>
            <h3>Have fun with NumberQuiz!</h3>
            <p>Your current score is:
                <%= ((Quiz)request.getAttribute("Quiz")).getNumCorrect() %>
                </br></br>
            <p>Attempt : <%= request.getAttribute("attimes") %></p>
                <p>Guess the next number in the sequence!
                    <%= request.getAttribute("cQuest") %>
                </p>
                <p>Your answer:<input type='text' name='txtAnswer' value='' /></p>
               
                <!--<p style='color:red' <%= request.getAttribute("error") %>>Your last answer was not correct! Please try again</p> -->
                <p style='color:red' <%= request.getAttribute("style") %>><%= request.getAttribute("message") %></p>
                
                <p><input type='submit' name='btnNext' value='Next' /></p>
                <p><input type='submit' name="hint" value="hint"/></p>
            </p>
        </form>
    </body>
</html>
