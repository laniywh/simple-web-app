package com.lanihuang.simplewebapp.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lanihuang.simplewebapp.beans.Product;
import com.lanihuang.simplewebapp.beans.UserAccount;

public class DBUtils {

  public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {

    String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a "
                 + " where a.User_Name = ? and a.password= ?";

    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, userName);
    pstm.setString(2, password);
    ResultSet rs = pstm.executeQuery();

    if (rs.next()) {
      String gender = rs.getString("Gender");
      UserAccount user = new UserAccount();
      user.setUserName(userName);
      user.setPassword(password);
      user.setGender(gender);
      return user;
    }
    return null;
  }

  public static UserAccount findUser(Connection conn, String userName) throws SQLException {

    String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " + " where a.User_Name = ? ";

    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, userName);

    ResultSet rs = pstm.executeQuery();

    if (rs.next()) {
      String password = rs.getString("Password");
      String gender = rs.getString("Gender");
      UserAccount user = new UserAccount();
      user.setUserName(userName);
      user.setPassword(password);
      user.setGender(gender);
      return user;
    }
    return null;
  }

  public static List<Product> queryProduct(Connection conn) throws SQLException {
    String sql = "Select a.Code, a.Name, a.Price from Product a ";

    PreparedStatement pstm = conn.prepareStatement(sql);

    ResultSet rs = pstm.executeQuery();
    List<Product> list = new ArrayList<Product>();
    while (rs.next()) {
      String code = rs.getString("Code");
      String name = rs.getString("Name");
      float price = rs.getFloat("Price");
      Product product = new Product();
      product.setCode(code);
      product.setName(name);
      product.setPrice(price);
      list.add(product);
    }
    return list;
  }

  public static Product findProduct(Connection conn, String code) throws SQLException {
    String sql = "Select a.Code, a.Name, a.Price from Product a where a.Code=?";

    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, code);

    ResultSet rs = pstm.executeQuery();

    while (rs.next()) {
      String name = rs.getString("Name");
      float price = rs.getFloat("Price");
      Product product = new Product(code, name, price);
      return product;
    }
    return null;
  }

  public static void updateProduct(Connection conn, Product product) throws SQLException {
    String sql = "Update Product set Name =?, Price=? where Code=? ";

    PreparedStatement pstm = conn.prepareStatement(sql);

    pstm.setString(1, product.getName());
    pstm.setFloat(2, product.getPrice());
    pstm.setString(3, product.getCode());
    pstm.executeUpdate();
  }

  public static void insertProduct(Connection conn, Product product) throws SQLException {
    String sql = "Insert into Product(Code, Name,Price) values (?,?,?)";

    PreparedStatement pstm = conn.prepareStatement(sql);

    pstm.setString(1, product.getCode());
    pstm.setString(2, product.getName());
    pstm.setFloat(3, product.getPrice());

    pstm.executeUpdate();
  }

  public static void deleteProduct(Connection conn, String code) throws SQLException {
    String sql = "Delete from Product where Code= ?";

    PreparedStatement pstm = conn.prepareStatement(sql);

    pstm.setString(1, code);

    pstm.executeUpdate();
  }

}