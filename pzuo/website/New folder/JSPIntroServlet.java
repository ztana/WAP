/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 984881
 */

 
import java.io.*;
import java.net.*;
 
import javax.servlet.*;
import javax.servlet.http.*;
 
public class JSPIntroServlet extends HttpServlet
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException
  {
    RequestDispatcher dispatcher = request.getRequestDispatcher("Hello.jsp");
    dispatcher.forward(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException
  {
    RequestDispatcher dispatcher = request.getRequestDispatcher("PostMessage.jsp");
    request.setAttribute("at1", 12);
    dispatcher.forward(request, response);    
  }
}