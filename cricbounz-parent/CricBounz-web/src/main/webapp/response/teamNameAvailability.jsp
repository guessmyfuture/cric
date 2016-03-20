<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    response.setContentType("application/json");
%>
<%
String userName=request.getParameter("teamName");
%>
<%=userName%>