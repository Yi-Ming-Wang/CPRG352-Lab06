/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adamw
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get the current session
        HttpSession session = request.getSession();

        // capture the  action parameter if the user wants to login out the form
        String operation = request.getParameter("action");

        if (operation != null && operation.equals("logout")) {
            // log out the user
            session.invalidate();
            //session = request.getSession();
            request.setAttribute("MESSAGE", "You have successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        String user = (String) session.getAttribute("USER");
        if (user != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get the current session
        HttpSession session = request.getSession();

        // capture the  action parameter if the user wants to login out the form
        String operation = request.getParameter("action");
        String user = request.getParameter("USER");
        String addItem = request.getParameter("ADDITEM");
        String removeItem = request.getParameter("REMOVE");

        // Reset the action for next operation 
        if (operation.equalsIgnoreCase("logout")) {
            operation = "register";
        }

        if (operation.equalsIgnoreCase("register") && (user != null || !user.isEmpty())) {
            session.setAttribute("USER", user);
            ArrayList<String> itemsList = new ArrayList<>();
            session.setAttribute("ITEMS", itemsList);
            response.sendRedirect("/ShoppingList");
            return;
        } else if (operation.equalsIgnoreCase("add")) {
            //Cast String type 
            ArrayList<String> itemsList = (ArrayList<String>) session.getAttribute("ITEMS");
            itemsList.add(addItem);
            session.setAttribute("ITEMS", itemsList);
            response.sendRedirect("/ShoppingList");
            return;
        } else if (operation.equalsIgnoreCase("delete")) {

            if (removeItem != null || removeItem.isEmpty()) {
                ArrayList<String> itemsList = (ArrayList<String>) session.getAttribute("ITEMS");
                itemsList.remove(removeItem);
                session.setAttribute("items", itemsList);
                response.sendRedirect("/ShoppingList");
                return;
            }
        }

    }

}
