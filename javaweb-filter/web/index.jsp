<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>当前有
    <span style="color: red">
        <%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%>
    </span>人在线
</h1>

</body>
</html>
