/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class Identity extends HttpServlet {
    private class User{
        public int id_user;
        public String name;
        public String email;
        public String password;
    }
    private Connection connection;
    private void connectDB() throws SQLException{
        try {
            System.out.println("Loading driver...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }
        String url = "jdbc:mysql://localhost:3306/db_stackexchange";
        String username = "root";
        String password = "";
        connection = null;
        System.out.println("Connecting database...");
        connection = (Connection) DriverManager.getConnection(url, username, password);
        System.out.println("Database connected!");
    }
    private void closeDB() throws SQLException{
        connection.close();
    }
    private User getUser(String email, String password){
        User user = null;
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT email FROM user WHERE email = '" + email + "' AND password = '" + password + "'");
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                user = new User();
                user.id_user = rs.getInt("id_user");
                user.name = rs.getString("name");
                user.email = rs.getString("email");
                user.password = rs.getString("password");
            }
            closeDB();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    private String generateToken(){
        UUID token = UUID.randomUUID();
        return token.toString();
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
        JSONObject json = new JSONObject();
        String token = request.getParameter("token");
        HttpSession session = request.getSession(true);
        if(session.getAttribute("token").equals(token)){
            int id_user = (int) session.getAttribute("id_user");
            json.put("status", "ok");
            json.put("id_user", id_user);
        }
        else{
            json.put("status", "invalid");
        }
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.println(json.toString());
        }
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
        User user = getUser(request.getParameter("email"), request.getParameter("password"));
        JSONObject json = new JSONObject();
        if(user != null){
            HttpSession session = request.getSession(true);
            
            String token = generateToken();
            session.setAttribute("id_user", user.id_user);
            session.setAttribute("token", token);
            session.setMaxInactiveInterval(600);
            json.put("status", "ok");
            json.put("token", token);
        }
        else{
            json.put("status", "invalid");
        }
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.println(json.toString());
        }
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