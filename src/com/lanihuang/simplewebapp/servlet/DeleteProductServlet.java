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

import com.lanihuang.simplewebapp.utils.DBUtils;
import com.lanihuang.simplewebapp.utils.MyUtils;

@WebServlet(urlPatterns = { "/deleteProduct" })
public class DeleteProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public DeleteProductServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    Connection conn = MyUtils.getStoredConnection(request);

    String code = (String) request.getParameter("code");

    String errorString = null;

    try {
      DBUtils.deleteProduct(conn, code);
    } catch (SQLException e) {
      e.printStackTrace();
      errorString = e.getMessage();
    }


    // If an error redirected to an error page.
    if (errorString != null) {

      // Store the information in the request attribute, before forward to views.
      request.setAttribute("errorString", errorString);
      //
      RequestDispatcher dispatcher = request.getServletContext()
                                     .getRequestDispatcher("/WEB-INF/views/deleteProductErrorView.jsp");
      dispatcher.forward(request, response);
    }

    // If everything nice.
    // Redirect to the product listing page.
    else {
      response.sendRedirect(request.getContextPath() + "/productList");
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    doGet(request, response);
  }

}