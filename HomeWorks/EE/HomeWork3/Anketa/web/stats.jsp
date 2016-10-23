<%--
  Created by IntelliJ IDEA.
  User: Dalvik
  Date: 22.10.2016
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="net.ukr.p454.entity.Answers" %>
<%@ page import="java.util.Map" %>
<%@ page import="net.ukr.p454.entity.Question" %>
<%@ page import="javax.servlet.http.HttpSession"%>

<html>
<head>
    <title>Stats</title>
    <style>
        p{
            text-indent: 20pt;
        }
    </style>
</head>
<body>

<h1>STATISTICS for  <%= session.getAttribute("name")%></h1>
<%
    for (Map.Entry<Question,Map<String,Integer>> map: Answers.getAnswers().entrySet()){
%>
        <h3><%= map.getKey().getQuestion().toString()%>
            <%= map.getKey().getAnswer()%>
        </h3>
        <%for (Map.Entry<String,Integer> mapIn : map.getValue().entrySet()){
        %>
        <h4><p>
            <%=mapIn.getKey()%> :
            <%=mapIn.getValue()%>
        </p></h4>
<%
        }
    }
%>
</body>
</html>
