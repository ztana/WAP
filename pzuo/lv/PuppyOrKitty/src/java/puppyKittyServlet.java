/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zuopeng
 */
public class puppyKittyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("in processRequest of ajaxpetsservlet");
        try (PrintWriter out = response.getWriter()) {
            String petResponse = request.getParameter("animal");
            String kittyString = "<img src='Pet_Gallery_files//kitty1.jpeg'>"
                    +"<img src='Pet_Gallery_files//kitty2.jpeg'>"
                    +"<img src='Pet_Gallery_files//kitty3.jpeg'>"
                    +"<img src='Pet_Gallery_files//kitty4.jpeg'>"
                    +"<img src='Pet_Gallery_files//kitty5.jpeg'>";
            String puppyString = "<img src='Pet_Gallery_files//puppy1.jpeg'>"
                    +"<img src='Pet_Gallery_files//puppy2.jpeg'>"
                     +"<img src='Pet_Gallery_files//puppy3.jpeg'>"
                     +"<img src='Pet_Gallery_files//puppy4.jpeg'>";
            if ("puppy".equals(petResponse)) {
                petResponse = puppyString;
            } else {
                petResponse = kittyString;
            }

            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            out.write(petResponse);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
