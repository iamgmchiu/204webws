<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="DashBoardHeader.jspf"%>
<style>
/*for validation*/
.error {
  color: #F00;
}
</style>

<div class="container-fluid pt-4 px-4">
	<div class="col-sm-12 col-xl-10">
		<div class="bg-light rounded h-100 p-4">
			<h6 class="mb-4">
				<c:if test="${comment != null}">編輯評論</c:if>
				<c:if test="${comment == null}">新增評論</c:if>
			</h6>
			<div class="row mb-3">
				<c:if test="${comment != null}">
					<form action="./CommentUpdate" method="post" id="form">
				</c:if>
				<c:if test="${comment == null}">
					<form action="./CommentConfirm" method="post" id="form">
				</c:if>
				<table class="table-responsive">
					<c:if test="${comment != null}">
						<input type="hidden" name="share_id"
							value="<c:out value='${comment.share_id}' />" />
					</c:if>
					<%
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
					String str = sdf.format(date);
					%>

					<tr>
						<th>新增時間:</th>
						<td><input class="form-control" type="text" value="<%=str%>"
							name="ref_time" readonly></td>
						<th>帳號:</th>
						<td>
						
						<input id="anonymous" type="radio" name="user" value="匿名" <c:if test="${(comment.user_id).contains('匿名')}"> checked</c:if>>
						匿名
						<input id="user" type="radio" name="user" value="會員" <c:if test="${!(comment.user_id).contains('匿名') && comment.user_id == 'null'}"> checked</c:if>>會員
						
						</td>
						<td colspan="2">
						<input style="display:none;" class="form-control" id="user_id" type="text"
							value="<c:out value='${comment.user_id}' />" name="user_id" placeholder="請輸入帳號">
						</td>
					</tr>
					<tr>
						<th>公司名稱:</th>
						<td><input class="form-control" id="comp_name" type="text"
							value="<c:out value='${comment.comp_name}' />" name="comp_name"
							placeholder="請輸入公司名稱" required></td>
						<th>公司評分:</th>
						<td>
							<div id="compScore"
								data-score="
								<c:if test="${comment.comp_score == null}">5</c:if>
								<c:if test="${comment.comp_score != null}"><c:out value='${comment.comp_score}' /></c:if> ">
								<input type="hidden" id="comp_score" name="comp_score"
									value="<c:out value='${comment.comp_score}' />">
							</div>
						</td>
					</tr>
					<tr>
						<th>職位:</th>
						<td><input class="form-control" id="job_name" type="text"
							value="<c:out value='${comment.job_name}' />" name="job_name"
							placeholder="請輸入職位名稱" ></td>
						<th>職務型態:</th>
						<td><select class="form-select" name="job_description"
							id="job_description" size="1">
								<option value="" selected>請選擇</option>
								<option value="全職"
									<c:if test="${comment.job_description== '全職'}"> selected</c:if>>全職</option>
								<option value="兼職"
									<c:if test="${comment.job_description== '兼職'}"> selected</c:if>>兼職</option>
								<option value="工讀"
									<c:if test="${comment.job_description== '工讀'}"> selected</c:if>>工讀</option>
								<option value="實習"
									<c:if test="${comment.job_description== '實習'}"> selected</c:if>>實習</option>
						</select></td>

						<th>職位評分:</th>
						<td>
							<div id=jobScore
								data-score="
								<c:if test="${comment.job_score == null}">5</c:if>
								<c:if test="${comment.job_score != null}"><c:out value='${comment.job_score}' /></c:if>">
								<input type="hidden" id="job_score" name="job_score"
									value="<c:out value='${comment.job_score}' />">
							</div>
						</td>
					</tr>
					<tr>
						<th>表定工時:</th>
						<td><input class="form-control" id="std_hour" type="text"
							value="<c:out value='${comment.std_hour}' />" name="std_hour"
							placeholder="小時/日"></td>
						<th>實際工時:</th>
						<td><input class="form-control" id="real_hour" type="text"
							value="<c:out value='${comment.real_hour}' />" name="real_hour"
							placeholder="小時/日"></td>
						<th>加班頻率:</th>
						<td><input class="form-control" id="over_freq" type="text"
							value="<c:out value='${comment.over_freq}' />" name="over_freq"
							placeholder="天/周"></td>
					</tr>
					<tr>
						<th>服務年資:</th>
						<td><input class="form-control" id="seniority" type="text"
							value="<c:out value='${comment.seniority}' />" name="seniority"
							placeholder="年"></td>
						<th>總年資:</th>
						<td><input class="form-control" id="total_seniority"
							type="text" value="<c:out value='${comment.total_seniority}' />"
							name="total_seniority" placeholder="年"></td>
					</tr>
					<tr>
						<th>月薪(元):</th>
						<td><input class="form-control" id="monthly_salary"
							type="text" value="<c:out value='${comment.monthly_salary}' />"
							name="monthly_salary" placeholder="元/月"></td>
						<th>年薪(萬元):</th>
						<td><input class="form-control" id="yearly_salary"
							type="text" value="<c:out value='${comment.yearly_salary}' />"
							name="yearly_salary" placeholder="萬元/年"></td>
						<th>獎金次數:</th>
						<td><input class="form-control" id="bonus_count" type="text"
							value="<c:out value='${comment.bonus_count}' />"
							name="bonus_count" placeholder="次/年"></td>
					</tr>
					<tr>
						<th>心得分享:</th>
						<td colspan="6"><textarea class="form-control" id="share"
								name="share" rows="6" cols="90"><c:out
									value='${comment.share}' /></textarea>
					</tr>

				</table>
			</div>
			<div align="center">
				<c:if test="${comment != null}">
					<button type="submit" class="btn btn-primary" name="submit"
						value="更新" >更新</button>
				</c:if>
				<c:if test="${comment == null}">
					<button type="button" class="btn btn-outline-dark" name="oneInput"
						value="一鍵輸入" id="OneInput">範例</button>
					<button type="submit" class="btn btn-primary" name="submit"
						value="新增" >新增</button>
				</c:if>
				<button type="button" class="btn btn-secondary"
					onclick="location.href='./CommentsManager'">取消</button>
			</div>
		</div>
	</div>
</div>

<%@include file="DashBoardFooter.jspf"%>