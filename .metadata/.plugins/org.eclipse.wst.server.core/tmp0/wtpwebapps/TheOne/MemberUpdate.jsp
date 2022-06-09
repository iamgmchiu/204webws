<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Bean.Member"%>
<%@ page import="java.util.List"%>


<%@include file="DashBoardHeader.jspf"%>

<!-- Content Start -->
<div class="container-fluid pt-4 px-4">
	<div class="col-sm-12 col-xl-10">
		<div class="bg-light rounded h-100 p-4">
			<h6 class="mb-4">修改會員資訊</h6>
			<form action="./MemberServlet" method="post"
				enctype="multipart/form-data" onsubmit="return checkMemberForm()">
				<%
				Member UpdateMember = (Member) request.getAttribute("UpdateMember");
				%>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">會員編號</label>
					<div class="col-sm-8">
						<input type="text" class="form-control"   name="idNumber" value="<%=UpdateMember.getIdNumber()%>" readonly id="idNumber">
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">帳號(身分證)</label>
					<div class="col-sm-8">
						<input type="hidden" class="form-control" name="update123"  value="0"> 
						<input type="text" class="form-control" name="userid" value="<%=UpdateMember.getUserid()%>" readonly id="userid">
					</div>
				</div>

				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">密碼</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" maxlength="15" name="pwd"
							value="<%=UpdateMember.getPwd()%>" required id="pwd"
							placeholder="(15個英文字元內)">
					</div>
				</div>

				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">姓名</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" maxlength="10"
							name="username" value="<%=UpdateMember.getUsername()%>"
							required id="username">
					</div>
				</div>

				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">性別</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="gender"
							maxlength="1" value="<%=UpdateMember.getGender()%>" required
							id="gender" placeholder="(請填入男或女)">
					</div>
				</div>

				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">生日</label>
					<div class="col-sm-8">
						<input type="date" class="form-control" name="birth"
							value="<%=UpdateMember.getBirth()%>" required id="birth">
					</div>
				</div>

				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">住宅電話</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" maxlength="11" name="tele"
							value="<%=UpdateMember.getTele()%>" required id="tele"
							placeholder="(02-87654321)">
					</div>
				</div>

				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">手機</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" maxlength="10"
							name="phone" value="<%=UpdateMember.getPhone()%>" required
							id="phone">
					</div>
				</div>

				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">通訊地址</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" maxlength="30"
							name="address" value="<%=UpdateMember.getAddress()%>" required
							id="address">
					</div>
				</div>

				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">email</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="email"
							value="<%=UpdateMember.getEmail()%>" required id="email">
					</div>
				</div>

				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">會員點數</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="point"
							value="<%=UpdateMember.getPoint()%>" required id="point"
							placeholder="(請輸入整數)">
					</div>
				</div>

				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">照片</label>
					<div class="col-sm-8 text-center">
						<img class="img-fluid mx-auto mb-4" id="preview_progressbarTW_img"
							src="<%=UpdateMember.getImage()%>" alt="請選擇您的照片"
							style="width: 260px; height: 320px;"> <input type="hidden"
							class="form-control" name="image"
							value="<%=UpdateMember.getImage()%>"> <input
							class="form-control" type="file" name="image" id="imgInp"
							accept="image/jpeg, image/png">
					</div>
				</div>


				<button type="submit" class="btn btn-primary" name="update"
					value="confirm">確認修改</button>
				<button type="button" class="btn btn-primary"
					onclick="location.href='./MemberServlet'">取消</button>
				<!--   <button type="button" class="btn btn-primary" id="wrongInput">錯誤輸入</button>
                            <button type="button" class="btn btn-primary" id="correctInput">正確輸入</button>     -->
			</form>
		</div>
	</div>
</div>
<!-- Content End -->

<%@include file="DashBoardFooter.jspf"%>