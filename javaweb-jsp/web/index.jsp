<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%--JSP 表达式
    作用：用来程序输出，输出到客户端
--%>
<%= new java.util.Date()%>

<hr/>

<%--jsp 脚本片段--%>
<%
    int sum = 0;
    for (int i = 0; i <= 100; i++) {
        sum += i;
    }
    out.println("<h1>" + sum + "</h1>");
%>

<%
    int x = 10;
    out.println(x);
%>
<p>这是一个 JSP 文档</p>
<%
    int y = 2;
    out.println(y);
%>

<hr/>

<%--在代码嵌入 HTML 元素--%>
<%
    for (int i = 0; i < 5; i++) {
%>
<h1>Hello, World  <%=i%>
</h1>
<%
    }
%>

<hr/>

<%--JSP 声明--%>
<%!
    static {
        System.out.println("Loading Servlet!");
    }

    private int globalVar = 0;

    public void hhh() {
        System.out.println("进入了 hhh 方法！");
    }
%>

<%hhh();%>

</body>
</html>
