<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Edit Product">

  <p class="error">${errorString}</p>

  <c:if test="${not empty product}">
    <form method="POST" action="doEditProduct">
      <input type="hidden" name="code" value="${product.code}" />
        <div class="form-group row">
          <label for="name" class="col-xs-2 col-form-label">Name</label>
          <div class="col-xs-5">
						<input type="text" class="form-control" id="name" name="name" value="${product.name}">
					</div>
        </div>
        <div class="form-group row">
          <label for="price" class="col-xs-2 col-form-label">Price</label>
          <div class="col-xs-5">
						<input type="text" class="form-control" id="price" name="price" value="${product.price}">
					</div>
				</div>
				<button type="submit" class="btn btn-submit">Submit</button>
				<a href="${pageContext.request.contextPath}/productList">Cancel</a>
    </form>
  </c:if>
</t:wrapper>