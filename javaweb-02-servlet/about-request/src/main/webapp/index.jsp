<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

<h1>登录</h1>

<div style="text-align: center">
    <%--以 post 方式提交表单，提交到我们的 login 请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username"> <br/>
        密码：<input type="password" name="password"> <br/>
        爱好：
        <input type="checkbox" name="hobby" value="学习">学习
        <input type="checkbox" name="hobby" value="代码">代码
        <input type="checkbox" name="hobby" value="唱歌">唱歌
        <input type="checkbox" name="hobby" value="电影">电影
        <input type="checkbox" name="hobby" value="看书">看书

        <br/>
        <input type="submit">
    </form>
</div>

</body>
</html>
