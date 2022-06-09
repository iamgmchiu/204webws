<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Bean.Job" %>
<%@ page import="java.util.List" %>
<%@include file="DashBoardHeader.jspf" %>
<head>
<style>
h6{
color:lightgray;
}
.center{
 text-align:center;
}
</style>
</head>
 <body>
<div class="container-fluid pt-4 px-4">
<div class="col-sm-12 col-xl-10">
<div class="bg-light rounded h-100 p-4">
<h5 class="mb-4">新增職缺</h5>
<h6>皆須確實填寫!</h6>
<div>
    <form action="AllJobs.jsp" method="get"> 
        
        <div class="d-flex align-items-center justify-content-between mb-4">
        <button type="submit" class="btn btn-primary mb-0 ">觀看所有職缺</button>
        </div>
        
        </form> 
<form action="insert" method="post" name="form">  
 <div class="row mb-3">
<label class="col-sm-2 col-form-label">統一編號:</label>
<div class="col-sm-8">
<input type="text"  name=comp_id maxlength="8" id="COMP_ID" class="form-control" required autofocus/>
</div>
</div>

<div class="row mb-3">
<label class="col-sm-2 col-form-label">職缺名稱:</label>
<div class="col-sm-8">
<input type="text" name="title" class="form-control" required/> 
</div>
</div>

<div class="row mb-3">
<label class="col-sm-2 col-form-label">職缺性質:</label>
<div class="col-sm-8">
<select name="job_description" class="form-select">
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
<input type="text" name="qualification" class="form-control" required/>
</div>
</div>

<div class="row mb-3">
<label class="col-sm-2 col-form-label">需要人數:</label>
<div class="col-sm-8">
<input type="text" name="required_number" class="form-control" required/> 
</div>
</div>

<div class="row mb-3">
<label class="col-sm-2 col-form-label">每月薪資:</label>  
<div class="col-sm-8">
<select name="salary" class="form-select">
<option>面議</option>
<option>25000以下</option>
<option>25001~30000</option>
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
<button type="submit" class="btn btn-primary" onclick="return checkJobForm()">新增</button>
<button type="reset" class="btn btn-primary">清除</button>
</div>
</form>

</div>
</div>
</div>
</div>
</body>
<%@include file="DashBoardFooter.jspf" %>