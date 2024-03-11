package com.bookstore.controller.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/")
public class AdminHomeServlet extends HttpServlet {
    public AdminHomeServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = "index.jsp";

        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        dispatcher.forward(req,resp);
    }


}
