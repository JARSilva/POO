/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package MathServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fatec
 */
@WebServlet(name = "MathServlet", urlPatterns = {"/mathservlet.html"})
public class JoaoMathServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Equações</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultados</h1>");
            int n1 = 0;
            int n2 = 0;
            String res = "";
            
            try{
                n1 = Integer.parseInt(request.getParameter("n1"));
                n2 = Integer.parseInt(request.getParameter("n2"));
                res = request.getParameter("res");
                
                if (res.equals("soma")){
                    out.println("<h2>"+n1+" + "+n2+" = "+(n1+n2)+"</h2>");
                }else if(res.equals("sub")){
                    out.println("<h2>"+n1+" - "+n2+" = "+(n1-n2)+"</h2>");
                }else if(res.equals("divisao")){
                    out.println("<h2>"+n1+" / "+n2+" = "+(n1/n2)+"</h2>");
                }else if(res.equals("multi")){
                    out.println("<h2>"+n1+" * "+n2+" = "+(n1*n2)+"</h2>");
                }
            }catch(Exception ex){
                out.println("Erro");
            }
                                
            out.println("<h4><a href='index.html'>Voltar</a></h4>");
            out.println("</body>");
            out.println("</html>");
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
