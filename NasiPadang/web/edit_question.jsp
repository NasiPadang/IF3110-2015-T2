<%-- 
    Document   : edit_question
    Created on : Nov 20, 2015, 10:37:51 AM
    Author     : user
--%>
<%@page import="org.wsdl.StackExchangeImplService"%>
<%
    StackExchangeImplService stackExchangeService = new StackExchangeImplService();
    org.wsdl.StackExchange stackExchange = stackExchangeService.getStackExchangeImplPort();
    int id = Integer.parseInt(request.getParameter("id"));
    id = stackExchange.editQuestion(id,request.getParameter("token"), request.getParameter("topic"), request.getParameter("content"));
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", "/NasiPadang/question.jsp?id=" + id);
%>