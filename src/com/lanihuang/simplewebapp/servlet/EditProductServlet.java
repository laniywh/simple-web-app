package com.lanihuang.simplewebapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lanihuang.simplewebapp.beans.Product;
import com.lanihuang.simplewebapp.utils.DBUtils;
import com.lanihuang.simplewebapp.utils.MyUtils;

@WebServlet(urlPatterns = { "/editProduct" })
public class EditProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public EditProductServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    Connection conn = MyUtils.getStoredConnection(request);

    String code = (String) request.getParameter("code");

    Product product = null;

    String errorString = null;

    try {
      product = DBUtils.findProduct(conn, code);
    } catch (SQLException e) {
      e.printStackTrace();
      errorString = e.getMessage();
    }


    // If no error.
    // The product does not exist to edit.
    // Redirect to productList page.
    if (errorString != null && product == null) {
      response.sendRedirect(request.getServletPath() + "/productList");
      return;
    }

    // Store errorString in request attribute, before forward to views.
    request.setAttribute("errorString", errorString);
    request.setAttribute("product", product);

    RequestDispatcher dispatcher = request.getServletContext()
                                   .getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
    dispatcher.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    doGet(request, response);
  }

}