<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="DashBoardHeader.jspf"%>

<div class="container-fluid pt-4 px-4">
	<div class="bg-light text-center rounded p-4">
		<div class="d-flex align-items-center justify-content-between mb-4">
			<h6 class="mb-0">公司職位評論</h6>
			<div class="form-control-sm w-75 rounded-pill bg-white">
				<span class="float-start mx-1 my-2 rounded-circle"> 
				<i class="fa-solid fa-magnifying-glass"></i>
				</span>
				<div class="">
					<input
						class="form-control float-start bg-transparent border-0 w-75 searchBar"
						type="search" data-table="order-table" placeholder="搜尋...">
				</div>
			</div>

			<button type="button" class="btn btn-primary mb-0"
				onclick="location.href='./CommentNew'">新增評論</button>
		</div>
		<div class="table-responsive">
			<table
				class="table align-middle table-bordered table-hover mb-0 order-table"
				id="myTable">
				<thead>
					<tr class="text-dark">
						<th scope="col" onclick="javascript:sortTable(0)">編號</th>
						<th scope="col" onclick="javascript:sortTable(1)">新增時間</th>
						<th scope="col" onclick="javascript:sortTable(2)">公司名稱</th>
						<th scope="col" onclick="javascript:sortTable(3)">公司評分</th>
						<th scope="col" onclick="javascript:sortTable(4)">職位</th>
						<th scope="col" onclick="javascript:sortTable(6)">職位評分</th>
						<!-- 
						<th scope="col">職務型態</th>
						<th scope="col">表定工時</th>
						<th scope="col">實際工時</th>
						<th scope="col">加班頻率</th>
						<th scope="col">服務年資</th>
						<th scope="col">總年資</th>
						<th scope="col">月薪</th>
						<th scope="col">年薪</th>
						<th scope="col">獎金次數</th>
						<th scope="col">帳號</th>
						 -->
						<th scope="col">心得分享</th>
						<th scope="col">動作</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="comment" items="${listComment}">
						<tr>
							<td><c:out value="${comment.share_id}" /></td>
							<td><c:out value="${comment.ref_time}" /></td>
							<td><c:out value="${comment.comp_name}" /></td>
							<td class="listComp"
								data-score="<c:out value='${comment.comp_score}' />"></td>
							<td><c:out value="${comment.job_name}" /></td>
							<td class="listJob"
								data-score="<c:out value='${comment.job_score}' />"></td>
							<!-- 
							<td><c:out value="${comment.job_description}" /></td>
							<td><c:out value="${comment.std_hour}" /></td>
							<td><c:out value="${comment.real_hour}" /></td>
							<td><c:out value="${comment.over_freq}" /></td>
							<td><c:out value="${comment.seniority}" /></td>
							<td><c:out value="${comment.total_seniority}" /></td>
							<td><c:out value="${comment.monthly_salary}" /></td>
							<td><c:out value="${comment.yearly_salary}" /></td>
							<td><c:out value="${comment.bonus_count}" /></td>
							<td><c:out value="${comment.user_id}" /></td>
							 -->
							<td><c:out value="${comment.share}" /></td>
							<td>
								<button type="button" class="btn btn-outline-info m-0"
									onclick="location.href='./CommentDetail?id=<c:out value='${comment.share_id}' />'">內容</button>
								<button type="button" class="btn btn-outline-primary m-0"
									onclick="location.href='./CommentEdit?id=<c:out value='${comment.share_id}' />'">修改</button>
								<button id="delete" type="button"
									class="btn btn-outline-danger m-0"
									onclick="javascript:if(confirm('確定要刪除嗎?'))location.href='./CommentDelete?id=<c:out value='${comment.share_id}' />'; else location.href='./CommentsManager'">刪除</button>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@include file="DashBoardFooter.jspf"%>