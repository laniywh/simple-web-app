<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="My Account">
  User Name: <b>${user.userName}</b>
  <br />
  Gender: ${user.gender}
  <br />
</t:wrapper>