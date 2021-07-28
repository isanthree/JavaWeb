<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
http://localhost:8080/jsptag.jsp?name=hhh&age=18
--%>
<jsp:forward page="/jsptag2.jsp">
    <jsp:param name="name" value="hhh"/>
    <jsp:param name="age" value="18"/>
</jsp:forward>
</body>
</html>
