/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Home
 */
@WebServlet(name = "Exercicio01", urlPatterns = {"/Exercicio01"})
public class Exercicio01 extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String Palavra = request.getParameter("Palavra");
            String Anagrama = request.getParameter("Anagrama");
            String Resposta;

            if (VerificarAnagrama(Palavra, Anagrama)) {
                Resposta = "A palavra " + Anagrama + " é um anagrama de " + Palavra + ".";
            } else {
                Resposta = "A palavra " + Anagrama + " não é um anagrama de " + Palavra + ".";
            }
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Exercicio01</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Resposta: </h3>");
            out.println("<div>Resposta da função: " + VerificarAnagrama(Palavra, Anagrama) + " </div>");
            out.println("<br><br>");
            out.println("<div>Resposta: " + Resposta + "</div>");
            out.println("<br><br>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private boolean VerificarAnagrama(String Palavra, String Anagrama) {
        ArrayList<Character> palavra = new ArrayList();
        ArrayList<Character> anagrama = new ArrayList();
        for (int i = 0; i < Palavra.length(); i++) {
            palavra.add(Palavra.charAt(i));
        }
        for (int i = 0; i < Anagrama.length(); i++) {
            anagrama.add(Anagrama.charAt(i));
        }
        palavra = ordenar(palavra);
        anagrama = ordenar(anagrama);
              
        return palavra.equals(anagrama);
    }

    private static ArrayList<Character> ordenar(ArrayList<Character> vetor) {
        boolean troca = true;
        char aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < vetor.size() - 1; i++) {
                if (vetor.get(i) > vetor.get(i + 1)) {
                    aux = vetor.get(i);
                    vetor.set(i, vetor.get(i + 1));
                    vetor.set(i + 1, aux);
                    troca = true;
                }
            }
        }
        return vetor;
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
