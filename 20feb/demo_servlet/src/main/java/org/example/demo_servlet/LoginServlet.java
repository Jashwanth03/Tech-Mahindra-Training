package org.example.demo_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get user input
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Print to console (for debugging)
        System.out.println("username: " + username);
        System.out.println("password: " + password);

        // Display response in browser
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String htmlResponse = "<html>";
        htmlResponse += "<h2>Your username is: " + username + "<br/>";
        htmlResponse += "Your password is: " + password + "</h2></html>";
        writer.println(htmlResponse);
    }
}
