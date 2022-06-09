<%@page import="DAO.ResumeDao"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Bean.Resume"%>
<%@ page import="java.util.List"%>

<%@include file="DashBoardHeader.jspf"%>
<title>履歷總覽</title>
<style>
</style>
<div class="container-fluid pt-4 px-4">
<div class="bg-light text-center rounded p-4">
<div class="d-flex align-items-center justify-content-between mb-4">
<h1 class="mb-0">所有履歷</h1>
<button type="button" class="btn btn-primary mb-0" onclick="location.href='./ResumeCreate.jsp'">新增履歷</button>
</div>

<table class="table align-middle table-bordered table-hover mb-0">
	<tr>
		<th>履歷編號</th>
		<th>學歷</th>
		<th>畢業學校</th>
		<th>畢業科系</th>
		<th>工作經驗</th>
		<th>取得證照</th>
		<th>身分證字號</th>
		<th>更新</th>
		<th>刪除</th>
	</tr>
	<%
     List<Resume> resumes = (List<Resume>) request.getAttribute("resumes");
     if(resumes != null){
     for(Resume resume : resumes){
     %>
	<tr>
		<td><%=resume.getResume_id()%></td>
		<td><%=resume.getEdu()%></td>
		<td><%=resume.getSchool()%></td>
		<td><%=resume.getDept()%></td>
		<td><%=resume.getWork_exp()%></td>
		<td><%=resume.getSkills()%></td>
		<td><%=resume.getUser_id()%></td>
		<td>
			<button type="button" class="btn btn-outline-primary m-0" onclick="location.href='./ResumeServlet?UpdateId=<%= resume.getResume_id() %>'">更新</button>
		</td>
		<td>
			<button type="button" class="btn btn-outline-danger m-0" onclick="javascript:if(confirm('確定要刪除嗎?'))location.href='./ResumeServlet?DeleteId=<%= resume.getResume_id() %>'">刪除</button>
		</td>
	</tr>
	<% }
     } %>
</table>
</div>
</div>
<%@include file="DashBoardFooter.jspf"%>