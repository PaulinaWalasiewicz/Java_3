<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="Servlet1">Servlet1</a>
<a href="Servlet2">Servlet2</a>
<a href="Servlet3">Servlet3</a>
<a href="Servlet4">Servlet4</a>

<br>
<%--<c:forEach var="entry" items="${MyMap}">--%>
<%--    <tr>--%>
<%--        <td>${entry.key}</td>--%>
<%--        <td>${entry.value}</td>--%>
<%--    </tr>--%>
<%--</c:forEach>--%>
<%--${MyMap}--%>
<%--<ol>--%>
<%--<c: forEach var="element" items="${MyMap}">--%>
<%--    <li><a herf="http://localhost:8080/${element.key}">${element.key} </a>${element.value}</li>--%>
<%--</c:>--%>
<%--</ol>--%>
<%--</c:>--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
    <tbody>
    <c:forEach items="${MyMap}" var="entry">
        <tr>
            <td><a href="${entry.key}">${entry.key}</a></td>
            <td>${entry.value}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%--<ol>--%>
<%--    <c:forEach items="${MyMap}" var"entry">--%>
<%--    <li> <a href="${entry.key}">${entry.key}</a> ${entry.value}</li>--%>
<%--    </c:forEach>--%>
<%--</ol>--%>

</body>
</html>