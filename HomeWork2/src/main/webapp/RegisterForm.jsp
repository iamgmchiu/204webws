<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <%@ page import="mvcdemo.bean.StudentBean"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班級報名註冊</title>
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
<header><h2>
報名資料登入
</h2></header>
<form action=".\RegisterServlet" method="post">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<tr bgcolor="#ff0000">
    <td>姓名:</td>
    <td><input type="text" name="name" size="10" maxlength="10"></td>
</tr>
<tr bgcolor="#FFA500">
    <td>生日:</td>
    <td>
    
    <input type="date"  name="birth" required id="birth">
      
    </td>
</tr>
<tr bgcolor="yellow">
    <td>身份證字號:</td>
    <td><input type="text" name="id" maxlength="10"></td>
</tr>
<tr class=a7 bgcolor="green"><td >性別:</td>
<td><input type="radio" name="gender" value="男生" id="">男性
<input type="radio" name="gender" value="女生" id="">女性</td>
<tr  bgcolor="blue">
    <td class=a7 width="150">聯絡地址:</td>
    <td class=a7>郵遞區號 <input type="text" name="zipcode" size="3" maxlength="3"><input type="text" name="address" size="50" maxlength="50"></td>
</tr>
<tr  bgcolor="#4b0080">
    <td class=a7>聯絡電話:</td>
    <td class=a7><input type="text" name="phone" size="20"></td>
</tr>
<tr bgcolor="purple">
    <td class=a7>E-mail:</td>
    <td class=a7><input type="text" name="mailaddress" size="20" maxlength="20"></td>
</tr>
</table>
<center>
<input type="submit" name="submit" value="送出">
</center>
</form>
</body>
</html>