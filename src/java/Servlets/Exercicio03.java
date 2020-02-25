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
@WebServlet(name = "Exercicio03", urlPatterns = {"/Exercicio03"})
public class Exercicio03 extends HttpServlet {

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
            ArrayList<String> valor_decomposto = new ArrayList();
            
            int notas = Integer.parseInt(request.getParameter("Reais"));
            int moedas = Integer.parseInt(request.getParameter("Centavos"));

            valor_decomposto=Decompor(notas,moedas);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Exercicio03</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Resposta: </h3>");
            out.println("<div>Decomposição: " + Imprimir(valor_decomposto) + " </div>");
            out.println("<br><br>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private ArrayList<String> Decompor(int valor,int moedas) {
        
        ArrayList<String> notas = new ArrayList();

        int aux;
        
        if (valor / 100 > 0) {
            aux = valor / 100;
            valor = valor - (aux * 100);
            if (aux == 1) {
                notas.add(aux + " nota de 100 reais");
            } else {
                notas.add(aux + " notas de 100 reais");
            }
        }
        if (valor / 50 > 0) {
            aux = valor / 50;
            valor = valor - (aux * 50);
            if (aux == 1) {
                notas.add(aux + " nota de 50 reais");
            } else {
                notas.add(aux + " notas de 50 reais");
            }
        }
        if (valor / 20 > 0) {
            aux = valor / 20;
            valor = valor - (aux * 20);
            if (aux == 1) {
                notas.add(aux + " nota de 20 reais");
            } else {
                notas.add(aux + " notas de 20 reais");
            }
        }
        if (valor / 10 > 0) {
            aux = valor / 10;
            valor = valor - (aux * 10);
            if (aux == 1) {
                notas.add(aux + " nota de 10 reais");
            } else {
                notas.add(aux + " notas de 10 reais");
            }
        }
        if (valor / 5 > 0) {
            aux = valor / 5;
            valor = valor - (aux * 5);
            if (aux == 1) {
                notas.add(aux + " nota de 5 reais");
            } else {
                notas.add(aux + " notas de 5 reais");
            }
        }
        if (valor / 2 > 0) {
            aux = valor / 2;
            valor = valor - (aux * 2);
            if (aux == 1) {
                notas.add(aux + " nota de 2 reais");
            } else {
                notas.add(aux + " notas de 2 reais");
            }
        }
        if (valor == 1) {
            notas.add("1 moeda de 1 real");
        }
        
        if (moedas / 50 > 0) {
            aux = moedas / 50;
            moedas = moedas - (aux * 50);
            if (aux == 1) {
                notas.add(aux + " moeda de 50 centavos");
            } else {
                notas.add(aux + " moedas de 50 centavos");
            }
        }
        if (moedas / 25 > 0) {
            aux = moedas / 25;
            moedas = moedas - (aux * 25);
            if (aux == 1) {
                notas.add(aux + " moeda de 25 centavos");
            } else {
                notas.add(aux + " moedas de 25 centavos");
            }
        }
        if (moedas / 10 > 0) {
            aux = moedas / 10;
            moedas = moedas - (aux * 10);
            if (aux == 1) {
                notas.add(aux + " moeda de 10 centavos");
            } else {
                notas.add(aux + " moedas de 10 centavos");
            }
        }
        if (moedas / 5 > 0) {
            aux = moedas / 5;
            moedas = moedas - (aux * 5);
            if (aux == 1) {
                notas.add(aux + " moeda de 5 centavos");
            } else {
                notas.add(aux + " moedas de 5 centavos");
            }
        }
        if (moedas / 1 > 0) {
            aux = moedas / 1;
            moedas = moedas - (aux * 1);
            if (aux == 1) {
                notas.add(aux + " moeda de 1 centavos");
            } else {
                notas.add(aux + " moedas de 1 centavos");
            }
        }
        
        return notas;
    }
    public String Imprimir(ArrayList<String> lista){
        String result = null;
        for (int i = 0; i < lista.size(); i++) {
            if(i==0){
                result="<br>"+lista.get(i)+"<br>";
            }else{
                result+=""+lista.get(i)+"<br>";
            }
        }
        return result;
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
