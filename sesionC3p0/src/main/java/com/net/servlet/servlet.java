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
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;

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
        response.setContentType("application/json; charset=UTF-8");
        //Strings
        String docJson = "";
        String opcion = request.getParameter("opcion");
        //Gson
        Gson gson = new Gson();

        if (opcion != null) {
            if (opcion.equals("connect")) {
                try {
                    //Driver
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (Exception x) {
                    response.setStatus(500);
                    docJson = "{\"status\":401,\"msg\":\"jdbc driver error.\"}";
                    response.getWriter().append(gson.toJson(docJson));
                }
                 //Connexion
                ComboPooledDataSource cpds = new ComboPooledDataSource();
                cpds.setJdbcUrl("jbdc:mysql://localhost/trolleyes");
                cpds.setUser("root2");
                cpds.setPassword("bitnami");
                
                //Configuramos el pool
                //Num conexiones con la que inicia el pool
                cpds.setInitialPoolSize(0);
                //Minimo de conexiones que tendra el pool
                cpds.setMinPoolSize(0);  
                //Nume de conexiones a crear cada incremento
                cpds.setAcquireIncrement(1);
                //Maximo numero de conexiones
                cpds.setMaxPoolSize(5);
                //Maximo de consultas
                cpds.setMaxStatements(180);
                //Maximo numero de reintentos para conectar a base de datos
                cpds.setAcquireRetryAttempts(2);
                //Que se genere una excepcion si no se puede conectar
                cpds.setBreakAfterAcquireFailure(true);
                
                try{ 
                    ComboPooledDataSource dataSource = cpds;
                    Connection connection;
                    connection = dataSource.getConnection();
                    docJson = "{\"status\":200,\"msg\":\"C3p0 Connection perfect.\"}";
                }catch(SQLException e){
                    docJson = "{\"status\":401,\"msg\":\"Bad C3p0 Connection.\"}";
                }
            } else {
                docJson = "{\"status\":401,\"msg\":\"Authentication error login.\"}";
            }
        } else {
            docJson = "{\"status\":401,\"msg\":\"Authentication error login.\"}";
        }

        response.getWriter().append(gson.toJson(docJson));

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
