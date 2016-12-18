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

@WebServlet(urlPatterns = { "/doCreateProduct" })
public class DoCreateProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public DoCreateProductServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    Connection conn = MyUtils.getStoredConnection(request);

    String code = (String) request.getParameter("code");
    String name = (String) request.getParameter("name");
    String priceStr = (String) request.getParameter("price");
    float price = 0;
    try {
      price = Float.parseFloat(priceStr);
    } catch (Exception e) {
    }
    Product product = new Product(code, name, price);

    String errorString = null;

    // Product ID is the string literal [a-zA-Z_0-9]
    // with at least 1 character
    String regex = "\\w+";

    if (code == null || !code.matches(regex)) {
      errorString = "Product Code invalid!";
    }

    if (errorString == null) {
      try {
        DBUtils.insertProduct(conn, product);
      } catch (SQLException e) {
        e.printStackTrace();
        errorString = e.getMessage();
      }
    }

    // Store infomation to request attribute, before forward to views.
    request.setAttribute("errorString", errorString);
    request.setAttribute("product", product);

    // If error, forward to Edit page.
    if (errorString != null) {
      RequestDispatcher dispatcher = request.getServletContext()
                                     .getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
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