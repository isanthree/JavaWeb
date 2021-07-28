<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--内置对象--%>
<%
    pageContext.setAttribute("name1", "一号");
    request.setAttribute("name2", "二号");
    session.setAttribute("name3", "三号");
    application.setAttribute("name4", "四号");
%>

<%--脚本片段中的代码,会被原封不动生成到 JSP.java 中
要求：这里面的代码,必须保证 Java 语法的正确性
--%>
<%
    // 从 pageContext 中取出，我们通过寻找的方式来
    // 从底层到高层（作用域）:
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
    String name5 = (String) pageContext.findAttribute("name5");
%>

<%--使用 EL 表达式输出 ${}--%>
<h1>取出的值为：</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>

</body>
</html>
