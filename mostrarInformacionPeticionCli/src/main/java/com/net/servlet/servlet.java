/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author artur
 */
public class servlet extends HttpServlet {

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
         
          out.println("<h4>request.getAttributeNames()==> "+request.getAttributeNames()+"</h4>");
          out.println("<h4>request.getRemoteAddr()==>" + request.getRemoteAddr()+"</41>");
          out.println("<h4>request.getCharacterEncoding()  ==>" + request.getCharacterEncoding() +"</h4>");
          out.println("<h4>request.getContentType() ==>" + request.getContentType() +"</h4>");
          out.println("<h4>request.getContextPath() ==>" + request.getContextPath() +"</h4>");
          out.println("<h4>request.getHeader==>" + request.getHeader("Hu ja") +"</h4>");
          out.println("<h4>request.getLocalAddr() ==>" + request.getLocalAddr() +"</h4>");
          out.println("<h4>request.getLocalName() ==>" + request.getLocalName() +"</h4>");
          out.println("<h4>request.getMethod() ==>" + request.getMethod() +"</h4>");
          out.println("<h4>request.getPathInfo() ==>" + request.getPathInfo() +"</h4>");
          out.println("<h4>request.getPathTranslated() ==>" + request.getPathTranslated() +"</h4>");
          out.println("<h4>request.getProtocol() ==>" + request.getProtocol() +"</h4>");
          out.println("<h4>request.getQueryString() ==>" + request.getQueryString() +"</h4>");
          out.println("<h4>request.getRemoteAddr() ==>" + request.getRemoteAddr() +"</h4>");
          out.println("<h4>request.getRemoteHost() ==>" + request.getRemoteHost() +"</h4>");
          out.println("<h4>request.getRemoteUser() ==>" + request.getRemoteUser() +"</h4>");
          out.println("<h4>request.getRequestURI() ==>" + request.getRequestURI() +"</h4>");
          out.println("<h4>request.getRequestedSessionId() ==>" + request.getRequestedSessionId() +"</h4>");
          out.println("<h4>request.getScheme() ==>" + request.getScheme() +"</h4>");
          out.println("<h4>request.getServerName() ==>" + request.getServerName() +"</h4>");
          out.println("<h4>request.getServletPath() ==>" + request.getServletPath() +"</h4>");
          out.println("<h4>request.getAsyncContext() ==>" + request.getAsyncContext() +"</h4>");
          out.println("<h4>request.getAttributeNames() ==>" + request.getAttributeNames() +"</h4>");
          out.println("<h4>request.getClass() ==>" + request.getClass() +"</h4>");
          out.println("<h4>request.getContentLength() ==>" + request.getContentLength() +"</h4>");
          out.println("<h4>request.getContentLengthLong() ==>" + request.getContentLengthLong() +"</h4>");
          out.println("<h4>request.getCookies())  ==>" + Arrays.toString(request.getCookies()) +"</h4>");
          out.println("<h4>request.getDispatcherType() ==>" + request.getDispatcherType() +"</h4>");
          out.println("<h4>request.getHeaderNames() ==>" + request.getHeaderNames() +"</h4>");
          out.println("<h4>request.getInputStream() ==>" + request.getInputStream() +"</h4>");
          out.println("<h4>request.getLocalPort() ==>" + request.getLocalPort() +"</h4>");
          out.println("<h4>request.getLocale() ==>" + request.getLocale() +"</h4>");
          out.println("<h4>request.getLocales() ==>" + request.getLocales() +"</h4>");
          out.println("<h4>request.getParameterMap() ==>" + request.getParameterMap() +"</h4>");
          out.println("<h4>request.getParameterNames() ==>" + request.getParameterNames() +"</h4>");
          out.println("<h4>request.getParts() ==>" + request.getParts() +"</h4>");
          out.println("<h4>request.getReader() ==>" + request.getReader() +"</h4>");
          out.println("<h4>request.getRemotePort() ==>" + request.getRemotePort() +"</h4>");
          out.println("<h4>request.getRequestURL() ==>" + request.getRequestURL() +"</h4>");
          
          
          
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
