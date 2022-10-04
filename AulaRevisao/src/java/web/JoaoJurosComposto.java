/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import java.text.DecimalFormat;

/**
 *
 * @author Fatec
 */
@WebServlet(name = "joaoJurosComposto", urlPatterns = {"/joaoJurosComposto.json"})
public class JoaoJurosComposto extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {

            out.println("<h4><a href='index.html'>Voltar</a></h4>");
            double c = 0, i = 0, t = 0, r=0, mont=0;
            try{
            c = Double.parseDouble(request.getParameter("c"));
            i = Double.parseDouble(request.getParameter("i"));
            t = Double.parseDouble(request.getParameter("t"));
            r = (c*Math.pow(1+(i/100), t) - c);
            mont = r + c;
            }catch(Exception ex){
                out.println("<div style='color:red'> "
                        + "Parametro Invalido"
                        + "</div>");
            }
            JSONObject jcomposto = new JSONObject();
            String valorFormatado = new DecimalFormat("#,##0.00").format(r);
            String valorFormatado2 = new DecimalFormat("#,##0.00").format(mont);
            jcomposto.put("Juros Composto", valorFormatado);
            jcomposto.put("Montante: ", valorFormatado2);
            response.getWriter().println(jcomposto.toString());
       
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
