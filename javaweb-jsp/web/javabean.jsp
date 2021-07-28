<%--<%@ page import="org.example.pojo.People" %>--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
//    People people = new People();
//    people.setAddress();
//    people.setId();
//    people.setAge();
//    people.setName();
%>
<jsp:useBean id="people" class="org.example.pojo.People" scope="page" />
<jsp:setProperty name="people" property="address" value="xi'an" />
<jsp:setProperty name="people" property="age" value="20" />
<jsp:setProperty name="people" property="name" value="hhh" />
<jsp:setProperty name="people" property="id" value="1" />

姓名：<jsp:getProperty name="people" property="name"/>
ID：<jsp:getProperty name="people" property="id"/>
年龄：<jsp:getProperty name="people" property="age"/>
地址：<jsp:getProperty name="people" property="address"/>

</body>
</html>
