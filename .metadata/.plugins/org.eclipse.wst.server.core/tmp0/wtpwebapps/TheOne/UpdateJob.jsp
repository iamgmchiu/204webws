<%@page import="DAO.impl.JobDaoImpl"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Bean.Job"%>
<%@include file="DashBoardHeader.jspf"%>
<style>
.center{
 text-align:center;
}
</style>
<div class="container-fluid pt-4 px-4">
<div class="col-sm-12 col-xl-10">
<div class="bg-light text-center rounded p-4">

<h1 class="mb-4">更新職缺</h1>
<form action='update' method='post'>
<%
Job job = (Job)request.getAttribute("job");
%>
<div class="row mb-3">
<input type='hidden' name='job_id' value='<%=job.getJob_id() %>'/>
</div>

<div class="row mb-3">
<label class="col-sm-2 col-form-label">統一編號:</label>
<div class="col-sm-8">
<input type='text' name='' value='<%=job.getComp_id() %>' disabled class="form-control"/>
<input type='hidden' name='comp_id' value='<%=job.getComp_id() %>'/>
</div>
</div>

<div class="row mb-3">
<label class="col-sm-2 col-form-label">職缺名稱:</label>
<div class="col-sm-8">
<input type='text' name='title' value='<%=job.getTitle() %>'  class="form-control" required/>
</div>
</div>

<div class="row mb-3">
<label class="col-sm-2 col-form-label">職缺性質:</label>
<div class="col-sm-8">
<select name='job_description' class="form-select" >
<option selected><%=job.getJob_description() %></option>
<option>全職</option>
<option>兼職</option>
<option>工讀</option>
<option>其他</option>
</select>
</div>
</div>

<div class="row mb-3">
<label class="col-sm-2 col-form-label">職缺條件:</label>
<div class="col-sm-8">
<input type='text' name='qualification' value='<%=job.getQualification() %>' class="form-control" required/>
</div>
</div>

<div class="row mb-3">
<label class="col-sm-2 col-form-label">需要人數:</label>
<div class="col-sm-8">
<input type='text' name='required_number' value='<%=job.getRequired_number() %>' class="form-control" required/>
</div>
</div>

<div class="row mb-3">
<label class="col-sm-2 col-form-label">每月薪資:</label>
<div class="col-sm-8">  
<select name='salary' class="form-select">
<option selected><%=job.getSalary() %></option>
<option>面議</option>
<option>25000以下</option>
<option>30001~35000</option>
<option>35001~40000</option>
<option>40001~45000</option>
<option>45001~50000</option>
<option>50001~55000</option>
<option>55000以上</option>
</select>
</div>
</div>
<div class="center">
<button type="submit" class="btn btn-primary">更改並儲存</button>
</div>
</form>
</div>
</div>
</div>
<%@include file="DashBoardFooter.jspf"%>