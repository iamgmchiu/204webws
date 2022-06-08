<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="mvcdemo.bean.StudentBean"%>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>報名資料確認</title>
<style>
 header {
            background-color: black;
            color: lightgreen;
            /* 內距 */
            padding: 20px;
            /* 水平對齊  */
            text-align: center;
        }
        
        .a7{
        color: white;
        }
        </style>
</head>
<body>
<jsp:useBean id="reg_student" class="mvcdemo.bean.StudentBean" scope="session" />
<header>
<h1>
報名資料如下請確認
</h1></header>
<form action=".\RegisterServlet" method="post">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<tr bgcolor="#ff0000">
    <td >姓名:</td>
    <td >
    <jsp:getProperty name="reg_student" property="name" /></td>
</tr>
<tr bgcolor="#FFA500">
    <td>生日:</td>
    <td>
    
    <jsp:getProperty name="reg_student" property="birth" /> 
   
    </td>
</tr>
<tr bgcolor="yellow">
    <td>身份證字號:</td>
    <td><jsp:getProperty name="reg_student" property="id" /></td>
</tr>
<tr bgcolor="green">
    <td class=a7>性別:</td>
    <td class=a7><jsp:getProperty name="reg_student" property="gender" /></td>
</tr>



<tr bgcolor="blue">
    <td class=a7 width="150">聯絡地址:</td>
    <td class=a7><jsp:getProperty name="reg_student" property="zipcode" /> <jsp:getProperty name="reg_student" property="address" /></td>
</tr>
<tr bgcolor="#4b0080">
    <td class=a7>聯絡電話</td>
    <td class=a7><jsp:getProperty name="reg_student" property="phone" /></td>
</tr>
<tr bgcolor="purple">
    <td class=a7>E-mail:</td>
    <td class=a7><jsp:getProperty name="reg_student" property="mailaddress" /></td>
</tr>
</table>
<center>
<input type="submit" name="confirm" value="確認" >
</center>
</form>
</body>
</html>