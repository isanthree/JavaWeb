<%@ page contentType="text/html;charset=UTF-8" %>
<%--引入 JSTL 核心标签库，才能使用 JSTL 标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>if 测试</h4>

<hr/>

<form action="coreif.jsp" method="get">
    <%-- EL 表达式获取表单中的数据
        ${param.参数名}
    --%>
    <label>
        <input type="text" name="username" value="${param.username}"/>
    </label>
    <input type="submit" value="登录"/>
</form>

<%--判断如果提交的用户名是管理员，则登陆成功--%>
<c:if test="${param.username == 'admin'}" var="isAdmin">
    <c:out value="管理员欢迎您"/>
</c:if>

<c:out value="${isAdmin}"/>
</body>
</html>
