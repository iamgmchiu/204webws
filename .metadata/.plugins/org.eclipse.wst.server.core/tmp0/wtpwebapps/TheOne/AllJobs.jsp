<%@page import="java.security.Provider.Service"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Bean.Job"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="DashBoardHeader.jspf"%>

<div class="container-fluid pt-4 px-4">
<div class="bg-light text-center rounded p-4">
	<form action="JobDashBoard.jsp" method="post">
	<div class="d-flex align-items-center justify-content-between mb-4">
	<h2>所有職缺</h2>
	
		 <input type="submit" value="新增職缺" class="btn btn-primary mb-0">
    </div>                    
	</form>
	<div class="table-responsive">
	<table class="table align-middle table-bordered table-hover mb-0 order-table" id="lee">
	<thead>
		<tr class="text-dark">
			<th scope="col">職缺名稱</th>
			<th scope="col">職缺性質</th>
			<th scope="col">職缺條件</th>
			<th scope="col" onclick="javascript:sortTable(3)">需求人數</th>
			<th scope="col" onclick="javascript:sortTable(4)">每月薪資</th>
			<th scope="col" onclick="javascript:sortTable(5)">統一編號</th>
			<th scope="col">動作</th>
		</tr>
		</thead>
        <tbody>
        <c:forEach var="job" items="${allJobs}">
		<tr>
			<td><c:out value="${job.title}" /></td>
			<td><c:out value="${job.job_description}" /></td>
			<td><c:out value="${job.qualification}" /></td>
			<td><c:out value="${job.required_number}" /></td>
			<td><c:out value="${job.salary}" /></td>
			<td><c:out value="${job.comp_id}" /></td>
			<td>
			<a href='edit?job_id=<c:out value="${job.job_id}" />' class="btn btn-outline-primary m-0">更新</a>
			<a href='delete?job_id=<c:out value="${job.job_id}" />' class="btn btn-outline-danger m-0" onclick="return deleteForm()">刪除</a>
			</td>	
			
		</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
	</div>
	<%@include file="DashBoardFooter.jspf"%>