<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Product List">

  <p class="error">${errorString}</p>

  <table class="table table-striped">
    <tr>
      <th>Code</th>
      <th>Name</th>
      <th>Price</th>
      <th>Edit</th>
      <th>Delete</th>
    </tr>
    <c:forEach items="${productList}" var="product" >
      <tr>
        <td>${product.code}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>
          <a href="editProduct?code=${product.code}">Edit</a>
        </td>
        <td>
          <a href="deleteProduct?code=${product.code}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>

  <a class="btn btn-primary" role="button" href="createProduct" >Create Product</a>

</t:wrapper>