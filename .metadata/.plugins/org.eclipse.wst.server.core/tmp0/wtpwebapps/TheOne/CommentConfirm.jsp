<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="DashBoardHeader.jspf"%>


<form action="./CommentsManager" method="post">
	<jsp:useBean id="comment" class="Bean.CommentBean" scope="session" />

	<div class="container-fluid pt-4 px-4">
		<div class="col-sm-12 col-xl-10">
			<div class="bg-light rounded h-100 p-4">
				<div align="center">
					<h2>評論內容</h2>
				</div>
				<div align="center">
					<!--  	<c:if test="${comment != null}">
					<form action="./CommentUpdate" method="post">
				</c:if>-->
					<form action="CommentInsert" method="post">

						<table
							class="table table-light align-middle table-bordered table-hover mb-0">
<!-- 							<tr> -->
<!-- 							<td>編號:</td>  -->
<%-- 							<td><jsp:getProperty name="comment" property="share_id" /></td> --%>
<!-- 							</tr> -->
							<tr>
								<td>分享時間:</td>
								<td><jsp:getProperty name="comment" property="ref_time" /></td>
								<td>帳號:</td>
								<td><jsp:getProperty name="comment" property="user_id" /></td>
								<td colspan="2"></td>
							</tr>
							<tr>
								<td>公司名稱:</td>
								<td><jsp:getProperty name="comment" property="comp_name" /></td>
								<td>公司評分:</td>
								<td id="confirmComp" data-score="<jsp:getProperty name="comment" property="comp_score" />"></td>
								<td colspan="2"></td>
							</tr>
							<tr>
								<td>職位:</td>
								<td><jsp:getProperty name="comment" property="job_name" /></td>
								<td>職務型態:</td>
								<td><jsp:getProperty name="comment"
										property="job_description" /></td>
								<td>職位評分:</td>
								<td id="confirmJob" data-score="<jsp:getProperty name="comment" property="job_score" />"></td>
							</tr>
							<tr>
								<td>表定工時:</td>
								<td><jsp:getProperty name="comment" property="std_hour" /></td>
								<td>實際工時:</td>
								<td><jsp:getProperty name="comment" property="real_hour" /></td>
								<td>加班頻率:</td>
								<td><jsp:getProperty name="comment" property="over_freq" /></td>
							</tr>
							<tr>
								<td>服務年資:</td>
								<td><jsp:getProperty name="comment" property="seniority" /></td>
								<td>總年資:</td>
								<td><jsp:getProperty name="comment"
										property="total_seniority" /></td>
								<td colspan="2"></td>
							</tr>
							<tr>
								<td>月薪:</td>
								<td><jsp:getProperty name="comment"
										property="monthly_salary" /></td>
								<td>年薪:</td>
								<td><jsp:getProperty name="comment"
										property="yearly_salary" /></td>
								<td>獎金次數:</td>
								<td><jsp:getProperty name="comment" property="bonus_count" /></td>
							</tr>
							<tr>
								<td>心得分享:</td>
								<td colspan="6"><jsp:getProperty name="comment"
										property="share" /></td>
							</tr>

						</table>
				</div>
				<br>
				<div align="center">
					<c:if test="${comment.share_id == null}">
						<button type="submit" class="btn btn-primary" name="confirm"
							value="送出" onclick="form.action='./CommentInsert'">確認</button>
						<button type="button" class="btn btn-secondary"
							onclick="location.href='./CommentsManager'">取消</button>
					</c:if>
					<c:if test="${comment.share_id != null}">
						<button type="button" class="btn btn-primary"
							onclick="location.href='./CommentEdit?id=<c:out value='${comment.share_id}' />'">編輯</button>
						<button type="button" class="btn btn-secondary" name="back"
							value="返回" onclick="location.href='./CommentsManager'">返回</button>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</form>

<%@include file="DashBoardFooter.jspf"%>