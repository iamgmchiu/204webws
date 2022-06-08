<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.setContentType("text/html;charset=UTF-8");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>資料確認</title>
</head>
<body>
<jsp:useBean id="reg_Interview" class="minedemo.Interview" scope="session" />
<h2>
資料如下請確認
</h2>
<form action=".\InterViewServletDS" method="get">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<tr bgcolor="#FFFFE1">
    
  Created_Time  : <jsp:getProperty name="reg_Interview" property="Created_Time"><BR>
   Int_Time  :  <jsp:getProperty name="reg_Interview" property="Int_Time"><BR>
   Comp_Name  :  <jsp:getProperty name="reg_Interview" property="Comp_Name"><BR>
   Job_Name  :  <jsp:getProperty name="reg_Interview" property="Job_Name"><BR>
   Offer  :  <jsp:getProperty name="reg_Interview" property="Offer"><BR>
   Test  :  <jsp:getProperty name="reg_Interview" property="Test"><BR>
   Language  :  <jsp:getProperty name="reg_Interview" property="Language"><BR>
   QA  :  <jsp:getProperty name="reg_Interview" property="QA"><BR>
   Share  :  <jsp:getProperty name="reg_Interview" property="Share"><BR>
   Int_Score  :  <jsp:getProperty name="reg_Interview" property="Int_Score"><BR>
   Comp_Score  :  <jsp:getProperty name="reg_Interview" property="Comp_Score"><BR>
   USER_ID  :  <jsp:getProperty name="reg_Interview" property="USER_ID"><BR>

</tr>
</table>
<center>
<input type="submit" name="confirm" value="確認" >
</center>
</form>
</body>
</html>