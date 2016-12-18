<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Login">
  <p class="error">${errorString}</p>

  <form method="POST" action="doLogin">
    <div class="form-group row">
      <label for="userName" class="col-xs-2 col-form-label">Username</label>
      <div class="col-xs-5">
        <input type="text" class="form-control" id="userName" name="userName" value="${user.userName}">
      </div>
    </div>

    <div class="form-group row">
      <label for="password" class="col-xs-2 col-form-label">Password</label>
      <div class="col-xs-5">
        <input type="password" class="form-control" id="password" name="password" value="${user.password}">
      </div>
    </div>

    <div class="form-group">
			<label class="custom-control custom-checkbox">
				<input type="checkbox" class="custom-control-input">
				<span class="custom-control-indicator"></span>
				<span class="custom-control-description">Remember me</span>
			</label>
    </div>

    <input type="submit" class="btn btn-submit" value= "Submit" />
    <a href="${pageContext.request.contextPath}/">Cancel</a>
  </form>

  <p class="login-info">User Name: lani, password: lani001 or tom/tom001 or jerry/jerry001</p>
</t:wrapper>