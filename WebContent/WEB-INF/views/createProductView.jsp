<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Create Product">

  <p style="color: red;">${errorString}</p>

  <form method="POST" action="doCreateProduct">
		<div class="form-group row">
			<label for="code" class="col-xs-2 col-form-label">Code</label>
			<div class="col-xs-5">
				<input type="text" class="form-control" id="code" name="code" value="${product.code}">
			</div>
		</div>
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
</t:wrapper>