<%@page import="web.servlet.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- attribute에 binding된 데이터를 받아옴 -->

<%

Member mem1 = (Member)request.getAttribute("mem1");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><b><%= request.getParameter("address") %></b>에 사는 멤버 정보입니다.</h2>
<p></p>
<p></p>
이름 : <%= mem1.getName() %>
나이 : <%= mem1.getAge() %>
</body>
</html>