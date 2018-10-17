/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author artur
 */
public class servletJson extends HttpServlet {

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
        response.setContentType("application/json; charset=UTF-8");

        //Sesion
        HttpSession sesion = request.getSession();
        //Strings
        String name = request.getParameter("user");
        String password = request.getParameter("pass");
        String opcion = request.getParameter("op");
        String usuarioR = "Arturo";
        String contrase = "holamundo";
        String strJson = "";
        String strUserName = "";
        //Declaramos gson
        Gson gson = new Gson();

        try {
            if (opcion != null) {
                switch (opcion.trim()) {
                    case "login":
                        if (name.equals(usuarioR) && password.equals(contrase)) {
                            sesion.setAttribute("antoniet", name);
                            strJson = "{\"status\":200,\"msg\":\"" + name + "\"}";
                        } else {
                            response.setStatus(500);
                            strJson = "{\"status\":401,\"msg\":\"Authentication error login.\"}";
                        }
                        break;
                    case "logout":
                        sesion.invalidate();
                        strJson = "{\"status\":200,\"msg\":\"Session is closed.\"}";
                        break;
                    case "check":
                        strUserName = (String) sesion.getAttribute("antoniet");
                        if (strUserName != null) {
                            strJson = "{\"status\":200,\"msg\":\"" + strUserName + "\"}";
                        } else {
                            strJson = "{\"status\":401,\"msg\":\"Authentication error check.\"}";
                        }
                        break;
                    case "topsecret":
                        strUserName = (String) sesion.getAttribute("antoniet");
                        if (strUserName != null) {
                            strJson = "{\"status\":200,\"msg\":\"666\"}";
                        } else {
                            strJson = "{\"status\":401,\"msg\":\"Authentication error topsecret.\"}";
                        }
                        break;
                    default:
                        response.setStatus(500);
                        strJson = "Ninguna opción es correcta.";
                }
                response.getWriter().append(gson.toJson(strJson));

            } else {
                strJson = "{\"status\":200,\"msg\":\"" + opcion + "::" + name + "::" + password + "\"}";
                response.getWriter().append(gson.toJson(strJson));
            }
        } finally {
            out.close();
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
