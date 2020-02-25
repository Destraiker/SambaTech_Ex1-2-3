/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Home
 */
@WebServlet(name = "Exercicio02", urlPatterns = {"/Exercicio02"})
public class Exercicio02 extends HttpServlet {

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
            String parametro = request.getParameter("Vetor");
            String vetor_parametro[]=parametro.split(",");
            ArrayList<Integer> vetor=new ArrayList();
            
            for (int i = 0; i < vetor_parametro.length; i++) {
                vetor.add(Integer.parseInt(vetor_parametro[i]));
            }
            
            vetor=Ordenar(vetor);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Exercicio02</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Resposta: </h3>");
            out.println("<div>Novo vetor: " + vetor + " </div>");
            out.println("<br><br>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private static ArrayList<Integer> Ordenar(ArrayList<Integer> vetor){
        ArrayList<Integer> par=new ArrayList();
        ArrayList<Integer> impar=new ArrayList();
        ArrayList<Integer> resultado=new ArrayList();
        
        for (int i = 0; i < vetor.size(); i++) {
            if(vetor.get(i)%2==0){
                par.add(vetor.get(i));
            }else{
                impar.add(vetor.get(i));
            }
        }
        par=Ordenar_decrescente(par);
        impar=Ordenar_crescente(impar);
        
        for (int i = 0; i < par.size(); i++) {
            resultado.add(par.get(i));
        }
        for (int i = 0; i < impar.size(); i++) {
            resultado.add(impar.get(i));
        }
        
        return resultado;
    }
    
    private static ArrayList<Integer> Ordenar_crescente(ArrayList<Integer> vetor) {
        boolean troca = true;
        int aux;
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
    
    private static ArrayList<Integer> Ordenar_decrescente(ArrayList<Integer> vetor) {
        boolean troca = true;
        int aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < vetor.size() - 1; i++) {
                if (vetor.get(i) < vetor.get(i + 1)) {
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
